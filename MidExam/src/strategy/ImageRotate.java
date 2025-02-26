package strategy;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// ImageRotate 클래스: 전략 패턴의 일환으로 이미지 회전 처리를 적용하는 전략 클래스
public class ImageRotate implements ImageProcessingStrategy {

    // processImage 메서드: 파일 이름을 받아 회전 처리를 수행
    @Override
    public void processImage(String filename) {
        // 파일 확장자 가져오기
        String format = ImageUtil.getExtension(filename);

        // 이미지 파일 로드
        BufferedImage image = ImageUtil.load(filename);

        // 회전 처리된 이미지 생성 (회전 각도 45도)
        BufferedImage outputImage = rotate(image, 45.0);

        // 출력 파일 이름 생성 및 저장
        String outputFile = ImageUtil.getFullpathWithoutExt(filename) + " ImageRotate" + "." + format;
        ImageUtil.save(outputImage, format, outputFile);
    }

    // rotate 메서드: 입력된 이미지를 지정된 각도로 회전하여 새 이미지로 반환
    public static BufferedImage rotate(BufferedImage image, double rotateAngle) {
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // Graphics2D 객체를 사용하여 회전 변환 적용
        Graphics2D g2d = newImage.createGraphics();

        // 이미지의 중심을 기준으로 회전 각도만큼 회전
        g2d.rotate(Math.toRadians(rotateAngle), image.getWidth() / 2, image.getHeight() / 2);
        g2d.drawImage(image, null, 0, 0);
        g2d.dispose(); // 그래픽 자원 해제

        // 회전된 새 이미지 반환
        return newImage;
    }

    // toString 메서드: 클래스의 설명을 반환
    @Override
    public String toString() {
        return "ImageRotate";
    }
}
