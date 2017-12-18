package com.sapient.CarRegistration.Suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sapient.CarRegistration.CreateContactTest;
import com.sapient.CarRegistration.CreateVehicleTest;
import com.sapient.CarRegistration.UserReportTest;
import com.sapient.CarRegistration.VehicleReportTest;

@RunWith(Suite.class)
@SuiteClasses({ CreateContactTest.class,CreateVehicleTest.class,UserReportTest.class,VehicleReportTest.class/*DisplayModeTestSuite.class,RunModeTestSuite.class,ImageComparisonTest.class*/ })
public class AllTestSuite {

}
