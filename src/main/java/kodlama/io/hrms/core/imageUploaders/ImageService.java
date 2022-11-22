package kodlama.io.hrms.core.imageUploaders;

import kodlama.io.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageService {

    DataResult<?> save(MultipartFile file);

    DataResult<Map> upload(MultipartFile multipartFile) throws IOException;

    DataResult<Map> delete(String id) throws IOException;
}
