package kodlama.io.hrms.core.imageUploaders;

import com.cloudinary.Cloudinary;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService implements ImageService {

    private final Cloudinary cloudinary;
    private final Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryService() {
        valuesMap.put("cloud_name", "dlytm7ohp");
        valuesMap.put("api_key", "555425962964555");
        valuesMap.put("api_secret", "7K_IYz2X3AOG07F20xVWg4ZXhzQ");
        cloudinary = new Cloudinary(valuesMap);
    }

    @Override
    public DataResult<?> save(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }

    @Override
    public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {

        Map<String, Object> options = new HashMap<>();
        var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
        options.put("allowed_formats", allowedFormats);
        File file = convert(multipartFile);
        Map result = null;
        try {
            result = cloudinary.uploader().upload(file, options);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
        file.delete();
        return new SuccessDataResult<>(result);

    }

    @Override
    public DataResult<Map> delete(String id) throws IOException {

        Map<String, Boolean> options = new HashMap<>();
        options.put("invalidate", true);
        Map result = cloudinary.uploader().destroy(id, options);
        return new SuccessDataResult<>(result);
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
}
