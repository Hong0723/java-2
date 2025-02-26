import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

// Boid 클래스는 보이드를 정의
public class Boid {
    public static final int SPEED = 3; // 보이드의 최대 속도
    public static final int SEPARATION_DISTANCE = 20; // 분리 거리
    public static final int VISION_RANGE = 50; // 주변 시야 범위
    public static final int JOIN_THRESHOLD = 15; // 합류 기준 거리

    private static int count = 0; // 보이드 ID를 부여하기 위한 static 카운터
    private Point position; // 현재 보이드의 위치
    private Point velocity; // 현재 보이드의 속도
    private int panelWidth; // 패널의 너비
    private int panelHeight; // 패널의 높이
    private BoidState state; // 보이드의 현재 상태
    private int id; // 보이드의 고유 ID
    private Random random; // 난수 생성기

    // 생성자: 보이드를 초기화하고 화면 크기에 따라 임의의 위치와 속도를 설정
    public Boid(int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.random = new Random();
        position = new Point(random.nextInt(panelWidth), random.nextInt(panelHeight));
        velocity = new Point(random.nextInt(2 * SPEED) - SPEED, random.nextInt(2 * SPEED) - SPEED);
        this.id = ++count;
        this.state = new WanderState(); // 초기 상태를 WanderState로 설정
    }

    // 군집 행동 메서드: 분리, 정렬, 결집 힘을 계산하고 속도에 적용
    public void flock(List<Boid> boids) {
        Point separation = separate(boids); // 분리 행동 계산
        Point alignment = align(boids); // 정렬 행동 계산
        Point cohesion = cohere(boids); // 결집 행동 계산

        // 힘을 가중치에 따라 합산
        velocity.translate((int)(separation.x * 1.5 + alignment.x * 1.0 + cohesion.x * 1.0),
                           (int)(separation.y * 1.5 + alignment.y * 1.0 + cohesion.y * 1.0));
                           limitSpeed();
    }

    // 분리 행동: 가까운 보이드와 거리 두기
    private Point separate(List<Boid> boids) {
        Point steer = new Point(0, 0); // 방향 벡터
        int count = 0;

        for (Boid other : boids) {
            int distance = (int) position.distance(other.position); // 다른 보이드와의 거리 계산
            if (other != this && distance > 0 && distance < SEPARATION_DISTANCE) {
                Point diff = new Point(position.x - other.position.x, position.y - other.position.y);
                steer.translate(diff.x / distance, diff.y / distance);
                count++;
            }
        }

        if (count > 0) {
            steer.x /= count; // 평균화
            steer.y /= count;
        }
        return steer;
    }

    private Point align(List<Boid> boids) {
        Point avgVelocity = new Point(0, 0); // 평균 속도
        int count = 0;
    
        for (Boid other : boids) {
            // 자기 자신을 제외하고 주변 보이드들과 거리 비교
            if (other != this && position.distance(other.position) < VISION_RANGE) {
                avgVelocity.translate(other.velocity.x, other.velocity.y);
                count++;
            }
        }
    
        // 주변 보이드가 있으면 평균 속도 계산
        if (count > 0) {
            avgVelocity.x /= count; // 평균화
            avgVelocity.y /= count;
            avgVelocity.translate(-velocity.x, -velocity.y); // 현재 속도와의 차이 계산
        }
    
        // 속도 제한
        double magnitude = Math.sqrt(avgVelocity.x * avgVelocity.x + avgVelocity.y * avgVelocity.y);
        if (magnitude > SPEED) {
            avgVelocity.x = (int)(avgVelocity.x / magnitude * SPEED);
            avgVelocity.y = (int)(avgVelocity.y / magnitude * SPEED);
        }
    
        return avgVelocity;
    }
    

