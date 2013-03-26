package fossil.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FossilCfgLoader
{
    private static final File cfgdir = new File(".", "/config/");
    public static final File IDcfgfile = new File(cfgdir, "ModFossil.cfg");
    private static final File OptionConfigFile = new File(cfgdir, "ModFossilOptions.cfg");
    public static final Properties props = new Properties();

    public void CfgLoader() {}

    public static Properties loadIDConfig() throws IOException
    {
        cfgdir.mkdir();

        if (!IDcfgfile.exists() && !IDcfgfile.createNewFile())
        {
            return null;
        }
        else if (IDcfgfile.canRead())
        {
            FileInputStream var0 = new FileInputStream(IDcfgfile);
            props.load(var0);
            var0.close();
            return props;
        }
        else
        {
            return null;
        }
    }

    public static Properties loadOptionConfig() throws IOException
    {
        cfgdir.mkdir();

        if (!OptionConfigFile.exists() && !OptionConfigFile.createNewFile())
        {
            return null;
        }
        else if (OptionConfigFile.canRead())
        {
            FileInputStream var0 = new FileInputStream(OptionConfigFile);
            props.load(var0);
            var0.close();
            return props;
        }
        else
        {
            return null;
        }
    }

    public static void saveIDConfig(Properties var0) throws IOException
    {
        cfgdir.mkdir();

        if (IDcfgfile.exists() || IDcfgfile.createNewFile())
        {
            if (IDcfgfile.canWrite())
            {
                FileOutputStream var1 = new FileOutputStream(IDcfgfile);
                var0.store(var1, "ModFossil Config");
                var1.close();
            }
        }
    }

    public static void saveOptionConfig(Properties var0) throws IOException
    {
        cfgdir.mkdir();

        if (OptionConfigFile.exists() || OptionConfigFile.createNewFile())
        {
            if (OptionConfigFile.canWrite())
            {
                FileOutputStream var1 = new FileOutputStream(OptionConfigFile);
                var0.store(var1, "ModFossil Option Config");
                var1.close();
            }
        }
    }
}
