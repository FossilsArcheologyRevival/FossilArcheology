package fossil.client;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class IDException extends IllegalArgumentException
{
    private File cfgLocation;
    private HashSet ConflictedID = new HashSet();

    public IDException setLoc(File var1)
    {
        this.cfgLocation = var1;
        return this;
    }

    public boolean IsConflicted()
    {
        return !this.ConflictedID.isEmpty();
    }

    public void add(int var1)
    {
        this.ConflictedID.add(Integer.valueOf(var1));
    }

    public String getMessage()
    {
        String var1 = "/config/mod_Fossil.cfg";

        try
        {
            var1 = this.cfgLocation.getCanonicalPath();
        }
        catch (IOException var4)
        {
            var4.printStackTrace();
        }

        StringBuilder var2 = (new StringBuilder()).append("[mod_Fossil Error]ID conflicted at ID:\n");
        Iterator var3 = this.ConflictedID.iterator();

        while (var3.hasNext())
        {
            var2.append(var3.next()).append(' ');
        }

        var2.append('\n').append("Please change ID at ").append(var1);
        return var2.toString();
    }
}
