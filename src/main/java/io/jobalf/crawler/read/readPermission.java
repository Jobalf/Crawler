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
		_bot = new ArrayList<String>();
		for(int i=0; i<botsContents.length; i++)
		{
			if(botsContents[i].toLowerCase().contains("user-agent:"))
			{
				_bot.add(botsContents[i].substring(12));
			}
		}
		
		return _bot;
	}
	
	public ArrayList<String> getDisallowedPath() 
	{
		_disAllowedPath = new ArrayList<String>();
		for(int i=0; i<botsContents.length; i++)
		{
			if(botsContents[i].equalsIgnoreCase("Disallow:"))
			{
				_disAllowedPath.add(botsContents[i].substring(9));
				//	_disAllowedPath.add(botsContents[i].substring(botsContents[i].indexOf("Disallow:", 9)));
			}
		}
		
		return _disAllowedPath;
	}
}
