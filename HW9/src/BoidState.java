import java.util.List;

public interface BoidState {
    void applyBehavior(Boid boid, List<Boid> boids);
}
