package spring.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleDescription;

    @OneToMany(mappedBy = "role")
    private List<User> users; // Một Role có thể dành cho nhiều User

    // Getters and setters...
}
