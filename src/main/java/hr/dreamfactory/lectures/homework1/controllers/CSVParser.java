package hr.dreamfactory.lectures.homework1.controllers;

import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import hr.dreamfactory.lectures.homework1.common.UserGenerator;
import hr.dreamfactory.lectures.homework1.model.User;

import java.io.File;
import java.util.List;


public class CSVParser {

    private UserGenerator repository;
    private String filename;

    public CSVParser(String filename, UserGenerator repository) {
        this.repository = repository;
        this.filename = filename;
    }

    public void serialize() {
        List<User> userList = repository.generate();
        BeanWriterProcessor<User> beanWriter = new BeanWriterProcessor<>(User.class);
        beanWriter.initialize();

        CsvWriterSettings settings = new CsvWriterSettings();
        settings.setRowWriterProcessor(beanWriter);

        CsvWriter writer = new CsvWriter(new File(filename), settings);
        writer.processRecords(userList);
        writer.close();
    }
}
