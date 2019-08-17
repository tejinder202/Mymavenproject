package APITesting.com.org.api;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	
@Test
public void Test_01(){
	Response resp=
	get("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	System.out.println(resp.getStatusCode());
}

}
