package RestAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ColorLovers {
	
	public Response getResponseFromURI() {
		
        RestAssured.baseURI=("https://www.colourlovers.com");
        String path = "/api/patterns";
    Response response = RestAssured
                .given()
                .header("User-Agent:", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36")
                .get(path)
                .then().extract().response();
       return response;
        
    }
	
	
	public List<String> parseResponse(Response response){
		
		List<String> numViewsList = response.xmlPath().getList("patterns.pattern.numViews");
		
		return numViewsList;
		
		
	}
	public boolean isNumViewsValueGreater(int value , List <String> numViewsList){
		
		for (String numview : numViewsList) {
            int numViewsValue = Integer.parseInt(numview);
            if (numViewsValue <= value){
                
                
                return false;
            }

        }		
	
		return true;
		
	}
}
