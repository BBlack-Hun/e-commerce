package kr.co.bblackhun.ecommerce.User.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String userName;

    @NotBlank
    @Size(max = 50)
    @Email
    @Indexed(unique = true)
    private String email;

    @NotBlank
    private String password;

    private ERole roles;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();

    public User() {

    }

    public User(User user) {
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }




}
