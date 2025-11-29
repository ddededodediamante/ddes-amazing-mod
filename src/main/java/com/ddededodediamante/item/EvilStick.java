package com.ddededodediamante.item;

import com.ddededodediamante.ModSounds;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

public class EvilStick extends Item {
    public EvilStick(Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postHit(stack, target, attacker);

        World world = attacker.getEntityWorld();
        if (!(world instanceof ServerWorld server))
            return;

        target.addVelocity(0, 0.5, 0);
        target.velocityModified = true;

        server.playSound(
                target,
                target.getBlockPos(),
                ModSounds.SCREAM,
                SoundCategory.PLAYERS,
                1.0f,
                1.2f + (world.random.nextFloat() - 0.5f) * 0.2f);
    }
}
