
package de.devjava.playshot.addon.objects.register;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import de.devjava.playshot.addon.LabyAddon;

public class ListenerManager
{
	private List<Listener> listener;
	private LabyAddon labyAddon;

	public ListenerManager(final LabyAddon labyAddon)
	{
		this.listener = new ArrayList<Listener>();
		this.labyAddon = labyAddon;
	}

	public List<Listener> getListener()
	{
		return this.listener;
	}

	public boolean isListenerRegisted(final Listener listener)
	{
		return this.listener.contains(listener);
	}

	public void addListener(final Listener listener)
	{
		if(this.isListenerRegisted(listener))
			return;

		this.listener.add(listener);
		this.labyAddon.getApi().registerForgeListener(listener);
	}

	public void callListener(Event event)
	{
		try
		{
			for(Listener listener : getListener())
			{
				for(Method method : listener.getClass().getMethods())
				{
					if(method == null)
						continue;

					LabyModEvent labymodEvent = method.<LabyModEvent> getAnnotation(LabyModEvent.class);
					if(labymodEvent == null)
						continue;
					if(method.isBridge() || method.isSynthetic())
						continue;
					
					Class<?> checkClass;
					if((method.getParameterTypes()).length != 1 || !Event.class.isAssignableFrom(checkClass = method.getParameterTypes()[0]))
						continue;

					final Class<? extends Event> eventClass = checkClass.asSubclass(Event.class);
					if(!event.getClass().getSimpleName().equals(eventClass.getSimpleName()))
						continue;

					method.setAccessible(true);
					method.invoke(listener, event);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void removeListener(final Listener listener)
	{
		if(!this.isListenerRegisted(listener))
			return;

		this.listener.remove(listener);
	}
}
