package cover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static Hull list[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new Hull[N+1];
		for(int i = 0 ; i <= N ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[i] = new Hull(a, b);
		}
		
		// 1. 기준점 산정
		for(int i = 1 ; i <= N ; i++){
			if(list[1].y > list[i].y || list[1].y == list[i].y && list[1].x > list[i].x){
				Hull temp = list[1];
				list[1] = list[i];
				list[i] = temp;
			}
		}
		
		//2. 기준점 기준으로 반시계방향으로 정렬
		Arrays.sort(list, 2, N+1 , new Comparator<Hull>(){
			public int compare(Hull a, Hull b){
				int v = ccw(new Hull(list[1].x, list[1].y), a, b);
				if( v > 0) return -1;
				if(v <0) return 1;
				return (Math.abs(a.x) + a.y) - (Math.abs(b.x) + b.y);
			}
		});
		
		// 3. stack
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		for(int i = 2; i <= N ; i++){
			while(stack.size() > 1 && ccw(list[stack.get(stack.size()-2)], list[stack.peek()], list[i]) <=0 ){
				stack.pop();
			}
			stack.add(i);
		}
		bw.write(stack.size() + "\n");;
		bw.flush();
	}

	protected static int ccw(Hull A, Hull B, Hull C){
		long cal = 0;
		cal = (long)(B.x - A.x) * (C.y - A.y) - (long)(C.x - A.x) * (B.y - A.y);
		if(cal > 0) return 1;
		else if (cal< 0) return -1;
		else return 0;
	}
}


class Hull{
	int x, y;
	Hull(int x , int y){
		this.x = x;
		this.y = y;
	}
}

