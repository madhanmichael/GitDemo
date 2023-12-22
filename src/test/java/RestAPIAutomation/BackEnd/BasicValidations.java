package RestAPIAutomation.BackEnd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class BasicValidations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//given - all input details
		//when - submit the api
		//then - validate the response
		
//		RestAssured.baseURI = "https://reqres.in";
//		String response = given().header("Content-type","application/json").body("{\r\n"
//				+ "    \"name\": \"morpheus\",\r\n"
//				+ "    \"job\": \"leader\"\r\n"
//				+ "}").when().post("/api/users").then().assertThat().extract().asString();
//		JsonPath js= new JsonPath(response);
//		String value=js.getString("name");
//		System.out.println(value);
		
		///complex Json Validations
		
		
		JsonPath js1= new JsonPath(Payload.payloadjson());
		
		//print no of courses returned by api
		int Coursecount = js1.getInt("courses.size()");
		System.out.println(Coursecount);
		
		//Print Purchase amount
		int purchasecount= js1.getInt("dashboard.purchaseAmount"); 
		System.out.println(purchasecount);
		
		//print the title of the first course
		System.out.println(js1.getString("courses[0].title").toString());;
		
		//print all course titles and their respective prices
		for (int i = 0; i < Coursecount; i++) {
			
			System.out.println(js1.get("courses["+i+"].title"));
			
			System.out.println(js1.get("courses["+i+"].price")); 
		}
		
		//print no of copies sold by RPA course
		for(int i =0; i<Coursecount ; i++)
		{
			String courseTitles = js1.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
					{
				     System.out.println(js1.get("courses["+i+"].copies"));
				     break;
					}
		}
		
		
	}

}
