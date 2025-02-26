package observer;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

// ImageNegative 클래스: 옵저버 패턴을 통해 이미지에 네거티브(반전) 처리를 적용하는 클래스
public class ImageNegative implements Observer {

    // update 메서드: 이미지 파일 이름을 받아 네거티브 처리를 적용
    @Override
    public void update(String filename) {
        // 파일 확장자 형식 가져오기
        String format = ImageUtil.getExtension(filename);

        // 이미지 파일 로드
        BufferedImage image = ImageUtil.load(filename);

        // 네거티브 처리 적용
        BufferedImage outputImage = negative(image);

        // 출력 파일 이름 생성 및 저장
        String outputFile = ImageUtil.getFullpathWithoutExt(filename) + " ImageNegative" + "." + format;
        ImageUtil.save(outputImage, format, outputFile);
    }

    // negative 메서드: 입력된 이미지의 색상을 반전하여 새 이미지로 반환
    // 각 색상 값을 -1.0으로 스케일링하고 255를 더해 반전 효과 적용
    public static BufferedImage negative(BufferedImage image) {
        // 이미지가 null인 경우 null 반환
        if (image == null) return null;

        // 원본 이미지와 동일한 크기 및 타입으로 새 이미지 생성
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // RescaleOp 객체 생성: 각 픽셀 색상을 -1로 스케일하고 255를 더해 반전 효과 적용
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);

        // 필터를 적용하여 네거티브 처리된 이미지 생성
        newImage = op.filter(image, null);

        // 네거티브 처리된 새 이미지 반환
        return newImage;
    }

    @Override
    public String toString() {
        return "ImageNegative";
    }
}
