package fossil.fossilAI;

import fossil.client.FossilOptions;
import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilEnums.EnumDinoType;
import fossil.fossilEnums.EnumSituation;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

public class DinoAIGrowup extends EntityAIBase
{
    protected EntityDinosaurce AITarget;

    public DinoAIGrowup(EntityDinosaurce var1)
    {
        this.AITarget = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {  
        if (FossilOptions.DinoGrows && this.AITarget.getDinoAge() < this.AITarget.MaxAge)
        {
            this.AITarget.increaseDinoAgeTick();
            return this.AITarget.getDinoAgeTick() >= this.AITarget.AgingTicks;
        }
        return false;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.AITarget.setDinoAgeTick(0);
        this.AITarget.increaseDinoAge();
        //this.AITarget.CheckSkin();

        if (this.AITarget.getHealth() < this.AITarget.getMaxHealth())
        {//the dino heals itself 5% when growing up
            this.AITarget.heal(MathHelper.ceiling_double_int(this.AITarget.getMaxHealth()*0.05f));
        }

        this.AITarget.updateSize();
        this.AITarget.setPosition(this.AITarget.posX, this.AITarget.posY, this.AITarget.posZ);

        if ((!this.AITarget.CheckSpace() && this.AITarget.SelfType!=EnumDinoType.Mosasaurus) || (this.AITarget.isInWater() && this.AITarget.SelfType==EnumDinoType.Mosasaurus))
        {
            this.AITarget.setDinoAge(this.AITarget.getDinoAge()-1);
            //this.AITarget.CheckSkin();

            if (this.AITarget.getHealth() > MathHelper.ceiling_double_int(this.AITarget.getMaxHealth()*0.05f))
            {
                this.AITarget.attackEntityFrom(DamageSource.generic, MathHelper.ceiling_double_int(this.AITarget.getMaxHealth()*0.05f));
            }

            this.AITarget.updateSize();
            //this.AITarget.setPosition(this.AITarget.posX, this.AITarget.posY, this.AITarget.posZ);

            if (this.AITarget.isTamed())
            {
                this.AITarget.SendStatusMessage(EnumSituation.NoSpace);//, this.AITarget.SelfType);
            }
        }
    }
}
