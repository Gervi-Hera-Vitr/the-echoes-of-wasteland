package me.lugaru.gaming.inventory;


public enum Items {
    PICKPOCKET("Pick pocket", "Be able to steal undetected! Just don't pick the wrong pocket or you'll end up with some weird looks...", 5, 0, "Agility"),
    BAREHANDED("Barehanded", "Guns are for weaklings, use your fist or a hammer instead! HAMMER THAT MAN HARD!!!", 10, 0, "Strength"),
    BETTERBARTERING("Better bartering", "Get something expensive for cheap just like that! Did you seduce the barterer?", 10, 0, "Charisma"),
    CRITKING("Crit King", "Always hit crits! Your girl will be begging for more!", 10, 0, "Perception"),
    SILVERTOUNGE("Silvertounge", "Smooth Talk everyone and their mommas! Especially their mommas!", 5, 0,"Charisma"),
    RADCHILD("Rad Children", "Survive the wasteland with RadAway! Suck the radiation right out of your...", 5, 0, "Endurance"),
    PACKMULE("Packmule", "Show off those muscles! Just don't show too many muscles...", 5, 0, "Strength"),
    DEADEYE("Deadeye", "Hit all of your targets dead on! No more missing 5 times in a row when trying to shove it in!", 5, 0, "Perception"),
    WEALTHFINDER("Wealth finder", "Find all that the Wasteland has to offer! Besides the RadRoaches, Mutants, and the gas-powered vibrators!", 5, 0, "Luck"),
    TANKY("Tanky", "Wow! Now I can call you the 'Beefy D'!", 10, 0, "Endurance"),
    DODGY("Dodgy", "Enemies now have a less chance at hitting you! But you will have less chance hitting it... well screw the hoes!s", 10, 0, "Agility"),
    HACKING("Hacking and cracking", "Hack all of the Computers and Break into all of your neighbors computers and steal there pornhub subscriptions!", 5, 0, "Intelligence"),
    CRAFTER("Craft N Scrap", "Scrap and Craft all you want! Armor, Tools, Explosives! You name it! Just... don't try crafting dildos...", 10, 0, "Intelligence"),
    SECONDCHANCE("SecondChance", "When on the edge of life and death, you choose life. Or maybe death... actually I think you choose life.", 10, 0,"Luck"),;

    public final String name;
    public final String description;
    public final int levelRequirement;
    public int lvl;
    String PerkType;

    Items(String name, String description, int levelRequirement, int lvl, String perkType ) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.lvl = lvl;
        this.PerkType = perkType;




    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Override
    public String toString() {
        return name + " (Level " + levelRequirement + "): " + description;
    }
}
