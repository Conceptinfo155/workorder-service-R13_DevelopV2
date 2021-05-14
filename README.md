Workorder-service
==============

Orion Work Order Service provide integration between AMIL and WFX to  support the schedule appointments on WFX scheduler.

Service Version
V1

Supported Operations:

•	createWorkOrder:

  Service URL (INT) :https://workorder-int.u1.app.cloud.comcast.net:443/workorder/v1/createworkorder/or-1111110370000289
  
•	updateWorkOrder:

  Service URL (INT) :https://workorder-int.u1.app.cloud.comcast.net:443/workorder/v1/updateworkorder/or-1111110370000289

  Sample Workorder number pattern :   or-1111110370000289


Dependencies
------------
This project depends on following projects.

##Projects
- orion-gateway: https://github.comcast.com/Orion/orion-gateway.git
- deployment-manifests: https://github.comcast.com/Orion/deployment-manifests.git
- orion-properties: https://github.comcast.com:Orion/orion-properties.git

##WFX Jar Dependencies

Schedule Service and Work Order Service referring the below downstream jar which is deployed in JFrog.

https://github.comcast.com/Orion/wfx-schedule-jar.git

##Location Service Dependencies

Workorder Service internally using the Orion location Service API 

https://location-int.u1.app.cloud.comcast.net:443/location/v1/locationinfo

##Authorization/Authentication

### OAuth token is required to pass security
Provide HTTP header to your REST request:
Header name: "Authorization"
Header value: "Bearer {access_token}"

To get the access_token for Dev, QA and INT use Ping Federate Playground INT environment: https://websec-int.cable.comcast.com/OAuthPlayground/case4-client-credentials.jsp.
- Populate client id (for example: orion_dev) and client secret (for example: c02af9ff99dc45019fcba878fc90cb10)
- Provide scope value "orion:orion-dev" or customer specific scope like "orion:amdocs"
- Press Request token button
- Copy access_token value

Ping Federate Auth server for STG and PROD environments:
https://websec-stg.cable.comcast.com/OAuthPlayground/case4-client-credentials.jsp
https://websec.cable.comcast.com/OAuthPlayground/case4-client-credentials.jsp    (Production environment)

### WIKI
- WorkOrder-Service:  https://wiki.sys.comcast.net/display/BSTA/Workorder+service
