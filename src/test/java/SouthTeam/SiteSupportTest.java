package SouthTeam;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import affix.java.effective.moneyservice.*;

public class SiteSupportTest {

	@Test
	public void test() {
		testSiteSupport1();
	}
	
	
	@Test
	public void testSiteSupport1() {
		
		
		List<Transaction> t = new ArrayList<Transaction>();
	
		t.add(new Transaction(1, LocalDateTime.now(), "USD", 100, TransactionMode.BUY));

		String test = "test";
		SiteSupport.storeTransectionInSerializedFile(t, test );


		File f = new File(test);

		boolean exists = f.exists();
		
		Assert.assertTrue(exists);
	}
	
	
}
