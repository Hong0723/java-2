package template;
import java.util.ArrayList;
import java.util.List;

public class DiabetesManager implements Subject { // subject 인터페이스를 구현, 옵저버 패턴을 사용
    
    private List<Observer> Observers; // 옵저버 리스트와 하루건강 데이터를 멤버변수로 정의
    private DailyHealthData d;

    
    public DiabetesManager() {
        this.Observers = new ArrayList<>();
        this.d = null;
    }
    
    public void addDailyHealthData(DailyHealthData d) { //DailyHealthData를 추가하고 옵저버들에게 알려줌
        this.d = d;
        notifyObservers();
    }
    
    public void addObserver(Observer o) { //옵저버를 리스트에 추가
        Observers.add(o);
    }
   
    public void removeObserver(Observer o) {  // 옵저버를 리스트에서 제거함
        Observers.remove(o);
    }
    
    public void notifyObservers() { // DailyHealthData 객체 모든 옵저버에게 알려줌
        for (Observer observer : Observers) {
            observer.update(this.d);
    }
    }
    public void setDailyHealthData(DailyHealthData d) {   // DailyHealthData를 설정하고 옵저버에게 알려줌
        this.d = d;
        notifyObservers();
    }
    
    public DailyHealthData getDailyHealthData() { // 현재 DailyHealthData를 반환
        return d;
    }
}
