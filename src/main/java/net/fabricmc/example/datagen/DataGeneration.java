package net.fabricmc.example.datagen;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class DataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        for(int i = 0; i < 50; i++)
            System.out.println("test " + i);
        fabricDataGenerator.createPack().addProvider(ModelGenerator::new);
    }

    private static class ModelGenerator extends FabricModelProvider {

        public ModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

            blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ExampleMod.BAMBOO_LADDER);
            blockStateModelGenerator.registerItemModel(ExampleMod.BAMBOO_LADDER);

        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        }
    }
}
