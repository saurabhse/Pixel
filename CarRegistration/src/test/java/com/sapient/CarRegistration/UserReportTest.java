package com.sapient.CarRegistration;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.image.imageComparison.compare.CompareImages;

public class UserReportTest {

	@Test
	public void testUserReport() {
		CompareImages.captureImageInChrome("UserReportTest_testUserReport");
		String imageWithDiff = CompareImages.compareImage("UserReportTest_testUserReport");
		if(imageWithDiff!=null){
			Assert.assertEquals("Difference ", "", imageWithDiff);
		}
	}

}
