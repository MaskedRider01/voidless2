package io.github.maskedrider01.voidclient;

import gg.essential.api.EssentialAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = "voidlessclient", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class VoidlessClient {
    public static final String MODID = "voidlessclient";

    public static final String VERSION = "1.0";

    private Config config;

    @Instance("voidlessclient")
    public static VoidlessClient instance;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        this.config = new Config();
        if (this.config.isDiscordRPEnabled)
            (new DiscordRP()).start();
        MinecraftForge.EVENT_BUS.register(this);
        EssentialAPI.getCommandRegistry().registerCommand(new VoidlessCommand());
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (this.config.isSprintEnabled)
            KeyBinding.func_74510_a((Minecraft.func_71410_x()).field_71474_y.field_151444_V.func_151463_i(), true);
    }

    public Config getConfig() {
        return this.config;
    }
}