package fossil.tags;

public final class ShortTag extends Tag
{
    private final short value;

    public ShortTag(String var1, short var2)
    {
        super(var1);
        this.value = var2;
    }

    public Short getValue()
    {
        return Short.valueOf(this.value);
    }

    public String toString()
    {
        String var1 = this.getName();
        String var2 = "";

        if (var1 != null && !var1.equals(""))
        {
            var2 = "(\"" + this.getName() + "\")";
        }

        return "TAG_Short" + var2 + ": " + this.value;
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
