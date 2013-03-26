package fossil.fossilEnums;

public enum EnumStoneboard
{
    Lighting("Lighting", 0, "Lighting", 32, 16, 0, 0),
    Sociel("Sociel", 1, "Sociel", 16, 16, 32, 0),
    Greatwar("Greatwar", 2, "Greatwar", 32, 32, 0, 16),
    Killboss("Killboss", 3, "Killboss", 32, 16, 0, 48),
    Portol("Portol", 4, "Portol", 32, 32, 0, 64),
    Herobine("Herobine", 5, "Herobine", 32, 32, 32, 32),
    FlatCreep("FlatCreep", 6, "FlatCreep", 16, 16, 48, 0),
    annoyangry("annoyangry", 7, "annoyangry", 16, 16, 48, 16),
    Rex1("Rex1", 8, "Rex1", 32, 32, 64, 0),
    Rex2("Rex2", 9, "Rex2", 32, 16, 64, 32),
    Rex3("Rex3", 10, "Rex3", 32, 16, 64, 48),
    Rex4("Rex4", 11, "Rex4", 32, 32, 64, 64),
    Puzzle("Puzzle", 12, "Puzzle", 32, 32, 32, 64),
    GunFight("GunFight", 13, "GunFight", 64, 32, 32, 96),
    Pricess("Pricess", 14, "Pricess", 32, 32, 0, 96),
    Mosa("Mosa", 15, "Mosa", 32, 16, 64, 128),
    HolyMosa("HolyMosa", 16, "HolyMosa", 64, 32, 0, 128),
    AnciTM("AnciTM", 17, "AnciTM", 32, 32, 96, 0),
    ModTM("ModTM", 18, "ModTM", 16, 32, 128, 0),
    VigTM("VigTM", 19, "ModTM", 32, 32, 144, 0);
    public static final int maxArtTitleLength = "annoyangry".length();
    public final String title;
    public final int sizeX;
    public final int sizeY;
    public final int offsetX;
    public final int offsetY;
    private static final EnumStoneboard[] allArt = new EnumStoneboard[]{Lighting, Sociel, Greatwar, Killboss, Portol, Herobine, FlatCreep, annoyangry, Rex1, Rex2, Rex3, Rex4, Puzzle, GunFight, Pricess, Mosa, HolyMosa, AnciTM, ModTM, VigTM};

    private EnumStoneboard(String var3, int var4, String var5, int var6, int var7, int var8, int var9)
    {
        this.title = var5;
        this.sizeX = var6;
        this.sizeY = var7;
        this.offsetX = var8;
        this.offsetY = var9;
    }
}
