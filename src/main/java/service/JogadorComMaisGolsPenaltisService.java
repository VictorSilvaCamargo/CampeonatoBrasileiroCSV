package service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.DadosGolsFutebol;
import repository.DadosGolsFutebolRepository;

public class JogadorComMaisGolsPenaltisService {

    private static DadosGolsFutebolRepository dadosGolsFutebolRepository;

    public JogadorComMaisGolsPenaltisService(DadosGolsFutebolRepository dadosGols) {
        dadosGolsFutebolRepository = dadosGols;
    }

    public Map<String, Long> execute() {
        List<DadosGolsFutebol> dados = dadosGolsFutebolRepository.listaDadosGolsFutebol();

        Map<String, Long> jogadorMaisGols = dados.stream().filter(linha -> "Penalty".equals(linha.getTipoDeGol()))
                .collect(Collectors.groupingBy(line -> line.getAtleta(), Collectors.counting()));

        Map<String, Long> result = Map.of(
                Collections.max(jogadorMaisGols.entrySet(), Map.Entry.comparingByValue()).getKey(),
                Collections.max(jogadorMaisGols.entrySet(), Map.Entry.comparingByValue()).getValue());

        return result;
}
