# IFSC_RoutingNumbers_REST


[![Build Status](https://travis-ci.org/HraivoronskyiDmytro/IFSC_RoutingNumbers_REST.png)](https://travis-ci.org/HraivoronskyiDmytro/IFSC_RoutingNumbers_REST)

Sempahore status: [![Build Status](https://semaphoreci.com/api/v1/hraivoronskyidmytro/ifsc_routingnumbers_rest/branches/master/shields_badge.svg)](https://semaphoreci.com/hraivoronskyidmytro/ifsc_routingnumbers_rest/)

This is the simple test project for API testing based on Cucumber & RestAssured with responce validation based on Json Schema V4 (https://json-schema.org/).
It consists of two feature files that represents basic test suits for two endpoints of free fintech API:
 - Razorpay's IFSC API(https://github.com/razorpay/ifsc/wiki/API) - endpoint: https://ifsc.razorpay.com/ 
 - API for ACH/NACHA Bank Routing Numbers (https://www.routingnumbers.info/api/index.html) - endpoint https://www.routingnumbers.info/api/name.json
 
 Feature files are in /src/test/resources/service/
 
Scenarios basically cover the CRUD, changing in endpoint HTTPS to HTTP, invalid mandatory request's parameter, absent mandatory request's parameter.

Steps are defined in: /src/test/java/service/Stepdefs.java

JAVA 8 is required for running the project.

to run tests please clone the project & execute in the command promt from project root:" ./gradlew test "
