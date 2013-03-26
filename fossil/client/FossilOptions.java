package fossil.client;

public class FossilOptions
{
    public static boolean ShouldAnuSpawn = true;
    public static boolean SpawnShipwrecks = true;
    public static boolean SpawnWeaponShop = true;
    public static boolean SpawnAcademy = true;
    public static boolean DinoGrows = true;
    public static boolean DinoHunger = true;
    public static boolean TRexBreakingBlocks = false;
    public static boolean BraBreakingBlocks = false;
    public static boolean PalaeorapheSpawn = false;
    public static final String[] negWords = new String[] {"false", "no", "off", "close"};

    public static boolean isNegtiveWord(String var0)
    {
        for (int var1 = 0; var1 < negWords.length; ++var1)
        {
            if (var0.equalsIgnoreCase(negWords[var1]))
            {
                return true;
            }
        }

        return false;
    }
}
