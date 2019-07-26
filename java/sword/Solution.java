package sword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	public static int N;
	public static int H;
	public static int L;
	public static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:/Developer/Source/SWTest/src/sword/sample_input.txt");
		BufferedReader br = new BufferedReader(fr);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int HSquare = 0;
		int LSquare = 0;
		
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			double[][] initPos = new double[N][5];
			double tempData = 0;
			
			for(int i = 0; i< N; i++){
				st = new StringTokenizer(br.readLine()); 
				initPos[i][0] = Integer.parseInt(st.nextToken());
				initPos[i][1] = Integer.parseInt(st.nextToken());
				initPos[i][4] = i;
			}
			
			if( N < 1 || N > 5000){
				// 오류
			} else if(L <= H){
				
			} else if(L < 1 || L > 30000){
				
			} else if(H < 1 || H > 30000){
				
			} else {
				HSquare = H^2;
				LSquare = L^2;
				for(int j = 0 ; j < N ; j++){
					tempData = distSquare(initPos[j][0], initPos[j][1]);
					if(tempData < HSquare){
						initPos[j][0] = 0;
						initPos[j][1] = 0;
						continue;
					}
					if(tempData < LSquare){
						initPos[j][0] = 0;
						initPos[j][1] = 0;
						continue;
					}
				}
				
				int tempSeq = 0;
				for(int k =0; k < N ; k++){
					if(initPos[k][0] == 0 && initPos[k][1] == 0){
						initPos[k][2] = -1;
						initPos[k][3] = 0;
					}else {
						initPos[k][2] = checkAng(0.0, 0.0, initPos[k][0], initPos[k][1]);
						initPos[k][3] = ++tempSeq;
					}
				}
				
				Arrays.sort(initPos, new Comparator<double[]>(){
					@Override
					public int compare(double[] one, double[] two){
						return (one[2] - two[2]) > 0 ? 1 : (one[2] - two[2]) == 0 ? 0 : -1;
					}
				});
				
				int tempSequ1 = 1;
				int tempSequ2 = 1;
				
				for(int i = 0; i< N ; i++){
					if(initPos[i][2] == -1){
						initPos[i][3] = 0;
					}else{
						if(i == 0 ){
							initPos[i][3] = tempSequ1;
						}else {
							if(i == 0){
								initPos[i][3] = tempSequ1;
							}else{
								if(initPos[i - 1][2] == initPos[i][2]){
									initPos[i][3] = tempSequ1;
								}else{
									tempSequ1 = tempSequ2;
									initPos[i][3] = tempSequ1;
								}
							}
							tempSequ2++;
						}
					}
				}
				
				Arrays.sort(initPos, new Comparator<double[]>(){
					public int compare(double[] one, double[] two){
						return Integer.compare((int)one[4], (int) two[4]); 
					}
				});
				
				System.out.print("#" + test_case + " ");
				for(int i = 0 ; i < initPos.length ; i++){
					System.out.print((int)initPos[i][3] + " ");
				}
			}
		}
		
	}
	private static double checkAng(double d, double e, double f, double g) {
		// TODO Auto-generated method stub
		return 0;
	}
	private static double distSquare(double d, double e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
