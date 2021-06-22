package pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class RickAndMortyApi {
    Response response=null;


    public void Get_Character(){
        response=RestAssured.given().when().get("https://rickandmortyapi.com/api/character/1");
        JsonPath js=response.jsonPath();
        String name=js.get("name");
        System.out.println(name);
    }

    public void Get_List_Character(){
        response=RestAssured.given().when().get("https://rickandmortyapi.com/api/character");
        JsonPath js=response.jsonPath();
        List<String> list=js.get("results.name");
        System.out.println(list);
//her iki yolda olur.İkiside aynısı.
        List<String> list2=RestAssured.given().when().get("https://rickandmortyapi.com/api/character")
                .then().extract().jsonPath()
                .getList("results.name");
        System.out.println(list2);
    }


    public void Get_Id_Character(){
        response=RestAssured.given().pathParam("id",2).when()
                .get("https://rickandmortyapi.com/api/character/{id}");
        response.then().log().body();
    }

}
