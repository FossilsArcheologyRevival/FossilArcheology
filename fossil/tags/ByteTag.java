package fossil.tags;

public final class ByteTag extends Tag
{
    private final byte value;

    public ByteTag(String var1, byte var2)
    {
        super(var1);
        this.value = var2;
    }

    public Byte getValue()
    {
        return Byte.valueOf(this.value);
    }

    public String toString()
    {
        String var1 = this.getName();
        String var2 = "";

        if (var1 != null && !var1.equals(""))
        {
            var2 = "(\"" + this.getName() + "\")";
        }

        return "TAG_Byte" + var2 + ": " + this.value;
    }

    /*public Object getValue()
    {
        return this.getValue();
    }*/
}
