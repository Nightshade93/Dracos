package com.github.dracos.gui;

import com.github.dracos.playerComponent.playerComponent;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.MinecraftClient;


public class CharSheet2 extends LightweightGuiDescription {

    public CharSheet2() {

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(400, 250);

        WButton lastPage = new WButton();
        root.add(lastPage, 0, 5);
        lastPage.setOnClick(() -> {
            MinecraftClient.getInstance().openScreen(null);
            MinecraftClient.getInstance().openScreen(new ExampleScreen(new CharSheet1()));
        });

        WLabel title = new WLabel("Character Sheet");
        root.add(title, 6, 0);

        WLabel spellsLabel = new WLabel("Spells");
        root.add(spellsLabel, 1, 1);

    }

}
