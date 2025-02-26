package template;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

// ImageNegative 클래스: 이미지 색상을 반전(네거티브) 처리하는 클래스
public class ImageNegative {

    // negative 메서드: 입력된 이미지의 색상을 반전하여 새 이미지를 반환
    // 각 색상 값을 -1.0으로 스케일링하고 255를 더해 반전 효과 적용
    public static BufferedImage negative(BufferedImage image) {
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // RescaleOp 객체 생성: 각 픽셀 색상을 -1로 스케일하고 255를 더해 반전 효과 적용
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);
        newImage = op.filter(image, null);

        // 네거티브 처리된 새 이미지 반환
        return newImage;
    }
}
