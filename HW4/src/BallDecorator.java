import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

public class BallDecorator extends DollDecorator { // DollDecorator 의 서브클래스이며 공을 들고있는 인형을 표현

    public BallDecorator(Doll decoratorDoll){ // 공을 들고있는 인형을 꾸미기 위한 객체 생성, decoratorDoll을 파라미터로 받아 상위클래스에 전달  
        super(decoratorDoll);
        try{
            image = ImageIO.read(new File("image/ball.png")); // 공 이미지 파일을 읽어서 image 필드에 저장
        } catch (IOException e){
            e.printStackTrace(); // 이미지 파일을 읽는 도중 오류가 발생할경우, 오류 메세지를 출력
        }
    }

    @Override
    public String describe() { // 인형에 대한 설명을 추가로 제공하는 메소드 
        return decorateDoll.describe() + "with a ball"; 
    }


    @Override
    public void paintComponent(Graphics g) { // 인형을 그리는 메소드
        Graphics2D g2 = (Graphics2D) g; // 2D 그래픽으로 변환
        if ( image != null) g2.drawImage(image,-50,550,this); // 좌표(-50,550)에 이미지를 그리도록 설정
    }
}
