package fossil.tags;

public final class StringTag extends Tag
{
    private final String value;

    public StringTag(String var1, String var2)
    {
        super(var1);
        this.value = var2;
    }

    public String getValue()
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

        return "TAG_String" + var2 + ": " + this.value;
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
