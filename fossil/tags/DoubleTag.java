package fossil.tags;

public final class DoubleTag extends Tag
{
    private final double value;

    public DoubleTag(String var1, double var2)
    {
        super(var1);
        this.value = var2;
    }

    public Double getValue()
    {
        return Double.valueOf(this.value);
    }

    public String toString()
    {
        String var1 = this.getName();
        String var2 = "";

        if (var1 != null && !var1.equals(""))
        {
            var2 = "(\"" + this.getName() + "\")";
        }

        return "TAG_Double" + var2 + ": " + this.value;
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
