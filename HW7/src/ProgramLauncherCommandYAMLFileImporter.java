// (Your Code)
import org.yaml.snakeyaml.DumperOptions; 
import org.yaml.snakeyaml.Yaml; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.util.HashMap;
import java.util.Map;   

public class ProgramLauncherCommandYAMLFileImporter implements FileImporter<ProgramLauncherCommand> { // Map 데이터를 YAML 파일로 저장하는 클래스
    private final Yaml yaml;
    
    public ProgramLauncherCommandYAMLFileImporter() { // DumperOptions를 사용하여 YAML의 출력 형식을 설정하고, Yaml 객체를 초기화함
        DumperOptions options = new DumperOptions(); // YAML 출력 옵션 생성
        options.setPrettyFlow(true); // 사람이 읽기 쉬운 형식으로 설정
        yaml = new Yaml(options); // 지정한 옵션을 사용하여 Yaml 객체 생성
    }
     
    @Override
    public Map<String, ProgramLauncherCommand> importFile(String filepath) { // YAML 파일을 읽어 Map<String, ProgramLauncherCommand>로 변환
        try (FileReader reader = new FileReader(filepath)) { // 파일 내용을 YAML로 파싱하여 Map으로 반환
            return yaml.load(reader);
        } catch (Exception e) {
            e.printStackTrace(); // 오류 발생 시 스택 트레이스 출력
        }
        return new HashMap<>(); // 오류 발생 시 빈 Map 반환
    }


    
    @Override
    public void exportFile(String filepath, Map<String, ProgramLauncherCommand> map) { // Map<String, ProgramLauncherCommand> 데이터를 YAML 파일로 저장
        try (FileWriter writer = new FileWriter(filepath)) {  // Map 데이터를 YAML 형식으로 변환하여 파일에 작성
            yaml.dump(map, writer);
        } catch (Exception e) {
            e.printStackTrace(); // 오류 발생 시 스택 트레이스 출력
        }
    }
}
