package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LeitorGolsCsv {
    private final String caminhoArquivo;
    private final long id;

    public LeitorGolsCsv(String caminhoArquivo, long id) {
        this.caminhoArquivo = caminhoArquivo;
        this.id = id;
    }

    public List<CSVRecord> lerArquivoCsv() throws IOException {
        try (FileReader leitorArquivo = new FileReader(caminhoArquivo);
             CSVParser parserCsv = CSVFormat.DEFAULT.withHeader().parse(leitorArquivo)) {
            return parserCsv.getRecords();
        }
    }

    public long getId() {
        return id;
    }
}
