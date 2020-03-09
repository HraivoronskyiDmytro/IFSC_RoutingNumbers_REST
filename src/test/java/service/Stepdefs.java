package service;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

    private service service;

    @Given("User has {string} endpoint")
    public void userHasEndpoint(String serviceName) {

        if (serviceName.equals("IFSC")) {
            service = new IFSC();

        } else if (serviceName.equals("Routing Numbers")) {
            service = new RoutingNumbers();
        } else {
            throw new cucumber.api.PendingException("Need to implement Service " + serviceName);
        }

    }

    @Given("User has valid IFSC/Routing code/number")
    public void addValidCode() {
        service.addValidCode();
    }

    @Given("User set invalid IFSC/Routing code/number")
    public void addInvalidCode() {
        service.addInvalidCode();
    }

    @When("User make {string} request")
    public void makeRequest(String type) {
        service.makeRequest(type);
    }

    @Then("Status code is {string}")
    public void checkStatus(String status) {
        service.checkStatus(status);
    }


    @Then("Content Type is {string}")
    public void checkContentType(String contentType) {
        service.checkContentType(contentType);
    }

    @Then("Response matches by {string} json scheme")
    public void checkJsonByScheme(String contentType) {
        service.checkJsonByScheme(contentType);
    }

    @And("Request body is {string}")
    public void requestBodyIs(String requestBody) {
        service.checkResponceBody(requestBody);
    }


    @And("User set http protocol in endpoint")
    public void userSetHttpProtocolInEndpoint() {
        service.setHttpEndpoint();
    }
}



