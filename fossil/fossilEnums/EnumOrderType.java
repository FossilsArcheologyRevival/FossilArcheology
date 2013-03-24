package fossil.fossilEnums;

import fossil.Fossil;
public enum EnumOrderType
{
    Stay,
    Follow,
    FreeMove;

    public final EnumOrderType Next()
    {
    	return this.values()[(this.ordinal()+1)%this.values().length];
        /*switch (this.ordinal())
        {
            case 1:return Follow;
            case 2:return FreeMove;
            case 3:return Stay;
            default:return FreeMove;
        }*/
    }
    /*public final String GetOrderString()
    {
        return Fossil.GetLangTextByKey("Order." + this.toString());
    }*/
}
