package io.github.thebusybiscuit.slimefun4.core.machines;

import javax.annotation.Nonnull;

import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;

public class MiningOperation implements MachineOperation {

    private final ItemStack result;

    private final int totalTicks;
    private int currentTicks = 0;

    public MiningOperation(@Nonnull ItemStack result, int totalTicks) {
        Validate.notNull(result, "The result cannot be null");
        Validate.isTrue(totalTicks > 0, "The amount of total ticks must be a positive integer");

        this.result = result;
        this.totalTicks = totalTicks;
    }

    @Override
    public void addProgress(int num) {
        currentTicks += num;
    }

    @Nonnull
    public ItemStack getResult() {
        return result;
    }

    @Override
    public int getProgress() {
        return currentTicks;
    }

    @Override
    public int getTotalTicks() {
        return totalTicks;
    }

}
