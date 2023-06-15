package starter.Jojonomic.StepDefiniitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Jojonomic.JsonSchema;
import starter.Jojonomic.WheaterAPI;

import java.io.File;

public class WheaterStepdefs extends JsonSchema {
    @Steps
    WheaterAPI wheaterAPI;

    @Given("Get current wheater with valid parameter")
    public void getCurrentWheaterWithValidParameter() {
        wheaterAPI.setGetCurrentData("40.73061","-73.935242");
    }

    @When("Send request current wheater data")
    public void sendRequestCurrentWheaterData() {
        SerenityRest.when().get(wheaterAPI.GET_CURRENT_DATA);

    }

    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCode(int OK) { SerenityRest.then().statusCode(OK);
    }

    @And("Validate json schema current wheater data")
    public void validateJsonSchemaCurrentWheaterData() {
        File jsonSchemaValidator = new File(GET_LIST_CURRENT);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaValidator));
    }

    @Given("Get forecast hourly wheater with valid parameter")
    public void getForecastHourlyWheaterWithValidParameter() {
        wheaterAPI.setGetForecastData(16620);
    }

    @When("Send request forecast hourly data")
    public void sendRequestForecastHourlyData() {
        SerenityRest.when().get(wheaterAPI.GET_FORECAST_DATA);
    }

    @And("Validate json schema forecast hourly data")
    public void validateJsonSchemaForecastHourlyData() {
        File jsonSchemaValidator = new File(GET_LIST_FORECAST);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaValidator));
    }


}
