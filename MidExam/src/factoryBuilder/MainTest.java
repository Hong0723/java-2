package factoryBuilder;

public class MainTest {
    
    // 생성자: MainTest 클래스가 생성될 때 실행
    public MainTest() {
        // ImageProcessor 객체 생성 및 여러 이미지 처리기 추가
        ImageProcessor ip = new ImageProcessor.Builder()
                                .add(ImageProcessorFactory.createInstance("ImageGrayscale"))
                                .add(ImageProcessorFactory.createInstance("ImageBlur"))
                                .add(ImageProcessorFactory.createInstance("ImageNegative"))
                                .add(ImageProcessorFactory.createInstance("ImageEdgeDetect"))
                                .add(ImageProcessorFactory.createInstance("ImageRotate", 45.0))
                                .build();

        // 처리할 이미지 파일 목록
        String[] imagefiles = {"cat1.jpg", "cat2.jpg"};

        // 각 이미지 파일에 대해 모든 프로세서를 순차적으로 적용하여 처리
        for (String filename : imagefiles) {
            ip.process(filename);
        }
    }

}
