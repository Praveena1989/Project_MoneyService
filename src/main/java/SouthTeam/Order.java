/**
 * 
 */
package SouthTeam;

/**
 * @author 
 *
 */
public class Order {

	private Long value;
	private String currencyCode;
	private String transactionMode; 
	private String site;
	private Client user;
	
	
	
	/**
	 * @param value
	 * @param currencyCode
	 * @param transactionMode
	 * @param site
	 */
	public Order(Long value, String currencyCode, String transactionMode, String site, Client user) {
		super();
		this.value = value;
		this.currencyCode = currencyCode;
		this.transactionMode = transactionMode;
		this.site = site;
		this.user = user;
	}
	/**
	 * @return the value
	 */
	public synchronized Long getValue() {
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
	public synchronized String getTransactionMode() {
		return transactionMode;
	}
	/**
	 * @return the site
	 */
	public synchronized String getSite() {
		return site;
	}
	/**
	 * @return the user
	 */
	public synchronized Client getUser() {
		return user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Order [value=%s, currencyCode=%s, transactionMode=%s, site=%s, user=%s]", value,
				currencyCode, transactionMode, site, user);
	}

	
	
	
	
}
