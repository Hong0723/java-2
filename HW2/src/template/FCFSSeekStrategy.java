package template;

public class FCFSSeekStrategy implements SeekStrategy {
    @Override
    public void seek(int[] queue, int start){
        System.out.print("FCFS ");
        for( int q : queue){ // for-each 문을 사용해 queue에 있는 배열들을 q에 넣음
            System.out.printf("%d ", q ); // q에 있는 배열들 출력
        }
        System.out.printf("\n");
    }
}
