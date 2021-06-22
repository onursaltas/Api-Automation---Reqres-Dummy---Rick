package pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ReqresApi {

    public void Put_User(){
        JSONObject request=new JSONObject();
        request.put("name","Emre");
        request.put("job","tester");
        System.out.println(request);
        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toString()).
                when().
                put("/users/2").
                then().
                statusCode(200).log().all();
    }

    public void Patch_User(){
        JSONObject request=new JSONObject();
        request.put("name","Emre");
        request.put("job","tester");
        System.out.println(request);
        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).log().all();
    }

    public void Delete_User() {
        baseURI = "https://reqres.in/api";
        given().
                when().
                delete("/users/2").
                then().
                statusCode(204).log().all();
    }
    }
