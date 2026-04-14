package com.coolerpromc.moregears.util;

import net.neoforged.neoforge.transfer.TransferPreconditions;
import net.neoforged.neoforge.transfer.energy.EnergyHandler;
import net.neoforged.neoforge.transfer.transaction.SnapshotJournal;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * NeoForge-specific wrapper around {@link MGEnergyStorage} that implements
 * NeoForge's {@link EnergyHandler} interface for capability registration.
 */
public class NeoForgeMGEnergyStorage implements EnergyHandler {
    private final MGEnergyStorage storage;
    private final EnergyJournal journal = new EnergyJournal();

    public NeoForgeMGEnergyStorage(MGEnergyStorage storage) {
        this.storage = storage;
    }

    @Override
    public long getAmountAsLong() {
        return storage.getEnergy();
    }

    @Override
    public long getCapacityAsLong() {
        return storage.getCapacity();
    }

    @Override
    public int insert(int amount, TransactionContext transaction) {
        TransferPreconditions.checkNonNegative(amount);

        int inserted = Math.min(storage.getCapacity() - storage.getEnergy(), Math.min(amount, storage.getMaxInsert()));
        if (inserted > 0) {
            journal.updateSnapshots(transaction);
            storage.addEnergy(inserted);
            return inserted;
        }
        return 0;
    }

    @Override
    public int extract(int amount, TransactionContext transaction) {
        TransferPreconditions.checkNonNegative(amount);

        int extracted = Math.min(storage.getEnergy(), Math.min(amount, storage.getMaxExtract()));
        if (extracted > 0) {
            journal.updateSnapshots(transaction);
            storage.removeEnergy(extracted);
            return extracted;
        }
        return 0;
    }

    private class EnergyJournal extends SnapshotJournal<Integer> {
        @Override
        protected Integer createSnapshot() {
            return storage.getEnergy();
        }

        @Override
        protected void revertToSnapshot(Integer snapshot) {
            storage.setEnergy(snapshot);
        }

        @Override
        protected void onRootCommit(Integer originalState) {
            // No additional action needed
        }
    }
}

