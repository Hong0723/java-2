package factoryBuilder;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// ImageRotate 클래스: 이미지를 지정된 각도로 회전시키는 클래스
public class ImageRotate implements IProcessor {
    protected double angle = 45.0; // 기본 회전 각도 설정

    // 생성자: 회전 각도를 받아 초기화하고 객체 정보 출력
    public ImageRotate(double angle) {
        this.angle = angle;
        System.out.println(this);
    }

    // toString 메서드 오버라이딩: 클래스의 설명과 회전 각도를 반환
    @Override
    public String toString() {
        return " ImageRotate " + this.angle;
    }

    // process 메서드: 입력된 이미지를 지정된 각도로 회전하여 반환
    @Override
    public BufferedImage process(BufferedImage image) {
        return rotate(image, angle);
    }

    // rotate 메서드: 입력된 이미지를 주어진 각도로 회전하여 새 이미지로 반환
    public static BufferedImage rotate(BufferedImage image, double rotateAngle) {
        if (image == null) return null;

        // 출력 이미지 생성 (원본 이미지와 동일한 크기 및 타입)
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // Graphics2D 객체를 사용하여 회전 변환 적용
        Graphics2D g2d = newImage.createGraphics();
        // 이미지의 중심을 기준으로 회전 각도만큼 회전
        g2d.rotate(Math.toRadians(rotateAngle), image.getWidth() / 2, image.getHeight() / 2);
        g2d.drawImage(image, null, 0, 0);
        g2d.dispose(); // 자원 해제

        // 회전된 새 이미지 반환
        return newImage;
    }
}
