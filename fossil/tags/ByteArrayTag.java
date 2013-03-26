package fossil.tags;

public final class ByteArrayTag extends Tag
{
    private final byte[] value;

    public ByteArrayTag(String var1, byte[] var2)
    {
        super(var1);
        this.value = var2;
    }

    public byte[] getValue()
    {
        return this.value;
    }

    public String toString()
    {
        StringBuilder var1 = new StringBuilder();
        byte[] var2 = this.value;
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            byte var5 = var2[var4];
            String var6 = Integer.toHexString(var5).toUpperCase();

            if (var6.length() == 1)
            {
                var1.append("0");
            }

            var1.append(var6).append(" ");
        }

        String var7 = this.getName();
        String var8 = "";

        if (var7 != null && !var7.equals(""))
        {
            var8 = "(\"" + this.getName() + "\")";
        }

        return "TAG_Byte_Array" + var8 + ": " + var1.toString();
    }

    //public Object getValue()
    //{
    //    return this.getValue();
    //}
}
