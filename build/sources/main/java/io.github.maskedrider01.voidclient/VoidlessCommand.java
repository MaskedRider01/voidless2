package io.github.maskedrider01.voidclient;

import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;
import gg.essential.api.utils.GuiUtil;
import net.minecraft.client.gui.GuiScreen;

public class VoidlessCommand extends Command {
    public VoidlessCommand() {
        super("voidless");
    }

    @DefaultHandler
    public void handle() {
        GuiUtil.open((GuiScreen)VoidlessClient.instance.getConfig().gui());
    }
}
