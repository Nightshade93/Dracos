package com.github.dracos.command;

import com.github.dracos.Dracos;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;


public class XpCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("dracos")
                .then(
                        CommandManager.literal("giveXP")
                        .then(
                                CommandManager.argument("player", EntityArgumentType.player())
                                .then(
                                        CommandManager.argument(
                                                //Minimum 1
                                                "value", IntegerArgumentType.integer(1))
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

    private static int execute(ServerCommandSource source, ServerPlayerEntity player, int giveXP) {
        if (source.getEntity() instanceof ServerPlayerEntity && player != null) {
            Dracos.addXpAndLevelUp(Dracos.PLAYER_LEVEL, player, giveXP);
            player.sendMessage(new LiteralText("§aDRACOS >§r Gave " + giveXP + " experience to " +  player.getEntityName()), false);


        }

        return 0;

    }

}