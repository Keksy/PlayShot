
package de.devjava.playshot.addon.objects.category;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public enum Categorys
{
	CATEGORY_STATS(new ModuleCategory("PlayShot Stats", true, new ControlElement.IconData(Material.DIAMOND_SWORD)));

	private ModuleCategory moduleCategory;

	private Categorys(ModuleCategory moduleCategory)
	{
		this.moduleCategory = moduleCategory;
	}

	public ModuleCategory getModuleCategory()
	{
		return this.moduleCategory;
	}
}
