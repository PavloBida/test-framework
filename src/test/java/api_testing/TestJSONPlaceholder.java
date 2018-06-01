package api_testing;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Pavlo Bida in 2018
 * https://github.com/PavloBida
 */

public class TestJSONPlaceholder extends ApiTestBase{

    private final String POSTS = "/posts";

    private final int SUCCESS_CODE = 200;

    private final int USER_ID = 1;
    private final int POST_ID = 6;
    private final String TITLE = "dolorem eum magni eos aperiam quia";
    private final String BODY = "ut aspernatur corporis harum nihil quis provident sequi\n" +
            "mollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\n" +
            "voluptate dolores velit et doloremque molestiae";

    @Test
    public void testPosts() {
        when().get(BASE_URL + POSTS).
        then().assertThat()
                .statusCode(SUCCESS_CODE).and()
                .body("userId", hasItem(USER_ID)).and()
                .body("id", hasItem(POST_ID)).and()
                .body("title", hasItem(TITLE)).and()
                .body("body", hasItem(BODY));
    }

    @Test
    public void testPost6() {
        String id = "?id=6";
        when().get(BASE_URL + POSTS + id).
        then().assertThat()
                .statusCode(SUCCESS_CODE).and()
                .body("id", hasItem(POST_ID));
    }
}
