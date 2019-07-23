package battle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int Min;
	static int[] Result;
	static Point[][] Temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:/Developer/Source/SWTest/src/battle/input.txt");
		BufferedReader br = new BufferedReader(fr);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++){
			N = Integer.parseInt(br.readLine());
			Result = new int[N]; 
			Temp = new Point[N][2];
			for(int j = 0 ; j < N ; j++){
				st = new StringTokenizer(br.readLine());
				Temp[j][0] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
				Temp[j][1] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
				System.out.println(Temp[j][0].x + " " + Temp[j][0].y + " " + Temp[j][1].x + " " + Temp[j][1].y);
			}
			
			// 시간내 처리 방식 확인
			for(int Min = 0 ; Min < 31; Min++){
				for(int k = 0 ; k < N ; k ++ ){
					int ccwResult = ccw(Temp[k][0], Temp[k][1], Temp[k+1][0]);
					if (ccwResult == 0){
						
					}
				}
			}
			
			
//			System.out.println(ccw(p1, p2, p3));
			
			
			// 결과 출력
			System.out.println("#" + (i + 1) + makeInt(Result));
		}
		
	}
	
	static int ccw(Point p1, Point p2, Point p3){
		long tmp = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
		if(tmp > 0) return 1;
		else if(tmp < 0) return -1;
		else return 0;
	}
	
//	static int ccw(Point p1, Point p2, Point p3){
//		long tmp = (p1.x1 * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
//		if(tmp < 0) return -1;
//		else if(tmp > 0) return 1;
//		else return 0;
//	}
	
	static String makeInt(int[] Result){
		String resultStr = "";
		for(int i = 0 , len = Result.length ; i < len ; i++){
			resultStr = resultStr + " " + Result[i];
		}
		return resultStr;
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