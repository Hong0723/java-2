package template;

import java.awt.image.BufferedImage;

// MainTest 클래스: 다양한 이미지 필터를 적용하여 결과 이미지를 저장하는 테스트 클래스
public class MainTest {

    // 생성자: MainTest 객체가 생성될 때 이미지 처리 작업을 수행
    public MainTest() {
        // 처리할 이미지 파일 배열
        String[] imagefiles = {"cat1.jpg", "cat2.jpg"};

        // 각 파일에 대해 모든 이미지 필터를 순차적으로 적용
        for (String filename : imagefiles) {
            String format = ImageUtil.getExtension(filename); // 파일 확장자 형식 추출
            BufferedImage image = ImageUtil.load(filename);   // 이미지 파일 로드

            // Grayscale 필터 적용 및 저장
            BufferedImage outputImage = ImageGrayscale.grayscale(image);
            String outputFile = ImageUtil.getFullpathWithoutExt(filename) + "Grayscale." + format;
            ImageUtil.save(outputImage, format, outputFile);

            // Blur 필터 적용 및 저장
            outputImage = ImageBlur.blur(image);
            outputFile = ImageUtil.getFullpathWithoutExt(filename) + "ImageBlur." + format;
            ImageUtil.save(outputImage, format, outputFile);

            // Negative 필터 적용 및 저장
            outputImage = ImageNegative.negative(image);
            outputFile = ImageUtil.getFullpathWithoutExt(filename) + "ImageNegative." + format;
            ImageUtil.save(outputImage, format, outputFile);

            // Edge Detection 필터 적용 및 저장
            outputImage = ImageEdgeDetect.edgeDetect(image);
            outputFile = ImageUtil.getFullpathWithoutExt(filename) + "ImageEdgeDetect." + format;
            ImageUtil.save(outputImage, format, outputFile);

            // Rotate 필터 적용 및 저장 (45도 회전)
            outputImage = ImageRotate.rotate(image, 45.0);
            outputFile = ImageUtil.getFullpathWithoutExt(filename) + "ImageRotate." + format;
            ImageUtil.save(outputImage, format, outputFile);
        }
    }
}
