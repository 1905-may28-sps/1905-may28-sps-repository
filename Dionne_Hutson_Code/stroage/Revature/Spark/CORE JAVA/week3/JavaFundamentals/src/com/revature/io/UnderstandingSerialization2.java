package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UnderstandingSerialization2 {

	static String filePath="src/com/revature/io/serializedObject.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializablePerson deserialized=(SerializablePerson) deserializeObject();
		
		System.out.println(deserialized);
		
	}
static Object deserializeObject() {
	Object obj=null;
	try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath))){
		obj=ois.readObject();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;
		
	}


}