// Your Code


import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

public class DogballDecorator extends DollDecorator { // DollDecorator 의 서브클래스이며 개의 공을 표현

    public DogballDecorator(Doll decoratorDoll){ // 개의 공을 가진 인형을 꾸며주기 위한 객체 생성
        super(decoratorDoll); // 상위 클래스의 생성자 호출
        try{
            image = ImageIO.read(new File("image/ball.png")); // ball 이미지를 읽어 image 변수에 저장
        } catch (IOException e){
            e.printStackTrace(); // 이미지 파일을 읽는 도중 오류가 발생하면 오류 메세지를 출력
        }
    }

    @Override
    public String describe() { // 인형에 대한 설명을 제공하는 메소드
        return decorateDoll.describe() + "with a ball";  
    }


    @Override
    public void paintComponent(Graphics g) { // 인형을 그리는 메소드
        Graphics2D g2 = (Graphics2D) g; // 2D 그래픽으로 변환
        if ( image != null) g2.drawImage(image, 1000,550,this); // 이미지가 null이 아니라면 좌표(1000,550)에 공을 그림
    }
}
