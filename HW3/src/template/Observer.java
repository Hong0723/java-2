package template;

//옵저버 패턴에 사용되는 인터페이스. 객체 갱신될 때 호출되는 update메소드 정의
public interface Observer {
    void update(DailyHealthData d);
}
