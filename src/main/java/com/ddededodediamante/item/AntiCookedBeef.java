package com.ddededodediamante.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AntiCookedBeef extends Item {
    public AntiCookedBeef(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            player.getHungerManager().add(-8, -0.8f);
        }

        return super.finishUsing(stack, world, user);
    }
}
