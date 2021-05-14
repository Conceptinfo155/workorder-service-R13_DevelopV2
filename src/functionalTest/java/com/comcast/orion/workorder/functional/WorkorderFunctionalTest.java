package com.comcast.orion.workorder.functional;

import static com.comcast.orion.workorder.test.helpers.Utils.FUNCTIONAL_TEST_DIR;
import static com.comcast.orion.workorder.test.helpers.Utils.contentFromFile;
import static com.comcast.orion.workorder.test.helpers.Utils.filePath;
import static com.github.dreamhead.moco.Moco.by;
import static com.github.dreamhead.moco.Moco.uri;
import static com.github.dreamhead.moco.Runner.running;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;

import org.apache.http.HttpStatus;
import org.junit.Test;

import com.comcast.orion.workorder.test.helpers.BaseServiceTest;
import com.comcast.orion.workorder.test.helpers.OAuthTokenHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WorkorderFunctionalTest extends BaseServiceTest {
	private String requestFilePath = "workorder-request.json";
	private String wFXTechLogin = "wFXTechLogin-Mandatory.json";
	private String wFXTechLoginValueMiss = "wFXTechLogin-ValueMiss.json";
	private String wFXTechLoginLength = "wFXTechLoginLength.json";
	private String orderMgtSystem = "orderMgtSystem-Mandatory.json";
	private String orderMgtSystemValueMiss = "orderMgtSystemValueMiss.json";
	private String orderMgtSystemLength = "orderMgtSystemLength.json";
	private String jobNum = "jobNum-Mandatory.json";
	private String scheduleDateFormat ="scheduleDateFormat.json";

	/**
	 * Test case to test success response with proper response code and
	 * description
	 * 
	 * @throws Exception
	 */
	@Test
	public void workOrderSuccessResponse() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		mocoServer.request(by(uri("/location/v1/locationinfo")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "location-response.json"));
		mocoServer.request(by(uri("/access1_0-qa.g1.app.cloud.comcast.net")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "wfx-authresonse.json"));
		mocoServer.request(by(uri("/OMS/workorders/11111134530")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "wfx-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + requestFilePath));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/11111134530").then().assertThat()
						.statusCode(HttpStatus.SC_OK).body("CreateWorkorderResponse.Response", equalTo("Successfully created WorkOrder"))
						.body("CreateWorkorderResponse.workOrderNum", equalTo("11111134530")));
	}

	/**
	 * Mandatory field wFXTechLogin test for error scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void wFXTechLoginMandatory() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + wFXTechLogin));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("wFXTechLogin : may not be null")));
	}

	/**
	 * Mandatory field wFXTechLogin value missing test for error scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void wFXTechLoginValueMissing() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + wFXTechLoginValueMiss));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("wFXTechLogin : size must be between 1 and 10")));
	}

	/**
	 * Mandatory field wFXTechLogin value Length Validation
	 * 
	 * @throws Exception
	 */
	@Test
	public void wFXTechLoginLength() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + wFXTechLoginLength));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("wFXTechLogin : size must be between 1 and 10")));
	}

	/**
	 * Mandatory field OrderMgtSystem test for error scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void orderMgtSystemMandatory() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + orderMgtSystem));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("job.orderMgtSystem : may not be null")));
	}

	/**
	 * Mandatory field orderMgtSystem value missing test for error scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void orderMgtSystemValueMissing() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + orderMgtSystemValueMiss));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("job.orderMgtSystem : size must be between 1 and 15")));
	}

	/**
	 * Mandatory field orderMgtSystem value Length Validation
	 * 
	 * @throws Exception
	 */
	@Test
	public void orderMgtSystemLength() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + orderMgtSystemLength));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("job.orderMgtSystem : size must be between 1 and 15")));
	}

	/**
	 * Mandatory field OrderMgtSystem test for error scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void jobNumMandatory() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + jobNum));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("job.jobNum : may not be null")));
	}

	/*
	 * Schedule Date format validation (YYYY-MM-DD)
     */
	
	@Test
	public void scheduleDateMandatory() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + scheduleDateFormat));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-101"))
						.body("errors.get(0).message", equalTo("Invalid data provided for the field ScheduleDate")));
	}

}