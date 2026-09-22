#!/usr/bin/env python3
# Renders the shield icons in public/icons/ the way the game draws a shield in the inventory.
# Shields have no flat item texture -- they are drawn by a special renderer from the entity
# texture -- so the icon has to be rendered from the model instead of cropped from a sprite.
#
# Geometry is vanilla's ShieldModel, textured with Minecraft's cube UV layout, mirrored the way
# the shield item definition does (scale 1,-1,-1), posed with the vanilla `gui` display transform
# (rotation 15,-25,-5), and shaded with the same two-light formula the item shader uses.
#
# Run `python docs/scripts/render-shield-icons.py` from the repository root after adding a tier,
# then upload the new icons under the same names (see docs/README.md).
import math
import sys
from pathlib import Path

from PIL import Image

ROOT = Path(__file__).resolve().parents[2]
SHIELD_TEXTURES = ROOT / "common/src/main/resources/assets/moregears/textures/entity/shield"
ICONS = ROOT / "docs/public/icons"
SIZE = 1024
MARGIN = 0.02

# name, texOffs, origin, size -- from ShieldModel.createLayer()
BOXES = [
    ("plate", (0, 0), (-6.0, -11.0, -2.0), (12.0, 22.0, 1.0)),
    ("handle", (26, 0), (-1.0, -3.0, -1.0), (2.0, 6.0, 6.0)),
]

# Lighting.DIFFUSE_LIGHT_0 / _1
DIFFUSE_0 = (0.2, 1.0, -0.7)
DIFFUSE_1 = (-0.2, 1.0, 0.7)


def normalize(v):
    length = math.sqrt(sum(c * c for c in v)) or 1.0
    return tuple(c / length for c in v)


LIGHT_0 = normalize(DIFFUSE_0)
LIGHT_1 = normalize(DIFFUSE_1)


def box_faces(tex_offs, origin, size):
    """The six faces of a box as (verts, uvs, normal), following ModelPart.Cube."""
    x, y = tex_offs
    min_x, min_y, min_z = origin
    w, h, d = size
    max_x, max_y, max_z = min_x + w, min_y + h, min_z + d

    t0 = (min_x, min_y, min_z)
    t1 = (max_x, min_y, min_z)
    t2 = (max_x, max_y, min_z)
    t3 = (min_x, max_y, min_z)
    l0 = (min_x, min_y, max_z)
    l1 = (max_x, min_y, max_z)
    l2 = (max_x, max_y, max_z)
    l3 = (min_x, max_y, max_z)

    u0, u1, u2 = x, x + d, x + d + w
    u22, u3, u4 = x + d + w + w, x + d + w + d, x + d + w + d + w
    v0, v1, v2 = y, y + d, y + d + h

    faces = []
    for verts, ua, va, ub, vb, normal in (
        ([l1, l0, t0, t1], u1, v0, u2, v1, (0, -1, 0)),  # down
        ([t2, t3, l3, l2], u2, v1, u22, v0, (0, 1, 0)),  # up
        ([t0, l0, l3, t3], u0, v1, u1, v2, (-1, 0, 0)),  # west
        ([t1, t0, t3, t2], u1, v1, u2, v2, (0, 0, -1)),  # north
        ([l1, t1, t2, l2], u2, v1, u3, v2, (1, 0, 0)),  # east
        ([l0, l1, l2, l3], u3, v1, u4, v2, (0, 0, 1)),  # south
    ):
        # Polygon() maps vertex 0 -> (ub, va), 1 -> (ua, va), 2 -> (ua, vb), 3 -> (ub, vb).
        faces.append((verts, [(ub, va), (ua, va), (ua, vb), (ub, vb)], normal))
    return faces


def pose(v):
    """The item definition's mirror, then the vanilla `gui` display rotation."""
    x, y, z = v[0], -v[1], -v[2]
    rx, ry, rz = math.radians(15.0), math.radians(-25.0), math.radians(-5.0)
    y, z = y * math.cos(rx) - z * math.sin(rx), y * math.sin(rx) + z * math.cos(rx)
    x, z = x * math.cos(ry) + z * math.sin(ry), -x * math.sin(ry) + z * math.cos(ry)
    x, y = x * math.cos(rz) - y * math.sin(rz), x * math.sin(rz) + y * math.cos(rz)
    return (x, y, z)


