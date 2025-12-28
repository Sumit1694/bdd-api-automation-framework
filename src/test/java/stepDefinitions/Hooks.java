package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import resources.APIResource;
import resources.TestContext;
import resources.Utils;

public class Hooks {

	private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

	TestContext context;

	public Hooks(TestContext context) {
		this.context = context;
	}

	private void createPlace() throws IOException {

		logger.info("Creating place for scenario");

		context.request = given()
				.spec(Utils.requestSpecification())
				.body(context.testData.addPlacePayload(
						"TempPlace",
						"English",
						"Temporary Address"));

		context.response = context.request.when()
				.post(APIResource.addPlaceAPI.getResource());

		context.placeId = context.utils.getJsonPath(context.response, "place_id");

		logger.info("Place ID created: {}", context.placeId);
	}
	@Before
	public void beforeScenario(Scenario scenario) throws IOException {

		String scenarioName = scenario.getName().toLowerCase();

		if (scenarioName.contains("get place") || scenarioName.contains("delete")) {

			createPlace();
		}
	}


	@After
	public void afterScenario(Scenario scenario) {

		if (scenario.isFailed()) {
			logger.error("Scenario FAILED: {}", scenario.getName());
		} else {
			logger.info("Scenario PASSED: {}", scenario.getName());
		}
	}
}
