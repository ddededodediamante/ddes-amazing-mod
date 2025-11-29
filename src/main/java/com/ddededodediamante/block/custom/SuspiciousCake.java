package com.ddededodediamante.block.custom;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntry.Reference;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SuspiciousCake extends CakeBlock {
    public static final IntProperty BITES = Properties.BITES;

    public SuspiciousCake(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos,
            PlayerEntity player, BlockHitResult hit) {

        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        }

        if (!world.isClient()) {
            List<Reference<StatusEffect>> allEffects = Registries.STATUS_EFFECT.streamEntries().toList();

            RegistryEntry<StatusEffect> randomEntry = allEffects.get(world.getRandom().nextInt(allEffects.size()));

            StatusEffectInstance effectInstance = new StatusEffectInstance(
                    randomEntry,
                    75 + world.getRandom().nextInt(75),
                    0);

            player.addStatusEffect(effectInstance);
        }

        ActionResult result = super.onUse(state, world, pos, player, hit);
        return result;
    }

    @Override
    protected ActionResult onUseWithItem(
            ItemStack stack,
            BlockState state,
            World world,
            BlockPos pos,
            PlayerEntity player,
            Hand hand,
            BlockHitResult hit) {

        if (stack.isIn(ItemTags.CANDLES)) {
            return ActionResult.FAIL;
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }
}
