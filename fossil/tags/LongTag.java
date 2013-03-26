package fossil.tags;

public final class LongTag extends Tag
{
    private final long value;

    public LongTag(String var1, long var2)
    {
        super(var1);
        this.value = var2;
    }

    public Long getValue()
    {
        return Long.valueOf(this.value);
    }

    public String toString()
    {
        String var1 = this.getName();
        String var2 = "";

        if (var1 != null && !var1.equals(""))
        {
            var2 = "(\"" + this.getName() + "\")";
        }

        return "TAG_Long" + var2 + ": " + this.value;
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
