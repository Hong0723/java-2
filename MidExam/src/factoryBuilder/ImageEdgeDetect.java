package factoryBuilder;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

// ImageEdgeDetect 클래스: 에지(경계) 검출을 위한 이미지 처리 클래스
public class ImageEdgeDetect implements IProcessor {

    // 생성자: 객체 생성 시 클래스 정보 출력
    public ImageEdgeDetect() {
        System.out.println(this);
    }

    // toString 메서드 오버라이딩: 클래스의 설명을 반환
    @Override
    public String toString() {
        return " ImageEdgeDetect";
    }

    // process 메서드: 입력된 이미지를 에지 검출 처리하여 반환
    @Override
    public BufferedImage process(BufferedImage image) {
        return edgeDetect(image);
    }
    
    // 3x3 에지 검출 커널: 주변 픽셀과의 차이를 강조하여 경계를 검출하는 필터
    public static final float[] edge3x3Kernel = { 
        0.0f, -0.75f, 0.0f, 
        -0.75f, 3.0f, -0.75f, 
        0.0f, -0.75f, 0.0f 
    };

    // edgeDetect 메서드: 입력된 이미지에 에지 검출 필터를 적용하여 새 이미지 반환
    public static BufferedImage edgeDetect(BufferedImage image) {
        // 이미지가 null인 경우 null 반환
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // ConvolveOp 객체를 생성하여 3x3 에지 검출 커널 필터 적용
        ConvolveOp op = new ConvolveOp(new Kernel(3, 3, edge3x3Kernel));
        newImage = op.filter(image, null);  // 필터를 적용하여 에지 검출 이미지 생성

        // 에지 검출된 새 이미지 반환
        return newImage;
    }
}
