package decorator;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// ImageUtil 클래스: 이미지 로드, 저장, 변환 등의 유틸리티 기능을 제공
public class ImageUtil {
	
	// 이미지를 로드하는 메서드 (파일 경로를 입력 받아 BufferedImage로 반환)
	public static BufferedImage load(String fullPath) {
    	try {
			// 이미지 파일을 읽어와 호환되는 이미지로 변환하여 반환
			return toCompatibleImage(ImageIO.read(new File(fullPath)));
		} catch (IOException e) {
			System.out.println(fullPath  + " could not be loaded. It's not an image!");
			e.printStackTrace();
		}
		return null; // 파일을 읽지 못한 경우 null 반환
    }

    // 이미지를 기본 화면 장치와 호환되는 데이터 모델을 가진 BufferedImage로 변환하는 메서드
    public static BufferedImage toCompatibleImage(BufferedImage image) {
        BufferedImage compatibleImage = null;
    	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	GraphicsDevice gd = ge.getDefaultScreenDevice();
    	GraphicsConfiguration gc = gd.getDefaultConfiguration();
    	
    	// 호환 가능한 BufferedImage 생성 (투명도 포함)
    	compatibleImage = gc.createCompatibleImage(image.getWidth(), image.getHeight(), image.getTransparency());
    	Graphics2D g2d = compatibleImage.createGraphics();
    	
    	// 원본 이미지를 그려서 복사
    	g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    	g2d.dispose(); // 그래픽 자원 해제
        return compatibleImage;
    }

    // 이미지를 저장하는 메서드 (이미지, 형식, 파일 경로를 입력 받아 저장)
    public static void save(BufferedImage image, String format, String fullPath) {
    	try {
			// 이미지 파일을 저장하고 성공 여부를 출력
			boolean result = ImageIO.write(image, format, new File(fullPath));
			if (result) {
				System.out.println(fullPath + " in format " + format + " successfully saved.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    // 파일 경로에서 디렉토리 경로만 반환 (e.g. C:/JAVA/IMG.jpg => C:/JAVA/)
    public static String getPath(String fullPath) {
    	return fullPath.lastIndexOf('/') == -1 ? null : fullPath.substring(0, fullPath.lastIndexOf('/'));
    }
    
    // 파일 경로에서 확장자를 제외한 파일명 반환 (e.g. C:/JAVA/IMG.jpg => IMG)
    public static String getFilenameWithoutExt(String fullPath) {
    	return fullPath.substring(fullPath.lastIndexOf('/') + 1, fullPath.lastIndexOf('.'));
    }    
    
    // 파일 경로에서 확장자를 제외한 전체 경로 반환 (e.g. C:/JAVA/IMG.jpg => C:/JAVA/IMG)
    public static String getFullpathWithoutExt(String fullPath) {
    	return fullPath.substring(0, fullPath.lastIndexOf('.'));
    }
    
    // 파일 경로에서 확장자만 반환 (e.g. C:/JAVA/IMG.jpg => jpg)
    public static String getExtension(String fullPath) {
    	return fullPath.substring(fullPath.lastIndexOf('.') + 1);
    }
}
