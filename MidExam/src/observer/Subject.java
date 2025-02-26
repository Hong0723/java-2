package observer;

import java.util.ArrayList;
import java.util.List;

// Subject 클래스: 옵저버 패턴의 주체로서, 여러 Observer에게 메시지를 전달하는 역할
public class Subject {
    private List<Observer> observers = new ArrayList<>(); // Observer 리스트

    // addObserver 메서드: Observer를 리스트에 추가
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // removeObserver 메서드: Observer를 리스트에서 제거
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // notifyObservers 메서드: 모든 Observer에게 메시지를 전달
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message); // 각 Observer의 update 메서드 호출
        }
    }
}
