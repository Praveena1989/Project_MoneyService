package SouthTeam;
import affix.java.effective.moneyservice.*;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Support class for storing transaction data streams
 */
public class SiteSupport implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

//	public static void storeTransectionInSerializedFile(List<Transaction> transactionList, String filename) {
//
//		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
//			oos.writeObject(transactionList);			
//		}
//		// handle any exception
//		catch(IOException ioe){
//			System.out.println("Exception occurred: " + ioe);
//		}
//
//	}
	
	
	/**
	 * @param trans (Object)
	 * @param filename (String)
	 */
	public static void storeTransectionInSerializedFile(List<Transaction> transactionList, String filename){

		File fileOut = new File(filename);

		try(DataOutputStream dataOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileOut)))){

			for(Transaction ts : transactionList){
				dataOut.writeInt(ts.getId());
				dataOut.writeInt(ts.getTimeStamp().getYear());
				dataOut.writeInt(ts.getTimeStamp().getMonthValue());
				dataOut.writeInt(ts.getTimeStamp().getDayOfMonth());
				dataOut.writeInt(ts.getTimeStamp().getHour());
				dataOut.writeInt(ts.getTimeStamp().getMinute());
				dataOut.writeInt(ts.getTimeStamp().getSecond());
				dataOut.writeChars(ts.getCurrencyCode());
				dataOut.writeInt(ts.getAmount());
				dataOut.writeChars(ts.getMode().name());
			}
		}
		// handle any exception
		catch(IOException ioe){
			System.out.println("Exception occurred: " + ioe);
		}
	}

}
