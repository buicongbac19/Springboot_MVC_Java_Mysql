package spring.example.service;

import spring.example.model.Post;
import spring.example.repository.PostRepository; // Chú ý sửa tên từ PostRepository thành PostsRepository
import spring.example.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postsRepository; // Chỉnh sửa đây

    public List<Post> getAllPosts() {
        return postsRepository.findAll(); // Chỉnh sửa ở đây
    }

    public Post getPostById(Long id) {
        return postsRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    public Post createPost(Post post) {
        return postsRepository.save(post);
    }

    public void deletePost(Long id) {
        postsRepository.deleteById(id);
    }
}
