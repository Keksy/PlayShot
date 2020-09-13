
package de.devjava.playshot.addon.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaser extends EntityThrowable
{
	public EntityLaser(World world, EntityLivingBase entity, double x, double y, double z)
	{
		super(world, entity);
		func_70107_b(x, y, z);
	}

	public EntityLaser(World world)
	{
		super(world);
	}

	public EntityLaser(World world, double par2, double par4, double par6)
	{
		super(world, par2, par4, par6);
	}

	public void func_70071_h_()
	{
		super.func_70071_h_();
		this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
	}

	protected void func_70184_a(MovingObjectPosition mop)
	{
		if(mop.field_72308_g != null)
		{
			mop.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity) this, (Entity) func_85052_h()), 4.0F);
			mop.field_72308_g.func_70015_d(15);
		}
		if(!this.field_70170_p.field_72995_K)
			this.field_70170_p.func_72885_a((Entity) null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.5F, true, false);
		this.field_70170_p.func_175688_a(EnumParticleTypes.FLAME, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
		func_70106_y();
	}

	protected float func_70185_h()
	{
		return 0.001F;
	}

	protected float func_70182_d()
	{
		return 5.0F;
	}

	@Override
	protected void func_70184_a(MovingObjectPosition p_70184_1_)
	{
		// TODO Auto-generated method stub

	}
}
