package pl.edu.amu.wmi.students.mario.suncodedemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.amu.wmi.students.mario.suncodedemo.entities.ExampleEntity;
import pl.edu.amu.wmi.students.mario.suncodedemo.repositories.ExampleEntityRepository;

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
}
