package net.kaupenjoe.mccourse.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.screen.custom.PedestalScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MCCourseMod.MOD_ID, "pedestal_screen_handler"),
                    new ExtendedScreenHandlerType<>(PedestalScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        MCCourseMod.LOGGER.info("Registering Screen Handlers for " + MCCourseMod.MOD_ID);
    }
}
