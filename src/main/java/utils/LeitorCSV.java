/**
 * Esta classe fornece funcionalidade para ler dados de um arquivo CSV.
 */
package utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LeitorCSV {

    private String filePath;

    public LeitorCSV(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> lerCSV() throws IOException {
        Path path = Path.of("src/main/resources/" + filePath);

        // Converte o caminho do arquivo para um objeto Path
        List<String> lines = Files.readAllLines(path);

        // Remove a primeira linha (cabeçalho) dos arquivos
        lines.remove(0);

        // Converte as linhas em arrays de strings, removendo também aspas duplas
        return lines.stream()
                .map(line -> line.replaceAll("\"", "").split(","))
                .toList();
    }

}
