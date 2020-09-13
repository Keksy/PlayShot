
package de.devjava.playshot.addon.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import de.devjava.playshot.addon.utils.EntityLaser;

@SideOnly(Side.CLIENT)
public class RenderLaser extends Render<EntityLaser>
{
	private static final ResourceLocation arrowTextures = new ResourceLocation("laser.png");

	public RenderLaser(RenderManager renderManagerIn)
	{
		super(renderManagerIn);
	}

	public void func_76986_a(EntityLaser entity, double x, double y, double z, float entityYaw, float partialTicks)
	{

		func_180548_c((EntityLaser) entity);
		GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.func_179094_E();
		GlStateManager.func_179109_b((float) x, (float) y, (float) z);
		GlStateManager.func_179109_b(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * partialTicks - 90.0F, 0.0F, 1.0F);
		GlStateManager.func_179109_b(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * partialTicks, 0.0F, 0.0F);
		Tessellator tessellator = Tessellator.func_178181_a();
		WorldRenderer worldrenderer = tessellator.func_178180_c();
		GlStateManager.func_179140_f();
		float lastBrightnessX = OpenGlHelper.lastBrightnessX;
		float lastBrightnessY = OpenGlHelper.lastBrightnessY;
		OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
		int i = 0;
		float f = 0.0F;
		float f1 = 0.5F;
		float f2 = (0 + i * 10) / 32.0F;
		float f3 = (5 + i * 10) / 32.0F;
		float f4 = 0.0F;
		float f5 = 0.15625F;
		float f6 = (5 + i * 10) / 32.0F;
		float f7 = (10 + i * 10) / 32.0F;
		float f8 = 0.05625F;
		GlStateManager.func_179091_B();
		float f9 = 0.0F - partialTicks;
		if(f9 > 0.0F)
		{
			float f10 = -MathHelper.func_76126_a(f9 * 3.0F) * f9;
			GlStateManager.func_179114_b(f10, 0.0F, 0.0F, 1.0F);
		}
		GlStateManager.func_179114_b(45.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.func_179152_a(f8, f8, f8);
		GlStateManager.func_179109_b(-4.0F, 0.0F, 0.0F);
		GL11.glNormal3f(f8, 0.0F, 0.0F);
		worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
		worldrenderer.func_181662_b(-7.0D, -2.0D, -2.0D).func_181673_a(f4, f6).func_181675_d();
		worldrenderer.func_181662_b(-7.0D, -2.0D, 2.0D).func_181673_a(f5, f6).func_181675_d();
		worldrenderer.func_181662_b(-7.0D, 2.0D, 2.0D).func_181673_a(f5, f7).func_181675_d();
		worldrenderer.func_181662_b(-7.0D, 2.0D, -2.0D).func_181673_a(f4, f7).func_181675_d();
		tessellator.func_78381_a();
		GL11.glNormal3f(-f8, 0.0F, 0.0F);
		worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
		worldrenderer.func_181662_b(-7.0D, 2.0D, -2.0D).func_181673_a(f4, f6).func_181675_d();
		worldrenderer.func_181662_b(-7.0D, 2.0D, 2.0D).func_181673_a(f5, f6).func_181675_d();
		worldrenderer.func_181662_b(-7.0D, -2.0D, 2.0D).func_181673_a(f5, f7).func_181675_d();
		worldrenderer.func_181662_b(-7.0D, -2.0D, -2.0D).func_181673_a(f4, f7).func_181675_d();
		tessellator.func_78381_a();
		for(int j = 0; j < 4; j++)
		{
			GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f8);
			worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
			worldrenderer.func_181662_b(-8.0D, -2.0D, 0.0D).func_181673_a(f, f2).func_181675_d();
			worldrenderer.func_181662_b(8.0D, -2.0D, 0.0D).func_181673_a(f1, f2).func_181675_d();
			worldrenderer.func_181662_b(8.0D, 2.0D, 0.0D).func_181673_a(f1, f3).func_181675_d();
			worldrenderer.func_181662_b(-8.0D, 2.0D, 0.0D).func_181673_a(f, f3).func_181675_d();
			tessellator.func_78381_a();
		}
		OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, lastBrightnessX, lastBrightnessY);
		GlStateManager.func_179145_e();
		GlStateManager.func_179101_C();
		GlStateManager.func_179121_F();
	}

	@Override
	protected ResourceLocation func_110775_a(EntityLaser entity)
	{
		return arrowTextures;
	}

}
