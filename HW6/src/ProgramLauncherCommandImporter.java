import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProgramLauncherCommandImporter {

     // JSON 파일에서 명령어 목록을 읽어들여, 각 명령어를 ProgramLauncherCommand 객체로 생성하여 맵에 저장합니다.

    public static Map<String, ProgramLauncherCommand> loadCommandsFromJson(String filename) {
        Map<String, ProgramLauncherCommand> commandsMap = new HashMap<>();
        try {
            JSONParser parser = new JSONParser(); // JSON 파서를 생성
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(filename)); // 파일을 읽고 JSON 객체로 변환

            // JSON 객체에서 "commands" 배열을 가져옴
            JSONArray commandsArray = (JSONArray) jsonObject.get("commands");

            // 배열에 있는 각 명령어 정보를 반복하여 처리
            for (Object obj : commandsArray) {
                JSONObject commandData = (JSONObject) obj; // 각 명령어 정보를 JSON 객체로 변환
                String name = (String) commandData.get("name"); // 명령어 이름을 가져옴
                String executable = (String) commandData.get("executable"); // 실행 파일 경로를 가져옴
                String icon = (String) commandData.get("icon"); // 아이콘 경로를 가져옴

                // ProgramLauncherCommand 객체 생성 (name, executable, icon 필드 사용)
                ProgramLauncherCommand command = new ProgramLauncherCommand(executable, icon, name);
                commandsMap.put(name, command); // 명령어 이름을 키로, 객체를 값으로 맵에 저장
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(); // 파일 읽기 또는 파싱 오류 발생 시 스택 트레이스 출력
        }
        return commandsMap; // 생성된 명령어 맵 반환
    }
}
