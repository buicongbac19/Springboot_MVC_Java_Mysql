package spring.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; // Một Post chỉ thuộc về một User

    private String postContent;

    private LocalDateTime createdAt = LocalDateTime.now(); // Thời gian tạo Post
    private LocalDateTime updatedAt = LocalDateTime.now(); // Thời gian cập nhật Post

    @OneToMany(mappedBy = "post")
    private List<Image> images; // Một Post có thể có nhiều Image

    // Getters and setters...
}
