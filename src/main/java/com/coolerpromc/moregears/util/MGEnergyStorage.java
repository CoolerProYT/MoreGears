package com.coolerpromc.moregears.util;

import net.minecraftforge.energy.EnergyStorage;

public class MGEnergyStorage extends EnergyStorage {
    public MGEnergyStorage(int capacity) {
        super(capacity);
    }

    public MGEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public MGEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public MGEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    public void setEnergy(int energy) {
        if(energy < 0)
            energy = 0;
        if(energy > this.capacity)
            energy = this.capacity;

        this.energy = energy;
    }

    public void setMaxReceive(int maxReceive) {
        this.maxReceive = maxReceive;
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

    public static String convertEnergyToString(int energy){
        if(energy < 1000){
            return energy + " FE";
        }
        else if(energy < 1000000){
            return String.format("%.2f", energy / 1000f) + " kFE";
        }
        else if(energy < 1000000000){
            return String.format("%.2f", energy / 1000000f) + " MFE";
        }
        else{
            return String.format("%.2f", energy / 1000000000f) + " GFE";
        }
    }
}
