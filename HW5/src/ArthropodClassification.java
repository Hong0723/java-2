import java.util.List;

public class ArthropodClassification {
    private List<ArthropodClassifier> classifiers;  // ArthropodClassifier 리스트를 저장하는 필드

    // 생성자: ArthropodClassifier 리스트를 받아와 초기화
    public ArthropodClassification(List<ArthropodClassifier> classifiers) {
        this.classifiers = classifiers;  // 받은 리스트를 클래스의 필드에 할당
    }

 
    public ArthropodType classify(Arthropod arthropod) {
         for (ArthropodClassifier classifier : classifiers) { // Arthropod 객체 자체를 매칭
            if (classifier.matches(arthropod)) {  // 객체 매칭이 성공하면 ArthropodType 반환
                return classifier.getArthropodType();
            } else { // Arthropod 객체의 필드를 하나씩 매칭
            if (classifier.matches(arthropod.getArthropodname(), arthropod.getBodyRegions(), 
                        arthropod.getPairsOfAntennae(), arthropod.getRespiration(), 
                        arthropod.getMetamorphosis(), arthropod.getPairsOfWing(),
                        arthropod.getNumberOfLegs(), arthropod.getDistinction())) {
                    return classifier.getArthropodType();  // 필드 매칭 성공 시 ArthropodType 반환
                }
            }
        }
        // 일치하는 분류기가 없을 때 UNKNOWN 타입 반환
        return ArthropodType.UNKNOWN;
    }
}
