package service;

import model.DadosCartoesFutebol;
import repository.DadosCartoesFutebolRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JogadorComMaisCartoesVermelhosService {

    private DadosCartoesFutebolRepository dadosCartoesFutebolRepository;

    public JogadorComMaisCartoesVermelhosService(DadosCartoesFutebolRepository dadosCartoesFutebolRepository){
        this.dadosCartoesFutebolRepository = dadosCartoesFutebolRepository;

    }
    public String jogadorComMaisCartoesVermelhos(){
        List<DadosCartoesFutebol>  dadosCartoesFutebolList = dadosCartoesFutebolRepository.listaDadosCartoesFutebol();

        Map<String, Long> atletaCartoes = dadosCartoesFutebolList.stream()
                .filter(dadosCartoesFutebol -> "Vermelho".equals(dadosCartoesFutebol.getCartao()))
                .collect(Collectors.groupingBy(DadosCartoesFutebol::getAtleta, Collectors.counting()));

        return Collections.max(atletaCartoes.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
