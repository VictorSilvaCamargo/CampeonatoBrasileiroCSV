import model.DadosFullFutebol;
import repository.DadosCartoesFutebolRepository;
import repository.DadosEstatisticasFutebolRepository;
import repository.DadosFullFutebolRepository;
import repository.DadosGolsFutebolRepository;

import service.JogadorComMaisCartoesVermelhosService;
import service.PartidaComMaisGolsService;

import service.EstadoMenosJogos;
import service.VencedorJogos2008;

import java.util.List;


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

        DadosFullFutebolRepository repository = new DadosFullFutebolRepository();

        repository.lerDadosFullFutebolCSV();

        List<DadosFullFutebol> partidas = repository.listaDadosFullFutebol();

        VencedorJogos2008.encontrarTimeComMaisVitoriasNoAno2008EImprimir(partidas);

        // Encontre o estado com menos jogos no período de 2003 a 2022
        EstadoMenosJogos.encontrarEstadoComMenosJogosNoPeriodoEImprimir(partidas);


    }

}
