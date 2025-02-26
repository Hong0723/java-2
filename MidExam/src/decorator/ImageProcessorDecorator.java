package decorator;

import java.awt.image.BufferedImage;

// ImageProcessorDecorator 추상 클래스: 데코레이터 패턴을 위한 추상 클래스
// ImageProcessor 클래스를 상속받고, 추가적인 기능을 구현하기 위해 사용
public abstract class ImageProcessorDecorator extends ImageProcessor {
    protected ImageProcessor imageProcessor; // 데코레이터가 감싸고 있는 ImageProcessor 인스턴스

    // 생성자: 데코레이터가 감쌀 ImageProcessor 객체를 인자로 받아 설정
    protected ImageProcessorDecorator(ImageProcessor imageProcessor) {
        this.imageProcessor = imageProcessor;
    }

    // 이미지 반환: 감싸고 있는 ImageProcessor의 getImage() 메서드를 호출
    @Override
    public BufferedImage getImage() {
        return imageProcessor.getImage();
    }

    // 파일 확장자 반환: 감싸고 있는 ImageProcessor의 getExt() 메서드를 호출
    @Override
    public String getExt() {
        return imageProcessor.getExt();
    }

    // 파일 경로 반환: 감싸고 있는 ImageProcessor의 getPath() 메서드를 호출
    @Override
    public String getPath() {
        return imageProcessor.getPath();
    }
}
