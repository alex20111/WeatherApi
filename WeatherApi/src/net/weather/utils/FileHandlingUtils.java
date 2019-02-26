package net.weather.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class created to handle files writes. 
 * 
 * 
 * @author axb161
 *
 */
public class FileHandlingUtils
{
	/**
	 * 
	 * @param location
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String writeObjectToDisk(String location, Object obj) throws Exception
	{
		File file = new File(location);
		
		if (!file.exists())
		{
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout); 
			oos.writeObject(obj);
			oos.close();
		}	
		return file.getAbsolutePath();
	}
	/**
	 * Write a list of objects to a specified location.
	 * @param location
	 * 			- location to store the file
	 * @param objects
	 * 		- objects to write
	 * @throws Exception
	 */
	public static String writeObjectListToDisk(String location, List<Object> objects) throws Exception
	{
		File file = new File(location);
		
		if (file.exists())
		{
			file.delete();
		}
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);  
			for (Object obj : objects)
			{

				oos.writeObject(obj);
			}
			oos.close();

		return file.getAbsolutePath();
	}
	/**
	 * 
	 * @param location
	 * @return
	 * @throws Exception
	 */
	public static List<Object> readFileWithMultipleObjectToArray(String location) throws Exception
	{
		File file = new File(location);
		List<Object> objs = new ArrayList<Object>();
		if (file.exists())
		{
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fin);
			try{
				while (fin.available() != -1) {
					//Read object from file
					objs.add(ois.readObject());
				}	
			}catch(EOFException eof)
			{
				ois.close();
			}
		}
		
		return objs;
	}
	/**
	 * 
	 * @param location
	 * @return
	 * @throws Exception
	 */
	public static Object readFileObject(String location) throws Exception
	{
		File file = new File(location);
		Object obj = new Object();
		if (file.exists())
		{
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fin);
			try{
				//Read object from file
				obj = ois.readObject();

			}catch(EOFException eof)
			{
				ois.close();
			}
		}

		return obj;
	}
	/**
	 * 
	 * @param location
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public static String  writeTextToDisk(String location, String text) throws Exception
	{
		File file = new File(location);
		
		if (file.exists())
		{
			file.delete();
		}
		FileWriter fw = new FileWriter(file);
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(text);
		//bw.newLine();
		
		bw.flush();
		bw.close();
		fw.close();
		return file.getAbsolutePath();
	}
	/**
	 * 
	 * @param location
	 * @return
	 * @throws Exception
	 */
	public static String readFileToString(String location) throws Exception
	{
		BufferedReader reader = new BufferedReader( new FileReader (location));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();

	    while( ( line = reader.readLine() ) != null )
	    {
	        stringBuilder.append( line );
	    }

	    reader.close();
	    
	    return stringBuilder.toString();

	}
	/**
	 * 
	 * @param location
	 * @return
	 * @throws Exception
	 */
	public static List<String> readFileToArray(String location) throws Exception
	{
		BufferedReader reader = new BufferedReader( new FileReader (location));
	    String         line = null;
	    List<String> string = new ArrayList<String>();


	    while( ( line = reader.readLine() ) != null ) 
	    {
	    	string.add(line);
	    }

	    reader.close();
	    
	    return string;
	}
}
