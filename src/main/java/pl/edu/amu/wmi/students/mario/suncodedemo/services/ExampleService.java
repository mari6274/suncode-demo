package pl.edu.amu.wmi.students.mario.suncodedemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.wmi.students.mario.suncodedemo.entities.ExampleEntity;
import pl.edu.amu.wmi.students.mario.suncodedemo.repositories.ExampleEntityRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
public class ExampleService {

    private ExampleEntityRepository repository;

    @Autowired
    public ExampleService(ExampleEntityRepository repository) {
        this.repository = repository;
    }

    public List<ExampleEntity> findColumn1Duplicates() {
        return repository.findColumn1Duplicates();
    }

    public List<ExampleEntity> findColumn2Duplicates() {
        return repository.findColumn2Duplicates();
    }

    public List<ExampleEntity> findColumn3Duplicates() {
        return repository.findColumn3Duplicates();
    }

    public List<ExampleEntity> findColumn4Duplicates() {
        return repository.findColumn4Duplicates();
    }

    public List<ExampleEntity> findColumn1UniqueRows() {
        return repository.findColumn1UniqueRows();
    }

    public List<ExampleEntity> findColumn2UniqueRows() {
        return repository.findColumn2UniqueRows();
    }

    public List<ExampleEntity> findColumn3UniqueRows() {
        return repository.findColumn3UniqueRows();
    }

    public List<ExampleEntity> findColumn4UniqueRows() {
        return repository.findColumn4UniqueRows();
    }

    @Transactional
    public void createNew() {
        Long newId =
                repository.findAll().stream().sorted(Comparator.comparing(ExampleEntity::getId).reversed()).findFirst()
                        .map(ExampleEntity::getId)
                        .map(id -> id + 1)
                        .orElse(1L);
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setId(newId);
        exampleEntity.setColumn1("Xxxx");
        exampleEntity.setColumn2("ccccc");
        exampleEntity.setColumn3("vvvvv");
        exampleEntity.setColumn4(1L);
        repository.save(exampleEntity);
    }

    public void updateLast() {
        repository.findAll().stream().sorted(Comparator.comparing(ExampleEntity::getId).reversed()).findFirst()
                .ifPresent(last -> {
                    last.setColumn4(300L);
                    repository.save(last);
                });
    }
}
