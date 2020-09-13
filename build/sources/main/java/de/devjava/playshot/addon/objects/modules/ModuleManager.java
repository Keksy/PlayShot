package de.devjava.playshot.addon.objects.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager
{
	private List<Module> modules;
	
	public ModuleManager()
	{
		this.modules = new ArrayList<Module>();
	}
	
	public List<Module> getModules()
	{
		return this.modules;
	}
	
	public boolean isModuleRegisted(final Module module)
	{
		return this.modules.contains(module);
	}
	
	public void addModule(final Module module)
	{
		if(!this.isModuleRegisted(module))
			this.modules.add(module);
	}
	
	public void removeModule(final Module module)
	{
		if(this.isModuleRegisted(module))
			this.modules.add(module);
	}
}
