package starter.Jojonomic;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Jojonomic.Utils.Constant;

import java.io.File;

public class WheaterAPI {

    public static  String TOKEN = "3af36c7bf7aa47e18bcef6e50a1f8310";
    public static  String GET_CURRENT_DATA = Constant.BASE_URL + "/current?lat={lat}&lon={lon}&key={token}";
    public static  String GET_FORECAST_DATA = Constant.BASE_URL + "/forecast/hourly?postal_code={postalCode}&key={tokenForecast}";

    @Step ("Get current wheater")
    public void setGetCurrentData(String lat,String lon){
        SerenityRest.given()
                .pathParam("lat", lat)
                .pathParam("lon", lon)
                .pathParam("token" , TOKEN);

    }
    @Step ("Get forecast data")
    public void setGetForecastData(int postalCode){
        SerenityRest.given()
                .pathParam("postalCode", postalCode)
                .pathParam("tokenForecast" ,TOKEN);
    }

    @Step("Json Schema Validator")
    public  void setJsonSchema(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}