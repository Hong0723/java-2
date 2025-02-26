package decorator;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

// ImageNegative 클래스 (이미지를 네거티브로 변환하는 클래스)
public class ImageNegative extends ImageProcessorDecorator {

    // 생성자 - ImageProcessor 객체를 받아 상위 클래스의 생성자에 전달
    protected ImageNegative(ImageProcessor imageProcessor) {
        super(imageProcessor);
    }

    // 이미지 처리 메서드 오버라이딩 - 기본 이미지 프로세서를 통해 처리 후 네거티브로 변환하여 반환
    @Override
    protected BufferedImage process(BufferedImage image2) {
        return negative(imageProcessor.process(image2));
    }

    // 이미지의 이름 반환 메서드 - 기본 이름에 " ImageNegative"를 추가하여 반환
    @Override
    public String getName() {
        return imageProcessor.getName() + " ImageNegative";
    }

    // 네거티브 변환 메서드
    // 각 색상 값에 -1.0을 곱하고 255를 더하여 색상 반전 효과를 생성
    public static BufferedImage negative(BufferedImage image) {
        // 이미지가 null인 경우 null 반환
        if (image == null) return null;

        // 새 이미지를 생성 (원본 이미지와 동일한 크기와 타입)
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // RescaleOp 객체를 사용하여 각 색상 값을 반전 (-1.0을 곱하고 255를 더함)
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);

        // 원본 이미지에 필터 적용하여 네거티브 변환된 새 이미지 생성
        newImage = op.filter(image, null);

        // 네거티브 변환된 새 이미지 반환
        return newImage;
    }
}
