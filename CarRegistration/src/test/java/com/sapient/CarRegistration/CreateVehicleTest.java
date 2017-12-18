package com.sapient.CarRegistration;

import org.junit.Assert;
import org.junit.Test;

import com.image.imageComparison.compare.CompareImages;



public class CreateVehicleTest {

	@Test
	public void testCreateVehiclePage() {
		//System.setProperty("mode", "Actual");
		CompareImages.captureImageInChrome("CreateVehicleTest_testCreateVehiclePage");
		String imageWithDiff = CompareImages.compareImage("CreateVehicleTest_testCreateVehiclePage");
		if(imageWithDiff !=null){
			Assert.assertEquals("Difference ", "", imageWithDiff);
		}
	}
	
	@Test
	public void testCreateVehicle() {
		CompareImages.captureImageInChrome("CreateVehicleTest_testCreateVehicle");
		String imageWithDiff = CompareImages.compareImage("CreateVehicleTest_testCreateVehicle");
		if(imageWithDiff !=null){
			Assert.assertEquals("Difference ", "", imageWithDiff);
		}
	}

}
