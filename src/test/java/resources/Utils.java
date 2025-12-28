package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;
    public static RequestSpecification requestSpecification() throws IOException {

        if (requestSpec == null) {

            logger.info("Initializing Request Specification");

            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseurl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();

            logger.info("Request Specification created successfully");
        }
        return requestSpec;
    }

    public ResponseSpecification responseSpecification() {

        if (responseSpec == null) {
            logger.info("Initializing Response Specification");

            responseSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectContentType(ContentType.JSON)
                    .build();
        }
        return responseSpec;
    }

    public static String getGlobalValue(String key) throws IOException {

        logger.info("Reading property value for key: {}", key);

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\Global.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String value = prop.getProperty(key);
        logger.info("Property value fetched: {} = {}", key, value);

        return value;
    }

    public String getJsonPath(Response response, String key) {

        logger.info("Extracting value from response for key: {}", key);

        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
