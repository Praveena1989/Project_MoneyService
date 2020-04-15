package SouthTeam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Support class for storing transaction data streams
 */
public class SiteSupport implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Transaction trans;
	private String filename;
	
	/**
	 * @param trans (Object)
	 * @param filename (String)
	 */
	
	public SiteSupport(Transaction trans, String filename) {
		super();
		this.trans = trans;
		this.filename = filename;
		storeTransectionInSerializedFile(trans, filename);
	}

	/**
	 * @param trans (Object)
	 * @param filename (String)
	 */
	public static void storeTransectionInSerializedFile(Transaction trans, String filename){

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(trans);			
		}
		// handle any exception
		catch(IOException ioe){
			System.out.println("Exception occurred: " + ioe);
		}
		
	}

}
