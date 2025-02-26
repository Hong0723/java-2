import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProgramLauncherCommandCSVFileLoader implements FileLoader<ProgramLauncherCommand> {   // CSV파일 읽고, 저장하는 클래스
  
    @Override
    public Map<String, ProgramLauncherCommand> load(String filepath) {  // 파일 읽어서 맵 객체로 반환
        Map<String, ProgramLauncherCommand> commands = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {   // 각 줄을 읽어와서 객체로 변환
                String[] data = line.split(",");  // 각 줄을 콤마 단위로 파싱해서 맵으로 저장
                if (data.length == 3) {
                    String name = data[0];
                    String executable = data[1];
                    String icon = data[2];

                    ProgramLauncherCommand command = new ProgramLauncherCommand(name, executable, icon);    // ProgramLauncherCommand 객체 생성 후 Map에 추가
                    commands.put(name, command);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return commands;
    }

    @Override
    public void save(String filepath, Map<String, ProgramLauncherCommand> map) {  // 맵 객체를 포매팅해서 파일로 저장
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {  // Map의 데이터를 CSV 형식으로 저장
            for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
                ProgramLauncherCommand command = entry.getValue();
                String line = String.format("%s,%s,%s", command.getName(), command.getExecutable(), command.getIcon());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}