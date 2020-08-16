package com.github.dracos.command;

import com.github.dracos.Dracos;
import com.github.dracos.playerComponent.playerLevel;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import nerdhub.cardinal.components.api.component.ComponentProvider;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

public class StatsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("dracos")
                        .then(
                                CommandManager.literal("checkStats")
                                        .then(
                                                CommandManager.argument("player", EntityArgumentType.player())
                                                                        .executes(
                                                                                (commandContext) -> execute(
                                                                                        commandContext.getSource(), EntityArgumentType.getPlayer(commandContext, "player")
                                                                                )
                                                                        )

                                        )
                        )
        );
    }

    private static int execute(ServerCommandSource source, ServerPlayerEntity player) {
        if (source.getEntity() instanceof ServerPlayerEntity && player != null) {
            ComponentProvider provider = ComponentProvider.fromEntity(player);
            player.sendMessage(new LiteralText("§aDRACOS >§r Stats for " + player.getEntityName()), false);

            player.sendMessage(new LiteralText( "Lvl: " + Dracos.getComponentLevel(Dracos.PLAYER_LEVEL, provider) + "  XP: " + Dracos.getComponentXP(Dracos.PLAYER_LEVEL, provider) + "/" + Dracos.calculateXpNeededToReachLevel(Dracos.PLAYER_LEVEL.get(provider).getLevel() + 1)), false);
            player.sendMessage(new LiteralText( "Str: " + playerLevel.strength.getStatVal()     + "  Mod: " + playerLevel.strength.getModifier()), false);
            player.sendMessage(new LiteralText( "Dex: " + playerLevel.dexterity.getStatVal()    + "  Mod: " + playerLevel.dexterity.getModifier()), false);
            player.sendMessage(new LiteralText( "Con: " + playerLevel.constitution.getStatVal() + "  Mod: " + playerLevel.constitution.getModifier()), false);
            player.sendMessage(new LiteralText( "Int: " + playerLevel.intelligence.getStatVal() + "  Mod: " + playerLevel.intelligence.getModifier()), false);
            player.sendMessage(new LiteralText( "Wis: " + playerLevel.wisdom.getStatVal()       + "  Mod: " + playerLevel.wisdom.getModifier()), false);
            player.sendMessage(new LiteralText( "Cha: " + playerLevel.charisma.getStatVal()     + "  Mod: " + playerLevel.charisma.getModifier()), false);
        }

        return 0;

    }

}