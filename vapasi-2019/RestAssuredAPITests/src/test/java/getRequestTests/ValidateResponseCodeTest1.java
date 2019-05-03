package getRequestTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ValidateResponseCodeTest1 {

    @Test
    public void validateResponseCode() {
        RestAssured.baseURI = "https://reqres.in";

        validateData();
    }

    private void validateData( ) {


        Response response =
                (Response) given()
                        .when()
                        .get("/api/users/2")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .and()
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();


        Map<String,?> actualData = response.jsonPath().getMap("data");

        System.out.println("Id : "+actualData.get("id").toString());
        }

    }

