package factoryBuilder;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// ImageProcessor 클래스: 여러 IProcessor를 이용하여 이미지에 연속적으로 처리 효과를 적용하는 클래스
public class ImageProcessor {
    private List<IProcessor> processors = new ArrayList<>(); // 이미지 처리기 목록

    // 생성자: Builder 객체로부터 프로세서 목록을 받아 초기화
    public ImageProcessor(Builder builder) {
        this.processors = builder.processors;
    }

    // 이미지 처리기 목록 반환
    public List<IProcessor> getProcessors() {
        return this.processors;
    }

    // 지정된 파일에 대해 모든 프로세서를 적용하여 이미지 처리
    public void process(String filename) {
        for (IProcessor processor : processors) {
            // 파일 확장자 형식 가져오기
            String format = ImageUtil.getExtension(filename);

            // 이미지 파일 로드
            BufferedImage image = ImageUtil.load(filename);

            // 각 프로세서를 이용하여 이미지 처리
            BufferedImage outputImage = processor.process(image);

            // 출력 파일 이름 생성
            String outputFile = ImageUtil.getFullpathWithoutExt(filename) + processor.toString() + "." + format;

            // 처리된 이미지 저장
            ImageUtil.save(outputImage, format, outputFile);
        }
    }

    // Builder 클래스: ImageProcessor 객체를 빌더 패턴을 통해 생성
    public static class Builder {
        private List<IProcessor> processors = new ArrayList<>(); // 이미지 처리기 목록

        // 프로세서를 추가하는 메서드
        public Builder add(IProcessor processor) {
            processors.add(processor);
            return this;
        }

        // ImageProcessor 객체를 생성하고 반환
        public ImageProcessor build() {
            return new ImageProcessor(this);
        }
    }
}
