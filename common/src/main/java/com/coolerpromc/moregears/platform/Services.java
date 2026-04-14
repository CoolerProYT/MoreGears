package com.coolerpromc.moregears.platform;

import com.coolerpromc.moregears.Constants;
import com.coolerpromc.moregears.platform.services.IMenuHelper;
import com.coolerpromc.moregears.platform.services.IPlatformHelper;
import com.coolerpromc.moregears.platform.services.IRegistryHelper;

import java.util.ServiceLoader;

public class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);
    public static final IMenuHelper MENU = load(IMenuHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader()).findFirst().orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}