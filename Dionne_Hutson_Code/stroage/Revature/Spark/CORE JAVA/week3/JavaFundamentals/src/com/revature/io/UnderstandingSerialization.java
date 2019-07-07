package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UnderstandingSerialization {

	static String filePath="src/com/revature/io/serializedObject.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializablePerson p=new SerializablePerson("Gen","6/17",789463125L);
		System.out.println(p);
		serializeObject(p);

	}
static void serializeObject(Object obj) {
	try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(filePath))){
		outputStream.writeObject(obj);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}


}
