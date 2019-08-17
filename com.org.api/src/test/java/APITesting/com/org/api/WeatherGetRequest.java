package APITesting.com.org.api;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	
@Test
public void Test_01(){
	Response resp=
	get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=1f721bd004b754f9146748289e0d1e64");
	System.out.println(resp.getStatusCode());
	System.out.println(resp.asString());
	System.out.println(resp.jsonPath());
}

}
