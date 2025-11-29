package com.ddededodediamante.screen.custom;

import com.ddededodediamante.ModBlocks;
import com.ddededodediamante.ModSounds;
import com.ddededodediamante.screen.ModScreenHandlers;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DieBlockScreenHandler extends ScreenHandler {
    public static final int BUTTON_ROLL = 1;

    private final Inventory inventory;

    public DieBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos blockPos) {
        this(syncId, playerInventory, playerInventory.player.getEntityWorld().getBlockEntity(blockPos));
    }

    public DieBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ModScreenHandlers.DIE_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity);

        int buttonWidth = 28;
        int slotX = 80;
        int slotY = 35;

        this.addSlot(new Slot(inventory, 0, slotX - buttonWidth - 7, slotY));
        this.addSlot(new Slot(inventory, 1, slotX + buttonWidth + 9, slotY) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (id != BUTTON_ROLL)
            return false;

        World world = player.getEntityWorld();

        if (player.getEntityWorld().isClient())
            return true;

        ItemStack slot0 = inventory.getStack(0);
        ItemStack slot1 = inventory.getStack(1);

        if (slot0.isEmpty() || !slot1.isEmpty())
            return true;

        if (slot0.getMaxCount() <= 1)
            return true;

        if (slot0.getCount() * 2 > slot0.getMaxCount())
            return true;

        if (slot0.isOf(ModBlocks.DIE.asItem()))
            return true;

        world.playSound(
                null,
                player.getBlockPos(),
                ModSounds.DIE_ROLLING,
                SoundCategory.BLOCKS,
                1.0f,
                1.0f + (world.random.nextFloat() - 0.5f) * 0.2f);

        boolean success = world.random.nextBoolean();

        if (success) {
            int newCount = Math.min(slot0.getMaxCount(), slot0.getCount() * 2);
            ItemStack result = slot0.copy();
            result.setCount(newCount);

            inventory.setStack(1, result);
        }

        inventory.setStack(0, ItemStack.EMPTY);

        if (inventory instanceof BlockEntity be) {
            be.markDirty();
        }

        this.sendContentUpdates();
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
