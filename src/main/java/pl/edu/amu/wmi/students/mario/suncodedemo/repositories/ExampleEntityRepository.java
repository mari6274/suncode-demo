package pl.edu.amu.wmi.students.mario.suncodedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.amu.wmi.students.mario.suncodedemo.entities.ExampleEntity;

import java.util.List;

@Repository
public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long> {

    @Query("select e from ExampleEntity e where e.column1 in (select en.column1 from ExampleEntity en group by en.column1 having count(en.column1) > 1)")
    List<ExampleEntity> findColumn1Duplicates();

    @Query("select e from ExampleEntity e where e.column2 in (select en.column2 from ExampleEntity en group by en.column2 having count(en.column2) > 1)")
    List<ExampleEntity> findColumn2Duplicates();

    @Query("select e from ExampleEntity e where e.column3 in (select en.column3 from ExampleEntity en group by en.column3 having count(en.column3) > 1)")
    List<ExampleEntity> findColumn3Duplicates();

    @Query("select e from ExampleEntity e where e.column4 in (select en.column4 from ExampleEntity en group by en.column4 having count(en.column4) > 1)")
    List<ExampleEntity> findColumn4Duplicates();

    @Query("select e from ExampleEntity e where e.column1 in (select en.column1 from ExampleEntity en group by en.column1 having count(en.column1) = 1)")
    List<ExampleEntity> findColumn1UniqueRows();

    @Query("select e from ExampleEntity e where e.column2 in (select en.column2 from ExampleEntity en group by en.column2 having count(en.column2) = 1)")
    List<ExampleEntity> findColumn2UniqueRows();

    @Query("select e from ExampleEntity e where e.column3 in (select en.column3 from ExampleEntity en group by en.column3 having count(en.column3) = 1)")
    List<ExampleEntity> findColumn3UniqueRows();

    @Query("select e from ExampleEntity e where e.column4 in (select en.column4 from ExampleEntity en group by en.column4 having count(en.column4) = 1)")
    List<ExampleEntity> findColumn4UniqueRows();

}
