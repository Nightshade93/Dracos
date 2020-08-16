package com.github.dracos.gui;

import com.github.dracos.Dracos;
import com.github.dracos.playerComponent.playerComponent;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import nerdhub.cardinal.components.api.component.ComponentProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class CharSheet1 extends LightweightGuiDescription {

    public CharSheet1(PlayerEntity user) {

        ComponentProvider provider = ComponentProvider.fromEntity(user);
        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WButton nextPage = new WButton();
        nextPage.setSize(10, 10);
        root.add(nextPage, 290, 100);
        nextPage.setOnClick(() -> {
            MinecraftClient.getInstance().openScreen(null);
            MinecraftClient.getInstance().openScreen(new ExampleScreen(new CharSheet2(user)));
        });

        WLabel title = new WLabel("Character Sheet");
        root.add(title, 150, 0);
        title.setHorizontalAlignment(HorizontalAlignment.CENTER);

        WLabel label = new WLabel("Character");
        root.add(label, 25, 25);

        WLabel level = new WLabel("Lvl: " + Dracos.getComponentLevel(Dracos.PLAYER_LEVEL, provider) + " XP: " + Dracos.getComponentXP(Dracos.PLAYER_LEVEL, provider) + "/" + Dracos.calculateXpNeededToReachLevel(Dracos.PLAYER_LEVEL.get(provider).getLevel() + 1));
        root.add(level, 25, 35);

        WLabel points = new WLabel("Unassigned Points: " + Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider));
        root.add(points, 25, 45);

        if (playerComponent.usingSA && Dracos.getComponentHasSANumRemaining(Dracos.PLAYER_LEVEL, provider)) {

            if (!playerComponent.strength.checkIfSet()) {
                WButton setStr = new WButton();
                root.add(setStr, 150, 68);
                setStr.setOnClick(() -> {
                    WGridPanel sA = new WGridPanel();
                    sA.setSize(100, 100);
                    root.add(sA,150,0);
                    root.validate(this);

                    if (!playerComponent.eight.isUsed()) {
                        WButton eight = new WButton();
                        sA.add(eight, 1, 1);
                        WLabel eightL = new WLabel("8");
                        sA.add(eightL, 2, 1);
                        eight.setOnClick(() -> {
                            if (!playerComponent.strength.checkIfSet()) {
                                playerComponent.strength.setStatVal(8);
                                playerComponent.eight.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.ten.isUsed()) {
                        WButton ten = new WButton();
                        sA.add(ten, 1, 2);
                        WLabel tenL = new WLabel("10");
                        sA.add(tenL, 2, 2);
                        ten.setOnClick(() -> {
                            if (!playerComponent.strength.checkIfSet()) {
                                playerComponent.strength.setStatVal(10);
                                playerComponent.ten.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.twelve.isUsed()) {
                        WButton twelve = new WButton();
                        sA.add(twelve, 1, 3);
                        WLabel twelveL = new WLabel("12");
                        sA.add(twelveL, 2, 3);
                        twelve.setOnClick(() -> {
                            if (!playerComponent.strength.checkIfSet()) {
                                playerComponent.strength.setStatVal(12);
                                playerComponent.twelve.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.thirteen.isUsed()) {
                        WButton thirteen = new WButton();
                        sA.add(thirteen, 1, 4);
                        WLabel thirteenL = new WLabel("13");
                        sA.add(thirteenL, 2, 4);
                        thirteen.setOnClick(() -> {
                            if (!playerComponent.strength.checkIfSet()) {
                                playerComponent.strength.setStatVal(13);
                                playerComponent.thirteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fourteen.isUsed()) {
                        WButton fourteen = new WButton();
                        sA.add(fourteen, 1, 5);
                        WLabel fourteenL = new WLabel("14");
                        sA.add(fourteenL, 2, 5);
                        fourteen.setOnClick(() -> {
                            if (!playerComponent.strength.checkIfSet()) {
                                playerComponent.strength.setStatVal(14);
                                playerComponent.fourteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fifteen.isUsed()) {
                        WButton fifteen = new WButton();
                        sA.add(fifteen, 1, 6);
                        WLabel fifteenL = new WLabel("15");
                        sA.add(fifteenL, 2, 6);
                        fifteen.setOnClick(() -> {
                            if (!playerComponent.strength.checkIfSet()) {
                                playerComponent.strength.setStatVal(15);
                                playerComponent.fifteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }
                });
            }

            if (!playerComponent.dexterity.checkIfSet()) {
                WButton setDex = new WButton();
                root.add(setDex, 150, 93);
                setDex.setOnClick(() -> {
                    WGridPanel sA = new WGridPanel();
                    sA.setSize(100, 100);
                    root.add(sA,150,0);
                    root.validate(this);

                    if (!playerComponent.eight.isUsed()) {
                        WButton eight = new WButton();
                        sA.add(eight, 1, 1);
                        WLabel eightL = new WLabel("8");
                        sA.add(eightL, 2, 1);
                        eight.setOnClick(() -> {
                            if (!playerComponent.dexterity.checkIfSet()) {
                                playerComponent.dexterity.setStatVal(8);
                                playerComponent.eight.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.ten.isUsed()) {
                        WButton ten = new WButton();
                        sA.add(ten, 1, 2);
                        WLabel tenL = new WLabel("10");
                        sA.add(tenL, 2, 2);
                        ten.setOnClick(() -> {
                            if (!playerComponent.dexterity.checkIfSet()) {
                                playerComponent.dexterity.setStatVal(10);
                                playerComponent.ten.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.twelve.isUsed()) {
                        WButton twelve = new WButton();
                        sA.add(twelve, 1, 3);
                        WLabel twelveL = new WLabel("12");
                        sA.add(twelveL, 2, 3);
                        twelve.setOnClick(() -> {
                            if (!playerComponent.dexterity.checkIfSet()) {
                                playerComponent.dexterity.setStatVal(12);
                                playerComponent.twelve.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.thirteen.isUsed()) {
                        WButton thirteen = new WButton();
                        sA.add(thirteen, 1, 4);
                        WLabel thirteenL = new WLabel("13");
                        sA.add(thirteenL, 2, 4);
                        thirteen.setOnClick(() -> {
                            if (!playerComponent.dexterity.checkIfSet()) {
                                playerComponent.dexterity.setStatVal(13);
                                playerComponent.thirteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fourteen.isUsed()) {
                        WButton fourteen = new WButton();
                        sA.add(fourteen, 1, 5);
                        WLabel fourteenL = new WLabel("14");
                        sA.add(fourteenL, 2, 5);
                        fourteen.setOnClick(() -> {
                            if (!playerComponent.dexterity.checkIfSet()) {
                                playerComponent.dexterity.setStatVal(14);
                                playerComponent.fourteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fifteen.isUsed()) {
                        WButton fifteen = new WButton();
                        sA.add(fifteen, 1, 6);
                        WLabel fifteenL = new WLabel("15");
                        sA.add(fifteenL, 2, 6);
                        fifteen.setOnClick(() -> {
                            if (!playerComponent.dexterity.checkIfSet()) {
                                playerComponent.dexterity.setStatVal(15);
                                playerComponent.fifteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }
                });
            }

            if (!playerComponent.constitution.checkIfSet()) {
                WButton setCon = new WButton();
                root.add(setCon, 150, 118);
                setCon.setOnClick(() -> {
                    WGridPanel sA = new WGridPanel();
                    sA.setSize(100, 100);
                    root.add(sA,150,0);
                    root.validate(this);

                    if (!playerComponent.eight.isUsed()) {
                        WButton eight = new WButton();
                        sA.add(eight, 1, 1);
                        WLabel eightL = new WLabel("8");
                        sA.add(eightL, 2, 1);
                        eight.setOnClick(() -> {
                            if (!playerComponent.constitution.checkIfSet()) {
                                playerComponent.constitution.setStatVal(8);
                                playerComponent.eight.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.ten.isUsed()) {
                        WButton ten = new WButton();
                        sA.add(ten, 1, 2);
                        WLabel tenL = new WLabel("10");
                        sA.add(tenL, 2, 2);
                        ten.setOnClick(() -> {
                            if (!playerComponent.constitution.checkIfSet()) {
                                playerComponent.constitution.setStatVal(10);
                                playerComponent.ten.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.twelve.isUsed()) {
                        WButton twelve = new WButton();
                        sA.add(twelve, 1, 3);
                        WLabel twelveL = new WLabel("12");
                        sA.add(twelveL, 2, 3);
                        twelve.setOnClick(() -> {
                            if (!playerComponent.constitution.checkIfSet()) {
                                playerComponent.constitution.setStatVal(12);
                                playerComponent.twelve.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.thirteen.isUsed()) {
                        WButton thirteen = new WButton();
                        sA.add(thirteen, 1, 4);
                        WLabel thirteenL = new WLabel("13");
                        sA.add(thirteenL, 2, 4);
                        thirteen.setOnClick(() -> {
                            if (!playerComponent.constitution.checkIfSet()) {
                                playerComponent.constitution.setStatVal(13);
                                playerComponent.thirteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fourteen.isUsed()) {
                        WButton fourteen = new WButton();
                        sA.add(fourteen, 1, 5);
                        WLabel fourteenL = new WLabel("14");
                        sA.add(fourteenL, 2, 5);
                        fourteen.setOnClick(() -> {
                            if (!playerComponent.constitution.checkIfSet()) {
                                playerComponent.constitution.setStatVal(14);
                                playerComponent.fourteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fifteen.isUsed()) {
                        WButton fifteen = new WButton();
                        sA.add(fifteen, 1, 6);
                        WLabel fifteenL = new WLabel("15");
                        sA.add(fifteenL, 2, 6);
                        fifteen.setOnClick(() -> {
                            if (!playerComponent.constitution.checkIfSet()) {
                                playerComponent.constitution.setStatVal(15);
                                playerComponent.fifteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }
                });
            }

            if (!playerComponent.intelligence.checkIfSet()) {
                WButton setInt = new WButton();
                root.add(setInt, 150, 143);
                setInt.setOnClick(() -> {
                    WGridPanel sA = new WGridPanel();
                    sA.setSize(100, 100);
                    root.add(sA,150,0);
                    root.validate(this);

                    if (!playerComponent.eight.isUsed()) {
                        WButton eight = new WButton();
                        sA.add(eight, 1, 1);
                        WLabel eightL = new WLabel("8");
                        sA.add(eightL, 2, 1);
                        eight.setOnClick(() -> {
                            if (!playerComponent.intelligence.checkIfSet()) {
                                playerComponent.intelligence.setStatVal(8);
                                playerComponent.eight.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.ten.isUsed()) {
                        WButton ten = new WButton();
                        sA.add(ten, 1, 2);
                        WLabel tenL = new WLabel("10");
                        sA.add(tenL, 2, 2);
                        ten.setOnClick(() -> {
                            if (!playerComponent.intelligence.checkIfSet()) {
                                playerComponent.intelligence.setStatVal(10);
                                playerComponent.ten.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.twelve.isUsed()) {
                        WButton twelve = new WButton();
                        sA.add(twelve, 1, 3);
                        WLabel twelveL = new WLabel("12");
                        sA.add(twelveL, 2, 3);
                        twelve.setOnClick(() -> {
                            if (!playerComponent.intelligence.checkIfSet()) {
                                playerComponent.intelligence.setStatVal(12);
                                playerComponent.twelve.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.thirteen.isUsed()) {
                        WButton thirteen = new WButton();
                        sA.add(thirteen, 1, 4);
                        WLabel thirteenL = new WLabel("13");
                        sA.add(thirteenL, 2, 4);
                        thirteen.setOnClick(() -> {
                            if (!playerComponent.intelligence.checkIfSet()) {
                                playerComponent.intelligence.setStatVal(13);
                                playerComponent.thirteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fourteen.isUsed()) {
                        WButton fourteen = new WButton();
                        sA.add(fourteen, 1, 5);
                        WLabel fourteenL = new WLabel("14");
                        sA.add(fourteenL, 2, 5);
                        fourteen.setOnClick(() -> {
                            if (!playerComponent.intelligence.checkIfSet()) {
                                playerComponent.intelligence.setStatVal(14);
                                playerComponent.fourteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fifteen.isUsed()) {
                        WButton fifteen = new WButton();
                        sA.add(fifteen, 1, 6);
                        WLabel fifteenL = new WLabel("15");
                        sA.add(fifteenL, 2, 6);
                        fifteen.setOnClick(() -> {
                            if (!playerComponent.intelligence.checkIfSet()) {
                                playerComponent.intelligence.setStatVal(15);
                                playerComponent.fifteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }
                });
            }

            if (!playerComponent.wisdom.checkIfSet()) {
                WButton setWis = new WButton();
                root.add(setWis, 150, 168);
                setWis.setOnClick(() -> {
                    WGridPanel sA = new WGridPanel();
                    sA.setSize(100, 100);
                    root.add(sA,150,0);
                    root.validate(this);

                    if (!playerComponent.eight.isUsed()) {
                        WButton eight = new WButton();
                        sA.add(eight, 1, 1);
                        WLabel eightL = new WLabel("8");
                        sA.add(eightL, 2, 1);
                        eight.setOnClick(() -> {
                            if (!playerComponent.wisdom.checkIfSet()) {
                                playerComponent.wisdom.setStatVal(8);
                                playerComponent.eight.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.ten.isUsed()) {
                        WButton ten = new WButton();
                        sA.add(ten, 1, 2);
                        WLabel tenL = new WLabel("10");
                        sA.add(tenL, 2, 2);
                        ten.setOnClick(() -> {
                            if (!playerComponent.wisdom.checkIfSet()) {
                                playerComponent.wisdom.setStatVal(10);
                                playerComponent.ten.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.twelve.isUsed()) {
                        WButton twelve = new WButton();
                        sA.add(twelve, 1, 3);
                        WLabel twelveL = new WLabel("12");
                        sA.add(twelveL, 2, 3);
                        twelve.setOnClick(() -> {
                            if (!playerComponent.wisdom.checkIfSet()) {
                                playerComponent.wisdom.setStatVal(12);
                                playerComponent.twelve.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.thirteen.isUsed()) {
                        WButton thirteen = new WButton();
                        sA.add(thirteen, 1, 4);
                        WLabel thirteenL = new WLabel("13");
                        sA.add(thirteenL, 2, 4);
                        thirteen.setOnClick(() -> {
                            if (!playerComponent.wisdom.checkIfSet()) {
                                playerComponent.wisdom.setStatVal(13);
                                playerComponent.thirteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fourteen.isUsed()) {
                        WButton fourteen = new WButton();
                        sA.add(fourteen, 1, 5);
                        WLabel fourteenL = new WLabel("14");
                        sA.add(fourteenL, 2, 5);
                        fourteen.setOnClick(() -> {
                            if (!playerComponent.wisdom.checkIfSet()) {
                                playerComponent.wisdom.setStatVal(14);
                                playerComponent.fourteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fifteen.isUsed()) {
                        WButton fifteen = new WButton();
                        sA.add(fifteen, 1, 6);
                        WLabel fifteenL = new WLabel("15");
                        sA.add(fifteenL, 2, 6);
                        fifteen.setOnClick(() -> {
                            if (!playerComponent.wisdom.checkIfSet()) {
                                playerComponent.wisdom.setStatVal(15);
                                playerComponent.fifteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }
                });
            }

            if (!playerComponent.charisma.checkIfSet()) {
                WButton setCha = new WButton();
                root.add(setCha, 150, 193);
                setCha.setOnClick(() -> {
                    WGridPanel sA = new WGridPanel();
                    sA.setSize(100, 100);
                    root.add(sA,150,0);
                    root.validate(this);

                    if (!playerComponent.eight.isUsed()) {
                        WButton eight = new WButton();
                        sA.add(eight, 1, 1);
                        WLabel eightL = new WLabel("8");
                        sA.add(eightL, 2, 1);
                        eight.setOnClick(() -> {
                            if (!playerComponent.charisma.checkIfSet()) {
                                playerComponent.charisma.setStatVal(8);
                                playerComponent.eight.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.ten.isUsed()) {
                        WButton ten = new WButton();
                        sA.add(ten, 1, 2);
                        WLabel tenL = new WLabel("10");
                        sA.add(tenL, 2, 2);
                        ten.setOnClick(() -> {
                            if (!playerComponent.charisma.checkIfSet()) {
                                playerComponent.charisma.setStatVal(10);
                                playerComponent.ten.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.twelve.isUsed()) {
                        WButton twelve = new WButton();
                        sA.add(twelve, 1, 3);
                        WLabel twelveL = new WLabel("12");
                        sA.add(twelveL, 2, 3);
                        twelve.setOnClick(() -> {
                            if (!playerComponent.charisma.checkIfSet()) {
                                playerComponent.charisma.setStatVal(12);
                                playerComponent.twelve.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.thirteen.isUsed()) {
                        WButton thirteen = new WButton();
                        sA.add(thirteen, 1, 4);
                        WLabel thirteenL = new WLabel("13");
                        sA.add(thirteenL, 2, 4);
                        thirteen.setOnClick(() -> {
                            if (!playerComponent.charisma.checkIfSet()) {
                                playerComponent.charisma.setStatVal(13);
                                playerComponent.thirteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fourteen.isUsed()) {
                        WButton fourteen = new WButton();
                        sA.add(fourteen, 1, 5);
                        WLabel fourteenL = new WLabel("14");
                        sA.add(fourteenL, 2, 5);
                        fourteen.setOnClick(() -> {
                            if (!playerComponent.charisma.checkIfSet()) {
                                playerComponent.charisma.setStatVal(14);
                                playerComponent.fourteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }

                    if (!playerComponent.fifteen.isUsed()) {
                        WButton fifteen = new WButton();
                        sA.add(fifteen, 1, 6);
                        WLabel fifteenL = new WLabel("15");
                        sA.add(fifteenL, 2, 6);
                        fifteen.setOnClick(() -> {
                            if (!playerComponent.charisma.checkIfSet()) {
                                playerComponent.charisma.setStatVal(15);
                                playerComponent.fifteen.setUsed(true);
                                root.remove(sA);
                                root.validate(this);
                                refreshGUI(user);
                            }
                        });
                    }
                });
            }
        }

        WButton addStr = new WButton();
        root.add(addStr, 5, 68);
        addStr.setOnClick(() -> {
            if (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) > 0) {
                playerComponent.strength.addToStat(1);
                Dracos.setComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider, (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) - 1));
                refreshGUI(user);
            }
        });

        WLabel strength = new WLabel("Str: " + playerComponent.strength.getStatTxt(playerComponent.strength.getStatVal()) + "  Mod: " + playerComponent.strength.getStatTxt(playerComponent.strength.getModifier()));
        root.add(strength, 25, 75);

        WButton addDex = new WButton();
        root.add(addDex, 5, 93);
        addDex.setOnClick(() -> {
            if (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) > 0) {
                playerComponent.dexterity.addToStat(1);
                Dracos.setComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider, (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) - 1));
                refreshGUI(user);
            }
        });

        WLabel dexterity = new WLabel("Dex: " + playerComponent.dexterity.getStatTxt(playerComponent.dexterity.getStatVal()) + "  Mod: " + playerComponent.dexterity.getStatTxt(playerComponent.dexterity.getModifier()));
        root.add(dexterity, 25, 100);

        WButton addCon = new WButton();
        root.add(addCon, 5, 118);
        addCon.setOnClick(() -> {
            if (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) > 0) {
                playerComponent.constitution.addToStat(1);
                Dracos.setComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider, (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) - 1));
                refreshGUI(user);
            }
        });

        WLabel constitution = new WLabel("Con: " + playerComponent.constitution.getStatTxt(playerComponent.constitution.getStatVal()) + "  Mod: " + playerComponent.constitution.getStatTxt(playerComponent.constitution.getModifier()));
        root.add(constitution, 25, 125);

        WButton addInt = new WButton();
        root.add(addInt, 5, 143);
        addInt.setOnClick(() -> {
            if (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) > 0) {
                playerComponent.intelligence.addToStat(1);
                Dracos.setComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider, (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) - 1));
                refreshGUI(user);
            }
        });

        WLabel intelligence = new WLabel("Int: " + playerComponent.intelligence.getStatTxt(playerComponent.intelligence.getStatVal()) + "  Mod: " + playerComponent.intelligence.getStatTxt(playerComponent.intelligence.getModifier()));
        root.add(intelligence, 25, 150);

        WButton addWis = new WButton();
        root.add(addWis, 5, 168);
        addWis.setOnClick(() -> {
            if (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) > 0) {
                playerComponent.wisdom.addToStat(1);
                Dracos.setComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider, (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) - 1));
                refreshGUI(user);
            }
        });

        WLabel wisdom = new WLabel("Wis: " + playerComponent.wisdom.getStatTxt(playerComponent.wisdom.getStatVal()) + "  Mod: " + playerComponent.wisdom.getStatTxt(playerComponent.wisdom.getModifier()));
        root.add(wisdom, 25, 175);

        WButton addCha = new WButton();
        root.add(addCha, 5, 193);
        addCha.setOnClick(() -> {
            if (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) > 0) {
                playerComponent.charisma.addToStat(1);
                Dracos.setComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider, (Dracos.getComponentPntsToSpend(Dracos.PLAYER_LEVEL, provider) - 1));
                refreshGUI(user);
            }
        });

        WLabel charisma = new WLabel("Cha: " + playerComponent.charisma.getStatTxt(playerComponent.charisma.getStatVal()) + "  Mod: " + playerComponent.charisma.getStatTxt(playerComponent.charisma.getModifier()));
        root.add(charisma, 25, 200);

    }

    private static void refreshGUI (PlayerEntity user) {

        MinecraftClient.getInstance().openScreen(null);
        MinecraftClient.getInstance().openScreen(new ExampleScreen(new CharSheet1(user)));

    }

}