package service;

import model.DadosFullFutebol;
import repository.DadosFullFutebolRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartidaComMaisGolsService {

    private DadosFullFutebolRepository dadosFullFutebolRepository;

    public PartidaComMaisGolsService(DadosFullFutebolRepository dadosFullFutebolRepository){
        this.dadosFullFutebolRepository = dadosFullFutebolRepository;

    }
    public String partidaComMaisGols(){
        List<DadosFullFutebol>  dadosFullFutebollList = dadosFullFutebolRepository.listaDadosFullFutebol();

        Map<DadosFullFutebol, Integer> partidaResultadosTotais = dadosFullFutebollList.stream()
                .collect(Collectors.toMap(
                        (DadosFullFutebol partida) -> partida,
                        (DadosFullFutebol partida) -> partida.getMandantePlacar() + partida.getVisitantePlacar()));


        DadosFullFutebol partidaComMaisGols = Collections.max(partidaResultadosTotais.entrySet(), Map.Entry.comparingByValue()).getKey();
int highestTotalScore = partidaComMaisGols.getMandantePlacar() + partidaComMaisGols.getVisitantePlacar();
return String.valueOf(highestTotalScore);
    }
}
