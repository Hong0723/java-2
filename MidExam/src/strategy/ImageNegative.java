package strategy;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

// ImageNegative 클래스: 전략 패턴의 일환으로 이미지 색상을 반전(네거티브) 처리하는 전략 클래스
public class ImageNegative implements ImageProcessingStrategy {

    // processImage 메서드: 파일 이름을 받아 네거티브 처리를 수행
    @Override
    public void processImage(String filename) {
        // 파일 확장자 가져오기
        String format = ImageUtil.getExtension(filename);

        // 이미지 파일 로드
        BufferedImage image = ImageUtil.load(filename);

        // 네거티브 처리된 이미지 생성
        BufferedImage outputImage = negative(image);

        // 출력 파일 이름 생성 및 저장
        String outputFile = ImageUtil.getFullpathWithoutExt(filename) + " ImageNegative" + "." + format;
        ImageUtil.save(outputImage, format, outputFile);
    }

    // negative 메서드: 입력된 이미지의 색상을 반전하여 새 이미지로 반환
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

    // toString 메서드: 클래스의 설명을 반환
    @Override
    public String toString() {
        return "ImageNegative";
    }
}
