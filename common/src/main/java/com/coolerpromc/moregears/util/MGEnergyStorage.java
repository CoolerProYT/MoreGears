package com.coolerpromc.moregears.util;

/**
 * Platform-agnostic energy storage used in common code.
 * Platform-specific wrappers (NeoForgeMGEnergyStorage, FabricMGEnergyStorage)
 * delegate to this class for capability exposure.
 */
public class MGEnergyStorage {
    protected int energy;
    protected int capacity;
    protected int maxInsert;
    protected int maxExtract;

    public MGEnergyStorage(int capacity) {
        this(capacity, capacity);
    }

    public MGEnergyStorage(int capacity, int maxTransfer) {
        this(capacity, maxTransfer, maxTransfer);
    }

    public MGEnergyStorage(int capacity, int maxInsert, int maxExtract) {
        this(capacity, maxInsert, maxExtract, 0);
    }

    public MGEnergyStorage(int capacity, int maxInsert, int maxExtract, int energy) {
        this.capacity = capacity;
        this.maxInsert = maxInsert;
        this.maxExtract = maxExtract;
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxInsert() {
        return maxInsert;
    }

    public int getMaxExtract() {
        return maxExtract;
    }

    public int getAmountAsInt() {
        return energy;
    }

    public int getCapacityAsInt() {
        return capacity;
    }

    public void setEnergy(int energy) {
        if (energy < 0) energy = 0;
        if (energy > this.capacity) energy = this.capacity;
        this.energy = energy;
    }

    public void setMaxReceive(int maxReceive) {
        this.maxInsert = maxReceive;
    }

    public void setMaxExtract(int maxExtract) {
        this.maxExtract = maxExtract;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addEnergy(int energy) {
        setEnergy(this.energy + energy);
    }

    public void removeEnergy(int energy) {
        setEnergy(this.energy - energy);
    }

    public int receiveEnergy(int amount, boolean simulate) {
        int received = Math.min(maxInsert, Math.min(amount, capacity - energy));
        if (!simulate && received > 0) {
            energy += received;
        }
        return received;
    }

    public int extractEnergy(int amount, boolean simulate) {
        int extracted = Math.min(maxExtract, Math.min(amount, energy));
        if (!simulate && extracted > 0) {
            energy -= extracted;
        }
        return extracted;
    }

    public boolean canReceive() {
        return maxInsert > 0;
    }

    public boolean canExtract() {
        return maxExtract > 0;
    }

    public static String convertEnergyToString(int energy) {
        if (energy < 1000) {
            return energy + " FE";
        } else if (energy < 1000000) {
            return String.format("%.2f", energy / 1000f) + " kFE";
        } else if (energy < 1000000000) {
            return String.format("%.2f", energy / 1000000f) + " MFE";
        } else {
            return String.format("%.2f", energy / 1000000000f) + " GFE";
        }
    }
}