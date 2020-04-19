/**
 * 
 */
package moneyservice;

/**
 * @author valen
 *
 */
public class Order
{
	private int value;
	private String currencyCode;
	private TransactionMode transactionMode; 
	private String site;
	
	/**
	 * @param value
	 * @param currencyCode
	 * @param transactionMode
	 * @param site
	 */
	public Order(int value, String currencyCode, TransactionMode transactionMode, String site)
	{
		this.value = value;
		this.currencyCode = currencyCode;
		this.transactionMode = transactionMode;
		this.site = site;
	}

		
	/**
	 * @return the value
	 */
	public synchronized int getValue() {
		return value;
	}



	/**
	 * @return the currencyCode
	 */
	public synchronized String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @return the transactionMode
	 */
	public synchronized TransactionMode getTransactionMode() {
		return transactionMode;
	}

	/**
	 * @return the site
	 */
	public synchronized String getSite() {
		return site;
	}
	
	/**
	 * isValueValid check if inputed value is Integer 
	 * @return boolean (isValueOk)
	 */
	public boolean isValueValid(String value)
	{
		boolean isValueOk = true;
		
 		try
		{
			@SuppressWarnings("unused")
			Long returnValue = Long.parseLong(value);
			
			return isValueOk;
		}
		catch(NumberFormatException e)
		{
			isValueOk = false;
		}
		return isValueOk;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (transactionMode != other.transactionMode)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Orderr [value=%s, currencyCode=%s, transactionMode=%s, site=%s]", value, currencyCode,
				transactionMode, site);
	}

	
	
}
