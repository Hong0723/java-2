package factoryBuilder;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

// ImageBlur 클래스: 가우시안 블러 처리를 위한 클래스
public class ImageBlur implements IProcessor {
	
    // 생성자: 객체 생성 시 클래스 정보 출력
	public ImageBlur() {
		System.out.println(this);
	}

	// toString 메서드 오버라이딩: 클래스의 설명을 반환
	@Override
	public String toString() {
		return " ImageBlur";
	}
	
	// process 메서드: 입력된 이미지를 블러 처리하여 반환
	@Override
	public BufferedImage process(BufferedImage image) {
		return blur(image);
	}

	// 3x3 블러 커널 배열: 기본 가우시안 블러 효과를 위한 필터
	public static final float[] blur3x3Kernel = { 
	    1/16f, 1/8f, 1/16f, 
	    1/8f, 1/4f, 1/8f, 
	    1/16f, 1/8f, 1/16f 
	};

	// 5x5 블러 커널 배열: 더 강한 가우시안 블러 효과를 위한 필터
	public static final float[] blur5x5Kernel = { 
	    1/273f, 4/273f, 7/273f, 4/273f, 1/273f, 
	    4/273f, 16/273f, 26/273f, 16/273f, 4/273f,
	    7/273f, 26/273f, 41/273f, 26/273f, 7/273f,
	    4/273f, 16/273f, 26/273f, 16/273f, 4/273f,
	    1/273f, 4/273f, 7/273f, 4/273f, 1/273f 
	};

	// blur 메서드: 이미지를 블러 처리하여 반환
	public static BufferedImage blur(BufferedImage image) {
		// 이미지가 null인 경우 null 반환
		if (image == null) return null;

		// 출력 이미지 생성 (원본 이미지와 동일한 크기 및 타입)
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		// ConvolveOp 객체 생성 (5x5 블러 커널 사용)
		ConvolveOp op = new ConvolveOp(new Kernel(5, 5, blur5x5Kernel));
		// 필터를 적용하여 새로운 블러 처리된 이미지 생성
		newImage = op.filter(image, null);

		// 블러 처리된 이미지 반환
		return newImage;
	}
}
