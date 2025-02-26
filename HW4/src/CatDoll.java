import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

public class CatDoll extends Doll { // Doll의 서브클래스이며 고양이 인형을 표현

    public CatDoll() { // CatDoll 객체 생성시 이미지 파일을 로드하여 인형에 적용
        try{
            image = ImageIO.read(new File("image/cat.png")); // 고양이 이미지를 경로에서 불러와 image변수에 저장
        } catch (IOException e ){
            e.printStackTrace(); // 이미지를 읽는 도중 오류가 발생하면, 오류 메세지를 출력
        }
    }

    @Override
    public void paintComponent(Graphics g) { // 인형을 그리는 메소드    
        Graphics2D g2 = (Graphics2D) g; // 2D 그래픽으로 변환
        if ( image != null) g2.drawImage(image,0,0,this); // 이미지가 null이 아닐 경우 고양이 이미지를 좌표(0,0)에 그림
    }

    @Override
    public String describe() { // 인형에 대한 설명을 제공하는 메소드
        return "Cat Doll"; // 고양이 인형임을 나타냄
    }

}
