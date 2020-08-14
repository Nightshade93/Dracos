package com.github.dracos;

//import com.github.dracos.command.player.LevelCommand;
//import com.github.dracos.command.player.XpCommand;
import com.github.dracos.items.CharSheetItem;
import com.github.dracos.playerComponent.StatsCommand;
import com.github.dracos.playerComponent.playerComponent;
import com.github.dracos.playerComponent.playerLevel;
import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.ComponentProvider;
import nerdhub.cardinal.components.api.event.EntityComponentCallback;
import nerdhub.cardinal.components.api.util.EntityComponents;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Dracos implements ModInitializer {

    public static final String MOD_ID = "dracos";

    public static final ComponentType<playerLevel> PLAYER_LEVEL = ComponentRegistry.INSTANCE.registerIfAbsent(new Identifier("dracos:playerlvl"), playerLevel.class);

    public static Item GUI_ITEM = new CharSheetItem(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {

        EntityComponentCallback.event(PlayerEntity.class).register(((myPlayer, component) -> component.put(PLAYER_LEVEL, new playerLevel(myPlayer))));
        EntityComponents.setRespawnCopyStrategy(PLAYER_LEVEL, RespawnCopyStrategy.ALWAYS_COPY);
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> StatsCommand.register(dispatcher));
//        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> XpCommand.register(dispatcher));
//        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> LevelCommand.register(dispatcher));

        Registry.register(Registry.ITEM, new Identifier("tutorial", "gui_item"), GUI_ITEM);

    }

    // Helper methods for components
    public static void setComponentXP(ComponentType<? extends playerComponent> type, ComponentProvider provider, int newValue) {
        type.get(provider).setXP(newValue);
    }

    public static int getComponentXP(ComponentType<? extends playerComponent> type, ComponentProvider provider) {
        return type.get(provider).getXP();
    }

    public static void setComponentLevel(ComponentType<? extends playerComponent> type, ComponentProvider provider, int newValue) {
        type.get(provider).setLevel(newValue);
    }

    public static int getComponentLevel(ComponentType<? extends playerComponent> type, ComponentProvider provider) {
        return type.get(provider).getLevel();
    }

    public static int checkPlayerLevel (ComponentType<? extends playerComponent> type, ServerPlayerEntity entity) {
        ComponentProvider provider = ComponentProvider.fromEntity(entity);
        return type.get(provider).getLevel();
    }

    public static void showStats(ComponentType<? extends playerComponent> type, ServerPlayerEntity entity) {

    }

    public static void addXpAndLevelUp(ComponentType<? extends playerComponent> type, ServerPlayerEntity entity, int addedXP) {

        ComponentProvider provider = ComponentProvider.fromEntity(entity);
        int nextXP = getComponentXP(type, provider) + addedXP;
        int currentLevel = getComponentLevel(type, provider);

            if (currentLevel < 20) {
                // Enough to level up
                int nextXPForLevelUp = calculateXpNeededToReachLevel(currentLevel + 1);

                if (nextXP >= nextXPForLevelUp) {
                    nextXP -= nextXPForLevelUp;
                    setComponentLevel(type, provider, currentLevel + 1);
                    ((PlayerEntity) type.get(provider).getEntity()).sendMessage(new LiteralText("§aDRACOS >§r You gained a level! You are now level §6" + type.get(provider).getLevel()), false);
                    type.get(provider).onLevelUp(false);
                }

                if (type.get(provider).getLevel() == 4 || type.get(provider).getLevel() == 8 || type.get(provider).getLevel() == 12 || type.get(provider).getLevel() == 16 || type.get(provider).getLevel() == 19) {

                    int rand = (int) (Math.random() * 6 + 1);
                    switch (rand) {

                        case 1:
                            playerLevel.strength.addToStat(2);
                            System.out.println("Added 2 to Str!");
                            break;
                        case 2:
                            playerLevel.dexterity.addToStat(2);
                            System.out.println("Added 2 to Dex!");
                            break;
                        case 3:
                            playerLevel.constitution.addToStat(2);
                            System.out.println("Added 2 to Con!");
                            break;
                        case 4:
                            playerLevel.intelligence.addToStat(2);
                            System.out.println("Added 2 to Int!");
                            break;
                        case 5:
                            playerLevel.wisdom.addToStat(2);
                            System.out.println("Added 2 to Wis!");
                            break;
                        case 6:
                            playerLevel.charisma.addToStat(2);
                            System.out.println("Added 2 to Cha!");
                            break;
                        default:
                            System.out.println("Not a valid rand!");
                            break;

                    }

                    return;

                }

                setComponentXP(type, provider, nextXP);
                System.out.println("Current level = " + type.get(provider).getLevel());
                System.out.println("Current xp = " + nextXP);
                System.out.println("Xp necessary to level = " + calculateXpNeededToReachLevel(type.get(provider).getLevel() + 1));

            }

    }


    public static int calculateXpGiven(int playerLevel)  {
        int xpGiven = 2700;

//        if (playerLevel < 11) {
//            xpGiven = playerLevel * 10;
//        } else if (playerLevel == 11) {
//            xpGiven = (int) ((double) playerLevel * 5.5);
//        } else {
//            xpGiven = playerLevel * 6;
//        }
        return xpGiven;
    }

    public static int calculateXpNeededToReachLevel(int level) {
        int necessaryXP = 0;
        if (level == 1){
            necessaryXP = 25;
        } else if (level == 2){
            necessaryXP = 300;
        } else if (level == 3){
            necessaryXP = 600;
        } else if (level == 4){
            necessaryXP = 1800;
        } else if (level == 5){
            necessaryXP = 3800;
        } else if (level == 6){
            necessaryXP = 7500;
        } else if (level == 7){
            necessaryXP = 9000;
        } else if (level == 8){
            necessaryXP = 11000;
        } else if (level == 9){
            necessaryXP = 14000;
        } else if (level == 10){
            necessaryXP = 16000;
        } else if (level == 11){
            necessaryXP = 21000;
        } else if (level == 12){
            necessaryXP = 15000;
        } else if (level == 13){
            necessaryXP = 20000;
        } else if (level == 14){
            necessaryXP = 20000;
        } else if (level == 15){
            necessaryXP = 25000;
        } else if (level == 16){
            necessaryXP = 30000;
        } else if (level == 17){
            necessaryXP = 30000;
        } else if (level == 18){
            necessaryXP = 40000;
        } else if (level == 19){
            necessaryXP = 40000;
        } else if (level == 20){
            necessaryXP = 50000;
        }
        return necessaryXP;
    }

}

