import repository.DadosCartoesFutebolRepository;
import repository.DadosEstatisticasFutebolRepository;
import repository.DadosFullFutebolRepository;
import repository.DadosGolsFutebolRepository;
import service.JogadorComMaisCartoesVermelhosService;
import service.PartidaComMaisGolsService;

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

        JogadorComMaisCartoesVermelhosService jogadorComMaisCartoesVermelhosService = new JogadorComMaisCartoesVermelhosService(dadosCartoesFutebolRepository);
        System.out.println("O jogador com mais cartões vermelho é: " + jogadorComMaisCartoesVermelhosService.jogadorComMaisCartoesVermelhos());

       PartidaComMaisGolsService partidaComMaisGolsService = new PartidaComMaisGolsService(dadosFullFutebolRepository);
        System.out.println("A partida com mais gols teve " + partidaComMaisGolsService.partidaComMaisGols() + " gols.");
    }

}
