package io.github.maskedrider01.voidclient;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {
    private boolean running = true;

    private long created = 0L;

    public void start() {
        this.created = System.currentTimeMillis();
        DiscordEventHandlers handlers = (new DiscordEventHandlers.Builder()).setReadyEventHandler(new ReadyCallback() {
            public void apply(DiscordUser user) {
                System.out.println("Discord: " + user.username + "#" + user.discriminator);
                DiscordRP.this.update();
            }
        }).build();
        String applicationId = (VoidlessClient.instance.getConfig()).discordRPApplicationId;
        if (applicationId.equals("")) {
            System.out.println("Discord: No application ID found.");
            return;
        }
        DiscordRPC.discordInitialize(applicationId, handlers, true);
        (new Thread("Discord RPC Callback") {
            public void run() {
                while (DiscordRP.this.running)
                    DiscordRPC.discordRunCallbacks();
            }
        }).start();
    }

    public void shutdown() {
        this.running = false;
        DiscordRPC.discordShutdown();
    }

    public void update() {
        String firstLine = (VoidlessClient.instance.getConfig()).discordRPFirstLine;
        String secondLine = (VoidlessClient.instance.getConfig()).discordRPSecondLine;
        String largeIcon = (VoidlessClient.instance.getConfig()).discordRPLargeIcon;
        String smallIcon = (VoidlessClient.instance.getConfig()).discordRPSmallIcon;
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage(largeIcon, "");
        b.setSmallImage(smallIcon, "");
        b.setDetails(firstLine);
        b.setStartTimestamps(this.created);
        DiscordRPC.discordUpdatePresence(b.build());
    }
}
