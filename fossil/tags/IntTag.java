package fossil.tags;

public final class IntTag extends Tag
{
    private final int value;

    public IntTag(String var1, int var2)
    {
        super(var1);
        this.value = var2;
    }

    public Integer getValue()
    {
        return Integer.valueOf(this.value);
    }

    public String toString()
    {
        String var1 = this.getName();
        String var2 = "";

        if (var1 != null && !var1.equals(""))
        {
            var2 = "(\"" + this.getName() + "\")";
        }

        return "TAG_Int" + var2 + ": " + this.value;
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
