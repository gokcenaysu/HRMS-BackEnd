package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.LinkService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.LinkRepository;
import kodlama.io.hrms.model.concretes.Link;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkManager implements LinkService {

    @Autowired
    private LinkRepository linkRepository;
    private ModelMapper modelMapper;

    public LinkManager(LinkRepository linkRepository, ModelMapper modelMapper) {
        this.linkRepository = linkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(CreateResumeDto createResumeDto) {
        Link link = modelMapper.map(createResumeDto, Link.class);
        this.linkRepository.save(link);
        return new SuccessResult("ok");
    }

        @Override
    public Result addAll(List<Link> link) {
        this.linkRepository.saveAll(link);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(Link link) {
        this.linkRepository.delete(link);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<Link>> findAll() {
        return new SuccessDataResult<List<Link>>(this.linkRepository.findAll(),"ok");
    }

    @Override
    public DataResult<Link> findById(int id) {
        Link link = this.linkRepository.findById(id);
        if(link==null)
            return new ErrorDataResult<Link>("no");
        return new SuccessDataResult<Link>("ok");
    }

    @Override
    public DataResult<List<Link>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Link>>(this.linkRepository.findAllByJobSeekerId(id));
    }
}
