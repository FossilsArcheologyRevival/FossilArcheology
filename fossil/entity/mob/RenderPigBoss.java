package fossil.entity.mob;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

public class RenderPigBoss extends RenderBiped
{
    public RenderPigBoss(ModelBiped var1, float var2)
    {
        super(var1, var2);
        this.setRenderPassModel(new ModelPigBoss());
    }

    public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
    {
        ((ModelPigBoss)((ModelPigBoss)this.mainModel)).RangedAttack = ((EntityPigBoss)var1).getAttackMode() == 1;
        super.doRenderLiving(var1, var2, var4, var6, var8, var9);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving var1, int var2, float var3)
    {
        return this.setChargeLineBrightness((EntityPigBoss)var1, var2, var3);
    }

    public int setChargeLineBrightness(EntityPigBoss var1, int var2, float var3)
    {
        if (var2 != 0)
        {
            return -1;
        }
        else
        {
            if (var1.FireballCount >= 50)
            {
                this.loadTexture("/fossil/textures/PigBossCharged_r.png");
            }
            else
            {
                this.loadTexture("/fossil/textures/PigBoss_r.png");
            }

            float var4 = (1.0F - var1.getBrightness(1.0F)) * 0.5F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, var4 * 100.0F);
            return 1;
        }
    }
}
