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

public class CreateUpdateWorkSuccFlowFunction extends BaseServiceTest {

	private String requestFilePath = "workorder-request.json";
	private String updRequestFilePath = "updateWorkRequest.json";
	private String Cancelworkorder = "Cancelworkorder-request.json";

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
	 * /** Test case to test success response with proper response code and
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
		JsonNode root = mapper.readTree(new File(filePath(FUNCTIONAL_TEST_DIR) + updRequestFilePath));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/updateworkorder/11111134530").then().assertThat()
						.statusCode(HttpStatus.SC_OK).body("UpdateWorkorderResponse.Response", equalTo("Successfully updated the WorkOrder"))
						.body("UpdateWorkorderResponse.workOrderNum", equalTo("11111134530")));
	}

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

}
