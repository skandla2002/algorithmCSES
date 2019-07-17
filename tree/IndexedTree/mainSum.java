

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

public class mainSum {
    static int N; // 숫자 개수
    static int M; // 변경 횟수
    static int K; // 구간합을 구하는 횟수

    static long[] tree; // 실제 트리
    static long[] lazy; // 계산 안한 레이지 트리
    
    static int k;
    static int treeSize; // 크기는 2^k
    static int startIdx; // 리프 노드의 시작 인덱스

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // map 계수 구하기
        k = 0;
        while(N > Math.pow(2, k++)){}
        treeSize = (int)Math.pow(2,k);
        tree = new long[treeSize];
        lazy = new long[treeSize];
        startIdx = treeSize/2;

        // 숫자 입력받음
        for(int i = 0; i < N;i++){
            int a = Integer.parseInt(br.readLine());
            tree[startIdx + i] = a;
        }

        // 트리 채우기
        fillTree(K);

        // 변경 및 부분합 구하기
        for(int i = 0; i < M + k ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 업데이트
            if(a == 1){
                update( b, c); // b번째를 c로바꾼다.
            }

            // 합구하기
            if(a == 2) System.out.println(sum(1, b,c, 1, (int)Math.pow(2, k-1)));
        }
    }

    static void print(){
        for(long t : tree){
            System.out.printf("%d", t);;
        }
    }

    /**
     * @param idx 현재 위치
     * @param left 구하려고 하는 구간의 시작
     * @param right 구하려고 하는 구간의 끝
     * @param start 현재 위치 노드 자손 리프노드의 시작
     * @param start 현재 위치 노드 자손 리프노드의 끝
     * @return
     */

    static long sum(int idx, int left, int right, int start, int end){

    	update_lazy(idx, start, end);
    	
        // 현재구간이 구하려는 구간 바깥
        if(end < left || right < start){
            return 0;
        }

        // 현재 구간이 구하려는 구간의 한쪽
        if(left <= start && end <= right){
            return tree[idx];
        }
        int mid = (start + end) / 2;

        // 현재 구간과 구하려는 구간이 겹침
        return sum(idx*2, left, right, start, mid) +
                sum(idx*2 + 1, left, right, mid + 1, end);
    }

    /**
     * @param idx 번째 수를
     * @param num 으로 교체
     */

    static void update(int idx, int num){
        long delta = num - tree[startIdx + idx -1];
        int updateIdx = startIdx + idx -1;
        
        while(0<updateIdx){
            tree[updateIdx] += delta;
            updateIdx /= 2;
        }
    }
    
    static void update_range(int idx, int start, int end, int left, int right, int diff){
    	update_lazy(idx, start, end);
    	if (end < left || right < start) return;
        if (left <= start && start <= right) {
            tree[idx] += (end - start + 1) * diff;
            if (start != end) {
                lazy[idx * 2] += diff;
                lazy[idx * 2 + 1] += diff;
            }
            return;
        }
        int mid = (start + end) / 2;
        update_range(idx * 2, start, mid, left, right, diff);
        update_range(idx * 2 + 1, mid + 1, end, left, right, diff);
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }
    
    static long init(int idx, int start, int end){
    	if(start == end) return tree[idx] = lazy[start];
    	int mid = (start + end) /2;
    	return tree[idx] = init(idx * 2, start, mid) + init(idx * 2 + 1, mid + 1, end);
    }

    static long fillTree(int index){
        if(index < treeSize/2) return tree[index] = fillTree(index*2) + fillTree(index*2 + 1);
        else return tree[index];
    }
    
    /**
     * @param idx 현재 위치
     * @param start 현재 위치 노드 자손 리프노드의 시작
     * @param start 현재 위치 노드 자손 리프노드의 끝
     * @return
     */
    static void update_lazy(int idx, int start, int end){
    	if(lazy[idx] != 0){
    		tree[idx] += (end - start+1) * lazy[idx];
    		if(start != end){
    			lazy[idx * 2] += lazy[idx];
    			lazy[idx * 2 + 1] += lazy[idx];
    		}
    		lazy[idx] = 0;
    	}
    }
    

}
