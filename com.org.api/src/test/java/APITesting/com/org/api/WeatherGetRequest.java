package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	
//@Test
public void Test_01(){
	Response resp= when().
	get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=1f721bd004b754f9146748289e0d1e64");
	System.out.println(resp.getStatusCode());
	Assert.assertEquals(resp.statusCode(), 200);
	System.out.println(resp.asString());
	//System.out.println(resp.jsonPath());
}

//@Test
public void Test_02(){
	Response resp= when().
	get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=1f721bd004b754f9146748289e0d1e64s");
	System.out.println(resp.getStatusCode());
	Assert.assertEquals(resp.statusCode(), 401);
	System.out.println(resp.asString());
	//System.out.println(resp.jsonPath());
}

@Test
public void Test_03(){
	Response resp =given().
			param("q","London").
			param("appid","1f721bd004b754f9146748289e0d1e64").
			when().
			get("https://api.openweathermap.org/data/2.5/weather");
			resp.then().assertThat().statusCode(200);
	System.out.println(resp.jsonPath());
}

@Test
public void Test_04(){
	
	Response resp =given().
			param("q","London").
			param("appid","1f721bd004b754f9146748289e0d1e64").
			when().
			get("https://api.openweathermap.org/data/2.5/weather");
	
	String actualweather = resp.
			then().
			contentType(ContentType.JSON).
			extract().
			path("weather[0].description");

String expectedweather = "scattered clouds";
if(actualweather.equalsIgnoreCase(expectedweather)){
	System.out.println("test passed");
}
else{
	System.out.println("Test failed");
}

}

}
