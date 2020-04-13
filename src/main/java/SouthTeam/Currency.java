/**
 * 
 */
package SouthTeam;

/**
 * @author 
 *
 */
public class Currency{

	String currencyCode;
	double exchangeRate;
	
	
	
	/**
	 * @param currencyCode
	 * @param exchangeRate
	 */
	public Currency(String currencyCode, double exchangeRate) {
		super();
		this.currencyCode = currencyCode;
		this.exchangeRate = exchangeRate;
	}
	/**
	 * @return the currencyCode
	 */
	public synchronized String getCurrencyCode() {
		return currencyCode;
	}
	/**
	 * @return the exchangeRate
	 */
	public synchronized double getExchangeRate() {
		return exchangeRate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(exchangeRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Currency other = (Currency) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (Double.doubleToLongBits(exchangeRate) != Double.doubleToLongBits(other.exchangeRate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Currency [currencyCode=%s, exchangeRate=%s]", currencyCode, exchangeRate);
	}


}
