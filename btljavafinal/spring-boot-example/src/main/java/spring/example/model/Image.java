package spring.example.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;  // Khóa ngoài của User
    private Long postId;  // Khóa ngoài của Post

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;  // Quan hệ với User

    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "id", insertable = false, updatable = false)
    private Post post;  // Quan hệ với Post

    // Các trường khác...
}
