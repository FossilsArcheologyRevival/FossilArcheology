package fossil.fossilEnums;

public enum EnumEmbryos
{
    Pig(3000),
    Sheep(3000),
    Cow(3000),
    Chicken(1000),
    SaberCat(4000),
    Mammoth(6000);
    
    public int GrowTime;
    
    private EnumEmbryos(int grow0)
    {
    	GrowTime=grow0;
    }
}
