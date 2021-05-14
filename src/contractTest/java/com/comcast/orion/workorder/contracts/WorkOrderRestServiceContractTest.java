package com.comcast.orion.workorder.contracts;

import static com.comcast.orion.workorder.test.helpers.Utils.CONTRACT_TEST_DIR;
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

public class WorkOrderRestServiceContractTest extends BaseServiceTest {

	private String requestFilePath = "workorder-request.json";
	private String wFXTechLogin = "wFXTechLogin-Mandatory.json";

	/**
	 * Test case to test Success Scenario for createWork Order
	 * 
	 * @throws Exception
	 */
	@Test
	public void workOrderSuccessResponse() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "auth-response.json"));
		mocoServer.request(by(uri("/location/v1/locationinfo")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "location-response.json"));
		mocoServer.request(by(uri("/access1_0-qa.g1.app.cloud.comcast.net")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "wfx-authresonse.json"));
		mocoServer.request(by(uri("/OMS/workorders/11111134530")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "wfx-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(CONTRACT_TEST_DIR) + requestFilePath));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/11111134530").then().assertThat()
						.statusCode(HttpStatus.SC_OK)/*.body("Response", equalTo("Successfully created WorkOrder"))
						.body("workOrderNum", equalTo("11111134530"))*/);
	}

	/**
	 * Test case to test HTTPSTATUS=404
	 * 
	 * @throws Exception
	 */
	@Test
	public void test404Error() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(CONTRACT_TEST_DIR) + requestFilePath));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").header("TrackingID", "orio12345").body(root)
						.accept("application/json").post("/workorder/v1/createworkorde1r/ORION-11111103700000051")
						.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND));
	}

	/**
	 * Test case to test HTTPSTATUS=401 and the response from orion service
	 * 
	 * @throws Exception
	 */
	@Test
	public void unauthorizedTest() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "auth-response.json"));
		mocoServer.request(by(uri("/location/v1/locationinfo")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "location-response.json"));
		mocoServer.request(by(uri("/access1_0-qa.g1.app.cloud.comcast.net")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "wfx-authresonse.json"));
		mocoServer.request(by(uri("/OMS/workorders/or-1111110370000289")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "wfx-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(CONTRACT_TEST_DIR) + requestFilePath));
		running(mocoServer,
				() -> given()
						.header("Authorization",
								"Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNpZ25pbmdDZXJ0LTIwMTUifQ.eyJjbGllbnRfaWQiOiJvcmlvbl9kZXYiLCJleHAiOjE0OTk0MjM1MjAsInNjb3BlIjpbIm9yaW9uOm9yaW9uLWRldiJdLCJpc3MiOiJQaW5nRmVkZXJhdGUifQ.ftfyqp8t_BuIzRgD7kLWMtdT0rNkOIbElgj57PfgJN1AD9H2vYEcaXb0wHUjGTPak6_HmtuRfeIpIg70ULoVS9jljyLb952sfJwTqCOMQkAmp3f4sv8MVr_1npqNUrlvcCVISZlcYHbhaVilcN3pxZFthS8aF-z-9H48nN0bquOr0F4wQsntnK97W3lV5cL04A-l8W8cyC5rysxOiPSE-ySpR8M4x2rTBPg_m0FM9AY_GRn0xcnV5LPPARw85YFNezDFmyTxA7qfx4u0bucm9I3g_D2h6pErxhA_FztiSHBKVy3YuNWv5p3sBO31_qF7H0m8IoE86Pr_6qVmlWI9lQ")
						.header("Content-Type", "application/json").header("TrackingID", "orio12345").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_UNAUTHORIZED));
	}

	/**
	 * Mandatory field wFXTechLogin test for error scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void wFXTechLoginMandatory() throws Exception {
		mocoServer.request(by(uri("/as/token.oauth2")))
				.response(contentFromFile(CONTRACT_TEST_DIR, "auth-response.json"));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(filePath(CONTRACT_TEST_DIR) + wFXTechLogin));
		running(mocoServer,
				() -> given().header("Authorization", "Bearer " + OAuthTokenHelper.getToken())
						.header("Content-Type", "application/json").body(root)
						.post("/workorder/v1/createworkorder/ORION-1111110370000005").then().assertThat()
						.statusCode(HttpStatus.SC_BAD_REQUEST).body("errors.get(0).code", equalTo("WO-CWO-100"))
						.body("errors.get(0).message", equalTo("wFXTechLogin : may not be null")));
	}
}
