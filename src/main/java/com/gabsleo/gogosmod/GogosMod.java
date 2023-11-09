package com.gabsleo.gogosmod;

import com.gabsleo.gogosmod.registers.BlockRegister;
import com.gabsleo.gogosmod.registers.ItemRegister;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("gogosmod")
public class GogosMod {

    public static final String MOD_ID = "gogosmod";
    public static final CreativeModeTab MOD_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegister.EXAMPLE_ITEM.get());
        }
    };

    public GogosMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegister.ITEMS.register(bus);
        BlockRegister.BLOCKS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void initializeCommonStuff(final FMLCommonSetupEvent event) {}
    @SubscribeEvent
    public static void initializeClientStuff(final FMLClientSetupEvent event) {}
    @SubscribeEvent
    public static void initializeServerStuff(final FMLDedicatedServerSetupEvent event) {}
}
