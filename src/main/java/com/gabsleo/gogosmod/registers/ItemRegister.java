package com.gabsleo.gogosmod.registers;
import com.gabsleo.gogosmod.GogosMod;
import com.gabsleo.gogosmod.entities.ExampleItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GogosMod.MOD_ID);
    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }

    public static final RegistryObject<Item> EXAMPLE_ITEM = register(
            "gogos",
            () -> new ExampleItem(new Item.Properties().tab(GogosMod.MOD_TAB))
    );
}