package com.coolerpromc.moregears.util;

import net.fabricmc.fabric.api.transfer.v1.storage.StoragePreconditions;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.fabricmc.fabric.api.transfer.v1.transaction.base.SnapshotParticipant;
import team.reborn.energy.api.EnergyStorage;

public class MGEnergyStorage extends SnapshotParticipant<Integer> implements EnergyStorage {
    public int amount = 0;
    public int capacity;
    public int maxInsert;
    public int maxExtract;

    public MGEnergyStorage(int capacity) {
        this(capacity, capacity);
    }

    public MGEnergyStorage(int capacity, int maxTransfer) {
        this(capacity, maxTransfer, maxTransfer);
    }

    public MGEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        StoragePreconditions.notNegative(capacity);
        StoragePreconditions.notNegative(maxReceive);
        StoragePreconditions.notNegative(maxExtract);
        this.capacity = capacity;
        this.maxInsert = maxReceive;
        this.maxExtract = maxExtract;
    }

    public void setEnergy(int energy) {
        if(energy < 0)
            energy = 0;
        if(energy > this.capacity)
            energy = this.capacity;

        this.amount = energy;
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

    public boolean supportsInsertion() {
        return this.maxInsert > 0L;
    }

    @Override
    public long insert(long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notNegative(maxAmount);
        long inserted = Math.min(this.maxInsert, Math.min(maxAmount, this.capacity - this.amount));
        if (inserted > 0) {
            this.updateSnapshots(transaction);
            this.amount += inserted;
            return inserted;
        } else {
            return 0;
        }
    }

    @Override
    public boolean supportsExtraction() {
        return this.maxExtract > 0L;
    }

    @Override
    public long extract(long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notNegative(maxAmount);
        long extracted = Math.min(this.maxExtract, Math.min(maxAmount, this.amount));
        if (extracted > 0L) {
            this.updateSnapshots(transaction);
            this.amount -= extracted;
            return extracted;
        } else {
            return 0L;
        }
    }

    @Override
    public long getAmount() {
        return amount;
    }

    @Override
    public long getCapacity() {
        return capacity;
    }

    @Override
    protected Integer createSnapshot() {
        return this.amount;
    }

    @Override
    protected void readSnapshot(Integer integer) {
        this.amount = integer;
    }

    public static String convertEnergyToString(long energy){
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
