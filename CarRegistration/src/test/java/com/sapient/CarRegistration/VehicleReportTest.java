package com.sapient.CarRegistration;

import org.junit.Assert;
import org.junit.Test;

import com.image.imageComparison.compare.CompareImages;

public class VehicleReportTest {

	@Test
	public void testVehicleReport() {
		CompareImages.captureImageInChrome("VehicleReportTest_testVehicleReport");
		String imageWithDiff = CompareImages.compareImage("VehicleReportTest_testVehicleReport");
		if(imageWithDiff!=null){
			Assert.assertEquals("Difference ", "", imageWithDiff);
		}
	}

	/*@Test
	public void testVehicleReportWithhError() {
		System.setProperty("mode", "Actual");
		CompareImages.captureImageInChrome("VehicleReportTest_testVehicleReportWithhError");
		String imageWithDiff = CompareImages.compareImage("VehicleReportTest_testVehicleReportWithhError");
		Assert.assertEquals("Difference ", "", imageWithDiff);
	}*/
	
}
