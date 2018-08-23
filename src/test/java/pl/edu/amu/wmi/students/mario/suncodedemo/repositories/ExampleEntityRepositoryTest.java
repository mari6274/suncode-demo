package pl.edu.amu.wmi.students.mario.suncodedemo.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.amu.wmi.students.mario.suncodedemo.entities.ExampleEntity;

import java.util.List;
import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:example-entity-repository-test.yaml")
@DataJpaTest
public class ExampleEntityRepositoryTest {

    @Autowired
    private ExampleEntityRepository exampleEntityRepository;

    @Test
    public void shouldFetchColumn1Duplicates() {
        checkRows(new Long[]{4L, 5L, 6L, 7L, 9L}, exampleEntityRepository::findColumn1Duplicates);
    }

    @Test
    public void shouldFetchColumn2Duplicates() {
        checkRows(new Long[]{2L, 3L}, exampleEntityRepository::findColumn2Duplicates);
    }

    @Test
    public void shouldFetchColumn3Duplicates() {
        checkRows(new Long[]{4L, 6L, 8L, 9L}, exampleEntityRepository::findColumn3Duplicates);
    }

    @Test
    public void shouldFetchColumn4Duplicates() {
        checkRows(new Long[]{4L, 5L, 8L}, exampleEntityRepository::findColumn4Duplicates);
    }

    @Test
    public void shouldFetchColumn1UniqueRows() {
        checkRows(new Long[]{1L, 2L, 3L, 8L, 10L}, exampleEntityRepository::findColumn1UniqueRows);
    }

    @Test
    public void shouldFetchColumn2UniqueRows() {
        checkRows(new Long[]{1L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}, exampleEntityRepository::findColumn2UniqueRows);
    }

    @Test
    public void shouldFetchColumn3UniqueRows() {
        checkRows(new Long[]{1L, 2L, 3L, 5L, 7L, 10L}, exampleEntityRepository::findColumn3UniqueRows);
    }

    @Test
    public void shouldFetchColumn4UniqueRows() {
        checkRows(new Long[]{1L, 2L, 3L, 6L, 7L, 9L, 10L}, exampleEntityRepository::findColumn4UniqueRows);
    }

    private void checkRows(Long[] resultIds, Supplier<List<ExampleEntity>> fetchMethod) {
        Long[] result = fetchMethod.get().stream().map(ExampleEntity::getId).toArray(Long[]::new);
        Assert.assertArrayEquals(resultIds, result);
    }

}