package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentsDTO {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    @JsonCreator
    public CommentsDTO(@JsonProperty("postId") int postId, @JsonProperty("id") int id,
                       @JsonProperty("name") String name, @JsonProperty("email") String email,
                       @JsonProperty("body") String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return String.format("%d, %d, %s, %s, %s", getPostId(), getId(), getName(), getEmail(), getBody());
    }
}
