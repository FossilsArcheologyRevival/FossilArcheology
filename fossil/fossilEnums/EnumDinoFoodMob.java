package fossil.fossilEnums;

import fossil.Fossil;
import fossil.entity.mob.EntityMosasaurus;
import fossil.entity.mob.EntityNautilus;
import fossil.entity.mob.EntityPlesiosaur;
import fossil.entity.mob.EntityPterosaur;
import fossil.entity.mob.EntityVelociraptor;
import fossil.entity.mob.EntityStegosaurus;
import fossil.entity.mob.EntityTRex;
import fossil.entity.mob.EntityTriceratops;
import fossil.entity.mob.EntityDilophosaurus;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import fossil.entity.mob.EntityBrachiosaurus;


public enum EnumDinoFoodMob
{
	Player(EntityPlayer.class,30,2),
	Chicken(EntityChicken.class,20,2),
	Cow(EntityCow.class,50,5),
	Pig(EntityPig.class,30,3),
	Sheep(EntitySheep.class,35,3),
	Squid(EntitySquid.class,30,3),
	Mob(EntityMob.class,20,1),
	Nautilus(EntityNautilus.class,100,5),
	Triceratops(EntityTriceratops.class,50,3),
	Raptor(EntityVelociraptor.class,20,3),
	TRex(EntityTRex.class,70,5),
	Pterosaur(EntityPterosaur.class,35,2),
	Plesiosaur(EntityPlesiosaur.class,50,3),
	Mosasaur(EntityMosasaurus.class,50,3),
	Stegosaur(EntityStegosaurus.class,50,3),
	Dilophosaurus(EntityDilophosaurus.class,25,2),
	Brachiosaur(EntityBrachiosaurus.class,80,5),
	;
    public Class preyClass;
    public int FoodValue;
    public int HealValue;

    private EnumDinoFoodMob(Class pClass, int Food, int Heal)
    {
        preyClass = pClass;
        FoodValue = Food;
        HealValue = Heal;
    }
    private EnumDinoFoodMob(EnumDinoFoodMob mob0)
    {
        preyClass = mob0.preyClass;
        FoodValue = mob0.FoodValue;
        HealValue = mob0.HealValue;
    }
}
