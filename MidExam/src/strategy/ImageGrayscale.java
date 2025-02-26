package strategy;

import java.awt.Color;
import java.awt.image.BufferedImage;

// ImageGrayscale 클래스: 전략 패턴의 일환으로 그레이스케일 처리를 적용하는 전략 클래스
public class ImageGrayscale implements ImageProcessingStrategy {

    // processImage 메서드: 파일 이름을 받아 그레이스케일 처리를 수행
    @Override
    public void processImage(String filename) {
        // 파일 확장자 가져오기
        String format = ImageUtil.getExtension(filename);

        // 이미지 파일 로드
        BufferedImage image = ImageUtil.load(filename);

        // 그레이스케일 처리된 이미지 생성
        BufferedImage outputImage = grayscale(image);

        // 출력 파일 이름 생성 및 저장
        String outputFile = ImageUtil.getFullpathWithoutExt(filename) + " Grayscale" + "." + format;
        ImageUtil.save(outputImage, format, outputFile);
    }

    // grayscale 메서드: 입력된 이미지를 그레이스케일로 변환하여 새 이미지로 반환
    public static BufferedImage grayscale(BufferedImage image) {
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // 각 픽셀을 순회하며 그레이스케일 색상으로 설정
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // 현재 픽셀의 색상 가져오기
                Color c = new Color(image.getRGB(x, y));

                // NTSC 표준에 따른 밝기 계산 공식 사용 (적, 녹, 청 비율로 밝기 계산)
                int brightness = (int) (c.getRed() * 0.299) + (int) (c.getGreen() * 0.587) + (int) (c.getBlue() * 0.114);

                // 밝기를 동일하게 설정하여 회색(그레이) 색상 생성
                Color grayColor = new Color(brightness, brightness, brightness);

                // 새 이미지에 그레이스케일로 변환된 픽셀 설정
                newImage.setRGB(x, y, grayColor.getRGB());
            }
        }

        // 그레이스케일로 변환된 새 이미지 반환
        return newImage;
    }

    // toString 메서드: 클래스의 설명을 반환
    @Override
    public String toString() {
        return "ImageGrayscale";
    }
}
