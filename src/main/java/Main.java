import repository.DadosCartoesFutebolRepository;
import repository.DadosEstatisticasFutebolRepository;
import repository.DadosFullFutebolRepository;
import repository.DadosGolsFutebolRepository;

public class Main {

    public static void main(String[] args) {
        DadosEstatisticasFutebolRepository dadosEstatisticasFutebolRepository = new DadosEstatisticasFutebolRepository();
        DadosCartoesFutebolRepository dadosCartoesFutebolRepository = new DadosCartoesFutebolRepository();
        DadosFullFutebolRepository dadosFullFutebolRepository = new DadosFullFutebolRepository();
        DadosGolsFutebolRepository dadosGolsFutebolRepository = new DadosGolsFutebolRepository();

        // Inicia a leitura e conversão dos CSVs
        dadosEstatisticasFutebolRepository.lerDadosEstatisticaFutebolCSV();
        dadosCartoesFutebolRepository.lerDadosCartoesFutebol();
        dadosFullFutebolRepository.lerDadosFullFutebolCSV();
        dadosGolsFutebolRepository.lerDadosCartoesFutebolCSV();

        // Executar as curiosidades aqui
    }

}
