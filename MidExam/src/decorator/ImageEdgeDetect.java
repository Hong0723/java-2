package decorator;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

// ImageEdgeDetect 클래스 (이미지 에지 검출을 위한 클래스)
public class ImageEdgeDetect extends ImageProcessorDecorator {

    // 생성자 - ImageProcessor 객체를 인자로 받아 상위 클래스의 생성자에 전달
    protected ImageEdgeDetect(ImageProcessor imageProcessor) {
        super(imageProcessor);
    }

    // 이미지 처리 메서드 오버라이딩 - 이미지 프로세서를 통해 이미지를 처리한 후 에지 검출 효과 적용
    @Override
    protected BufferedImage process(BufferedImage image2) {
        return edgeDetect(imageProcessor.process(image2));
    }

    // 이미지의 이름 반환 메서드 - 기본 이름에 " ImageEdgeDetect"를 추가하여 반환
    @Override
    public String getName() {
        return imageProcessor.getName() + " ImageEdgeDetect";
    }

    // 에지 검출 커널 배열 - 주변 픽셀과의 차이를 강조하여 에지(경계선)를 검출하는 필터
    public static final float[] edge3x3Kernel = { 
        0.0f, -0.75f, 0.0f, 
        -0.75f, 3.0f, -0.75f, 
        0.0f, -0.75f, 0.0f 
    };

    // 에지 검출 메서드 - 입력된 이미지에 에지 검출 효과를 적용하고 새 이미지를 반환
    public static BufferedImage edgeDetect(BufferedImage image) {
        // 이미지가 null인 경우 null 반환
        if (image == null) return null;
        
        // 새로운 이미지 객체 생성 (원본 이미지와 동일한 크기와 타입)
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        
        // 3x3 에지 검출 커널을 이용하여 ConvolveOp 객체 생성
        ConvolveOp op = new ConvolveOp(new Kernel(3, 3, edge3x3Kernel));
        
        // 필터를 사용하여 에지 검출을 적용하고 새 이미지에 결과를 저장
        newImage = op.filter(image, null);
        
        // 에지 검출 처리된 새 이미지 반환
        return newImage;
    }
}
