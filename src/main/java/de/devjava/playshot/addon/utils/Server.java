package de.devjava.playshot.addon.utils;

public enum Server {

	LAZERTAG("lasertag_jsonAPI"), BEDWARS("bedwars_jsonAPI"), CITYBUILD("err"), LOBBY("err"), OFFLINE("err");
	
	private String value; 
	
	private Server(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}
