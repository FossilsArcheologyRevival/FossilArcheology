package fossil.fossilInterface;

import fossil.fossilEnums.EnumOrderType;


public interface IDino
{
    int GROW_TIME_COUNT = 12000;

    String getOwnerName();

    void setOwner(String var1);

    boolean isTamed();

    void setTamed(boolean var1);

    void SetOrder(EnumOrderType var1);

    boolean HandleEating(int var1);

    boolean HandleEating(int var1, boolean var2);

    boolean CheckEatable(int var1);
}
