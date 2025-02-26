package decorator;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

// ImageBlur 클래스 (가우시안 블러 적용을 위한 클래스)
public class ImageBlur extends ImageProcessorDecorator {

	// 생성자 - ImageProcessor 객체를 인자로 받아 상위 클래스의 생성자에 전달
	protected ImageBlur(ImageProcessor imageProcessor) {
		super(imageProcessor);
	}

	// 이미지 처리 메서드 오버라이딩 - 이미지 프로세서를 통해 이미지를 처리한 후 블러 효과 적용
	@Override
	protected BufferedImage process(BufferedImage image2) {
		return blur(imageProcessor.process(image2));
	}

	// 이미지의 이름 반환 메서드 - 기본 이름에 " ImageBlur"를 추가하여 반환
	@Override
	public String getName() {
		return imageProcessor.getName() + " ImageBlur";
	}

	// 3x3 블러 커널 배열 - 작은 가우시안 블러를 위한 필터
	//public static final float[] blurKernel = { 0.1f, 0.1f, 0.1f, 0.1f, 0.2f, 0.1f, 0.1f, 0.1f, 0.1f };
	public static final float[] blur3x3Kernel = { 1/16f, 1/8f, 1/16f, 1/8f, 1/4f, 1/8f, 1/16f, 1/8f, 1/16f };

	// 5x5 블러 커널 배열 - 더 넓은 영역에 강한 가우시안 블러를 위한 필터
	public static final float[] blur5x5Kernel = { 
		1/273f, 4/273f, 7/273f, 4/273f, 1/273f, 
		4/273f, 16/273f, 26/273f, 16/273f, 4/273f,
		7/273f, 26/273f, 41/273f, 26/273f, 7/273f,
		4/273f, 16/273f, 26/273f, 16/273f, 4/273f,
		1/273f, 4/273f, 7/273f, 4/273f, 1/273f 
	};

	// 가우시안 블러 적용 메서드 - 입력된 이미지에 블러 효과를 적용하고 새 이미지를 반환
	public static BufferedImage blur(BufferedImage image) {
		// 이미지가 null인 경우 null 반환
		if (image == null) return null;
		
		// 새로운 이미지 객체 생성 (원본 이미지와 동일한 크기와 타입)
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		// 5x5 블러 커널을 이용하여 ConvolveOp 객체 생성
		// 3x3 블러 커널을 사용할 경우 -> new ConvolveOp(new Kernel(3, 3, blur3x3Kernel));
		ConvolveOp op = new ConvolveOp(new Kernel(5, 5, blur5x5Kernel));
		
		// 필터를 사용하여 블러를 적용하고 새 이미지에 결과를 저장
		newImage = op.filter(image, null);
		
		// 블러 처리된 새 이미지 반환
		return newImage;
	}

	// 객체를 문자열로 변환하는 메서드 오버라이딩 - "ImageBlur" 문자열 반환
	@Override
	public String toString() {
		return "ImageBlur";
	}
}
