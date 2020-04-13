package SouthTeam;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ConExApp {


	/**
	 * This class acts a configurator of the ExchangeApp application
	 */

	static long EUR_AMOUNT = 0; 	
	static long USD_AMOUNT = 0; 
	static long GBP_AMOUNT = 0; 
	static long NOK_AMOUNT = 0; 	
	static long DKK_AMOUNT = 0; 
	static long CHF_AMOUNT = 0; 
	static long RUB_AMOUNT = 0; 	
	static long AUD_AMOUNT = 0; 
	static long JPY_AMOUNT = 0; 
	static long SEK_AMOUNT = 0; 
	static String REF_CURRENCY ="";
	
	static double EUR_RATE = 0.00; 	
	static double USD_RATE = 0.00; 
	static double GBP_RATE = 0.00; 
	static double NOK_RATE = 0.00; 	
	static double DKK_RATE = 0.00; 
	static double CHF_RATE = 0.00; 
	static double RUB_RATE = 0.00; 	
	static double AUD_RATE = 0.00; 
	static double JPY_RATE = 0.00; 


	/**
	 * This method reads a configuration file and sets application constants
	 * @param configFile a String holding the name of a configuration file
	 */
//	BiFunction<String, String, String[]> lineParts
//    = (String line, String separator) -> { return line.split(separator);};
	public static void readProjectConfig( Map<String, Long>cashBoxes) {
		Predicate<String> notValue = (String input) -> { return input.contains("=");};
		String[] parts;
		Path projectConfigPath = Paths.get("ProjectConfig.txt");
		try (Stream<String> currencyRateStream = Files.lines(projectConfigPath).filter(notValue);) {

			Iterator<String> iter = currencyRateStream.iterator();			
			while(iter.hasNext()){
				String line = iter.next();
				parts = line.split("=");
				String currency = parts[0].strip();
				String value = parts[1].strip();

				switch(currency) {

				case "EUR":
					EUR_AMOUNT = Long.parseLong(value);
					break;
				case "USD":
					USD_AMOUNT = Long.parseLong(value);
					break;
				case "GBP":
					GBP_AMOUNT = Long.parseLong(value);
					break;
				case "NOK":
					NOK_AMOUNT = Long.parseLong(value);
					break;
				case "DKK":
					DKK_AMOUNT = Long.parseLong(value);
					break;
				case "CHF":
					CHF_AMOUNT = Long.parseLong(value);
					break;
				case "RUB":
					RUB_AMOUNT = Long.parseLong(value);
					break;
				case "AUD":
					AUD_AMOUNT = Long.parseLong(value);
					break;
				case "JPY":
					JPY_AMOUNT = Long.parseLong(value);
					break;
				case "SEK":
					SEK_AMOUNT = Long.parseLong(value);
					break;
				case "ReferenceCurrency":
					REF_CURRENCY = value;
					break;
				default:
					break;
				}
			}					
		} 
		catch (java.io.IOException ex) { 
			ex.printStackTrace();
		} 	

	}
	public static void readCurrencyConfig(String date, Map<String, Currency> currencyMap) {
		Predicate<String> notValue = (String input) -> { return input.contains(";");};
		Path projectConfigPath = Paths.get("CurrencyConfig_"+ date +".txt");
		try (Stream<String> currencyRateStream = Files.lines(projectConfigPath).filter(notValue);) {

			Iterator<String> iter = currencyRateStream.iterator();			
			while(iter.hasNext()){
				String line = iter.next();
				String[] parts = line.split(";");
				String[] firstPart = parts[2].split(" ");
				double secondPart = Double.parseDouble(parts[3].strip());
				String currency = firstPart[1].strip();
				double value;
				if (Integer.parseInt(firstPart[0].strip()) == 1) {
					
					value = secondPart;
				}
				else{
					value = secondPart/Integer.parseInt(firstPart[0].strip());
					
				}

				switch(currency) {

				case "EUR":
					EUR_RATE = value;
					break;
				case "USD":
					USD_RATE = value;
					break;
				case "GBP":
					GBP_RATE = value;
					break;
				case "NOK":
					NOK_RATE = value;
					break;
				case "DKK":
					DKK_RATE = value;
					break;
				case "CHF":
					CHF_RATE = value;
					break;
				case "RUB":
					RUB_RATE = value;
					break;
				case "AUD":
					AUD_RATE = value;
					break;
				case "JPY":
					JPY_RATE = value;
					break;
				default:
					break;
				}
			}					
		} 
		catch (java.io.IOException ex) { 
			ex.printStackTrace();
		} 	

	}
}


