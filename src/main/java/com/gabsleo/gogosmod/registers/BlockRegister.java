package com.gabsleo.gogosmod.registers;

import com.gabsleo.gogosmod.GogosMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegister {
    public static final DeferredRegister<Item> ITEMS = ItemRegister.ITEMS;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, GogosMod.MOD_ID
    );

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block){
        return BLOCKS.register(name, block);
    }

    //Generates item based on the block
    private static <T extends Block> RegistryObject<T> register(
            final String name,
            final Supplier<? extends T> block,
            Function<RegistryObject<T>, Supplier<? extends Item>> item
    ){
        RegistryObject<T> object = register(name, block);
        ITEMS.register(name, item.apply(object));
        return object;
    }

    public static final RegistryObject<Block> TEO_BLOCK = register(
            "theo_block",
            () -> new Block(
                    BlockBehaviour.Properties.of(
                            Material.CLAY,
                            MaterialColor.RAW_IRON).strength(3.0f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
            ),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(GogosMod.MOD_TAB))
    );
}
