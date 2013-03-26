package fossil.fossilAI;

import fossil.client.FossilOptions;
import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilEnums.EnumOrderType;
import fossil.fossilEnums.EnumSituation;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class DinoAIStarvation extends EntityAIBase
{
    EntityDinosaurce mover = null;

    public DinoAIStarvation(EntityDinosaurce var1)
    {
        this.mover = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        //if (FossilOptions.DinoHunger)
        //{
            this.mover.decreaseHungerTick();
            return this.mover.getHungerTick() <= 0;// && this.mover.worldObj.difficultySetting > 0;
        //}
        //return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        //this.mover.getClass();
        this.mover.setHungerTick(300);
        this.mover.decreaseHunger();
        if(this.mover.IsDeadlyHungry() && this.mover.OrderStatus!=EnumOrderType.FreeMove)
        {
        	this.mover.OrderStatus=EnumOrderType.FreeMove;
        	this.mover.SendStatusMessage(EnumSituation.StarveEsc);
        }
        if(this.mover.ItemInMouth != null)//The Dino has something in its mouth and gets hungry
        {
        	if(this.mover.FoodItemList.CheckItemById(this.mover.ItemInMouth.itemID))
        	{//its food
        		if(this.mover.IsHungry() || this.mover.MaxHunger-this.mover.getHunger()>this.mover.FoodItemList.getItemFood(this.mover.ItemInMouth.itemID))
            	{//it's hungry or there is enough place in the stomach free
            		this.mover.setHunger(this.mover.getHunger()+this.mover.FoodItemList.getItemFood(this.mover.ItemInMouth.itemID));
            		this.mover.ItemInMouth = null;
            	}
        	}
        	else
        	{//no food
        		if(this.mover.IsHungry())
        		{//The Dino gets hungry and because of that spits the object out of the mouth
        			this.mover.entityDropItem(new ItemStack(this.mover.ItemInMouth.itemID, 1, 0), 0.5F);
        			this.mover.ItemInMouth=null;
        		}
        	}
        }

        if (this.mover.getHunger() <= 0)
        {
            this.handleStarvation();
        }
    }

    private void handleStarvation()
    {
    	if(this.mover.getHealth()<=5)
    		this.mover.SendStatusMessage(EnumSituation.Starve);
        this.mover.attackEntityFrom(DamageSource.starve, 5);
    }
}
