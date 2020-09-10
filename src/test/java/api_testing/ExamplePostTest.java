package api_testing;

import dto.reqres_in.CreateUserResponse;
import org.springframework.cglib.core.Local;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.*;

public class ExamplePostTest {

    public static final String BASE_URI = "https://reqres.in/api/";
    public static final String USERS_ENDPOINT = "users";
    //This pattern is used to parse the following date format:
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private SoftAssert softAssert;

    private String expectedName = "Pavlo";
    private String expectedJob = "QA";
    private LocalDate expectedCreatedDate = LocalDate.now();
    private String jsonBody =
            "{" +
                "\"name\": \"" + expectedName + "\", " +
                "\"job\": \"" + expectedJob + "\"" +
            "}";

    @BeforeMethod
    public void setup() {
        baseURI = BASE_URI;
        softAssert = new SoftAssert();
    }

    /**
     * This test fails because 'name' and 'job' fields are expected to be present in response, but they're not in place
     * Please refer to the documentation for more details: https://reqres.in/
     */
    @Test(description = "Verifies that correct response is provided once the user is created")
    public void test() {
        CreateUserResponse createUserResponse =
                given()
                    .body(jsonBody)
        .       when()
                    .log().all() //Enable logging api requests in console
                    .post(BASE_URI + USERS_ENDPOINT)
                    .then()
                    .assertThat()
                    .statusCode(201)
                    .and()
                    .extract()
                    .body()
                    .as(CreateUserResponse.class);

        LocalDate createdDate =
                LocalDate.parse(createUserResponse.getCreatedAt(), DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));

        softAssert.assertEquals(createUserResponse.getName(), expectedName, "Invalid name in response");
        softAssert.assertEquals(createUserResponse.getJob(), expectedJob, "Invalid job in response");
        softAssert.assertNotNull(createUserResponse.getId(), "Response does not contain id");
        softAssert.assertEquals(createdDate, expectedCreatedDate, "Invalid created date in response");

        softAssert.assertAll();
    }

}


