package com.coolerpromc.moregears.platform.services;

public interface IEnergyHelper {
    long getEnergy();
    long getMaxEnergy();
    int insert(int amount, boolean simulate);
    int extract(int amount, boolean simulate);
    boolean canReceive();
    boolean canExtract();
    void setEnergy(int energy);
}
