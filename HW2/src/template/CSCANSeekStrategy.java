package template; // Your Code
import java.util.*;
public class CSCANSeekStrategy implements SeekStrategy { 
   
    @Override
    public void seek(int[] queue, int start){
        Arrays.sort(queue); // 큐를 정렬
        
        int splitIndex = 0;  // 현재 위치보다 큰 값 중 최소 값이며 첫 번째로 방문해야 할 인덱스 
        while (splitIndex < queue.length && queue[splitIndex] < start) {
            splitIndex++;
        }
        
        System.out.print("C-SCAN ");
        
        
        for (int i = splitIndex; i < queue.length; i++) { // 큰방향인 오른쪽 부터 처리
            System.out.print(queue[i] + " ");
        }
        
       
        if (splitIndex < queue.length) { // 오른쪽 가장 끝인 199로 이동 후, 처음인 0으로 이동
            System.out.print("199 0 ");
        }
        
        
        for (int i = 0; i < splitIndex; i++) { // 처음부터 다시 오른쪽으로 처리
            System.out.print(queue[i] + " ");
        }
        
        System.out.println();
    }

    } 


