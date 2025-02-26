package decorator;

import java.awt.image.BufferedImage;

// 추상 클래스 ImageProcessor: 이미지를 로드하고 처리하는 기본 클래스
public abstract class ImageProcessor {
    protected BufferedImage image = null; // 원본 이미지
    protected String name = null;         // 파일 이름
    protected String ext = null;          // 파일 확장자
    protected String path = null;         // 파일 경로

    // 이미지 파일을 로드하는 메서드
    public void load(String filename) {
        image = ImageUtil.load(filename);                       // 이미지 로드
        name = ImageUtil.getFilenameWithoutExt(filename);       // 파일명 (확장자 제외)
        ext = ImageUtil.getExtension(filename);                 // 파일 확장자
        path = ImageUtil.getPath(filename);                     // 파일 경로
    }

    // 이미지 처리 메서드
    public void process() {
        // 현재 이미지를 처리하여 새로운 이미지 생성
        BufferedImage newImage = process(getImage());
        
        // 출력 파일 경로 설정 (경로가 있으면 경로 포함, 없으면 파일 이름만)
        String outputFile = getPath() != null 
                            ? getPath() + "/" + getName() + "." + getExt() 
                            : getName() + "." + getExt();
        
        // 새로운 이미지가 null이 아니면 저장
        if (newImage != null) 
            ImageUtil.save(newImage, getExt(), outputFile);
    }

    // 추상 메서드 - 하위 클래스에서 이미지 처리 구현
    protected abstract BufferedImage process(BufferedImage image2);

    // 원본 이미지를 반환하는 메서드
    public BufferedImage getImage() {
        return image;
    }

    // 추상 메서드 - 파일 이름 반환, 하위 클래스에서 구현
    public abstract String getName();

    // 파일 확장자를 반환하는 메서드
    public String getExt() {
        return ext;
    }

    // 파일 경로를 반환하는 메서드
    public String getPath() {
        return path;
    }
}
