import javax.swing.JFrame;

// FlockSimulationApp 클래스는 군집 시뮬레이션 애플리케이션의 메인 프레임을 정의
public class FlockSimulationApp extends JFrame {
    public FlockSimulationApp() {
        super("2D Flock of Birds Simulation"); // 프레임 제목 설정
        this.add(new FlockPanel()); // FlockPanel을 프레임에 추가
        this.pack(); // 프레임 크기를 FlockPanel의 기본 크기로 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 애플리케이션 종료
        this.setLocationRelativeTo(null); // 화면 중앙에 프레임 위치 설정
        this.setVisible(true); // 프레임을 화면에 표시
    }
}
