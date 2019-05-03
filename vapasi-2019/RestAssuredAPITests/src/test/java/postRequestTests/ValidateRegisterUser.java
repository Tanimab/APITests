package postRequestTests;

import com.oracle.javafx.jmx.json.JSONException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateRegisterUser {
    @Test
    public void validateRegistrationOfUsersTest(){


        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","Application/json");
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put( "email","sydney@fife");
            requestJson.put("password", "pistol");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        request.body(requestJson.toString());
        Response responseRegister = request.post("https://reqres.in/api/register");
        System.out.println("Response Body:"+responseRegister.getBody().prettyPrint());
        Assert.assertEquals(responseRegister.getStatusCode(),201);


    }
}
