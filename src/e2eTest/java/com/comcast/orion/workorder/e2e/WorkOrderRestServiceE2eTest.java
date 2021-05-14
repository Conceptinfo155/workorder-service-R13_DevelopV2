package com.comcast.orion.workorder.e2e;

import static com.jayway.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.comcast.orion.workorder.test.helpers.Utils;
import static org.hamcrest.CoreMatchers.equalTo;
/*
 * Please use the below command to execute the end to end.
 * gradlew e2eTest -Dspring.profiles.active=orion-local -Dspring.oauth.url=https://websec-int.cable.comcast.com/as/token.oauth2 -Dspring.oauth.clientid=orion_dev -Dspring.oauth.clientsecret=c02af9ff99dc45019fcba878fc90cb10 -Dspring.oauth.scope=orion:orion-dev
 * 
 */

public class WorkOrderRestServiceE2eTest extends BaseEndToEndTest {

}
