package kopo4;

public class ArrayLoop {
	public static void main(String[] args) {
		
		//월별 마지막날짜 배열 선언
		int [] iLMD = {31,28,31,30,31,30,31,31,30,31,30,31};
		for (int i = 1; i < 13; i++) { //1~12월 반복문 실행
			System.out.printf("%d월 =>", i); // 월 먼저 출력 후 일수 반복문 아래 실행
			for(int j = 1; j < 32; j++) { //1~31 까지 반복문 실행
				System.out.printf("%d",j); // 반복문의 일자 변수 카운트 되면서 출력됨
				
				//각 i월의 마지막날 수와 일자j가 같아질 때 (배열은 인덱스0부터 시작한다.)
				if (iLMD[i-1] == j) {
					break;
				}
				//break 하지 않고 카운트 되는 변수들은 숫자뒤에 콤마가 찍힌다.
				System.out.printf(", "); //마지막 숫자는 break 문 만나서 빠져나오므로 콤마 안찍힌다.
				
			}
			System.out.printf("\n"); // 일자루프 빠져나갈때마다 개행
		}
	}
}
