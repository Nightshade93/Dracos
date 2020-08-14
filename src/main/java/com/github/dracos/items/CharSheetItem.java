package com.github.dracos.items;

import com.github.dracos.gui.CharSheet1;
import com.github.dracos.gui.ExampleScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CharSheetItem extends Item {


    public CharSheetItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient.getInstance().openScreen(new ExampleScreen(new CharSheet1()));
        return super.use(world, user, hand);

    }

}
