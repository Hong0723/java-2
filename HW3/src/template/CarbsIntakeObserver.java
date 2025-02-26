package template;

public class CarbsIntakeObserver implements Observer {  // Observer 인터페이스를 구현한 CarbsIntakeObserver클래스
        double CarbsIntakeThreshold;
    
    public CarbsIntakeObserver(double CarbsIntakeThreshold ) { // carbsintakethreshold를 초기화하는 생성자
        this.CarbsIntakeThreshold = CarbsIntakeThreshold;
    }
    
    public void update(DailyHealthData d) { // getcarbsintake가 carbsintakethreshold 보다 높으면 alert문 출력
        if(d.getCarbsIntake() > CarbsIntakeThreshold) {
            System.out.println("Alert: Carb intake is too high : " + d.getCarbsIntake());
        }
    }


}
