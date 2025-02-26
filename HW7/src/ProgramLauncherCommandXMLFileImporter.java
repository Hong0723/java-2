import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException;
import java.util.HashMap; 
import java.util.Map; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import javax.xml.transform.Transformer; 
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


 
public class ProgramLauncherCommandXMLFileImporter implements FileImporter<ProgramLauncherCommand> { 
    // XML 파일을 읽고 Map 데이터를 XML 형식으로 저장하는 클래스

    @Override
    public Map<String, ProgramLauncherCommand> importFile(String filePath) { // XML 파일을 읽어 Map<String, ProgramLauncherCommand>로 변환
        Map<String, ProgramLauncherCommand> commands = new HashMap<>();      // 결과 데이터를 저장할 Map 객체
        try {
            File xmlFile = new File(filePath); // XML 파일 객체 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // DocumentBuilderFactory와 Builder를 통해 XML 문서 파싱 준비
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile); // XML 문서 파싱
            NodeList commandList = document.getElementsByTagName("command"); // "command" 태그를 기준으로 XML 데이터를 추출

            for (int i = 0; i < commandList.getLength(); i++) { // 각 "command" 태그를 반복하면서 데이터 추출
                Element commandElement = (Element) commandList.item(i);

                // 태그 내 데이터 추출
                String name = commandElement.getElementsByTagName("name").item(0).getTextContent();
                String executable = commandElement.getElementsByTagName("executable").item(0).getTextContent();
                String icon = commandElement.getElementsByTagName("icon").item(0).getTextContent();

                // ProgramLauncherCommand 객체 생성 및 Map에 추가
                ProgramLauncherCommand command = new ProgramLauncherCommand(name, executable, icon);
                commands.put(name, command);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        return commands; // 변환된 Map 반환
    }

    @Override
    public void exportFile(String filePath, Map<String, ProgramLauncherCommand> map) { // Map<String, ProgramLauncherCommand> 데이터를 XML 파일로 저장
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // XML 문서를 생성하기 위한 DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();      

            Element root = document.createElement("commands"); // 루트 태그 "commands" 생성
            document.appendChild(root);

            for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) { // Map 데이터를 XML 형식으로 변환
                ProgramLauncherCommand command = entry.getValue();

                Element commandElement = document.createElement("command"); // "command" 태그 생성

                Element name = document.createElement("name"); // "name" 태그 생성
                name.setTextContent(command.getName());

                Element executable = document.createElement("executable"); // "executable" 태그 생성 및 데이터 추가
                executable.setTextContent(command.getExecutable());

                Element icon = document.createElement("icon"); // "icon" 태그 생성 및 데이터 추가
                icon.setTextContent(command.getIcon());

                // "command" 태그에 "name", "executable", "icon" 추가
                commandElement.appendChild(name);
                commandElement.appendChild(executable);
                commandElement.appendChild(icon);
                root.appendChild(commandElement); // 루트 태그에 "command" 추가
            }

            // Transformer 설정: 출력 결과 포매팅 적용
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes"); // 들여쓰기 적용
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // 들여쓰기 공백 설정

            // XML 데이터를 파일로 변환하여 저장
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(filePath));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
