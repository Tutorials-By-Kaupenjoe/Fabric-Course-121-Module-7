package net.kaupenjoe.mccourse.block.entity;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.entity.custom.CoalGeneratorBlockEntity;
import net.kaupenjoe.mccourse.block.entity.custom.CrystallizerBlockEntity;
import net.kaupenjoe.mccourse.block.entity.custom.PedestalBlockEntity;
import net.kaupenjoe.mccourse.block.entity.custom.TankBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MCCourseMod.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));

    public static final BlockEntityType<CrystallizerBlockEntity> CRYSTALLIZER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MCCourseMod.MOD_ID, "crystallizer_be"),
                    BlockEntityType.Builder.create(CrystallizerBlockEntity::new, ModBlocks.CRYSTALLIZER).build(null));

    public static final BlockEntityType<CoalGeneratorBlockEntity> COAL_GENERATOR_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MCCourseMod.MOD_ID, "coal_generator_be"),
                    BlockEntityType.Builder.create(CoalGeneratorBlockEntity::new, ModBlocks.COAL_GENERATOR).build(null));

    public static final BlockEntityType<TankBlockEntity> TANK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MCCourseMod.MOD_ID, "tank_be"),
                    BlockEntityType.Builder.create(TankBlockEntity::new, ModBlocks.TANK).build(null));

    public static void registerBlockEntities() {
        MCCourseMod.LOGGER.info("Registering Block Entities for " + MCCourseMod.MOD_ID);

        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, COAL_GENERATOR_BE);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, CRYSTALLIZER_BE);
    }
}
