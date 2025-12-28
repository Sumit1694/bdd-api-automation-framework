package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.APIResource;
import resources.TestContext;
import resources.Utils;

public class StepDefinitions {

	TestContext context;
	private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);


	public StepDefinitions(TestContext context)
	{
		this.context=context;
	}

	@Given("user fetches existing place with place_id")
	public void user_fetches_existing_place_with_place_id() throws IOException {

		logger.info("Creating GET Place request with place_id: {}", context.placeId);

		context.request = given()
				.spec(Utils.requestSpecification())
				.queryParam("place_id", context.placeId);
	}


	@Given("user provides add place payload with {string} {string} {string}")
	public void user_provides_add_place_payload(String name, String language, String address) throws IOException {
		logger.info("Creating Add Place payload");
		logger.info("Name: {}, Language: {}, Address: {}", name, language, address);

		context.request = given()
				.spec(Utils.requestSpecification())
				.body(context.testData.addPlacePayload(name, language, address));

		logger.info("Add Place payload created successfully");
	}

	@When("user hits {string} with {string} request")
	public void user_hits_add_place_api_with_post_request(String resourceName, String method) {

		APIResource resource = APIResource.valueOf(resourceName);

		logger.info("Hitting API: {} with method: {}", resourceName, method);

		if (method.equalsIgnoreCase("POST")) {
			context.response = context.request.when().post(resource.getResource());
		} else if (method.equalsIgnoreCase("GET")) {
			context.response = context.request.when().get(resource.getResource());
		} else if (method.equalsIgnoreCase("DELETE")) {
			context.response = context.request.when().delete(resource.getResource());
		}

		context.response = context.response.then()
				.spec(context.utils.responseSpecification())
				.extract()
				.response();

		logger.info("Response received with status code: {}",
				context.response.getStatusCode());
	}

	@Given("user provided delete place api")
	public void user_provided_delete_place_api() throws IOException {

		context.request = given()
				.spec(Utils.requestSpecification())
				.body(context.testData.deletePlacePayload(context.placeId));

	}

	@Then("API should return status code {int}")
	public void api_should_return_status_code(Integer statusCode) {

		logger.info("Validating status code. Expected: {}", statusCode);

		Assert.assertEquals(context.response.getStatusCode(), statusCode.intValue());

		logger.info("Status code validation passed");
	}

	@Then("response status should be {string}")
	public void response_status_should_be(String expectedStatus) {

		String actualStatus = context.utils.getJsonPath(context.response, "status");
		Assert.assertEquals(actualStatus, expectedStatus);
	}

	@Then("response should contain place id")
	public void response_should_contain_place_id() {

		context.placeId = context.utils.getJsonPath(context.response, "place_id");
		Assert.assertNotNull(context.placeId);
	}
}