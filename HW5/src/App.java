/* HW5
자바프로그래밍2_1분반
2024/10/23
32211792
박재홍 */

import java.util.*;
import java.util.stream.Collectors;

public class App {
    
    public static void main(String[] args) {
    
        // arthropods.csv 파일에서 곤충 데이터를 읽어와 ArthropodClassifier 리스트를 생성
        List<ArthropodClassifier> classifiers = ArthropodImporter.loadCSV("C:/Users/박재홍/source/java24/HW5/src/arthropods.csv");
        
        // ArthropodClassifier 리스트를 통해 ArthropodClassification 인스턴스를 생성
        ArthropodClassification classification = new ArthropodClassification(classifiers);
        
        // ArthropodBuilder를 사용하여 'Beetle'이라는 곤충 객체를 생성
        Arthropod beetle = new Arthropod.ArthropodBuilder()
        .setArthropodname("Beetle")  // 곤충의 이름 설정 (Your Code)
        .setBodyRegions(3)            
        .setPairsOfAntennae(1)    
        .setRespiration(RespirationType.TRACHEAL) 
        .setMetamorphosis(MetamorphosisType.COMPLETE)
        .setPairsOfWing(2)            
        .setNumberOfLegs(6)          
        .setDistinction("hard exoskeleton and elytra(wing covers)")  
        .build();                    
        
        System.out.print(beetle);
        System.out.println(" => Arthropod Type: " + classification.classify(beetle));
        
        // ArthropodFactory를 사용하여 'Crustacea' 객체를 생성
        Arthropod crab = ArthropodFactory.create(ArthropodType.CRUSTACEA);
        System.out.println(crab);
        System.out.println(" => Arthropod Type: " + classification.classify(crab));
        System.out.println();
        System.out.println();
        
        // classifiers 리스트에 있는 ArthropodClassifier의 Arthropod 객체를 Arthropod 리스트로 변환
        List<Arthropod> arthropods = classifiers.stream()
            .map(classifier -> classifier.getArthropod())
            .collect(Collectors.toList());
        
        // arthropods 리스트에 있는 각 곤충 객체를 출력하고, 그들의 ArthropodType을 분류하여 출력
        for (Arthropod arthropod : arthropods) {
            System.out.println(arthropod);
            System.out.println(" => Arthropod Type: " + classification.classify(arthropod));
        }
    }
}
