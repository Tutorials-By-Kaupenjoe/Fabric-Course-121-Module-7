package net.kaupenjoe.mccourse.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CrystallizerScreen extends HandledScreen<CrystallizerScreenHandler> {
    private static final Identifier GUI_TEXTURE =
            Identifier.of(MCCourseMod.MOD_ID, "textures/gui/crystallizer/crystallizer_gui.png");
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(MCCourseMod.MOD_ID, "textures/gui/crystallizer/arrow_progress.png");
    private static final Identifier CRYSTAL_TEXTURE =
            Identifier.of("textures/block/amethyst_cluster.png");

    public CrystallizerScreen(CrystallizerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();

        // Get rid of title and inventory title
        titleY = 1000;
        playerInventoryTitleY = 1000;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
        renderProgressCrystal(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(ARROW_TEXTURE, x + 73, y + 35, 0, 0,
                    handler.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private void renderProgressCrystal(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(CRYSTAL_TEXTURE,x + 104, y + 13 + 16 - handler.getScaledCrystalProgress(), 0,
                    16 - handler.getScaledCrystalProgress(), 16, handler.getScaledCrystalProgress(),16, 16);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
