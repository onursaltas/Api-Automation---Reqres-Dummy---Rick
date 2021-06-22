package pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class DummyRestApi {

    public Logger logger;

    @BeforeClass
    public void setup(){

        logger= Logger.getLogger("Fox API");//added Logger
        PropertyConfigurator.configure("Log4j.properties"); //added logger
        logger.setLevel(Level.DEBUG);

    }

    public void Get_Employees(){

        logger.info("----------------------------------------Start T1_Get_Employees----------------------------------");
        Response response = RestAssured.given().when().get("http://dummy.restapiexample.com/api/v1/employees");
        JsonPath js = response.jsonPath();
        String Name = js.get("data.employee_name[1]");
        String Id =js.get("data.id[1]");
        System.out.println("Response  : " + response.asString());
        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Name:"+Name);
        System.out.println("id: "+Id);
        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("----------------------------------------Finish T1_Get_Employees----------------------------------");


    }

    public void Post_Create() {

        logger.info("----------------------------------------Start T2_Post_Create----------------------------------");

        baseURI="http://dummy.restapiexample.com/api/v1";
        double number=Math.random();
        given().param("name"," emre")
                .param("lastname","akbaba")
                .param("age","35")
                .param("number",number)
                .post("/create")
                .then().statusCode(200).log().all();

        logger.info("----------------------------------------Finish T2_Post_Create----------------------------------");

    }

    public  void Post_Create_2(){

        logger.info("----------------------------------------Start T3_Post_Create_2----------------------------------");

        baseURI="http://dummy.restapiexample.com/api/v1";
        JSONObject request=new JSONObject();
        request.put("name","cenk");
        request.put("salary","7500");
        given().header("Content-Type","application/json")
                . contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toString())
                .when().post("/create")
                .then().statusCode(200).log().body();

        logger.info("----------------------------------------Finish T3_Post_Create_2----------------------------------");

    }
}
