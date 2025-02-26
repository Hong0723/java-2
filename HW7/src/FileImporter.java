import java.util.Map;

public interface FileImporter<T> {
    Map<String, T> importFile(String filepath); // 파일 입력받아서 맵으로 저장
    void exportFile(String filepath, Map<String, T> map);  // 맵 객체를 파일로 저장
   
}
