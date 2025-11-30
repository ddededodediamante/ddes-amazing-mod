package com.ddededodediamante.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.consume.UseAction;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class NightWand extends Item {
    public NightWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            long time = serverWorld.getTimeOfDay() % 24000;

            if (time >= 13000 && time <= 23000) {
                if (user instanceof PlayerEntity player) {
                    player.sendMessage(
                            Text.literal("You can only use this during the day!"),
                            true);
                }
                return ActionResult.FAIL;
            }
        }

        user.setCurrentHand(hand);
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 40;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient() && world instanceof ServerWorld serverWorld && user instanceof PlayerEntity player) {
            world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
                    SoundCategory.PLAYERS);

            serverWorld.setTimeOfDay(18000);

            player.getHungerManager().add(-2, 0f);
            player.getItemCooldownManager().set(stack, 40);
        }
        return stack;
    }
}
