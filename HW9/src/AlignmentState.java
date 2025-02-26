import java.awt.Point;
import java.util.List;

public class AlignmentState implements BoidState {

    @Override 
    public void applyBehavior(Boid boid, List<Boid> boids) {  // applyBehavior 메서드는 Boid의 상태를 결정하는 주요 동작을 수행
        
        Point avgVelocity = new Point(0, 0); // avgVelocity는 주어진 영역 내의 다른 Boid들의 속도의 평균을 계산
        int count = 0; // 다른 Boid들과의 거리가 VISION_RANGE 내에 있는 Boid들의 수를 셈

        for (Boid other : boids) {  // 모든 Boid들을 순회하면서, 각 Boid와의 거리가 VISION_RANGE 내에 있는지 확인
            // 자기 자신과 다른 Boid들만 고려 (다른 Boid와의 거리만 계산)
            if (!other.equals(boid) && boid.getPosition().distance(other.getPosition()) < Boid.VISION_RANGE) {
                // 다른 Boid의 속도를 평균 속도에 추가
                avgVelocity.translate(other.getVelocity().x, other.getVelocity().y);
                count++;  // 평균을 계산하기 위한 Boid들의 수를 셈
            }
        }

    
        if (count > 0) {    // 만약 count가 0보다 크면, 즉 다른 Boid들이 존재하고 그들의 속도를 고려한 평균을 계산했다면
            avgVelocity.x /= count;  // 평균 속도 계산
            avgVelocity.y /= count;

            // 현재 Boid의 속도와 평균 속도 차이를 보정하는 힘을 적용
            boid.applyForce(new Point(avgVelocity.x - boid.getVelocity().x, avgVelocity.y - boid.getVelocity().y));

            // Boid가 다른 Boid와 너무 가까워져서 분리해야 하는 경우 SeparationState로 상태 전환
            if (boid.getPosition().distance(boid.getPosition()) < Boid.SEPARATION_DISTANCE) {
                System.out.println("boid id = " + boid.getId() + " state = " + boid.getState() +  " changed to SeparationState");
                boid.setState(new SeparationState());  // SeparationState로 상태 변경
            }
        }
    }

    // 현재 상태의 이름을 반환하는 메서드, 디버깅 및 상태 추적에 사용
    @Override
    public String toString() {
        return "AlignmentState";  // 상태를 "AlignmentState"로 표시
    }
}
