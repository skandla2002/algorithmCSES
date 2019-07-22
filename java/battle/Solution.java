package battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int Min;
	static int[] Result;


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++){
			st = new StringTokenizer(br.readLine());
			Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Point p3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			
			System.out.println(ccw(p1, p2, p3));
			
		}
	}
	
	static int ccw(Point p1, Point p2, Point p3){
		long tmp = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
		if(tmp < 0) return -1;
		else if(tmp > 0) return 1;
		else return 0;
	}

}

class Point{
	long x;
	long y;
	
	Point(long x, long y){
		this.x = x;
		this.y = y;
	}
}