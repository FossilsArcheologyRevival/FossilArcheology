package fossil.entity.mob;

import fossil.fossilEnums.EnumDinoFoodMob;

public class DinoFoodMobList {
	
	EnumDinoFoodMob[] Mobs;
	
	int index;	
	
	public DinoFoodMobList()
	{
		index=0;
		this.Mobs = new EnumDinoFoodMob[100];
	}
	public void addMob(EnumDinoFoodMob mob)
	{
		this.Mobs[index]=mob;
		index++;
	}
	public boolean CheckMobByClass(Class mobclass)
	{
		for (int i=0;i<index;i++)
		{
			if (Mobs[i].preyClass == mobclass)
				return true;
		}
		return false;
	}
	public int getMobFood(Class mobclass)
	{
		for (int i=0;i<index;i++)
		{
			if (Mobs[i].preyClass == mobclass)
				return Mobs[i].FoodValue;
		}
		return 0;	
	}
	public int getMobHeal(Class mobclass)
	{
		for (int i=0;i<index;i++)
		{
			if (Mobs[i].preyClass == mobclass)
				return Mobs[i].HealValue;
		}
		return 0;	
	}
	public boolean IsEmpty()
	{
		return index==0;
	}
}
