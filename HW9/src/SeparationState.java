import java.awt.Point;
import java.util.List;


public class SeparationState implements BoidState { // SeparationState 클래스는 보이드가 다른 보이드와 거리를 유지하도록 하는 상태를 정의
 

    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {     // 현재 상태에서의 행동을 정의하는 메서드
        Point steer = new Point(0, 0); // 방향 벡터
        int count = 0; // 가까운 보이드의 개수

        for (Boid other : boids) {   // 주변 보이드와의 거리 계산
            if (!other.equals(boid)) { // 자기 자신은 제외
                double distance = boid.getPosition().distance(other.getPosition()); // 다른 보이드와의 거리 계산
                if (distance > 0 && distance < Boid.SEPARATION_DISTANCE) { // 분리 거리 내에 있는 경우
                    Point diff = new Point(boid.getPosition().x - other.getPosition().x, boid.getPosition().y - other.getPosition().y);
                    // 거리에 반비례하여 방향 벡터를 계산
                    steer.translate(diff.x / (int) distance, diff.y / (int) distance);
                    count++;
                }
            }
        }

        if (count > 0) { // 가까운 보이드가 있는 경우
            steer.x /= count; // 방향 벡터의 평균 계산
            steer.y /= count;
            boid.applyForce(steer); // 계산된 힘을 보이드에 적용
        }
        
         // 가까운 보이드가 없으면 WanderState로 전환
         boolean tooFar = true;
         for (Boid other : boids) {
             if (!other.equals(boid)) {
                 double distance = boid.getPosition().distance(other.getPosition());
                 if (distance < Boid.SEPARATION_DISTANCE) {
                     tooFar = false;
                     break;
                 }
             }
         }
 
         if (tooFar) {
            System.out.println("boid id = " + boid.getId() + " state = " + boid.getState() + " changed to WanderState");
             boid.setState(new WanderState()); // 가까운 보이드가 없으면 WanderState로 전환
         }
    
    }

    @Override
    public String toString() {
        return "SeparationState";
    }
}
