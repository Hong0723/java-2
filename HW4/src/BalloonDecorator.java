// Your Code

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

public class BalloonDecorator extends DollDecorator { // DollDecorator클래스의 서브 클래스이며 풍선을 표현함

    public BalloonDecorator(Doll decoratorDoll){ // 풍선 이미지를 가진 인형을 꾸며주기 위한 객체 생성
        super(decoratorDoll); // 상위 클래스의 생성자 호출
        try{
            image = ImageIO.read(new File("image/balloon.png")); // 풍선 이미지를 읽어 image변수에 저장
        } catch (IOException e){
            e.printStackTrace(); // 이미지 파일을 읽는 도중 오류가 발생할 경우, 오류 메세지 출력
        }
    }

    @Override
    public String describe() { // 인형에 대한 설명을 추가하는 메소드
        return decorateDoll.describe() + "with a balloon"; 
    }


    @Override
    public void paintComponent(Graphics g) { // 인형을 그리는 메소드
        Graphics2D g2 = (Graphics2D) g; // 2D 그래픽으로 변환하여 사용
        if ( image != null) g2.drawImage(image,1400,550,this); // 좌표(1400,550)에 풍선 이미지를 그림
    }
}

