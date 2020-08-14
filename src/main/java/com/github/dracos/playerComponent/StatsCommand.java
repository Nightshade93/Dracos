package com.github.dracos.playerComponent;

import com.github.dracos.playerComponent.playerLevel;
import com.mojang.brigadier.CommandDispatcher;
import nerdhub.cardinal.components.api.component.ComponentProvider;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

public class StatsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("dracos:stats")
                        .executes(
                                (commandContext) -> execute(
                                        commandContext.getSource(), (ServerPlayerEntity) commandContext.getSource().getEntity()
                                )
                        ).then(
                        CommandManager.argument(
                                "targets", EntityArgumentType.player()
                        )
                                .executes(
                                        (commandContext) -> execute(
                                                commandContext.getSource(), EntityArgumentType.getPlayer(commandContext, "targets")
                                        )
                                )
                )
        );
    }

    private static int execute(ServerCommandSource source, ServerPlayerEntity target) {
        if (source.getEntity() instanceof ServerPlayerEntity && target != null) {
            ComponentProvider provider = ComponentProvider.fromEntity(target);
            target.sendMessage(new LiteralText("§aDRACOS >§r Stats for " + target.getEntityName()), false);

            target.sendMessage(new LiteralText( "Str: " + playerLevel.strength.getStatVal()     + "  Mod: " + playerLevel.strength.getModifier()), false);
            target.sendMessage(new LiteralText( "Dex: " + playerLevel.dexterity.getStatVal()    + "  Mod: " + playerLevel.dexterity.getModifier()), false);
            target.sendMessage(new LiteralText( "Con: " + playerLevel.constitution.getStatVal() + "  Mod: " + playerLevel.constitution.getModifier()), false);
            target.sendMessage(new LiteralText( "Int: " + playerLevel.intelligence.getStatVal() + "  Mod: " + playerLevel.intelligence.getModifier()), false);
            target.sendMessage(new LiteralText( "Wis: " + playerLevel.wisdom.getStatVal()       + "  Mod: " + playerLevel.wisdom.getModifier()), false);
            target.sendMessage(new LiteralText( "Cha: " + playerLevel.charisma.getStatVal()     + "  Mod: " + playerLevel.charisma.getModifier()), false);
        }

        return 0;

    }

}