
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
		setPosition(x, y, z);
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
		super.onUpdate();
		this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
	}

	protected void func_70184_a(MovingObjectPosition mop)
	{
		if(mop.entityHit != null)
		{
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity) this, (Entity) getThrower()), 4.0F);
			mop.entityHit.setFire(15);
		}
		if(!this.worldObj.isRemote)
			this.worldObj.newExplosion((Entity) null, this.posX, this.posY, this.posZ, 0.5F, true, false);
		this.worldObj.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
		setDead();
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
	protected void onImpact(MovingObjectPosition p_70184_1_)
	{
		// TODO Auto-generated method stub

	}
}
