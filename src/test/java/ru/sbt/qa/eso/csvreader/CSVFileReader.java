package ru.sbt.qa.eso.csvreader;

import java.io.File;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;

/**
 *
 * @author sbt-murashov-vv
 */

public class CSVFileReader {
    
    private String filepath;        
    private CSVReader csvreader;        
    private List<String[]> dataPool;  
    
    public CSVFileReader(String fileName) throws IOException {
        setFilepath(".\\src\\test\\resources\\csvData\\"+fileName+".csv");
        setDataPool();
    }
    
    public final void setDataPool() throws IOException {
        
        try {
            csvreader = new CSVReader(new FileReader(new File(getFilepath())), ';');
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка при обращении к файлу с тестовыми данными \n" + ex.getLocalizedMessage());
        }
        
        dataPool = csvreader.readAll();
        dataPool.remove(0);
        csvreader.close();        
    }    
    public List<String[]> getDataPool() {
        return dataPool;
    }

    public final void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    public String getFilepath() {
        return filepath;
    }
}