    // 결집 행동: 주변 보이드의 중심으로 이동
    private Point cohere(List<Boid> boids) {
        Point center = new Point(0, 0); // 주변 보이드의 중심점
        int count = 0;

        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < VISION_RANGE) {
                center.translate(other.position.x, other.position.y);
                count++;
            }
        }

        if (count > 0) {
            center.x /= count; // 평균화
            center.y /= count;
            center.translate(-position.x, -position.y); // 현재 위치와의 차이 계산
        }
        return center;
    }

    // 외부에서 가한 힘을 속도에 추가
    public void applyForce(Point force) {
        velocity.translate(force.x, force.y);
    }

 

    // 속도 제한: 보이드의 속도를 SPEED로 제한
    private void limitSpeed() {
        double magnitude = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y); // 속도의 크기 계산
        if (magnitude > SPEED) {
            velocity.x = (int) ((velocity.x / magnitude) * SPEED);
            velocity.y = (int) ((velocity.y / magnitude) * SPEED);
        }
    }

    // 보이드의 위치와 상태를 업데이트
    public void update(List<Boid> boids) {
        if(state != null){
            state.applyBehavior(this, boids); // 현재 상태에 따라 행동 수행
        }
        position.translate(velocity.x, velocity.y); // 위치 갱신
        // 화면 가장자리에서 반대쪽으로 이동
        if (position.x < 0) position.x = panelWidth;
        else if (position.x > panelWidth) position.x = 0;
        if (position.y < 0) position.y = panelHeight;
        else if (position.y > panelHeight) position.y = 0;
    }

    // 보이드를 삼각형 형태로 그리기
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
   
        double angle = Math.atan2(velocity.y, velocity.x); // 속도의 방향 계산
        
        g2d.translate(position.x, position.y);
        g2d.rotate(angle);

        int[] xPoints = {0, -10, -10}; // 삼각형 x 좌표
        int[] yPoints = {0, -5, 5}; // 삼각형 y 좌표
        g2d.setColor(Color.BLUE); // 보이드 색상 설정
        g2d.fillPolygon(xPoints, yPoints, 3); // 삼각형 그리기

        g2d.rotate(-angle);
        g2d.translate(-position.x, -position.y);
    }

    // 목표 상태를 설정하는 메서드 (타겟 지점을 설정)
    public void moveToTarget(Point target){
        this.state = new TargetState(target);
    }
    
    // 보이드의 위치를 반환
    public Point getPosition() {
         return position; 
    }

    // 속도를 설정
    public void setVelocity(Point velocity){
        this.velocity = velocity;
    }

    // 현재 속도를 반환
    public Point getVelocity() {
        return velocity ;
    }

    // 목표 지점에 도달했는지 체크
    public boolean hasReachedTarget(Point target) {
        double distance = position.distance(target);
        return distance < SEPARATION_DISTANCE; // 목표 지점과의 거리가 SEPARATION_DISTANCE보다 작으면 도달
    }
   
    // 현재 상태를 설정
    public void setState(BoidState state) {
        this.state = state ;
    }

    // 현재 상태를 반환
    public BoidState getState() {
        return state;
    }

    // 보이드 ID를 반환
    public int getId() {
        return id;
    }

       // 주어진 보이드 리스트에서 가장 가까운 보이드와의 거리를 반환하는 메서드
       public double distanceToNearestBoid(List<Boid> boids) {
        double minDistance = Double.MAX_VALUE; // 초기 최소 거리는 매우 큰 값

        for (Boid other : boids) {
            if (!other.equals(this)) { // 자기 자신은 제외
                double distance = this.position.distance(other.getPosition());
                if (distance < minDistance) {
                    minDistance = distance; // 가장 가까운 보이드와의 거리 갱신
                }
            }
        }

        return minDistance; // 가장 가까운 보이드와의 거리 반환
    }

    @Override
    public String toString() {
        return "{" +
            " position='" + getPosition() + "'" +
            ", velocity='" + getVelocity() + "'" +
            ", state='" + getState() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }
}
