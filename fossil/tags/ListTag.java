package fossil.tags;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ListTag extends Tag
{
    private final Class type;
    private final List value;

    public ListTag(String var1, Class var2, List var3)
    {
        super(var1);
        this.type = var2;
        this.value = Collections.unmodifiableList(var3);
    }

    public Class getType()
    {
        return this.type;
    }

    public List getValue()
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
        var3.append("TAG_List" + var2 + ": " + this.value.size() + " entries of type " + NBTUtils.getTypeName(this.type) + "\r\n{\r\n");
        Iterator var4 = this.value.iterator();

        while (var4.hasNext())
        {
            Tag var5 = (Tag)var4.next();
            var3.append("   " + var5.toString().replaceAll("\r\n", "\r\n   ") + "\r\n");
        }

        var3.append("}");
        return var3.toString();
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
