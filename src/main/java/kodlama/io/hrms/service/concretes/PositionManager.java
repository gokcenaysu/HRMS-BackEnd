package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.PositionService;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.PositionRepository;
import kodlama.io.hrms.model.concretes.Position;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class PositionManager implements PositionService {

    private final PositionRepository positionRepository;

    public PositionManager(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public DataResult<List<Position>> findAll() {
        return new SuccessDataResult<List<Position>>(this.positionRepository.findAll());
    }

    @Override
    public DataResult<List<Position>> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Position>>(this.positionRepository.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Position>> findAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "positionName");
        return new SuccessDataResult<List<Position>>(this.positionRepository.findAll(sort),messages.listed);
    }

    @Override
    public DataResult<Position> findById(int id) {
        Position position=this.positionRepository.findById(id);
        if(position==null)
            return new ErrorDataResult<Position>(messages.noData);
        return new SuccessDataResult<Position>(position,messages.listed);
    }

    @Override
    public Result add(Position position) {
        if(position.getName().length()<2){
            return new ErrorResult(messages.letterLength);
        }
        if(positionRepository.existsByName(position.getName())){
            return new ErrorResult(messages.existsPosition);
        }
        this.positionRepository.save(position);
        return new SuccessResult(messages.added);
    }

    @Override
    public Result delete(Position position) {
        this.positionRepository.delete(position);
        return new SuccessResult(messages.deleted);
    }

    @Override
    public DataResult<List<Position>> findByPositionContains(String name) {
        return new SuccessDataResult<List<Position>>(this.positionRepository.findByNameContains(name),messages.listed);
    }
}
