package io.jobalf.crawler.entrypoint;

import io.jobalf.utilities.getWebContents;
import io.jobalf.crawler.read.*;
import java.net.*;

public class entryPoint 
{
	public static void main(String[] args)
	{
		try
		{
			readPermission rp = new readPermission("https://www.apple.com");
			
			for(int i =0; i < rp.getBot().size(); i++)
			{
				System.out.println(rp.getBot().get(i));
			}
		}
		catch(Exception e)
		{
			System.err.println("entryPoint JOB002 ERROR" + e.toString());
		}
	}
}
