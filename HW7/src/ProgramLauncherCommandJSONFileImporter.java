import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ProgramLauncherCommandJSONFileImporter implements FileImporter<ProgramLauncherCommand> { // json 파일 로드하고 파일로 생성하는 클래스
    private Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Gson 사용해서 파싱과정 간소화 

    @Override
    public Map<String, ProgramLauncherCommand> importFile(String filepath) {  // JSON 파일 읽어서 맵 객체로 반환
        try (FileReader reader = new FileReader(filepath)) {
            Type type = new TypeToken<Map<String, ProgramLauncherCommand>>() {}.getType();  // 제네릭 사용으로 인해 런타임에 객체의 타입을 알 수 없음
            return gson.fromJson(reader, type);  // 타입 토큰을 사용해서 명시한 제네릭 타입을 사용해서 맵 객체로 반환
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void exportFile(String filePath, Map<String, ProgramLauncherCommand> map) {    // 맵 객체를 JSON 파일로 저장
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(map, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}