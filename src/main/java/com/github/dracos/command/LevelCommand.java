package com.github.dracos.command;

import com.github.dracos.Dracos;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import nerdhub.cardinal.components.api.component.ComponentProvider;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;


public class LevelCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("dracos")
                        .then(
                                CommandManager.literal("setLvl")
                                        .then(
                                                CommandManager.argument("player", EntityArgumentType.player())
                                                        .then(
                                                                CommandManager.argument(
                                                                        //Minimum 1, Maximum 20
                                                                        "value", IntegerArgumentType.integer(1, 20))
                                                                        .executes(
                                                                                (commandContext) -> execute(
                                                                                        commandContext.getSource(), EntityArgumentType.getPlayer(commandContext, "player"), IntegerArgumentType.getInteger(commandContext, "value")
                                                                                )
                                                                        )
                                                        )
                                        )
                        )
        );
    }

    private static int execute(ServerCommandSource source, ServerPlayerEntity player, int setLvl) {
        if (source.getEntity() instanceof ServerPlayerEntity && player != null) {
            ComponentProvider provider = ComponentProvider.fromEntity(player);
            Dracos.setComponentLevel(Dracos.PLAYER_LEVEL, provider, setLvl);
            player.sendMessage(new LiteralText("§aDRACOS >§r Set " +  player.getEntityName() + "'s Level to " + setLvl), false);
            Dracos.addXpAndLevelUp(Dracos.PLAYER_LEVEL, player, 0);


        }

        return 0;

    }

}