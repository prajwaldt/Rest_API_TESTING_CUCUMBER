package testdataresourse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Reusableutils {
	public static RequestSpecification reqspec;

	public RequestSpecification reqspecu() throws IOException {

		if(reqspec==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqspec = new RequestSpecBuilder().setBaseUri(globalprperies("baseurl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return reqspec;
		}
		return reqspec;
	}

	public static String globalprperies(String key) throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\002E23744\\Desktop\\RESTAPITSESTING\\CucumberframeworkAPI\\src\\test\\java\\testdataresourse\\global.properties");
		pro.load(fis);
		return pro.getProperty(key);
	}
	
	public JsonPath Jsonp(String jresp)
	{
		JsonPath js = new JsonPath(jresp);
		return js;
	}
}
