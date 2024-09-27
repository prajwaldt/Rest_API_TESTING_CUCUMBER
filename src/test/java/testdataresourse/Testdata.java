package testdataresourse;

import java.util.ArrayList;
import java.util.Arrays;

import pojoclass.Location;
import pojoclass.Mainclasss;

public class Testdata {

	public Mainclasss reqpayload(String name,String language,String address)
	{
		Mainclasss ms = new Mainclasss();
		ms.setAccuracy(50);
		ms.setName(name);
		ms.setPhone_number("(+91) 983 893 3937");
		ms.setAddress(address);
		ms.setWebsite("http://google.com");
		ms.setLanguage(language);
		ArrayList<String> sa = new ArrayList<>(Arrays.asList("shoe park", "shop"));
		ms.setTypes(sa);
		Location ls = new Location();
		ls.setLat(-38.383494);
		ls.setLng(33.427362);
		ms.setLocation(ls);
		return ms;
	}
}
