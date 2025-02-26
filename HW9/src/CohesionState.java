import java.awt.Point;
import java.util.List;

public class CohesionState implements BoidState { // CohesionState 클래스는 보이드가 결집 행동을 수행하도록 하는 상태를 정의

    @Override 
    public void applyBehavior(Boid boid, List<Boid> boids){  // 현재 상태에서의 행동을 정의하는 메서드
        Point center = new Point(0, 0); // 주변 보이드들의 중심 위치
        int count = 0; // 중심 계산에 포함된 보이드 수

       
        for(Boid other : boids){  // 주변 보이드들의 위치를 탐색
            if(!other.equals(boid) && boid.getPosition().distance(other.getPosition()) < Boid.VISION_RANGE){
                // 시야 범위 내에 있는 다른 보이드의 위치를 중심 위치에 추가
                center.translate(other.getPosition().x, other.getPosition().y);
                count++;
            }
        }

        // 주변에 보이드가 있는 경우
        if (count > 0){
            center.x /= count; // 중심 x좌표 계산
            center.y /= count; // 중심 y좌표 계산
            
            // 현재 위치에서 중심 위치로 향하는 방향 계산
            Point direction = new Point(center.x - boid.getPosition().x, center.y - boid.getPosition().y);
            
           
            boid.applyForce(direction);   // 계산된 방향으로 힘을 적용

            // 보이드가 중심에 충분히 가까워지면 상태를 AlignmentState로 변경
            if (boid.getPosition().distance(center) < Boid.JOIN_THRESHOLD) {
                System.out.println("boid id = " + boid.getId() + " state = " + boid.getState() +  " changed to AlignmentState");
                boid.setState(new AlignmentState());
            }
        }
    }

    // 현재 상태를 문자열로 반환
    @Override
    public String toString(){
        return "CohesionState";
    }
}
