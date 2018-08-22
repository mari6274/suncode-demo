package pl.edu.amu.wmi.students.mario.suncodedemo.view.managedbeans;

import org.springframework.web.context.annotation.RequestScope;
import pl.edu.amu.wmi.students.mario.suncodedemo.entities.ExampleEntity;
import pl.edu.amu.wmi.students.mario.suncodedemo.services.ExampleService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.function.Supplier;

@Named
@RequestScope
public class MainPageBean {

    private final Map<String, Supplier<List<ExampleEntity>>> duplicateSuppliers = new LinkedHashMap<>();
    private final Map<String, Supplier<List<ExampleEntity>>> uniqueSuppliers = new LinkedHashMap<>();
    private final List<String> columnNames;
    private String selectedColumn;
    private QueryMode selectedMode = QueryMode.DUPLICATE;
    private List<ExampleEntity> resultRows;
    private QueryMode[] queryModes = QueryMode.values();

    @Inject
    public MainPageBean(ExampleService exampleService) {
        duplicateSuppliers.put("kolumna1", exampleService::findColumn1Duplicates);
        duplicateSuppliers.put("kolumna2", exampleService::findColumn2Duplicates);
        duplicateSuppliers.put("kolumna3", exampleService::findColumn3Duplicates);
        duplicateSuppliers.put("kolumna4", exampleService::findColumn4Duplicates);
        uniqueSuppliers.put("kolumna1", exampleService::findColumn1UniqueRows);
        uniqueSuppliers.put("kolumna2", exampleService::findColumn2UniqueRows);
        uniqueSuppliers.put("kolumna3", exampleService::findColumn3UniqueRows);
        uniqueSuppliers.put("kolumna4", exampleService::findColumn4UniqueRows);
        columnNames = new ArrayList<>(duplicateSuppliers.keySet());
    }

    public String getSelectedColumn() {
        return selectedColumn;
    }

    public void setSelectedColumn(String selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void updateResultRows() {
        switch (selectedMode) {
            case DUPLICATE:
                resultRows = duplicateSuppliers.getOrDefault(selectedColumn, Collections::emptyList).get();
                break;
            case UNIQUE:
                resultRows = uniqueSuppliers.getOrDefault(selectedColumn, Collections::emptyList).get();
                break;
        }
    }

    public List<ExampleEntity> getResultRows() {
        return resultRows;
    }

    public QueryMode getSelectedMode() {
        return selectedMode;
    }

    public void setSelectedMode(QueryMode selectedMode) {
        this.selectedMode = selectedMode;
    }

    public QueryMode[] getQueryModes() {
        return queryModes;
    }
}
