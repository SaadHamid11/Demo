package saad.automation.co.RestAssuredframework;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import Payloads.PlaceAPI;
import Pojo.CreateListing;
import Pojo.DemoSerialize;
import Pojo.GoogleMapAPI;
import Pojo.Location;
import Pojo.ShippingOptions;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class Basics {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException, SerializeException {
		
		
		
		SerializationExample();
		
	}
	
	
	public static void getListDemo() throws JsonMappingException, JsonProcessingException {
		
		RestAssured.baseURI="https://api.tmsandbox.co.nz";
		
		Pojo.Response response = given().headers("Connection","keep-alive").headers("Accept-Encoding","gzip,deflate,br").expect().defaultParser(Parser.JSON)
			
		 .when().get("/v1/Charities.json")
		 .as(Pojo.Response.class);
		// System.out.println("res +");
		//System.out.println(response.body().asPrettyString());
		
		//ArrayList<Pojo.Response> responseList = new ArrayList<Pojo.Response>();
		
		/*
		
		String _responseList =  response.body().asPrettyString();	
		
	
		
		ObjectMapper mapper = new ObjectMapper();
		Pojo.Response[] langs = mapper.readValue(_responseList, Pojo.Response[].class);
		
		for(int i = 0; i < langs.length ; i ++) {
			System.out.println(langs[i].Description);
		}
		
		
		*/
		 System.out.println(response.getDescription());
		
		 
		
		
	}
	
	
	public static void PostApiDemo() {
RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Object response = given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/json")
		.body(PlaceAPI.postAPIPayload()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		
		System.out.println("Response: "+response);
		JsonPath js = new JsonPath(response.toString());
		String placeId = js.getString("id");
		
		System.out.println("Place ID: "+placeId);
	}




public static void SerializationExample() throws SerializeException {
	/*JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
	
	String[] products = {"Apple", "Sony", "Samsung", "LG"};
	DemoSerialize demo = new DemoSerialize("Macbook",2000, "Silver", products);
	/*
	String jsonObj = jsonSerializer.serialize(demo);
	
	System.out.println(jsonObj);
	
	
	XmlSerializer xmlSer = XmlSerializer.DEFAULT_SQ_READABLE;
	
	String xmlRespo = xmlSer.serialize(demo);
	
	System.out.println(xmlRespo);
	
	*/
	
	
	List<ShippingOptions> shippingOptions = new ArrayList<ShippingOptions>();
	shippingOptions.add( new ShippingOptions(1,123.0,"ABC",123)); 
	shippingOptions.add( new ShippingOptions(2,123.0,"ABC",123));
	
	//String[] description = {"ABC", "ABC"};
	
	List<String> description = new ArrayList<String>();
	description.add("ABC");
	description.add("ABC");
	
	
	//int[] paymentMethods = {1,1};
	
	List<Integer> paymentMethod = new ArrayList<Integer>();
	paymentMethod.add(1);
	paymentMethod.add(1);
	
	CreateListing listing = new CreateListing(2273,"ABC","ABC",description, 123.0,123.0,123.0,10,1,shippingOptions,paymentMethod);

	Gson gson = new Gson();
	String json = gson.toJson(listing);
	
	//System.out.println(json);
	String consumerKey = "CAECAFC6DBF6FD0564EB7BEC3B3F0586";
	String consumerSecret = "CF0890BB1FCF8BF7B3623445431963E3";
	String accessToken = "EB8EE51D8C6C668FDFCA281C940B7288";
	String tokenSecret = "05929E860D7A30A69F0AC98D3C3A41D8";
	
	String  resp = RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
	.queryParam("Duration", 60)
	.header("Connection","keep-alive")
	.header("Content-type","application/json")
	.body(json)
	
	.when().post("https://api.tmsandbox.co.nz/v1/Selling.json")
	.then().extract().response().asPrettyString();
	
	
	System.out.println(resp);
	
	/*String resp = RestAssured.given()
	.auth().oauth("CAECAFC6DBF6FD0564EB7BEC3B3F0586","CF0890BB1FCF8BF7B3623445431963E3","EB8EE51D8C6C668FDFCA281C940B7288","05929E860D7A30A69F0AC98D3C3A41D8")
	.queryParam("Duration", 60)
	.body(listing)
	.expect().defaultParser(Parser.JSON)
	.when().post("https://api.tmsandbox.co.nz/v1/Selling.json")
	.then().assertThat().statusCode(200).extract().asString();*/

	//System.out.println(resp);
	
	 /*"Type": 1,
     "Price": 123.0,
     "Method": "ABC",
     "ShippingId": 123
     
     *
     *
     *
     *Category": 2273,
  "Title": "ABC",
  "Subtitle": "ABC",
  "Description": [
    "ABC",
    "ABC"
  ],
  "StartPrice": 123.0,
  "ReservePrice": 123.0,
  "BuyNowPrice": 123.0,
  "Duration": 10,
  "EndDateTime": "\/Date(1514764800)\/",
  "Pickup": 1,
 
  "ShippingOptions": [
    {
      "Type": 1,
      "Price": 123.0,
      "Method": "ABC",
      "ShippingId": 123
      
    },
    {
      "Type": 2,
      "Price": 123.0,
      "Method": "ABC",
      "ShippingId": 123
      
    }
  ],
  "PaymentMethods": [
    1,
    1
  ] */
}

public static void AddGoogleAPOPlace() {
	RestAssured.baseURI="https://rahulshettyacademy.com";
	GoogleMapAPI google= new GoogleMapAPI();
	
	google.setAccuracy(50);
	google.setName("BackLine House");
	google.setPhoneNumber("(+92) 304 444 0481");
	google.setAddress("29, side layout cohen 10");
	List<String> types = new ArrayList<String>();
	types.add("shoe park");
	types.add("shop");
	google.setTypes(types);
	
	Location location = new Location();
	location.setLat(-38.383494);
	location.setLng(33.427362);
	
	google.setLocation(location);
	
	
	
	
		
	
	String resp=given().queryParam("key", "qaclick123").body(google).when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().asString();
	
	
	System.out.println(resp);
}

}



