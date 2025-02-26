package template;


public class BloodSugarObserver implements Observer { // Observer 인터페이스를 구현한 BloodSugarObserver클래스
    double bloodSugarThreshold;
    
    public BloodSugarObserver(double bloodSugarThreshold) { //bloodsugarthreshold 초기화
    this.bloodSugarThreshold = bloodSugarThreshold;
}


@Override
public void update(DailyHealthData d){
    if(d.getBloodSugarLevel() > bloodSugarThreshold) { // bloodsugarlevel 이 bloodsugarthreshold보다 높으면 alert문 출력
        System.out.println("Alert: Blood Sugar is too high  : " + d.getBloodSugarLevel());
    }
}
}