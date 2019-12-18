package hr.dreamfactory.lectures.homework1.controllers;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import hr.dreamfactory.lectures.homework1.common.UserGenerator;
import hr.dreamfactory.lectures.homework1.model.User;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    private UserGenerator repository;
    private String filename;

    public CSVParser(String filename, UserGenerator repository) {
        this.repository = repository;
        this.filename = filename;
    }

    public void generateUsersAndSave(int batches) {
        List<User> allUsers = new ArrayList<>();

        for (int i = 0; i < batches; i++){
            allUsers.addAll(repository.generate());
        }

        writeUsersToCSV(allUsers);
    }

    public void writeUsersToCSV(List<User> userList) {
        BeanWriterProcessor<User> beanWriter = new BeanWriterProcessor<>(User.class);
        beanWriter.initialize();

        CsvWriterSettings settings = new CsvWriterSettings();
        settings.getFormat().setDelimiter("|");
        settings.setRowWriterProcessor(beanWriter);

        CsvWriter writer = new CsvWriter(new File(filename), settings);
        writer.writeHeaders();
        writer.processRecords(userList);
        writer.close();
    }
    public List<User> parse(){
        return parse(filename);
    }

    public List<User> parse(String filename){
        BeanListProcessor<User> processor = new BeanListProcessor<>(User.class);

        CsvParserSettings settings = new CsvParserSettings();
        settings.detectFormatAutomatically(',', '|');
        settings.setProcessor(processor);

        CsvParser parser = new CsvParser(settings);
        parser.parse(Paths.get(filename).toFile());

        return processor.getBeans();
    }
}
