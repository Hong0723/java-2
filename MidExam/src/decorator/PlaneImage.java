package decorator;

import java.awt.image.BufferedImage;

// PlaneImage 클래스: 기본 이미지를 로드하는 ImageProcessor 구현 클래스
public class PlaneImage extends ImageProcessor {
    
    // 생성자: 파일 이름을 받아서 이미지 로드
    public PlaneImage(String filename) {
        load(filename);
    }

    // 이미지 이름을 반환
    @Override
    public String getName() {
        return name;
    }

    // 이미지 처리 메서드 (PlaneImage는 처리 없이 원본 이미지를 반환)
    @Override
    protected BufferedImage process(BufferedImage image) {
        return image;
    }
}
