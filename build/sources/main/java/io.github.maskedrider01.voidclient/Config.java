package io.github.maskedrider01.voidclient;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {
    @Property(type = PropertyType.SWITCH, name = "Sprint", category = "Module", subcategory = "General", description = "ON / OFF")
    public boolean isSprintEnabled;

    @Property(type = PropertyType.SWITCH, name = "Discord Status", category = "Discord RP", subcategory = "Status", description = "You can change your Discord Status,But your must game restart")
    public boolean isDiscordRPEnabled;

    @Property(type = PropertyType.TEXT, name = "App ID", category = "Discord RP", subcategory = "Text", description = "You Must type your Discord App ID", protectedText = true)
    public String discordRPApplicationId;

    @Property(type = PropertyType.TEXT, name = "Original Discord Status Line 1", category = "Discord RP", subcategory = "Text", description = "First Line")
    public String discordRPFirstLine;

    @Property(type = PropertyType.TEXT, name = "Original Discord Status Line 2", category = "Discord RP", subcategory = "Text", description = "Second Line")
    public String discordRPSecondLine;

    @Property(type = PropertyType.TEXT, name = "Original Discord Status Large Image", category = "Discord RP", subcategory = "Image", description = "Large Image")
    public String discordRPLargeIcon;

    @Property(type = PropertyType.TEXT, name = "Original Discord Status Small Image", category = "Discord RP", subcategory = "Image", description = "Small Image")
    public String discordRPSmallIcon;



    public Config() {
        super(new File("./config/voidless_client.toml"));
        this.isSprintEnabled = true;
        this.isDiscordRPEnabled = true;
        this.discordRPApplicationId = "972045094825897985";
        this.discordRPFirstLine = "This is Minecraft Client";
        this.discordRPSecondLine = "Version:1.8.9";
        this.discordRPLargeIcon = "newimage";
        this.discordRPSmallIcon = "booooooooooooooooooooooost";
        initialize();
    }
}