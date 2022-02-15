package StepDefinitions;

import API.Methods;
import Driver.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.get;

public class API_MyStepdefs {
    private static Response response;
    private String data;
    private String strRes;

    @Given("Lat as {double} and Lon as {double}")
    public void lat_as_and_lon_as(Double double1, Double double2) {
        data = "/current?" +"lat=" + double1 + "&lon=" + double2;
    }


    @When("User sends GET request")
    public void userSendsGETRequest() throws IOException {
        Methods.response = get(Setup.getProperty("ApiURL") +  data + "&key=dfa7783da5044d35a3c06e63f49cafb6");
        response = Methods.response;
        strRes = response.asString();
    }

    @Then("It should parse the response and get the value of the {string}")
    public void itShouldParseTheResponseAndGetTheValueOfThe(String arg0) {
        String[] args =  arg0.split("/");
        JSONObject json = new JSONObject(strRes);
        Assert.assertNotNull(json.getJSONArray(args[0]).getJSONObject(0).getString(args[1]));
        System.out.println("State Code: "+json.getJSONArray(args[0]).getJSONObject(0).getString(args[1]));
    }


    @Given("Data for {int} hour forecast postal_code is {string} and country is {string}")
    public void dataForHourForecastPostal_codeIsAndCountryIs(int arg0, String arg1, String arg2) {
        data = "/forecast/hourly?postal_code="+arg1+"&country="+arg2+"&hours="+arg0;
    }

    @Then("It should parse the response and get the value of the timestamp_utc, weather for all the data entries")
    public void itShouldParseTheResponseAndGetTheValueOfTheTimestamp_utcWeatherForAllTheDataEntries() {
        JSONObject json = new JSONObject(strRes);
        int dataLen = json.getJSONArray("data").length();
        Assert.assertTrue(dataLen!=0);
        JSONObject jsonObj;
        for(int i=0;i<dataLen;i++)
        {
            jsonObj = json.getJSONArray("data").getJSONObject(i);
            int ctr = i+1;

            System.out.println(jsonObj.get("datetime").toString());
            System.out.println("Weather code "+ctr+": "+jsonObj.getJSONObject("weather").get("code"));
            System.out.println("Weather icon "+ctr+": "+jsonObj.getJSONObject("weather").get("icon"));
            System.out.println("Weather description "+ctr+": "+jsonObj.getJSONObject("weather").get("description"));
        }
    }
}
