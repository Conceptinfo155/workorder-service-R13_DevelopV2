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

public class UpdateWorkOrderFunctional extends BaseServiceTest {

	private String requestFilePath = "updateWorkRequest.json";
	private String wFXTechLogin = "uodatewFXTechLogin-Mandatory.json";
	private String wFXTechLoginValueMiss = "updatewFXTechLogin-ValueMiss.json";
	private String wFXTechLoginLength = "uptwFXTechLoginLength.json";
	private String orderMgtSystemLength = "uptorderMgtSystemLength.json";
	private String jobNumLength = "uptjobNumLength.json";

	/**
	 * Test case to test success response with proper response code and
	 * description
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateSuccessResponse() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		mocoServer.request(by(uri("/location/v1/locationinfo")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "location-response.json"));
		mocoServer.request(by(uri("/access1_0-qa.g1.app.cloud.comcast.net")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "wfx-authresonse.json"));
		mocoServer.request(by(uri("/OMS/workorders/11111134530")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "updateWorkWfxResponse.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + requestFilePath));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/updateworkorder/11111134530").then().assertThat()
						.statusCode(HttpStatus.SC_OK).body("UpdateWorkorderResponse.Response", equalTo("Successfully updated the WorkOrder"))
						.body("UpdateWorkorderResponse.workOrderNum", equalTo("11111134530")));
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
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
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
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
						.body("errors.get(0).message", equalTo("wFXTechLogin : size must be between 1 and 10")));
	}

	/**
	 * Mandatory field wFXTechLogin value missing test for error scenario
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
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
						.body("errors.get(0).message", equalTo("wFXTechLogin : size must be between 1 and 10")));
	}

	/**
	 * Length validation orderMgtSystem
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
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
						.body("errors.get(0).message", equalTo("job.orderMgtSystem : size must be between 1 and 15")));
	}

	/**
	 * Length validation field JobNumSystem
	 * 
	 * @throws Exception
	 */
	@Test
	public void jobNumLength() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + jobNumLength));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
						.body("errors.get(0).message", equalTo("job.jobNum : size must be between 1 and 6")));
	}
}
