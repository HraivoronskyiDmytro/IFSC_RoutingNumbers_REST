package service;


import static io.restassured.RestAssured.given;

public class IFSC extends service {


    IFSC() {
        request = given().baseUri("https://ifsc.razorpay.com");
    }

    @Override
    public void addValidCode() {
        request.basePath("KARB0000001");
    }

    @Override
    public void addInvalidCode() {
        request.basePath("KARB00000011");
    }

    @Override
    public void setHttpEndpoint() {
        request.baseUri("http://ifsc.razorpay.com");
    }
}