def shade(normal):
    """minecraft_mix_light(), verbatim."""
    light_0 = max(0.0, sum(a * b for a, b in zip(normal, LIGHT_0)))
    light_1 = max(0.0, sum(a * b for a, b in zip(normal, LIGHT_1)))
    return min(1.0, (light_0 + light_1) * 0.6 + 0.4)


def triangle(pixels, depth, points, uvs, texture, tex_size, light, size):
    (x0, y0, z0), (x1, y1, z1), (x2, y2, z2) = points
    denominator = (y1 - y2) * (x0 - x2) + (x2 - x1) * (y0 - y2)
    if abs(denominator) < 1e-9:
        return
    min_x = max(0, int(min(x0, x1, x2)))
    max_x = min(size - 1, int(max(x0, x1, x2)) + 1)
    min_y = max(0, int(min(y0, y1, y2)))
    max_y = min(size - 1, int(max(y0, y1, y2)) + 1)
    tex_w, tex_h = tex_size
    for py in range(min_y, max_y + 1):
        for px in range(min_x, max_x + 1):
            cx, cy = px + 0.5, py + 0.5
            a = ((y1 - y2) * (cx - x2) + (x2 - x1) * (cy - y2)) / denominator
            b = ((y2 - y0) * (cx - x2) + (x0 - x2) * (cy - y2)) / denominator
            c = 1.0 - a - b
            if a < 0 or b < 0 or c < 0:
                continue
            z = a * z0 + b * z1 + c * z2
            if z <= depth[py][px]:
                continue
            u = a * uvs[0][0] + b * uvs[1][0] + c * uvs[2][0]
            v = a * uvs[0][1] + b * uvs[1][1] + c * uvs[2][1]
            # Nearest-neighbour, so the pixel art stays sharp at icon size.
            r, g, bl, alpha = texture[min(tex_w - 1, max(0, int(u))), min(tex_h - 1, max(0, int(v)))]
            if alpha == 0:
                continue
            depth[py][px] = z
            pixels[px, py] = (int(r * light), int(g * light), int(bl * light), alpha)


def render(texture_path, out_path, size=SIZE, margin=MARGIN):
    texture = Image.open(texture_path).convert("RGBA")
    texels = texture.load()

    faces = []
    for _, tex_offs, origin, dims in BOXES:
        for verts, uvs, normal in box_faces(tex_offs, origin, dims):
            faces.append(([pose(v) for v in verts], uvs, normalize(pose(normal))))

    xs = [v[0] for face in faces for v in face[0]]
    ys = [v[1] for face in faces for v in face[0]]
    scale = size * (1 - 2 * margin) / max(max(xs) - min(xs), max(ys) - min(ys))
    cx, cy = (max(xs) + min(xs)) / 2, (max(ys) + min(ys)) / 2

    image = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    pixels = image.load()
    depth = [[-1e9] * size for _ in range(size)]

    for verts, uvs, normal in faces:
        projected = [(size / 2 + (v[0] - cx) * scale, size / 2 - (v[1] - cy) * scale, v[2]) for v in verts]
        light = shade(normal)
        for corners in ((0, 1, 2), (0, 2, 3)):
            triangle(
                pixels,
                depth,
                [projected[i] for i in corners],
                [uvs[i] for i in corners],
                texels,
                texture.size,
                light,
                size,
            )

    image.save(out_path)


def main():
    textures = sorted(SHIELD_TEXTURES.glob("*_base_nopattern.png"))
    if not textures:
        sys.exit(f"No shield textures in {SHIELD_TEXTURES}")
    ICONS.mkdir(parents=True, exist_ok=True)
    for texture in textures:
        tier = texture.name.removesuffix("_base_nopattern.png")
        out = ICONS / f"{tier}_shield.png"
        render(texture, out)
        print(f"{tier} -> {out.relative_to(ROOT)}")


if __name__ == "__main__":
    main()
