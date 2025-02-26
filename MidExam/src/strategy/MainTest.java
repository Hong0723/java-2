package strategy;

// MainTest 클래스: 여러 이미지 처리 전략을 순차적으로 적용하는 테스트 클래스
public class MainTest {

    // 생성자: MainTest 객체가 생성될 때 각 전략을 사용하여 이미지 처리 수행
    public MainTest() {
        // 처리할 이미지 파일 배열
        String[] imagefiles = {"cat1.jpg", "cat2.jpg"};

        // 각 이미지 처리 전략 인스턴스 생성
        ImageProcessingStrategy strategy1 = new ImageGrayscale();
        ImageProcessingStrategy strategy2 = new ImageBlur();
        ImageProcessingStrategy strategy3 = new ImageNegative();
        ImageProcessingStrategy strategy4 = new ImageEdgeDetect();
        ImageProcessingStrategy strategy5 = new ImageRotate();

        // 각 파일에 대해 모든 전략을 적용하여 처리
        for (String filename : imagefiles) {
            strategy1.processImage(filename); // 그레이스케일 처리
            strategy2.processImage(filename); // 블러 처리
            strategy3.processImage(filename); // 네거티브 처리
            strategy4.processImage(filename); // 에지 검출 처리
            strategy5.processImage(filename); // 이미지 회전 처리
        }
    }

}
