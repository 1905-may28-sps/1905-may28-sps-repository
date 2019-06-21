package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UnderstandingSerialization {

	//location	/Users/tiffanywest/git_repositories/1905-may28-sps-repository/Tiffany_West_Code/Core Java/examples/src/com/revature/io
	//static String filePath = "src/com/revature/io/serializeObject.text";
	
	static String filePath = "src/com/revature/io/serializedObject.txt";
	public static void main(String[] args) {
		SerializablePerson p = new SerializablePerson("Tiff", "5/20", 98765543l);
		System.out.println(p);
		serializeObject(p);

	}
	//for Junit right click on class > new> junit > junit4 > click 4 method stubs > fill in >run as junit test
	static void serializeObject(Object obj) {
		try(ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream(filePath))) {
			
			outputStream.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


