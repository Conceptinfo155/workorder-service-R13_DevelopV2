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

public class CancelWorkOrderFunctional extends BaseServiceTest {

	private String Cancelworkorder = "Cancelworkorder-request.json";
	private String cancelWFXTechLoginMandatory = "cancelWFXTechLoginMandatory.json";
	private String cancelwFXTechLogin = "cancelwFXTechLogin-ValueMiss.json";
	private String cancelwFXTechLoginLength = "cancelwFXTechLoginLength.json";
	private String canorderMgtSystemMandatory = "canorderMgtSystemMandatory.json";
	private String canorderMgtSystemValueMiss = "canorderMgtSystemValueMiss.json";
	private String canorderMgtSystemLength = "canorderMgtSystemLength.json";
	/**
	 * /** Test case to test success response with proper response code and
	 * description
	 * 
	 * @throws Exception
	 */
	@Test
	public void cancelSuccessResponse() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		mocoServer.request(by(uri("/location/v1/locationinfo")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "location-response.json"));
		mocoServer.request(by(uri("/access1_0-qa.g1.app.cloud.comcast.net")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "wfx-authresonse.json"));
		mocoServer.request(by(uri("/OMS/workorders/11111134530")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "updateWorkWfxResponse.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + Cancelworkorder));
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
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + cancelWFXTechLoginMandatory));
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
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + cancelwFXTechLogin));
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
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + cancelwFXTechLoginLength));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
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
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + canorderMgtSystemMandatory));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
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
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + canorderMgtSystemValueMiss));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
						.body("errors.get(0).message", equalTo("job.orderMgtSystem : size must be between 1 and 15")));
	}

	/**
	 * Mandatory field orderMgtSystem Length
	 * 
	 * @throws Exception
	 */
	@Test
	public void orderMgtSystemLength() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(FUNCTIONAL_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + canorderMgtSystemLength));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/updateworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-UWO-100"))
						.body("errors.get(0).message", equalTo("job.orderMgtSystem : size must be between 1 and 15")));
	}


}
