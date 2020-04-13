package SouthTeam;

import java.util.Map;
import java.util.Optional;


public class Site implements MoneyService{
	
	private Map<String, Long> cashBoxes;
	private Map<String, Currency> currencyMap;


	
	/**
	 * @param cashBoxes
	 * @param currencyMap
	 */
	public Site(Map<String, Long> cashBoxes, Map<String, Currency> currencyMap) {
		super();
		this.cashBoxes = cashBoxes;
		this.currencyMap = currencyMap;
	}

	@Override
	public boolean buyMoney(Order orderData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sellMoney(Order orderData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printSiteReport(String destination) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutDownService(String destination) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Currency> getCurrencyMap() {
		// TODO Auto-generated method stub
		return MoneyService.super.getCurrencyMap();
	}

	@Override
	public Optional<Double> getAvailableAmount(String currencyCode) {
		// TODO Auto-generated method stub
		return MoneyService.super.getAvailableAmount(currencyCode);
	}

	private boolean ValidateOrder(Order clintOrder) {
		
		return false;
		
	}
	
	private void addToReport(Order doneTransection) {
		
	}
	
}

