package template;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
// csv파일 읽고 데이터를 리스트로 반환
public class FileImporter<T> {
    private ParserStrategy<T> strategy;

    public FileImporter(ParserStrategy<T> strategy) {
        this.strategy = strategy;
    }
    // csv파일을 읽고, 파싱 후, 리스트로 반환
    public List<T> loadCSV(String fileName) {
        List<T> List = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
        while ((line = br.readLine()) != null) {
            T parsedObject = strategy.parse(line);
            List.add(parsedObject);
        }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
}
