package template;


public class SSTFSeekStrategy implements SeekStrategy {
    @Override
    public void seek(int[] queue, int start) {
        boolean[] visited = new boolean[queue.length]; // 트랙 방문 여부 확인
        int currentPosition = start;  // 현재 헤드 위치
        
    
        System.out.print("SSTF " );
    
        for (int i = 0; i < queue.length; i++) {
            int closestTrackIndex = -1;
            int minSeekTime = Integer.MAX_VALUE;
    
            
            for (int j = 0; j < queue.length; j++) { // 아직 방문하지 않은 트랙 중에서 가장 가까운 트랙을 찾음
                if (!visited[j]) {
                    int seekTime = Math.abs(currentPosition - queue[j]);
                    if (seekTime < minSeekTime) {
                        minSeekTime = seekTime;
                        closestTrackIndex = j;
                    }
                }
            }
    
            
            visited[closestTrackIndex] = true; // 가장 가까운 트랙 방문
            currentPosition = queue[closestTrackIndex];
    
            
            System.out.print(currentPosition + " " );
        }
    
        System.out.println();
    }
    
        
        

        /* for( int q : queue){
            System.out.printf("%d ", q ); // q에 있는 배열들 출력
        }
        System.out.printf("\n"); */







    
}

 
