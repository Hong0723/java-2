package template;


public class SeekAlgorithm {

    // SCAN 알고리즘에서는 배열을 복사해서 정렬한 후에 start 위치가 정렬된 배열에서 어느 위치에 속하는지를 확인. 하드 디스크를 읽는 헤드가 현재 위치에서 0쪽으로 움직이고 있다고 가정하고 처리. 정렬된 큐에서 현재 위치보다 작은 요소들을 내림차순 순서대로 처리. 다음에는 큐에서 현재 위치보다 큰 요소들을 오름차순 순서대로 처리.
    public void seekBySCAN(int[] queue, int start) {
    }

    // CFS(First Come First Served 알고리즘은 **순차적으로** 큐에 있는 내용을 
    // 화면에 출력. 마지막에 줄바꿈 문자 출력.
    public void seekByFCFS(int[] queue, int start) {
    }

    // 현재 위치에서 가장 가까운 요소를 큐에서 찾아 처리. 큐에 있는 요소 중에서 어떤 것들이 처리되었는지 확인할 수 있도록 같은 크기의 boolean 배열을 생성하고 모두 false로 초기화. 큐에 있는 idx 위치의 요소가 처리되면 생성한 boolean 배열의 idx 위치의 요소값을 true로 치환. 가장 가까운 요소를 찾아서 처리한 후에 현재 위치를 다시 처리된 요소의 위치값으로 치환. 큐에서 현재 위치와 가장 가까운 요소를 찾아서 처리하는 작업을 반복.
    public void seekBySSTF(int[] queue, int start) {
    }

}
