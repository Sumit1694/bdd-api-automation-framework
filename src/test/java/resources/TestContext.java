package resources;

import TestData.AddPlaceTestData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {
    public RequestSpecification request;
    public Response response;
    public String placeId;
    public Utils utils;
    public AddPlaceTestData testData;

    public TestContext()
    {
    	utils = new Utils();
    	testData = new AddPlaceTestData();
    }
}
