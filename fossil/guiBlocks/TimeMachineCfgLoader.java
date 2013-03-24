package fossil.guiBlocks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import net.minecraft.client.Minecraft;

public class TimeMachineCfgLoader
{
    private static final File cfgdir = new File(Minecraft.getMinecraftDir(), "/config/");
    private static final File cfgfile = new File(cfgdir, "AddonTimeMachine.cfg");
    public static final Properties props = new Properties();

    public void CfgLoader() {}

    public static Properties loadConfig() throws IOException
    {
        cfgdir.mkdir();

        if (!cfgfile.exists() && !cfgfile.createNewFile())
        {
            return null;
        }
        else if (cfgfile.canRead())
        {
            FileInputStream var0 = new FileInputStream(cfgfile);
            props.load(var0);
            var0.close();
            return props;
        }
        else
        {
            return null;
        }
    }

    public static void saveConfig(Properties var0) throws IOException
    {
        cfgdir.mkdir();

        if (cfgfile.exists() || cfgfile.createNewFile())
        {
            if (cfgfile.canWrite())
            {
                FileOutputStream var1 = new FileOutputStream(cfgfile);
                var0.store(var1, "AddonTimeMachine Config");
                var1.close();
            }
        }
    }
}
