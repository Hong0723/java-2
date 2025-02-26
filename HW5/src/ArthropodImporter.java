import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArthropodImporter {
    
    // CSV 파일을 읽어 List<ArthropodClassifier>로 변환하는 메소드
    public static List<ArthropodClassifier> loadCSV(String filename) {
        // ArthropodClassifier 객체들을 저장할 리스트
        List<ArthropodClassifier> arthropods = new ArrayList<>();
        // ArthropodFactory 객체 생성
        ArthropodFactory arthropodFactory = new ArthropodFactory();
        
        // 파일을 읽기 위해 BufferedReader 사용
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line; 

            // CSV 파일의 각 줄을 읽음 (11개의 줄을 읽음)
            for(int i = 0; i < 11; i++) {
                // 한 줄을 읽어옴
                line = br.readLine();
                
                // 쉼표(,)를 기준으로 문자열을 나누어 배열로 변환
                String[] values = line.split(",");
                
                // ArthropodType 열거형 값을 CSV에서 읽은 첫 번째 값으로 설정
                ArthropodType type = ArthropodType.valueOf(values[0].toUpperCase());

                // 임시 Arthropod 객체 생성
                Arthropod tmpArthropod;

                // ArthropodFactory를 사용하여 Arthropod 객체 생성
                tmpArthropod = arthropodFactory.create(type);

                // 생성된 Arthropod 객체를 ArthropodClassifier로 감싸서 리스트에 추가
                arthropods.add(new ArthropodClassifier(type, tmpArthropod));
            }
        } catch (IOException e) {
            // 파일 읽기 중 발생한 예외 처리
            e.printStackTrace();
        }
        
        // ArthropodClassifier 리스트 반환
        return arthropods;
    }
}
    