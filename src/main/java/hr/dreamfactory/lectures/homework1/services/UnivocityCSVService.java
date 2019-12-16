package hr.dreamfactory.lectures.homework1.services;

import com.univocity.parsers.common.AbstractWriter;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import hr.dreamfactory.lectures.homework1.model.UserModel;
import hr.dreamfactory.lectures.homework1.model.common.User;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UnivocityCSVService {
    public void writeToCSV(String path, List<? extends User> users){
        Path filePath = Paths.get(path);
        File file = filePath.toFile();

        BeanWriterProcessor<UserModel> processor = new BeanWriterProcessor<>(UserModel.class);
        processor.initialize();

        CsvWriterSettings settings = new CsvWriterSettings();
        settings.setRowWriterProcessor(processor);
        settings.setQuotationTriggers(' ');
        settings.getFormat().setDelimiter(", ");


        CsvWriter writer = new CsvWriter(file, settings);
        writer.writeHeaders("fullname", " location");
        writer.processRecords(users);
        writer.close();
    }
}
