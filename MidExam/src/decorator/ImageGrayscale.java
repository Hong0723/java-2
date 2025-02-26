package decorator;

import java.awt.Color;
import java.awt.image.BufferedImage;

// ImageGrayscale 클래스 (이미지를 그레이스케일로 변환하는 클래스)
public class ImageGrayscale extends ImageProcessorDecorator {

    // 생성자 - ImageProcessor 객체를 받아 상위 클래스의 생성자에 전달
    protected ImageGrayscale(ImageProcessor imageProcessor) {
        super(imageProcessor);
    }

    // 이미지 처리 메서드 오버라이딩 - 기본 이미지 프로세서를 통해 처리 후 그레이스케일로 변환하여 반환
    @Override
    protected BufferedImage process(BufferedImage image2) {
        return grayscale(imageProcessor.process(image2));
    }

    // 이미지의 이름 반환 메서드 - 기본 이름에 " ImageGrayscale"을 추가하여 반환
    @Override
    public String getName() {
        return imageProcessor.getName() + " ImageGrayscale";
    }

    // 그레이스케일 변환 메서드
    public static BufferedImage grayscale(BufferedImage image) {
        // 이미지가 null인 경우 null 반환
        if (image == null) return null;

        // 새 이미지를 생성 (원본 이미지와 동일한 크기와 타입)
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // 각 픽셀을 순회하여 그레이스케일 색상으로 설정
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                // 현재 픽셀의 색상 가져오기
                Color c = new Color(image.getRGB(x, y));
                
                // NTSC 표준에 따른 밝기 공식 사용 (적절한 비율로 색상 값을 조합하여 밝기 계산)
                int brightness = (int) (c.getRed() * 0.299) + (int) (c.getGreen() * 0.587) + (int) (c.getBlue() * 0.114);

                // 밝기를 동일하게 적용하여 회색(그레이) 색상 생성
                Color grayColor = new Color(brightness, brightness, brightness);

                // 새 이미지에 그레이스케일로 변환된 픽셀 값 설정
                newImage.setRGB(x, y, grayColor.getRGB());
            }
        }

        // 그레이스케일 변환된 새 이미지 반환
        return newImage;
    }
}
