package fossil.gens;

import fossil.fossilEnums.EnumShipTypes;


class WorldGenShipWreck$1
{
    static final int[] $SwitchMap$mod_Fossil$EnumShipTypes = new int[EnumShipTypes.values().length];

    static
    {
        try
        {
            $SwitchMap$mod_Fossil$EnumShipTypes[EnumShipTypes.Science.ordinal()] = 1;
        }
        catch (NoSuchFieldError var4)
        {
            ;
        }

        try
        {
            $SwitchMap$mod_Fossil$EnumShipTypes[EnumShipTypes.MetalTrader.ordinal()] = 2;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            $SwitchMap$mod_Fossil$EnumShipTypes[EnumShipTypes.Battleship.ordinal()] = 3;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            $SwitchMap$mod_Fossil$EnumShipTypes[EnumShipTypes.Cargo.ordinal()] = 4;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
