package com.coolerpromc.moregears.util;

import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.fabricmc.fabric.api.transfer.v1.transaction.base.SnapshotParticipant;
import team.reborn.energy.api.EnergyStorage;

/**
 * Fabric-specific wrapper around {@link MGEnergyStorage} that implements
 * Fabric's {@link EnergyStorage} interface for energy API registration.
 */
public class FabricMGEnergyStorage extends SnapshotParticipant<Integer> implements EnergyStorage {
    private final MGEnergyStorage storage;

    public FabricMGEnergyStorage(MGEnergyStorage storage) {
        this.storage = storage;
    }

    @Override
    public boolean supportsInsertion() {
        return storage.getMaxInsert() > 0;
    }

    @Override
    public long insert(long maxAmount, TransactionContext transaction) {
        long inserted = Math.min(storage.getMaxInsert(), Math.min(maxAmount, storage.getCapacity() - storage.getEnergy()));
        if (inserted > 0) {
            updateSnapshots(transaction);
            storage.addEnergy((int) inserted);
            return inserted;
        }
        return 0;
    }

    @Override
    public boolean supportsExtraction() {
        return storage.getMaxExtract() > 0;
    }

    @Override
    public long extract(long maxAmount, TransactionContext transaction) {
        long extracted = Math.min(storage.getMaxExtract(), Math.min(maxAmount, storage.getEnergy()));
        if (extracted > 0) {
            updateSnapshots(transaction);
            storage.removeEnergy((int) extracted);
            return extracted;
        }
        return 0;
    }

    @Override
    public long getAmount() {
        return storage.getEnergy();
    }

    @Override
    public long getCapacity() {
        return storage.getCapacity();
    }

    @Override
    protected Integer createSnapshot() {
        return storage.getEnergy();
    }

    @Override
    protected void readSnapshot(Integer snapshot) {
        storage.setEnergy(snapshot);
    }
}

