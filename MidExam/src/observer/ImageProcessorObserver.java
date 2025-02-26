package observer;

// ImageProcessorObserver 클래스: 옵저버 패턴에서 메시지를 받아 처리하는 옵저버 클래스
public class ImageProcessorObserver implements Observer {
    private String name; // 옵저버 이름

    // 생성자: 옵저버 이름을 받아 초기화
    public ImageProcessorObserver(String name) {
        this.name = name;
    }

    // update 메서드: 메시지를 받아 처리
    @Override
    public void update(String message) {
        // 업데이트된 메시지 출력
        System.out.println(name + " received update: " + message);
        // 추가적인 처리 로직 작성 가능
    }

    // 옵저버의 이름 반환
    @Override
    public String toString() {
        return "Observer: " + name;
    }
}
