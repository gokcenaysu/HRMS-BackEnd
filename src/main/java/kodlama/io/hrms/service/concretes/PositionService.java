package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.PositionRepository;
import kodlama.io.hrms.model.concretes.Position;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository repository;

    public PositionService(PositionRepository repository) {
        this.repository = repository;
    }

    public DataResult<List<Position>> findAll() {
        return new SuccessDataResult<List<Position>>(this.repository.findAll());
    }

    public DataResult<List<Position>> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Position>>(this.repository.findAll(pageable).getContent());
    }

    public DataResult<List<Position>> findAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "positionName");
        return new SuccessDataResult<List<Position>>(this.repository.findAll(sort), Messages.listed);
    }

    public DataResult<Position> findById(int id) {
        Position position = this.repository.findById(id);
        if (position == null)
            return new ErrorDataResult<Position>(Messages.noData);
        return new SuccessDataResult<Position>(position, Messages.listed);
    }

    public Result add(Position position) {
        if (position.getName().length() < 2) {
            return new ErrorResult(Messages.letterLength);
        }
        if (repository.existsByName(position.getName())) {
            return new ErrorResult(Messages.existsPosition);
        }
        this.repository.save(position);
        return new SuccessResult(Messages.added);
    }

    public Result delete(Position position) {
        this.repository.delete(position);
        return new SuccessResult(Messages.deleted);
    }

    public DataResult<List<Position>> findByPositionContains(String name) {
        return new SuccessDataResult<List<Position>>(this.repository.findByNameContains(name), Messages.listed);
    }
}
