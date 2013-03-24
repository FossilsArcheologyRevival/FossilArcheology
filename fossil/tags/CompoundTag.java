package fossil.tags;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class CompoundTag extends Tag
{
    private final Map value;

    public CompoundTag(String var1, Map var2)
    {
        super(var1);
        this.value = Collections.unmodifiableMap(var2);
    }

    public Map getValue()
    {
        return this.value;
    }

    public String toString()
    {
        String var1 = this.getName();
        String var2 = "";

        if (var1 != null && !var1.equals(""))
        {
            var2 = "(\"" + this.getName() + "\")";
        }

        StringBuilder var3 = new StringBuilder();
        var3.append("TAG_Compound" + var2 + ": " + this.value.size() + " entries\r\n{\r\n");
        Iterator var4 = this.value.entrySet().iterator();

        while (var4.hasNext())
        {
            Entry var5 = (Entry)var4.next();
            var3.append("   " + ((Tag)var5.getValue()).toString().replaceAll("\r\n", "\r\n   ") + "\r\n");
        }

        var3.append("}");
        return var3.toString();
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
