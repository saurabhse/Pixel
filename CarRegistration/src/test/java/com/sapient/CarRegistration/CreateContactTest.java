package com.sapient.CarRegistration;

import org.junit.Assert;
import org.junit.Test;

import com.image.imageComparison.compare.CompareImages;



public class CreateContactTest {

	@Test
	public void testCreateContactPage() {
		CompareImages.captureImageInChrome("CreateContactTest_testCreateContactPage");
		String imageWithDiff = CompareImages.compareImage("CreateContactTest_testCreateContactPage");
		if(imageWithDiff!=null){
			Assert.assertEquals("Difference ", "", imageWithDiff);
		}
	}
	
	@Test
	public void testCreateContact() {
		CompareImages.captureImageInChrome("CreateContactTest_testCreateContact");
		String imageWithDiff = CompareImages.compareImage("CreateContactTest_testCreateContact");
		if(imageWithDiff!=null){
			Assert.assertEquals("Difference ", "", imageWithDiff);
		}
	}

}
