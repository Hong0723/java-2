import java.awt.Point;
import java.util.List;
import java.util.Random;

public class WanderState implements BoidState { // WanderState 클래스는 보이드가 임의의 방향으로 자유롭게 움직이도록 하는 상태를 정의
    private static final int MAX_FORCE = 1; // 보이드가 임의로 이동할 수 있는 최대 힘

    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {     // 현재 상태에서의 행동을 정의하는 메서드
        Random random = new Random();

        // 임의의 방향으로 이동하기 위한 힘 계산
        int dx = random.nextInt(2 * MAX_FORCE + 1) - MAX_FORCE; // x축 방향 임의의 힘
        int dy = random.nextInt(2 * MAX_FORCE + 1) - MAX_FORCE; // y축 방향 임의의 힘

        boid.applyForce(new Point(dx, dy));  // 보이드에 힘을 적용하여 이동 방향을 변경

        for (Boid other : boids) {  // 주변 보이드와의 거리를 확인하여 CohesionState로 전환할 조건 검사
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.VISION_RANGE) {
                // 주변에 일정 범위 내의 다른 보이드가 발견되면 CohesionState로 전환
                System.out.println("boid id = " + boid.getId() + " state = " + boid.getState() + " changed to CohesionState");
                boid.setState(new CohesionState());
                return; // 상태를 변경한 후 종료
            }
        }
    }

    @Override
    public String toString() {
        return "WanderState";
    }
}
