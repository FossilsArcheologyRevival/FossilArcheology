package fossil;

import java.util.Random;

public class RelicHoleList
{
    private RelicHole[] Holes;
    private int DEFAULT_HOLE_COUNT = 9;
    private int DEFAULT_HOLE_SIZE = 7;

    public RelicHoleList(Random var1, int var2, int var3, int var4, byte[] var5, int var6, int var7)
    {
        if (var6 < 0)
        {
            var6 = this.DEFAULT_HOLE_COUNT;
        }

        if (var7 < 0)
        {
            var7 = this.DEFAULT_HOLE_SIZE;
        }

        this.Holes = new RelicHole[var6 + 1];

        for (int var8 = 0; var8 < this.Holes.length; ++var8)
        {
            this.Holes[var8] = new RelicHole(var1, var2, var3, var4, var5, var7);
        }
    }

    public boolean isHole(int var1, int var2, int var3)
    {
        for (int var4 = 0; var4 < this.Holes.length; ++var4)
        {
            if (this.Holes[var4].isHole(var1, var2, var3))
            {
                return true;
            }
        }

        return false;
    }
}
