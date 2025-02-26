package observer;

public class MainTest {

    // 생성자: MainTest 객체가 생성될 때 옵저버 패턴을 통해 이미지 처리 작업을 수행
    public MainTest() {
        // 이미지 파일 목록
        String[] imagefiles = {"cat1.jpg", "cat2.jpg"};

        // Subject 객체 생성
        Subject imageProcessingSubject = new Subject();

        // 다양한 이미지 처리 Observer 객체 생성
        Observer blurObserver = new ImageBlur();
        Observer edgeObserver = new ImageEdgeDetect();
        Observer grayscaleObserver = new ImageGrayscale();
        Observer negativeObserver = new ImageNegative();
        Observer rotateObserver = new ImageRotate();

        // Subject에 Observer를 추가
        imageProcessingSubject.addObserver(blurObserver);
        imageProcessingSubject.addObserver(edgeObserver);
        imageProcessingSubject.addObserver(grayscaleObserver);
        imageProcessingSubject.addObserver(negativeObserver);
        imageProcessingSubject.addObserver(rotateObserver);

        // 각 이미지 파일에 대해 모든 옵저버에게 알림
        for (String filename : imagefiles) {
            imageProcessingSubject.notifyObservers(filename);
        }
    }


}
