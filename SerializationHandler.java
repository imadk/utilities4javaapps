/***
 *
 *SerializationHandler: persist a serializable class into the filesystemm
 *
 *September 2010
 *
 * @author Imad Khoury
 * */

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class SerializationHandler {

	public static class Flatten{
		public static void run(String OUTPUT_PATH) throws IOException {
			String filename = OUTPUT_PATH + "instance.ser";
		    //replace "Instance" with your serializable class
			Instance SI = new Instance();
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			try {
				fos = new FileOutputStream(filename);
				out = new ObjectOutputStream(fos);
				out.writeObject(SI);
			} catch (IOException ex) {
				ex.printStackTrace();
			}finally {
			    if (out != null) {
			    	out.close();
			    	fos.close();
			    } else {
			        System.err.println("Out stream not open");
			    }

			}
		}
	}

	public static class Inflate {
        //replace "Instance" with your serializable class
		public static Instance run(String OUTPUT_PATH) {
			String filename = OUTPUT_PATH + "instance.ser";
		    //replace "Instance" with your serializable class
			Instance SI = null;
			FileInputStream fis = null;
			ObjectInputStream in = null;
			try {
				fis = new FileInputStream(filename);
				in = new ObjectInputStream(fis);
				SI = (Instance) in.readObject();
				in.close();
				fis.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			return SI;
		}
	}
}
