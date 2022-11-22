package kodlama.io.hrms.core.config;

import com.cloudinary.Cloudinary;
import kodlama.io.hrms.core.imageUploaders.CloudinaryService;
import kodlama.io.hrms.core.imageUploaders.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public Cloudinary cloudinaryService() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dlytm7ohp",
                "api_key", "555425962964555",
                "api_secret", "7K_IYz2X3AOG07F20xVWg4ZXhzQ"));
    }

    @Bean
    public ImageService imageService() {
        return new CloudinaryService();
    }
}
