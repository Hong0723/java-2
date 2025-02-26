package strategy;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

// ImageEdgeDetect 클래스: 전략 패턴의 일환으로 에지 검출 처리를 적용하는 전략 클래스
public class ImageEdgeDetect implements ImageProcessingStrategy {

    // processImage 메서드: 파일 이름을 받아 에지 검출 처리를 수행
    @Override
    public void processImage(String filename) {
        // 파일 확장자 가져오기
        String format = ImageUtil.getExtension(filename);

        // 이미지 파일 로드
        BufferedImage image = ImageUtil.load(filename);

        // 에지 검출된 이미지 생성
        BufferedImage outputImage = edgeDetect(image);

        // 출력 파일 이름 생성 및 저장
        String outputFile = ImageUtil.getFullpathWithoutExt(filename) + " ImageEdgeDetect" + "." + format;
        ImageUtil.save(outputImage, format, outputFile);
    }

    // edge3x3Kernel: 에지 검출을 위한 3x3 필터 커널 배열
    public static final float[] edge3x3Kernel = { 
        0.0f, -0.75f, 0.0f, 
        -0.75f, 3.0f, -0.75f, 
        0.0f, -0.75f, 0.0f 
    };

    // edgeDetect 메서드: 에지 검출 필터를 적용하여 새 이미지를 반환
    public static BufferedImage edgeDetect(BufferedImage image) {
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // ConvolveOp 객체를 생성하여 3x3 에지 검출 커널 필터 적용
        ConvolveOp op = new ConvolveOp(new Kernel(3, 3, edge3x3Kernel));
        newImage = op.filter(image, null); // 필터를 적용하여 에지 검출된 이미지 생성

        // 에지 검출된 새 이미지 반환
        return newImage;
    }

    // toString 메서드: 클래스의 설명을 반환
    @Override
    public String toString() {
        return "ImageEdgeDetect";
    }
}
