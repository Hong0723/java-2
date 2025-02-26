package decorator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// ImageRotate 클래스 (이미지를 회전시키는 기능을 추가하는 데코레이터 클래스)
public class ImageRotate extends ImageProcessorDecorator {
	private double angle = 45.0; // 회전 각도 기본값 설정

	// 생성자: 회전 각도와 ImageProcessor 객체를 인자로 받아 초기화
	protected ImageRotate(ImageProcessor imageProcessor, double angle) {
		super(imageProcessor);
		this.angle = angle;
	}

	// process 메서드: 주어진 이미지를 설정된 각도로 회전
	@Override
	protected BufferedImage process(BufferedImage image2) {
		return rotate(imageProcessor.process(image2), angle);
	}

	// getName 메서드: 현재의 프로세서 이름에 회전 각도를 추가하여 반환
	@Override
	public String getName() {
		return imageProcessor.getName() + " ImageRotate " + angle;
	}

	// rotate 메서드: 주어진 이미지를 rotateAngle 각도만큼 회전하여 반환
	public static BufferedImage rotate(BufferedImage image, double rotateAngle) {
		if (image == null) return null;
		
		// 출력 이미지를 생성
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		// Graphics2D 객체를 이용하여 이미지 회전
		Graphics2D g2d = newImage.createGraphics();
		// 이미지를 중심을 기준으로 rotateAngle 만큼 회전
		g2d.rotate(Math.toRadians(rotateAngle), image.getWidth() / 2, image.getHeight() / 2);  
		g2d.drawImage(image, null, 0, 0);
		g2d.dispose(); // Graphics2D 자원 해제
		
		return newImage;  
	}
}
