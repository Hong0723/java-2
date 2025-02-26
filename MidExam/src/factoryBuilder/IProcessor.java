package factoryBuilder;

import java.awt.image.BufferedImage;

// IProcessor 인터페이스: 이미지 처리 작업을 정의하는 인터페이스
public interface IProcessor {
    
    // process 메서드: 입력된 BufferedImage를 처리하고, 처리된 BufferedImage를 반환
    BufferedImage process(BufferedImage image);
}
