/**
 * 
 */
package SouthTeam;

/**
 * @author valen
 *
 */
public class Order 
{
	private String value;
	private String currencyCode;
	private String transactionMode; 
	private String site;


	/**
	 * @param value
	 * @param currencyCode
	 * @param transactionMode
	 * @param site
	 */
	public Order(String value, String currencyCode, String transactionMode, String site) 
	{
		super();
		this.value = value;
		this.currencyCode = currencyCode;
		this.transactionMode = transactionMode;
		this.site = site;
	}
	
	/**
	 * @return the value
	 */
	public synchronized String getValue() 
	{
		return value;
	}
	
	/**
	 * @return the currencyCode
	 */
	public synchronized String getCurrencyCode()
	{
		return currencyCode;
	}
	
	/**
	 * @return the transactionMode
	 */
	public synchronized String getTransactionMode()
	{
		return transactionMode;
	}
	
	/**
	 * @return the site
	 */
	public synchronized String getSite() 
	{
		return site;
	}
	
	/**
	 * 
	 * Helper method validating input value
	 * @return boolean true if condition is met
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
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (currencyCode == null) 
		{
			if (other.currencyCode != null)
				return false;
		} 
		else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (site == null) 
		{
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (transactionMode == null) 
		{
			if (other.transactionMode != null)
				return false;
		} 
		else if (!transactionMode.equals(other.transactionMode))
			return false;
		if (value == null)
		{
			if (other.value != null)
				return false;
		} 
		else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString() 
	{
		return String.format("Order [value=%s, currencyCode=%s, transactionMode=%s, site=%s]", value,
				currencyCode, transactionMode, site);
	}


}

