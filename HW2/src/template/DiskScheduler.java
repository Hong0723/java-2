package template;


public class DiskScheduler {

    private SeekStrategy strategy; // Seek 전략을 저장하는 인터페이스. FCFS, SSTF, SCAN 등 여러 알고리즘이 이 인터페이스를 구현

    public DiskScheduler() {     // 기본 생성자
    } 

    public void setSeekStrategy(SeekStrategy strategy){ // 사용자가 원하는 디스크 탐색을 설정하는 메소드
        this.strategy = strategy; // SCAN, FCFS, SSTF, CSCAN 등으로 설정
    }

    public void executeSeek(int[] queue, int start){ // 탐색을 시작하는 메소드 
    
        strategy.seek(queue, start); // queue 는 탐색해야할 트랙의 순서가 들어있는 배열, start 는 탐색을 시작해야할 헤드의 초기위치 
    
    }
    
}
