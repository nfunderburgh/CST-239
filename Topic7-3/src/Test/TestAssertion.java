package Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestAssertion {
	
	@Test
	public void testAssertions() {
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = null;
		String str4 = "abc";
		String str5 = "abc";
		
		int val1 = 5;
		int val2 = 6;
		
		String[] expectedArray = {"one","two","three"};
		String[] resultArray = {"one","two","three"};
		
		Assert.assertEquals(str1,str2);
		Assert.assertTrue(val1 < val2);;
		Assert.assertFalse(val1 > val2);
		Assert.assertNotNull(str1);
		Assert.assertNull(str3);
		Assert.assertSame(str4, str5);
		Assert.assertNotSame(str1, str3);
		Assert.assertArrayEquals(expectedArray, resultArray);
		
	}
}

