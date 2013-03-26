package fossil.fossilAI;

import java.util.Collections;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import fossil.entity.mob.EntityDinosaurce;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class DinoAIPickItems extends EntityAIBase
{
    private EntityDinosaurce Dino;
    private double destX;
    private double destY;
    private double destZ;
    
    // The dinos speed
    private float Speed;
    
    //the range in which the dino is able to look for items
    private final int SEARCH_RANGE;
    
    //the range the dino is able to get the item when in
    private final int USE_RANGE = 3;
    
    //the range the dino is searching for at the moment
    private int RANGE;
    
    //The item the dino is going to take
    private EntityItem targetItem;
    private DinoAINearestAttackableTargetSorter targetSorter;

    /**
     * Creates The AI, Input: Dino, Speed, searching range
     */
    public DinoAIPickItems(EntityDinosaurce Dino0, float Speed0, int Range0)
    {
    	this.targetItem = null;
        this.Dino = Dino0;
        this.Speed = Speed0;
        this.setMutexBits(1);
        this.SEARCH_RANGE = Range0;
        this.RANGE = Range0;
        this.targetSorter = new DinoAINearestAttackableTargetSorter(this, this.Dino);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.Dino.IsHungry() && !this.Dino.FoodItemList.IsEmpty())
        {
        	this.RANGE=this.SEARCH_RANGE;
        	if(this.Dino.IsDeadlyHungry())
            	this.RANGE=2*this.SEARCH_RANGE;
            Vec3 var1 = this.getNearestItem();

            if (var1 != null)
            {
                this.destX = var1.xCoord;
                this.destY = var1.yCoord;
                this.destZ = var1.zCoord;
                return true;
            }
        }
        else
        {
        	if(this.Dino.SelfType.canCarryItems())
        	{//It can carry items
        		this.RANGE=3;//Dino just steps over an item
        		Vec3 var1 = this.getNearestItem();

                if (var1 != null)
                {
                    this.destX = var1.xCoord;
                    this.destY = var1.yCoord;
                    this.destZ = var1.zCoord;
                    return true;
                }
        		if((new Random()).nextInt((new Random()).nextInt(4000)+4000)==1)
        		{// The Dino is willing to (once every 4000-8000 ticks), but looks only in a small radius
	        		this.RANGE=10;
	        		var1 = this.getNearestItem();
	
	                if (var1 != null)
	                {
	                    this.destX = var1.xCoord;
	                    this.destY = var1.yCoord;
	                    this.destZ = var1.zCoord;
	                    return true;
	                }
        		}
        	}
        }
        return false;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.Dino.getNavigator().noPath() && this.targetItem.isEntityAlive();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        double Distance = Math.pow(this.Dino.posX - this.destX, 2.0D) + Math.pow(this.Dino.posZ - this.destZ, 2.0D);
        this.getClass();

        if (Distance < Math.pow(3.0D, 2.0D))
        {
            int i=this.Dino.PickUpItem(this.targetItem.getEntityItem());
            if(i>0)
            	this.targetItem.getEntityItem().stackSize=i;
            else
            	this.targetItem.setDead();
            this.Dino.getNavigator().clearPathEntity();
        }
        else
        {
            this.Dino.getNavigator().tryMoveToXYZ(this.destX, this.destY, this.destZ, this.Speed);
        }
    }

    private Vec3 getNearestItem()
    {
        List var1 = this.Dino.worldObj.getEntitiesWithinAABB(EntityItem.class, this.Dino.boundingBox.expand((double)this.RANGE, 4.0D, (double)this.RANGE));
        Collections.sort(var1, this.targetSorter);
        Iterator var2 = var1.iterator();
        Vec3 var3 = null;

        while (var2.hasNext())
        {
            EntityItem var4 = (EntityItem)var2.next();

            if (this.Dino.FoodItemList.CheckItemById(var4.getEntityItem().itemID) || (this.Dino.SelfType.canCarryItems() && !this.Dino.IsHungry()))
            {//It's food or the dino can carry things and is not hungry
                this.targetItem = var4;
                var3 = Vec3.createVectorHelper(var4.posX, var4.posY, var4.posZ);
                break;
            }
        }

        return var3;
    }

    /*protected boolean checkTargetReachable(Entity var1, boolean var2)
    {
        if (var1 == null)
        {
            return false;
        }
        else if (!var1.isEntityAlive())
        {
            return false;
        }
        else if (var1.boundingBox.maxY > this.Dino.boundingBox.minY && var1.boundingBox.minY < this.Dino.boundingBox.maxY)
        {
            if (this.Dino.isTamed())
            {
                if (var1 instanceof EntityTameable && ((EntityTameable)var1).isTamed())
                {
                    return false;
                }

                if (var1 == this.entityVar.getOwner())
                {
                    return false;
                }
            }
            else if (var1 instanceof EntityPlayer && !var2 && ((EntityPlayer)var1).capabilities.disableDamage)
            {
                return false;
            }

            return this.Dino.isWithinHomeDistance(MathHelper.floor_double(var1.posX), MathHelper.floor_double(var1.posY), MathHelper.floor_double(var1.posZ));
        }
        else
        {
            return false;
        }
    }*/
}
