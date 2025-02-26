package factoryBuilder;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

// ImageNegative 클래스: 이미지를 네거티브(반전) 처리하는 클래스
public class ImageNegative implements IProcessor {

    // 생성자: 객체 생성 시 클래스 정보 출력
    public ImageNegative() {
        System.out.println(this);
    }

    // toString 메서드 오버라이딩: 클래스의 설명을 반환
    @Override
    public String toString() {
        return " ImageNegative";
    }

    // process 메서드: 입력된 이미지를 네거티브 처리하여 반환
    @Override
    public BufferedImage process(BufferedImage image) {
        return negative(image);
    }

    // negative 메서드: 각 색상 값을 반전하여 네거티브 이미지 생성
    // 각 색상 값에 -1.0을 곱하고 255를 더해 색상 반전 효과를 적용
    public static BufferedImage negative(BufferedImage image) {
        // 이미지가 null인 경우 null 반환
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // RescaleOp 객체 생성: 각 픽셀 색상을 -1로 스케일하고 255를 더해 반전 효과 적용
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);

        // 필터를 적용하여 네거티브 이미지 생성
        newImage = op.filter(image, null);

        // 네거티브 처리된 새 이미지 반환
        return newImage;
    }
}
