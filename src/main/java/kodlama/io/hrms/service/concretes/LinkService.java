package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.LinkRepository;
import kodlama.io.hrms.model.concretes.Link;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    private final LinkRepository repository;
    private final ModelMapper modelMapper;

    public LinkService(LinkRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Result add(CreateResumeDto createResumeDto) {
        Link link = modelMapper.map(createResumeDto, Link.class);
        this.repository.save(link);
        return new SuccessResult("ok");
    }

    public Result addAll(List<Link> link) {
        this.repository.saveAll(link);
        return new SuccessResult("ok");
    }

    public Result delete(Link link) {
        this.repository.delete(link);
        return new SuccessResult("ok");
    }

    public DataResult<List<Link>> findAll() {
        return new SuccessDataResult<List<Link>>(this.repository.findAll(), "ok");
    }

    public DataResult<Link> findById(int id) {
        Link link = this.repository.findById(id);
        if (link == null)
            return new ErrorDataResult<Link>("no");
        return new SuccessDataResult<Link>("ok");
    }

    public DataResult<List<Link>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Link>>(this.repository.findAllByJobSeekerId(id));
    }
}
