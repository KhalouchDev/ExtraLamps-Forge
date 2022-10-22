package net.khaled.extralamps.item;

import net.khaled.extralamps.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab LAMPS = new CreativeModeTab("ExtraLamps") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BLUE_LAMP.get());    //return new ItemStack(ModItems.BLUE_LAMP.get())
        }
    };
}
