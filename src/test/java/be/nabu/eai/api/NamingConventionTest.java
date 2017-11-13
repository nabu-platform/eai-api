package be.nabu.eai.api;

import junit.framework.TestCase;

public class NamingConventionTest extends TestCase {
	public void testCamelify() {
		assertEquals(
			"thisIsATest", 
			NamingConvention.LOWER_CAMEL_CASE.apply("this_is-a test")
		);
	}
	
	public void testDecamelify() {
		// note that subsequence uppercase characters are not transformed to prevent XML and the likes from becoming x-m-l
		assertEquals(
			"this-is-atest", 
			NamingConvention.DASH.apply("this-isATest")
		);
	}
	
	public void testLowerCase() {
		// note that subsequence uppercase characters are not transformed to prevent XML and the likes from becoming x-m-l
		assertEquals(
			"thisisatest", 
			NamingConvention.LOWER_CASE.apply("this-isATest", NamingConvention.DASH)
		);
	}
	
}
