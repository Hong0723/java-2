package template;
// observer 인터페이스를 구현
public class InsulinObserver implements Observer {
    double InsulinThreshold;
    // 인슐린 임계값
    public InsulinObserver(double InsulinThreshold) {
        this.InsulinThreshold = InsulinThreshold;
    }
    // 임계값보다 높으면 Alert출력
    public void update(DailyHealthData d) {
        if(d.getInsulinDose() > InsulinThreshold) {
            System.out.println("Alert: Insulin dose is too high : " + d.getInsulinDose());
        }
    }
}
