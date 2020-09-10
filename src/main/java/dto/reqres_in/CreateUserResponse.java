package dto.reqres_in;

import lombok.Data;

@Data
public class CreateUserResponse{
    public String name;
    public String job;
    public String id;
    public String createdAt;
}