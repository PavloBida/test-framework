package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Pavlo Bida in 2018
 * https://github.com/PavloBida
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDTO {
    private int userId;
    private int id;
    private String title;
    private String body;

    @JsonCreator
    public PostDTO(@JsonProperty("userId") int userId, @JsonProperty("id") int id,
                   @JsonProperty("title") String title, @JsonProperty("body") String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return String.format("%d, %d, %s, %s", getUserId(), getId(), getBody(), getBody());
    }
}
