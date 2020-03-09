package service;

import static io.restassured.RestAssured.given;

public class RoutingNumbers extends service {


    RoutingNumbers() {
        request = given().baseUri("https://www.routingnumbers.info/api/name.json");
    }

    @Override
    public void addValidCode() {
        request.param("rn", "122242597");
    }

    @Override
    public void addInvalidCode() {
        request.param("rn", "1222425971");
    }

    @Override
    public void setHttpEndpoint() {
        request.baseUri("http://www.routingnumbers.info/api/name.json");
    }
}
