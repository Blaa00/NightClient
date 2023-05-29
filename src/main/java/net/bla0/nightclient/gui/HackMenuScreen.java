package net.bla0.nightclient.gui;

import net.bla0.nightclient.NightClient;
import net.bla0.nightclient.modules.ListModule;
import net.bla0.nightclient.modules.ModuleRegistry;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;

public class HackMenuScreen extends Screen {

    private Screen parent;
    public HackMenuScreen(Screen parent) {
        super(Text.of("Nightclient Options"));
        this.parent = parent;
    }

    Text listText() {
        if (ModuleRegistry.getByAlias("list").enabled) {
            return Text.of("List is Enabled");
        } else {
            return Text.of("List is Disabled");
        }
    }
    Text elytraText() {
        if (ModuleRegistry.getByAlias("elytra").enabled) {
            return Text.of("ElytraFly is Enabled");
        } else {
            return Text.of("ElytraFly is Disabled");
        }
    }
    Text freezeText() {
        if (ModuleRegistry.getByAlias("freeze").enabled) {
            return Text.of("Freeze is Enabled");
        } else {
            return Text.of("Freeze is Disabled");
        }
    }
    Text xrayText() {
        if (ModuleRegistry.getByAlias("xray").enabled) {
            return Text.of("Xray is Enabled");
        } else {
            return Text.of("Xray is Disabled");
        }
    }
    Text fullbrightText() {
        if (ModuleRegistry.getByAlias("fullbright").enabled) {
            return Text.of("Fullbright is Enabled");
        } else {
            return Text.of("Fullbright is Disabled");
        }
    }
    Text freecamText() {
        if (ModuleRegistry.getByAlias("freecam").enabled) {
            return Text.of("Freecam is Enabled");
        } else {
            return Text.of("Freecam is Disabled");
        }
    }
    Text sprintText() {
        if (ModuleRegistry.getByAlias("sprint").enabled) {
            return Text.of("Sprint is Enabled");
        } else {
            return Text.of("Sprint is Disabled");
        }
    }
    Text speedText() {
        if (ModuleRegistry.getByAlias("speed").enabled) {
            return Text.of("Speed is Enabled");
        } else {
            return Text.of("Speed is Disabled");
        }
    }

    Text nofallText() {
        if (ModuleRegistry.getByAlias("nofall").enabled) {
            return Text.of("No Fall is Enabled");
        } else {
            return Text.of("No Fall is Disabled");
        }
    }

    Text flyText() {
        if (ModuleRegistry.getByAlias("fly").enabled) {
            return Text.of("Fly is Enabled");
        } else {
            return Text.of("Fly is Disabled");
        }
    }

    @Override
    protected void init() {
        this.addDrawableChild(new ButtonWidget.Builder(listText(), (button) -> {
            ModuleRegistry.getByAlias("list").setEnabled(!ModuleRegistry.getByAlias("list").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 2, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(elytraText(), (button) -> {
            ModuleRegistry.getByAlias("elytra").setEnabled(!ModuleRegistry.getByAlias("elytra").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 23, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(freezeText(), (button) -> {
            ModuleRegistry.getByAlias("freeze").setEnabled(!ModuleRegistry.getByAlias("freeze").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 44, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(xrayText(), (button) -> {
            ModuleRegistry.getByAlias("xray").setEnabled(!ModuleRegistry.getByAlias("xray").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 65, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(fullbrightText(), (button) -> {
            ModuleRegistry.getByAlias("fullbright").setEnabled(!ModuleRegistry.getByAlias("fullbright").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 86, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(freecamText(), (button) -> {
            ModuleRegistry.getByAlias("freecam").setEnabled(!ModuleRegistry.getByAlias("freecam").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 107, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(sprintText(), (button) -> {
            ModuleRegistry.getByAlias("sprint").setEnabled(!ModuleRegistry.getByAlias("sprint").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 128, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(speedText(), (button) -> {
            ModuleRegistry.getByAlias("speed").setEnabled(!ModuleRegistry.getByAlias("speed").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 149, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(nofallText(), (button) -> {
            ModuleRegistry.getByAlias("nofall").setEnabled(!ModuleRegistry.getByAlias("nofall").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 170, 200, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(flyText(), (button) -> {
            ModuleRegistry.getByAlias("fly").setEnabled(!ModuleRegistry.getByAlias("fly").enabled);
            this.client.setScreen(this);
        }).dimensions(2, 191, 200, 20).build());
        NightClient.speed.createWidget(this.client.options, 204, 149, 200);
    }
}
