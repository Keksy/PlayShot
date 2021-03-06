package de.devjava.playshot.addon.listener.custom;

import de.devjava.playshot.addon.objects.register.Event;
import net.minecraft.entity.Entity;

public class RenderEntityEvent extends Event
{
	private double arg1, arg2, arg3;
	private Entity entity;
	private float arg4;
	
	public RenderEntityEvent(final Entity entity, final double arg1, final double arg2, final double arg3, final float arg4)
	{
		this.entity = entity;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.arg4 = arg4;
	}
	
	public Entity getEntity()
	{
		return this.entity;
	}
	
	public double getarg1()
	{
		return this.arg1;
	}
	
	public double getarg2()
	{
		return this.arg2;
	}
	
	public double getarg3()
	{
		return this.arg3;
	}
	
	public float getarg4()
	{
		return this.arg4;
	}
}
