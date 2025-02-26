/* HW7
자바프로그래밍2_1분반
2024/11/20
32211792
박재홍 */

import java.util.Map;

public class MainTest {
    public static void main(String[] args) throws Exception {
        FileImporter<ProgramLauncherCommand> importer = new ProgramLauncherCommandJSONFileImporter();
        Map<String, ProgramLauncherCommand> map = importer.importFile("commands.json");    // commands.json의 내용을 파싱해서 객체로 저장

        for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getExecutable() + " " + entry.getValue().getIcon());
        }
        importer.exportFile("commands2.json", map);     // 저장된 객체를 파일로 저장
           
        System.out.println("\n\nJSONFileImporter use adapter to load"); // json 파일 로드하기위해 어댑터 사용
        FileLoader<ProgramLauncherCommand> loader = new FileImporterLoaderAdapter<ProgramLauncherCommand>(importer);   // 앞서 생성된 json파일 임포터 객체를 전달
      
        map = loader.load("commands.json");  // commands.json 파일을 로더가 받아서 임포터 객체로 전달
       
       
        for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {  // 임포터 객체의 importFile에서 파싱 진행
            System.out.println(entry.getKey() + " " + entry.getValue().getExecutable() + " " + entry.getValue().getIcon());
        }

        loader = new FileImporterLoaderAdapter<ProgramLauncherCommand>(new ProgramLauncherCommandXMLFileImporter());  // xml 파일 저장하기위해 어댑터 사용
        loader.save("commands2.xml", map);  // 파싱된 내용을 xml 파일로 저장
        
        // (Your Code)
        loader = new FileImporterLoaderAdapter<ProgramLauncherCommand>(new ProgramLauncherCommandYAMLFileImporter());  // YAML 파일 저장하기위해 어댑터 사용
        loader.save("commands2.yaml", map);    // 파싱된 내용을 YAML 파일로 저장
     
        importer = new FileLoaderImporterAdapter<ProgramLauncherCommand>(new ProgramLauncherCommandCSVFileLoader()); // CSV 파일 export하기 위해 어댑터 사용
        importer.exportFile("commands2.csv", map); // 파싱된 내용을 CSV 파일로 저장
    
    }
}
