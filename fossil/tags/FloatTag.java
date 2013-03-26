package fossil.tags;

public final class FloatTag extends Tag
{
    private final float value;

    public FloatTag(String var1, float var2)
    {
        super(var1);
        this.value = var2;
    }

    public Float getValue()
    {
        return Float.valueOf(this.value);
    }

    public String toString()
    {
        String var1 = this.getName();
        String var2 = "";

        if (var1 != null && !var1.equals(""))
        {
            var2 = "(\"" + this.getName() + "\")";
        }

        return "TAG_Float" + var2 + ": " + this.value;
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
