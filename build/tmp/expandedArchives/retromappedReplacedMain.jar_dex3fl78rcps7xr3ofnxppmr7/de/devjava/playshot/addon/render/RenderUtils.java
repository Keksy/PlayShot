package de.devjava.playshot.addon.render;

import org.lwjgl.opengl.GL11;

import net.labymod.core.LabyModCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public class RenderUtils
{

	public RenderUtils()
	{
		
	}
	
	public void renderName(String str, Entity entity, double x, double y, double z)
	{
		FontRenderer fontrenderer = Minecraft.func_71410_x().func_175598_ae().func_78716_a();
		float f = 1.6F;
		float f3 = 0.021133334F;
		GlStateManager.func_179094_E();
		GlStateManager.func_179109_b((float) x + 0.0F, (float) y + entity.field_70131_O + 1F, (float) z);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GlStateManager.func_179114_b(-Minecraft.func_71410_x().func_175598_ae().field_78735_i, 0.0F, 1.0F, 0.0F);
		GlStateManager.func_179114_b(Minecraft.func_71410_x().func_175598_ae().field_78732_j, 1.0F, 0.0F, 0.0F);
		GlStateManager.func_179152_a(-f3, -f3, f3);
		GlStateManager.func_179140_f();
		GlStateManager.func_179132_a(false);
		GlStateManager.func_179097_i();
		GlStateManager.func_179147_l();
		GlStateManager.func_179120_a(770, 771, 1, 0);
		Tessellator tessellator = Tessellator.func_178181_a();
		WorldRenderer worldrenderer = tessellator.func_178180_c();
		int i = 4;
		int j = fontrenderer.func_78256_a(str) / 2;
		GlStateManager.func_179090_x();
		worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181706_f);
		worldrenderer.func_181662_b((-j - 1), (-1 + i), 0.0D).func_181666_a(0.0F, 0.0F, 0.0F, 0.25F).func_181675_d();
		worldrenderer.func_181662_b((-j - 1), (8 + i), 0.0D).func_181666_a(0.0F, 0.0F, 0.0F, 0.25F).func_181675_d();
		worldrenderer.func_181662_b((j + 1), (8 + i), 0.0D).func_181666_a(0.0F, 0.0F, 0.0F, 0.25F).func_181675_d();
		worldrenderer.func_181662_b((j + 1), (-1 + i), 0.0D).func_181666_a(0.0F, 0.0F, 0.0F, 0.25F).func_181675_d();
		tessellator.func_78381_a();
		GlStateManager.func_179098_w();
		fontrenderer.func_78276_b(str, -fontrenderer.func_78256_a(str) / 2, i, 1);
		GlStateManager.func_179126_j();
		GlStateManager.func_179132_a(true);
		fontrenderer.func_78276_b(str, -fontrenderer.func_78256_a(str) / 2, i, 1);
		GlStateManager.func_179145_e();
		GlStateManager.func_179084_k();
		GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.func_179121_F();

	}
	
}
