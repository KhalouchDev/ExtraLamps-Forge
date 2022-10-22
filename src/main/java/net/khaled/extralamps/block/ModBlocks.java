package net.khaled.extralamps.block;

import net.khaled.extralamps.ExtraLamps;
import net.khaled.extralamps.block.custom.*;
import net.khaled.extralamps.item.ModCreativeModeTab;
import net.khaled.extralamps.item.ModItems;
import net.minecraft.world.item.BlockItem;
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
            () -> new BlueLampBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3f).lightLevel(state -> state.getValue(BlueLampBlock.LIT) ? 15 : 0).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> RED_LAMP = registerBlock("red_lamp",
            () -> new RedLampBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3f).lightLevel(state -> state.getValue(RedLampBlock.LIT) ? 15 : 0).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> GREEN_LAMP = registerBlock("green_lamp",
            () -> new GreenLampBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3f).lightLevel(state -> state.getValue(GreenLampBlock.LIT) ? 15 : 0).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> MAGENTA_LAMP = registerBlock("magenta_lamp",
            () -> new MagentaLampBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3f).lightLevel(state -> state.getValue(MagentaLampBlock.LIT) ? 15 : 0).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> YELLOW_LAMP = registerBlock("yellow_lamp",
            () -> new YellowLampBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3f).lightLevel(state -> state.getValue(YellowLampBlock.LIT) ? 15 : 0).sound(SoundType.GLASS)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeModeTab.LAMPS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

