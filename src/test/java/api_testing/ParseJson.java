package api_testing;

import dto.CommentsDTO;
import dto.PostDTO;
import org.testng.annotations.Test;
import util.JsonUtil;

import java.util.List;

public class ParseJson {

    @Test
    public void testJson() {
        List<CommentsDTO> comments =
                new JsonUtil<CommentsDTO>().parseJson("src/test/resources/comments.json", CommentsDTO.class);

        comments.forEach(System.out::println);
    }

    @Test
    public void testAnotherJson() {
        List<PostDTO> comments =
                new JsonUtil<PostDTO>().parseJson("src/test/resources/posts.json", PostDTO.class);

        comments.forEach(System.out::println);
    }

}
