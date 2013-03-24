package fossil.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class RenderDinoEgg extends Render
{
    protected ModelDinoEgg MainModel;

    public RenderDinoEgg(float var1)
    {
        this.shadowSize = var1;
        this.MainModel = new ModelDinoEgg();
    }

    public void renderDinoEgg(EntityDinoEgg var1, double var2, double var4, double var6, float var8, float var9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glRotatef(180.0F - var8, 0.0F, 1.0F, 0.0F);
        float var10 = (float)var1.timeSinceHit - var9;
        float var11 = (float)var1.damageTaken - var9;

        if (var11 < 0.0F)
        {
            var11 = 0.0F;
        }

        this.loadTexture("/terrain.png");
        float var12 = 0.75F;
        GL11.glScalef(var12, var12, var12);
        GL11.glScalef(1.0F / var12, 1.0F / var12, 1.0F / var12);
        this.loadTexture(var1.getTexture());
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.MainModel.render(var1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void doRenderLiving(EntityDinoEgg var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.renderDinoEgg(var1, var2, var4, var6, var8, var9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.renderDinoEgg((EntityDinoEgg)var1, var2, var4, var6, var8, var9);
    }
}
