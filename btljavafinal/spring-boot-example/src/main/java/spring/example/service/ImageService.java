package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.example.model.Image;
import spring.example.repository.ImageRepository;
import spring.example.exception.ImageNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    // Lấy tất cả hình ảnh
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    // Lấy hình ảnh theo ID
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    // Tạo mới hình ảnh
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    // Xóa hình ảnh theo ID
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    // Cập nhật hình ảnh (ví dụ nếu có thay đổi)
    public Image updateImage(Long id, Image image) {
        if (imageRepository.existsById(id)) {
            image.setId(id);
            return imageRepository.save(image);
        }
        return null; // Nếu không tồn tại ID, có thể ném lỗi hoặc trả về null.
    }
}
