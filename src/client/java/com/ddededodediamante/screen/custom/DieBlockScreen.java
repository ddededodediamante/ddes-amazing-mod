package com.ddededodediamante.screen.custom;

import com.ddededodediamante.ddesamazingmodMod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.packet.c2s.play.ButtonClickC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DieBlockScreen extends HandledScreen<DieBlockScreenHandler> {
    public static final Identifier GUI_TEXTURE = Identifier.of(ddesamazingmodMod.MOD_ID,
            "textures/gui/die/die_gui.png");

    public DieBlockScreen(DieBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();

        int x = (width - this.backgroundWidth) / 2;
        int y = (height - this.backgroundHeight) / 2;

        int buttonWidth = 28;
        int buttonHeight = 20;

        int buttonX = x + (this.backgroundWidth - buttonWidth) / 2;
        int buttonY = y + buttonHeight + 12;

        ButtonWidget rollButton = ButtonWidget.builder(
                Text.literal("Roll"),
                btn -> MinecraftClient.getInstance().getNetworkHandler().sendPacket(
                        new ButtonClickC2SPacket(this.handler.syncId, DieBlockScreenHandler.BUTTON_ROLL)))
                .dimensions(buttonX, buttonY, buttonWidth, buttonHeight)
                .build();

        this.addDrawableChild(rollButton);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        int x = (width - this.backgroundWidth) / 2;
        int y = (height - this.backgroundHeight) / 2;

        context.drawTexture(
                RenderPipelines.GUI_TEXTURED,
                GUI_TEXTURE,
                x, y,
                0, 0,
                this.backgroundWidth, this.backgroundHeight,
                this.backgroundWidth, this.backgroundHeight,
                256, 256);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
