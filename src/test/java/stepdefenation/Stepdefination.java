package stepdefenation;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoclass.Location;
import pojoclass.Mainclasss;
import testdataresourse.Enumclass;
import testdataresourse.Reusableutils;
import testdataresourse.Testdata;

public class Stepdefination extends Reusableutils {

	ResponseSpecification resspec;
	RequestSpecification res;
	Response res1;
	Testdata td = new Testdata();
	String respn;
	JsonPath ss,ss1;
	static String plc;
	

	@Given("add placeapi payload  {string} {string} {string}")
	public void add_placeapi_payload(String name, String language, String address) throws IOException {

		res = given().spec(reqspecu()).body(td.reqpayload(name, language, address));
	}

	@When("user calls {string} api with {string} methods")
	public void user_calls_api_with_methods(String resourse, String method) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200).build();
		Enumclass enumobj=Enumclass.valueOf(resourse);
		System.out.println("the resourse is : "+enumobj.getplaceresourse());
		
		
		if(method.equalsIgnoreCase("Post"))
		res1 = res.when().post(enumobj.getplaceresourse());
		else if(method.equalsIgnoreCase("Get"))
			res1 = res.when().get(enumobj.getplaceresourse());	
		
	}

	@Then("the api call got with success {int}")
	public void the_api_call_got_with_success(Integer int1) {
		String se = res1.then().spec(resspec).extract().response().asString();;
		ss1=Jsonp(se);
		 plc= ss1.getString("place_id");
		System.out.println(plc);
		assertEquals(res1.getStatusCode(),200);
// to use assertEquals u need to ahve Junit and import manually the import import static org.junit.Assert.*;

	}

	@Then("{string} in response body is {string} value")
	public void in_response_body_is_value(String string, String string2) {
		 respn = res1.asString();
		  ss=Jsonp(respn);
 		assertEquals(ss.getString(string), string2);
	}
	
	 
	@Given("add delete api payload")
	public void add_delete_api_payload() throws IOException {
		 
	    System.out.println("Place ID in delete payload: " + plc);
	    String eres=given().spec(reqspecu()).body("\"place_id\": \""+plc+"\"").when().post("/maps/api/place/delete/json").then().extract().response().asString();
	    JsonPath jos=new JsonPath(eres);
	    System.out.println(jos.getString("status"));
	    
	}

	@When("user calls deleteplaceApi api with Post methods")
	public void user_calls_deleteplace_api_api_with_post_methods() {
		System.out.println("name"); 
	}

	@Then("in response body is  value")
	public void in_response_body_is_value() {
		System.out.println("name"); 
	}

}
