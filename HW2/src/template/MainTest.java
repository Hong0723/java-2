package template;

public class MainTest {
    public MainTest() {
        int[] queue = { 70,  153,  24,  57,  140,  15,  115,  80, 85 };
        int start = 43;

        // seek
        DiskScheduler scheduler = new DiskScheduler(); // DiskScheduler 객체 생성
        SeekStrategy[] algorithms = { new SCANSeekStrategy() , new FCFSSeekStrategy()  , new SSTFSeekStrategy(), new CSCANSeekStrategy()  };
        for ( SeekStrategy algorithm : algorithms) {
            scheduler.setSeekStrategy(algorithm);
            scheduler.executeSeek(queue.clone(), start); // 원본 queue 를 건드리지 않기위해 clone() 을 사용

        }
        
    } 
}
