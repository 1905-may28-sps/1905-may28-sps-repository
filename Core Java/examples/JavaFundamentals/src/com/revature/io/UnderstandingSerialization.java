package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UnderstandingSerialization {
	
	/*
	 * Serialization is the conversion of the 
	 * state of an object into a byte stream
	 * (a sequence of bytes) which can then 
	 * be saved to a database or transferred
	 * over a network. 
	 * Deserialization does the opposite(stream
	 * of bytes -- object) 
	 * 
	 * Classes must implement the Serializable 
	 * interface to be eligible for serialization 
	 * When a class implements Serializable, all of
	 * its subclasses are serializable as well (is-a
	 * relationship).
	 * When an object has a reference to another object
	 * (has-a relationship), that class must also
	 * implement Serializable or a NotSerializableException
	 * will be thrown. 
	 * 
	 * When implementing Serializable, it is 
	 * suggested to give your class a Serial Version
	 * UID. This value is used to verify that the saved
	 * and loaded objects have the same attributes and 
	 * are thus compatible on serialization(basically
	 * ensuring that you are deserializing a stream 
	 * of bytes into the right type of object)
	 * 
	 * If attempting to deserialize a stream of bytes into
	 * the wrong class reference, an InvalidClassException 
	 * will be thrown
	 * 
	 * static fields belong to the class, not the
	 * object, and are not serialized
	 * 
	 * the transient keyword can be applied to 
	 * instance variables so that their values
	 * will not be serialized -- they will
	 * deserialize to the default value for their
	 * respective reference type 
	 * 
	 * In order to do this, we use ObjectInputStream
	 * and ObjectOutputStream which can respectively 
	 * read and write primitive types and graphs of
	 * objects
	 * 
	 */
	
	static String filePath = "src/com/revature/io/serializedObject.txt";
	public static void main(String[] args) {
		
		SerializablePerson p = new SerializablePerson("Gen", "6/17", 928937461L);
		System.out.println(p);
		serializeObject(p);
	}
	
	static void serializeObject(Object obj) {
		try(ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream(filePath))){
			
			outputStream.writeObject(obj);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	

}
