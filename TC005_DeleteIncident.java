package tests.rest;

import java.io.File;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC005_DeleteIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Delete Incident (REST)";
		testDescription = "Delete Incident and Verify";
		nodes = "Incident";
		authors = "Gopi";
		category = "REST";
		//dataProvider
		//dataFileName = "TC005";
		//dataFileType = "JSON";
	}

	@Test(dependsOnMethods = "tests.rest.TC004_UpdateIncident.updateIncident")
	public void deleteIncident() {		
				
		Response response = delete("incident/"+sysID);
		response.prettyPrint();
		//verifyContentType(response, "application/json");
		
		verifyResponseCode(response, 204);
		if(response.statusCode() == 204) {
			System.out.println("Testcase has been PASS");
		}else {
			System.out.println("Fail");
		}
		
		
		//verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia updated");
		//sysID = getContentWithKey(response, "result.sys_id");
	}


}




















