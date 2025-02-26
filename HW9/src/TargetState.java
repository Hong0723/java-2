// (Your Code)

import java.awt.Point;
import java.util.List;


public class TargetState implements BoidState { // TargetState 클래스는 보이드가 특정 목표 지점을 향해 이동하도록 하는 상태를 정의
    private Point target;  // 목표 지점을 저장하는 변수

  
    public TargetState(Point target) {   // 생성자: 목표 지점을 설정
        this.target = target;  
    }

    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) { // 현재 상태에서의 행동을 정의하는 메서드
        Point position = boid.getPosition(); // 보이드의 현재 위치
        Point velocity = boid.getVelocity(); // 보이드의 현재 속도

        // 목표 지점과 현재 위치 간의 x, y 차이 계산
        int dx = target.x - position.x;
        int dy = target.y - position.y;

        // 목표 지점까지의 거리 계산
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance != 0) {  // 거리가 0이 아닌 경우 목표 지점을 향하는 방향으로 속도를 계산
            dx = (int) (dx / distance * Boid.SPEED); // x 방향 속도
            dy = (int) (dy / distance * Boid.SPEED); // y 방향 속도
        }

        // 보이드의 속도를 목표 지점을 향하는 방향으로 설정
        velocity.setLocation(dx, dy);
        boid.setVelocity(velocity);

        // 보이드가 목표 지점에 도달한 경우
        if (distance < Boid.SEPARATION_DISTANCE) {
            System.out.println("boid id = " + boid.getId() + " state = " + boid.getState() + " changed to WanderState");
            boid.setState(new WanderState()); // 목표 지점 도달 시 WanderState로 상태 변경
        }
    }

    @Override
    public String toString() {
        return "TargetState";
    }
}
