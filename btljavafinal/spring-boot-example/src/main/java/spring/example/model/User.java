package spring.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String gender;
    private String phoneNumber;
    private String accountStatus;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role; // Một User chỉ có một Role

    @OneToMany(mappedBy = "user")
    private List<Post> posts; // Một User có thể có nhiều Post

    @OneToMany(mappedBy = "user")
    private List<Image> images; // Một User có thể có nhiều Image

    // Thời gian tạo người dùng
    private String createdAt = java.time.LocalDateTime.now().toString();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và Setter cho email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter và Setter cho password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and setters...
}
