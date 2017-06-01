package main.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public abstract class saveData {

	public static boolean ObjectToBin(Object obj, String path) throws java.io.IOException {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path));
			stream.writeObject(obj);
			stream.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public static Object BinToObject(String path) throws FileNotFoundException, IOException {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path));
		try {
			Object obj = stream.readObject();
			stream.close();
			return obj;
		} catch (ClassNotFoundException ex) {
			stream.close();
			return null;
		}
	}
}