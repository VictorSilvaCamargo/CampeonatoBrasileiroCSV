package service;

import org.apache.commons.csv.CSVRecord;
import utils.LeitorCartoesCsv;
import utils.LeitorCompletoCsv;
import utils.LeitorEstatisticasCsv;
import utils.LeitorGolsCsv;

import java.io.IOException;
import java.util.List;

public class MainLeituraCsv {

    public static void main(String[] args) {

        String caminhoArquivoGols = "src/main/resources/campeonato-brasileiro-gols.csv";
        String caminhoArquivoCartoes = "src/main/resources/campeonato-brasileiro-cartoes.csv";
        String caminhoArquivoEstatisticas = "src/main/resources/campeonato-brasileiro-estatisticas-full.csv";
        String caminhoArquivoCompleto = "src/main/resources/campeonato-brasileiro-full.csv";



        LeitorGolsCsv leitorGols = new LeitorGolsCsv(caminhoArquivoGols, 1);
        LeitorCartoesCsv leitorCartoes = new LeitorCartoesCsv(caminhoArquivoCartoes, 2);
        LeitorEstatisticasCsv leitorEstatisticas = new LeitorEstatisticasCsv(caminhoArquivoEstatisticas, 3);
        LeitorCompletoCsv leitorCompleto = new LeitorCompletoCsv(caminhoArquivoCompleto, 4);

        try {
            List<CSVRecord> registrosGols = leitorGols.lerArquivoCsv();
            List<CSVRecord> registrosCartoes = leitorCartoes.lerArquivoCsv();
            List<CSVRecord> registrosEstatisticas = leitorEstatisticas.lerArquivoCsv();
            List<CSVRecord> registrosCompleto = leitorCompleto.lerArquivoCsv();


            for (CSVRecord registro : registrosGols) {
                System.out.println(registro);
            }

            for (CSVRecord registro : registrosCartoes) {
                System.out.println(registro);
            }

            for (CSVRecord registro : registrosEstatisticas) {
                System.out.println(registro);
            }

            for (CSVRecord registro : registrosCompleto) {
                System.out.println(registro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
