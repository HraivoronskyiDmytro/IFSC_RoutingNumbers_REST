package service;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class service {

    RequestSpecification request;
    Response response;

    /**
     * Set JSON Schema checking to draft-08
     * see https://json-schema.org/
     */
    JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
            .setValidationConfiguration(
                    ValidationConfiguration.newBuilder()
                            .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
            .freeze();

    public abstract void addValidCode();

    public abstract void addInvalidCode();

    public abstract void setHttpEndpoint();


    public void makeRequest(String type) {
        switch (type) {
            case "GET":
                response = request.get();
                break;
            case "PUT":
                response = request.put();
                break;
            case "POST":
                response = request.post();
                break;
            case "DELETE":
                response = request.delete();
                break;
            case "PATCH":
                response = request.patch();
                break;
            case "OPTIONS":
                response = request.options();
                break;
            default:
                throw new cucumber.api.PendingException("Need to implement request " + type + " for class " + getClass().getName());
        }
    }


    public void checkJsonByScheme(String nameOfschema) {
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(nameOfschema).using(jsonSchemaFactory));

    }

    public void checkStatus(String status) {
        response.then().assertThat().statusCode(Integer.parseInt(status));
    }

    public void checkContentType(String contentType) {
        response.then().assertThat().contentType(contentType);
    }


    public void checkResponceBody(String responceBody) {
        assertEquals(response.body().asString(), responceBody);
    }

}
