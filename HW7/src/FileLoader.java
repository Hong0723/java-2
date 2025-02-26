import java.util.Map;

public interface FileLoader<T> {
    Map<String, T> load(String filepath); // 파일 입력받아서 맵으로 저장 
    void save(String filepath, Map<String, T> map);  // 맵 객체를 파일로 저장
}
