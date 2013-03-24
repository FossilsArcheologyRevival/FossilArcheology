package fossil.fossilEnums;

import net.minecraft.item.Item;
import fossil.Fossil;


public enum EnumDinoFoodItem
{
	Wheat(Item.wheat,10,2),//Veggie Foods
	Melon(Item.melon,10,2),
	Apple(Item.appleRed,15,3),
	Potato(Item.potato,10,2),
	BakedPotato(Item.bakedPotato,15,3),	
	Cake(Item.cake,25,5),
	Carrot(Item.carrot,10,2),
	Cookie(Item.cookie,15,4),
	PumpkinPie(Item.pumpkinPie,20,4),
	Sugar(Item.sugar,10,2),
	Bread(Item.bread,25,2),
	
	FishRaw(Item.fishRaw,30,3),//this MUST BE the first carnivore food!
	FishCooked(Item.fishCooked,40,4),
	BeefCooked(Item.beefCooked,50,5),
	BeefRaw(Item.beefRaw,40,4),
	ChickenCooked(Item.chickenCooked,30,3),
	ChickenRaw(Item.chickenRaw,40,4),
	PorkRaw(Item.porkRaw,30,2),
	PorkCooked(Item.porkCooked,50,3),
	Egg(Item.egg,10,2),
	Sjl(Fossil.sjl,30,3),//SioChiuLe
	Nautilus(Fossil.rawNautilus,20,2),
	ChickenSoupRaw(Fossil.rawChickenSoup,30,3),
	ChickenSoupCooked(Fossil.cookedChickenSoup,40,3),
	ChickenEssence(Fossil.chickenEss,60,10),
	Triceratops(Fossil.rawTriceratops,50,3),
	Raptor(Fossil.rawVelociraptor,20,3),
	TRex(Fossil.rawTRex,20,3),
	Pterosaur(Fossil.rawPterosaur,15,2),
	Plesiosaur(Fossil.rawPlesiosaur,30,3),
	Mosasaur(Fossil.rawMosasaurus,20,3),
	Stegosaur(Fossil.rawStegosaurus,50,3),
	Dilophosaurus(Fossil.rawDilophosaurus,25,2),
	Brachiosaur(Fossil.rawBrachiosaurus,50,4),
	DinoMeatCooked(Fossil.cookedDinoMeat,50,5),	
	//DinoMeatRaw(Fossil.rawDinoMeat,30,3)
	;
    public Item item;
    public int FoodValue;
    public int HealValue;
    
    public static final int ISHERBIVOROUS=1;
    public static final int ISCARNIVOROUS=-1;
    public static final int ISNOFOOD=0;

    /*private EnumDinoFoodItem(EnumDinoFoodItem Item0)
    {
        item = Item0;
        FoodValue = Item0.FoodValue;
        HealValue = Item0.HealValue;
    }*/
    private EnumDinoFoodItem(Item item0, int Food, int Heal)
    {
        item = item0;
        FoodValue = Food;
        HealValue = Heal;
    }
    
    /**
     * 
     * Takes the itemid and tells if its herbivore, carnivore or no food 
     */
    public static int foodtype(int i0)
    {
		for (int i=0;i<EnumDinoFoodItem.values().length;i++)//check all entries
		{
			if (EnumDinoFoodItem.values()[i].item.itemID==i0)//found it in the list
			{
				if(i<EnumDinoFoodItem.FishRaw.ordinal())//its before SJL, the first carn. food
					return ISHERBIVOROUS;
				return ISCARNIVOROUS;
			}
		}
		return ISNOFOOD;//wasnt found at all
    }
    
    /**
     * 
     * Takes the itemid and gives the food value
     */
    public static int getItemFood(int i0)
	{
		for (int i=0;i<EnumDinoFoodItem.values().length;i++)
		{
			if (EnumDinoFoodItem.values()[i].item.itemID==i0)
				return EnumDinoFoodItem.values()[i].FoodValue;
		}
		return 0;	
	}
}
