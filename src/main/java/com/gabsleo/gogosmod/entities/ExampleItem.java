package com.gabsleo.gogosmod.entities;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExampleItem extends net.minecraft.world.item.Item {

    public ExampleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide){
            System.out.println(player.getName().getString() + " used item with the " + hand.name());
        }
        return super.use(world, player, hand);
    }
}
