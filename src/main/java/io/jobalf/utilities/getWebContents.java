package io.jobalf.utilities;

import java.io.InputStream;
import java.net.*;
import org.apache.commons.io.IOUtils;

public class getWebContents 
{	
	private URL _url;
	private URLConnection _con;
	private String _body;
	
	//	Declare the object's instance -- Make the connection
	public getWebContents(URL url)
	{
		this._url = url;
		try
		{
			_con = _url.openConnection();
		}
		catch(Exception e)
		{
			System.err.println("getWebContents: JOB001 thrown >> " + e.getLocalizedMessage());
		}
	}
	
	//	Pass the page contents
	public String loadPage()
	{
		try
		{
			InputStream in = _con.getInputStream();
			String encoding = _con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
			encoding = encoding == null ? "UTF-8" : encoding;
			_body = IOUtils.toString(in, encoding);
		}
		catch(Exception e)
		{
			System.err.println("getWebContents: JOB002 thrown >> " + e.getMessage());
		}
		
		return _body;
	}
	
	//	Print the page contents
	public void displayPage()
	{
		try
		{
			InputStream in = _con.getInputStream();
			String encoding = _con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in, encoding);
			System.out.println(body);
		}
		catch(Exception e)
		{
			System.err.println("getWebContents: JOB003 thrown >> " + e.getMessage());
		}
	}
}
