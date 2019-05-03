package getRequestTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class ValidateResponseCodeTest {

    @Test
    public void validateResponseCode() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertTrue(response.getStatusCode() == 200);
        validateData(response);
    }

    private void validateData(Response response) {

        List<Map<String, ?>> actualData = response.jsonPath().getList("data");
        List<Map<String, ?>> expectedData ;

        int dataSize = actualData.size();
        for (int i = 0; i < dataSize; i++) {
            System.out.println("Id : " + actualData.get(i).get("id").toString());
            //Assert
        }

    }
}

