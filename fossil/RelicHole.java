package fossil;

import java.util.Random;

public class RelicHole
{
    public int CordX;
    public int CordY;
    public int CordZ;
    public int range;
    public int MixedIndex;

    public RelicHole()
    {
        this.CordX = this.CordY = this.CordZ = 0;
    }

    public RelicHole(Random var1, int var2, int var3, int var4, byte[] var5, int var6)
    {
        do
        {
            this.CordX = var1.nextInt(var2);
            this.CordY = var1.nextInt(var3);
            this.CordZ = var1.nextInt(var4);
            this.MixedIndex = this.CordY * var2 * var4 + this.CordZ * var2 + this.CordX;
        }
        while (var5[this.MixedIndex] == 0);

        this.range = var1.nextInt(var6) + 1;
    }

    public boolean isHole(int var1, int var2, int var3)
    {
        int var4 = (int)Math.sqrt(Math.pow((double)(this.CordX - var1), 2.0D) + Math.pow((double)(this.CordY - var2), 2.0D) + Math.pow((double)(this.CordZ - var3), 2.0D));
        return var4 <= this.range;
    }
}
