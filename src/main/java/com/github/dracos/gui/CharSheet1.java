package com.github.dracos.gui;

import com.github.dracos.playerComponent.playerComponent;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.MinecraftClient;

public class CharSheet1 extends LightweightGuiDescription {

    public CharSheet1() {

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WButton nextPage = new WButton();
        root.add(nextPage, 15, 5);
        nextPage.setOnClick(() -> {
            MinecraftClient.getInstance().openScreen(null);
            MinecraftClient.getInstance().openScreen(new ExampleScreen(new CharSheet2()));
        });

        WLabel title = new WLabel("Character Sheet");
        root.add(title, 6, 0);

        WLabel label = new WLabel("Character");
        root.add(label, 1, 1);

        WLabel strength = new WLabel("Str: " + playerComponent.strength.getStatTxt(playerComponent.strength.getStatVal()) + "  Mod: " + playerComponent.strength.getStatTxt(playerComponent.strength.getModifier()));
        root.add(strength, 1, 2);

        WLabel dexterity = new WLabel("Dex: " + playerComponent.dexterity.getStatTxt(playerComponent.dexterity.getStatVal()) + "  Mod: " + playerComponent.dexterity.getStatTxt(playerComponent.dexterity.getModifier()));
        root.add(dexterity, 1, 3);

        WLabel constitution = new WLabel("Con: " + playerComponent.constitution.getStatTxt(playerComponent.constitution.getStatVal()) + "  Mod: " + playerComponent.constitution.getStatTxt(playerComponent.constitution.getModifier()));
        root.add(constitution, 1, 4);

        WLabel intelligence = new WLabel("Int: " + playerComponent.intelligence.getStatTxt(playerComponent.intelligence.getStatVal()) + "  Mod: " + playerComponent.intelligence.getStatTxt(playerComponent.intelligence.getModifier()));
        root.add(intelligence, 1, 5);

        WLabel wisdom = new WLabel("Wis: " + playerComponent.wisdom.getStatTxt(playerComponent.wisdom.getStatVal()) + "  Mod: " + playerComponent.wisdom.getStatTxt(playerComponent.wisdom.getModifier()));
        root.add(wisdom, 1, 6);

        WLabel charisma = new WLabel("Cha: " + playerComponent.charisma.getStatTxt(playerComponent.charisma.getStatVal()) + "  Mod: " + playerComponent.charisma.getStatTxt(playerComponent.charisma.getModifier()));
        root.add(charisma, 1, 7);

    }

}
