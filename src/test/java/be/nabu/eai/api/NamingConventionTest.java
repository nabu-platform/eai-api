/*
* Copyright (C) 2015 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

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
