package template;
import java.util.*;
public class SCANSeekStrategy implements SeekStrategy {
    @Override
    public void seek(int[] queue, int start){
        Arrays.sort(queue); // 큐를 정렬하여 방향성을 유지
    
    int splitIndex = 0; // 첫 번째로 방문해야 할 인덱스 (현재 위치보다 작은 값 중 최대 값)
    while (splitIndex < queue.length && queue[splitIndex] < start) {
        splitIndex++;
    }
    
    System.out.print("SCAN ");
    
        for (int i = splitIndex - 1; i >= 0; i--) { // 작은 방향인 왼쪽으로 처리
        System.out.print(queue[i] + " ");
    }
    
    
    if (splitIndex > 0) { // 왼쪽 가장 끝인 0으로 이동
        System.out.print("0 ");
    }
    

    for (int i = splitIndex; i < queue.length; i++) { // 큰 방향인 오른쪽으로 처리
        System.out.print(queue[i] + " ");
    }
    
    System.out.println(); 
}
}