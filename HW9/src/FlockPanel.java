import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// FlockPanel 클래스는 보이드들의 군집 행동을 시각화하고 조작할 수 있는 패널을 제공
public class FlockPanel extends JPanel {
    private static final int PANEL_WIDTH = 800; // 패널의 너비
    private static final int PANEL_HEIGHT = 600; // 패널의 높이
    private static final int NUM_BOIDS = 20; // 생성할 보이드의 수
    private static final int UPDATE_INTERVAL = 200; // 타이머 업데이트 간격

    private List<Boid> boids; // 보이드 리스트
    private Point targetPoint; // 마우스 클릭으로 설정되는 타겟 지점
    
   
    public FlockPanel() {  // 생성자: 패널 초기화 및 보이드 생성
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT)); // 패널 크기 설정
        setBackground(Color.WHITE); // 배경 색상 설정
        
     
        boids = new ArrayList<>();    // 보이드 생성 및 초기화
        for (int i = 0; i < NUM_BOIDS; i++) {
            Boid boid = new Boid(PANEL_WIDTH, PANEL_HEIGHT);
            boids.add(boid); // 리스트에 보이드 추가
        }

       
        addMouseListener(new MouseAdapter() {  // 마우스 클릭 이벤트 처리
            @Override
            public void mouseClicked(MouseEvent e){
                targetPoint = e.getPoint(); // 클릭한 위치를 타겟 지점으로 설정
                for (Boid boid : boids){
                    boid.moveToTarget(targetPoint); // 모든 보이드가 타겟 지점을 향하도록 설정
                }
            }
        });

       
        new Timer(UPDATE_INTERVAL, e -> {  // 타이머 생성 및 시작 
            updateBoids(); // 보이드 상태와 위치 업데이트
            repaint(); // 패널 다시 그리기
        }).start();
    }

  
    private void updateBoids() {   // 보이드의 상태 및 위치를 업데이트
        for (Boid boid : boids) {
            boid.update(boids); // 현재 상태에 따른 행동 수행 및 위치 갱신
        }
    }

  
    @Override
    protected void paintComponent(Graphics g) {   // 패널에 보이드들을 그리는 메서드
        super.paintComponent(g); // 패널 초기화
        for (Boid boid : boids) {
            boid.draw(g); // 각 보이드를 그리기
           //   System.out.println(boid);
        }
    }
}
