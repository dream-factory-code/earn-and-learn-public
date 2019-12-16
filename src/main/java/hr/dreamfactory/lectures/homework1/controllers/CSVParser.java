package hr.dreamfactory.lectures.homework1.controllers;

import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import hr.dreamfactory.lectures.homework1.common.Users;
import hr.dreamfactory.lectures.homework1.model.UserModel;

import java.io.File;
import java.util.List;


public class CSVParser {

    private Users repository;
    private String filename;

    public CSVParser(String filename, Users repository) {
        this.repository = repository;
        this.filename = filename;
    }

    public void serialize() {
        List<UserModel> userList = (List<UserModel>) repository.getRandomUsers();
        BeanWriterProcessor<UserModel> beanWriter = new BeanWriterProcessor<UserModel>(UserModel.class);
        beanWriter.initialize();

        CsvWriterSettings settings = new CsvWriterSettings();
        settings.setRowWriterProcessor(beanWriter);
        settings.setHeaders("fullname", "location");
        settings.setQuotationTriggers(',', ' ');
        CsvFormat format = new CsvFormat();
        format.setDelimiter(", ");
        settings.setFormat(format);

        CsvWriter writer = new CsvWriter(new File(filename), settings);
        writer.writeHeaders();
        writer.processRecords(userList);
        writer.close();

    }
}
