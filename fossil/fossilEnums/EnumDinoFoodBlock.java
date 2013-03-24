package fossil.fossilEnums;

import net.minecraft.block.Block;
import fossil.Fossil;


public enum EnumDinoFoodBlock
{
	Cake(Block.cake,25,5),
	Carrot(Block.carrot,25,3),
	Crops(Block.crops,10,2),
	Leaves(Block.leaves,15,2),
	Melon(Block.melon,60,4),
	BrownMushroom(Block.mushroomBrown,15,1),
	RedMushroom(Block.mushroomRed,15,1),
	RedFlower(Block.plantRed,10,1),
	YellowFlower(Block.plantYellow,10,1),
	Potato(Block.potato,25,2),
	Pumpkin(Block.pumpkin,20,1),
	Reed(Block.reed,10,1),
	Sapling(Block.sapling,10,1),
	TallGrass(Block.tallGrass,10,1),
	Ferns(Fossil.ferns,50,3),
	;
    public int blockID;
    public int FoodValue;
    public int HealValue;

    private EnumDinoFoodBlock(Block block, int Food, int Heal)
    {
        blockID = block.blockID;
        FoodValue = Food;
        HealValue = Heal;
    }
    private EnumDinoFoodBlock(EnumDinoFoodBlock block0)
    {
        blockID = block0.blockID;
        FoodValue = block0.FoodValue;
        HealValue = block0.HealValue;
    }
}
