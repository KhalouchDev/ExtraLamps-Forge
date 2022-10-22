package net.khaled.extralamps.block;

import net.khaled.extralamps.ExtraLamps;
import net.khaled.extralamps.block.custom.BlueLampBlock;
import net.khaled.extralamps.item.ModCreativeModeTab;
import net.khaled.extralamps.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtraLamps.MOD_ID);


    public static final RegistryObject<Block> BLUE_LAMP = registerBlock("blue_lamp",
            () -> new BlueLampBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3f).lightLevel(state -> state.getValue(BlueLampBlock.LIT) ? 15 : 0).sound(SoundType.GLASS)), ModCreativeModeTab.LAMPS);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

