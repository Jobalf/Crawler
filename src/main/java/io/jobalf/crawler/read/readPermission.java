package io.jobalf.crawler.read;

import io.jobalf.impl.*;
import java.util.*;
import io.jobalf.utilities.getWebContents;
import java.net.*;

public class readPermission implements readRobot
{
	private ArrayList<String> _bot; 
	private ArrayList<String> _disAllowedPath;
	private String botsContents[];
	private String _robots;
	
	//	Define the Robots 
	public readPermission(String url)
	{
		try
		{
			getWebContents gb = new getWebContents(new URL(url + "/robots.txt"));
			
			//	Read in the User-agent: and see what is the bot used
			this._robots = gb.loadPage();
			botsContents = _robots.split("\\r\\n|\\n|\\r");
		}
		catch(Exception e)
		{
			System.err.println("readPermission: JOB004 thrown >> " + e.getLocalizedMessage());
		}
	}
	
	public String getBotString()
	{	
		return _robots;
	}
	
	public ArrayList<String> getBot()
	{
		for(int i=0; i<botsContents.length; i++)
		{
			System.err.println(botsContents[i]);
//			if(botsContents[i].equalsIgnoreCase("User-agent:"))
			if(botsContents[i].toString() == "User-agent:")
			{
				System.err.println("getBot");
				_bot.add(botsContents[i].substring(botsContents[i].indexOf("User-agent:", 11)));
			}
		}
		
		return _bot;
	}
	
	public ArrayList<String> getDisallowedPath() 
	{
		for(int i=0; i<botsContents.length; i++)
		{
			if(botsContents[i].equalsIgnoreCase("Disallow:"))
			{
				_disAllowedPath.add(botsContents[i].substring(botsContents[i].indexOf("Disallow:", 9)));
			}
		}
		
		return _disAllowedPath;
	}
}
