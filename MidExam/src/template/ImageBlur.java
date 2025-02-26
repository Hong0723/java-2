package template;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

// ImageBlur 클래스: 가우시안 블러 처리를 수행하는 이미지 처리 클래스
public class ImageBlur {

    // 블러 커널 정의
    public static final float[] blur3x3Kernel = { 
        1/16f, 1/8f, 1/16f, 
        1/8f, 1/4f, 1/8f, 
        1/16f, 1/8f, 1/16f 
    };

    public static final float[] blur5x5Kernel = { 
        1/273f, 4/273f, 7/273f, 4/273f, 1/273f, 
        4/273f, 16/273f, 26/273f, 16/273f, 4/273f,
        7/273f, 26/273f, 41/273f, 26/273f, 7/273f,
        4/273f, 16/273f, 26/273f, 16/273f, 4/273f,
        1/273f, 4/273f, 7/273f, 4/273f, 1/273f 
    };

    // blur 메서드: 가우시안 블러 필터를 적용하여 새 이미지를 반환
    public static BufferedImage blur(BufferedImage image) {
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // ConvolveOp 객체를 생성하여 5x5 블러 커널 필터 적용
        ConvolveOp op = new ConvolveOp(new Kernel(5, 5, blur5x5Kernel));
        newImage = op.filter(image, null); // 필터를 적용하여 블러 처리된 이미지 생성

        // 블러 처리된 새 이미지 반환
        return newImage;
    }

    // toString 메서드: 클래스의 설명을 반환
    @Override
    public String toString() {
        return "ImageBlur";
    }
}
