package observer;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// ImageUtil 클래스: 이미지 로드, 저장, 변환, 경로 및 파일 정보 처리를 위한 유틸리티 클래스
public class ImageUtil {

    // load 메서드: 이미지 파일 경로를 받아 이미지를 로드하고 호환 가능한 BufferedImage로 반환
    public static BufferedImage load(String fullPath) {
        try {
            // 이미지 파일을 읽어와 기본 화면 장치와 호환 가능한 BufferedImage로 변환
            return toCompatibleImage(ImageIO.read(new File(fullPath)));
        } catch (IOException e) {
            System.out.println(fullPath + " could not be loaded. It's not an image!");
            e.printStackTrace();
        }
        return null; // 파일을 읽지 못한 경우 null 반환
    }

    // toCompatibleImage 메서드: 이미지를 기본 화면 장치와 호환 가능한 형식으로 변환
    public static BufferedImage toCompatibleImage(BufferedImage image) {
        BufferedImage compatibleImage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();

        // 호환 가능한 BufferedImage 생성
        compatibleImage = gc.createCompatibleImage(image.getWidth(), image.getHeight(), image.getTransparency());
        Graphics2D g2d = compatibleImage.createGraphics();
        
        // 원본 이미지를 호환 가능한 이미지로 복사
        g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        g2d.dispose(); // 그래픽 자원 해제
        return compatibleImage;
    }

    // save 메서드: 이미지와 파일 형식, 저장 경로를 받아 이미지를 저장
    public static void save(BufferedImage image, String format, String fullPath) {
        try {
            boolean result = ImageIO.write(image, format, new File(fullPath));
            if (result) {
                System.out.println(fullPath + " in format " + format + " successfully saved.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getPath 메서드: 전체 경로에서 디렉토리 경로만 추출 (예: C:/JAVA/IMG.jpg => C:/JAVA/)
    public static String getPath(String fullPath) {
        return fullPath.lastIndexOf('/') == -1 ? null : fullPath.substring(0, fullPath.lastIndexOf('/'));
    }

    // getFilenameWithoutExt 메서드: 전체 경로에서 확장자를 제외한 파일명 추출 (예: C:/JAVA/IMG.jpg => IMG)
    public static String getFilenameWithoutExt(String fullPath) {
        return fullPath.substring(fullPath.lastIndexOf('/') + 1, fullPath.lastIndexOf('.'));
    }

    // getFullpathWithoutExt 메서드: 전체 경로에서 확장자를 제외한 전체 경로 추출 (예: C:/JAVA/IMG.jpg => C:/JAVA/IMG)
    public static String getFullpathWithoutExt(String fullPath) {
        return fullPath.substring(0, fullPath.lastIndexOf('.'));
    }

    // getExtension 메서드: 전체 경로에서 확장자만 추출 (예: C:/JAVA/IMG.jpg => jpg)
    public static String getExtension(String fullPath) {
        return fullPath.substring(fullPath.lastIndexOf('.') + 1);
    }
}
