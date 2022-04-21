package ticketing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Writer_CSV {
	Reader_CSV reader_CSV;

	void make_CSV_raw(String data) { //scanner로 받은대로 CSV 생성
		File csv = new File("C:\\project\\ticket_list_raw.csv");
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(csv, true));
			bw.write(data);
			bw.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	void make_CSV(String data) { //주문내역 그대로 CSV 생성
		File csv = new File("C:\\project\\ticket_list.csv");
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(csv, true));
			bw.write(data);
			bw.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	void make_CSV_ticket_type(String data) {//티켓 타입별로 CSV 생성
		File csv = new File("C:\\project\\ticket_list_ticket_type.csv");
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(csv, true));
			bw.write(data);
			bw.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	String csv_total_order_discount(Order_data data_variable, ArrayList<Order_data> make_list, int roundOfOrder) {
		String result = "";
		// 할인 티켓 출력
				result = (make_list.get(roundOfOrder).orderdate) + ",";
				
				switch (make_list.get(roundOfOrder).getTicket()) {
				case 1:
					result = result + "종합이용권" + ",";
					break;
				case 2:
					result = result + "파크이용권" + ",";
					break;
				}
				switch (make_list.get(roundOfOrder).getDayTicket()) {
				case 1:
					result = result + "1DAY"+",";
					break;
				case 2:
					result = result + "AFTER4"+ ",";
					break;
				}
				switch (make_list.get(roundOfOrder).getGeneration()) {
				case 1:
					result = result + "신생아"+ ",";
					break;
				case 2:
					result = result + "영유아"+",";
					break;
				case 3:
					result = result + "어린이" + ",";
					break;
				case 4:
					result = result + "청소년" + ",";
					break;
				case 5:
					result = result + "성인" + ",";
					break;
				case 6:
					result = result + "만67이상" + ",";
					break;
				}
				
				result = result + make_list.get(roundOfOrder).getDisNum() + "," + make_list.get(roundOfOrder).getTotalDiscountPrice() + ",";

				switch (make_list.get(roundOfOrder).getAdvantage()) {
				case 2:
					result = result + "장애인 우대적용";
					break;
				case 3:
					result = result + "국가유공자 우대적용";
					break;
				case 4:
					result = result + "휴가장병 우대적용";
					break;
				case 5:
					result = result + "임산부 우대적용";
					break;
				case 6:
					result = result + "다둥이 우대적용";
					break;
				}
		return result;
		} 
	String csv_total_order_nondiscount(Order_data data_variable, ArrayList<Order_data> make_list, int roundOfOrder) {
		String result = "";
		// 비할인 티켓 출력				
				result = (make_list.get(roundOfOrder).orderdate) + ",";

				switch (make_list.get(roundOfOrder).getTicket()) {
				case 1:
					result = result + "종합이용권" + ",";
					break;
				case 2:
					result = result + "파크이용권" + ",";
					break;
				}
				switch (make_list.get(roundOfOrder).getDayTicket()) {
				case 1:
					result = result + "1DAY"+",";
					break;
				case 2:
					result = result + "AFTER4"+ ",";
					break;
				}
				switch (make_list.get(roundOfOrder).getGeneration()) {
				case 1:
					result = result + "신생아"+ ",";
					break;
				case 2:
					result = result + "영유아"+",";
					break;
				case 3:
					result = result + "어린이" + ",";
					break;
				case 4:
					result = result + "청소년" + ",";
					break;
				case 5:
					result = result + "성인" + ",";
					break;
				case 6:
					result = result + "만67이상" + ",";
					break;
				}
				result = result + make_list.get(roundOfOrder).getNum() + "," + make_list.get(roundOfOrder).getTotalPrice() + ",";
				
				switch (make_list.get(roundOfOrder).getDisAdvantage()) {
				case 1:
					result = result + "할인 미적용";
					break;
				case 2:
					result = result + "할인 미적용";
					break;
				case 3:
					result = result + "할인 미적용";
					break;
				case 4:
					result = result + "할인 미적용";
					break;
				case 5:
					result = result +  "할인 미적용";
					break;
				case 6:
					result = result + "할인 미적용";
					break;
				}
		return result;
	} 
	
	String raw_csv_total_order_discount(Order_data data_variable, ArrayList<Order_data> make_list, int roundOfOrder) { //csv 인덱스값 넣기
		String result = "";
		// 할인 티켓 출력
		if (make_list.get(roundOfOrder).getDisNum() >= 1) {
			result = (make_list.get(roundOfOrder).orderdate) + "," + (make_list.get(roundOfOrder).getTicket()) + "," + (make_list.get(roundOfOrder).getDayTicket()) + ","
					+ (make_list.get(roundOfOrder).getGeneration()) + ","+ make_list.get(roundOfOrder).getDisNum() + "," + make_list.get(roundOfOrder).getTotalDiscountPrice() + ","
					+ (make_list.get(roundOfOrder).getAdvantage());
		}
		return result;
	} 
	
	String raw_csv_total_order_nondiscount(Order_data data_variable, ArrayList<Order_data> make_list, int roundOfOrder) { //csv 인덱스값 넣기
		String result = "";
		// 비할인 티켓 출력
		if (make_list.get(roundOfOrder).getNum() >= 1) {
			result = (make_list.get(roundOfOrder).orderdate) + "," + (make_list.get(roundOfOrder).getTicket()) + "," + (make_list.get(roundOfOrder).getDayTicket()) + ","
					+ (make_list.get(roundOfOrder).getGeneration()) + ","+ make_list.get(roundOfOrder).getNum() + "," + make_list.get(roundOfOrder).getTotalPrice() + ","
					+ (make_list.get(roundOfOrder).getDisAdvantage());
		}
		return result;
	} 
	
	void csv_loop (Order_data data_variable, ArrayList<Order_data> make_list) {//csv 텍스트로 만들기
		System.out.printf("***프로그램을 종료 합니다. 발권 확인 부탁드립니다. 즐거운 시간 되세요.***\n");		
			make_CSV(data_variable.menu);

		for (int roundOfOrder = 0; roundOfOrder < make_list.size(); roundOfOrder++) {
			if (make_list.get(roundOfOrder).getDisNum() >= 1) {
				make_CSV(csv_total_order_discount(data_variable, make_list, roundOfOrder));// 할인 정보 추출				
			}
			if (make_list.get(roundOfOrder).getNum() >= 1) {
				make_CSV(csv_total_order_nondiscount(data_variable, make_list, roundOfOrder));// 비 할인 정보 추출				
			}
		}
	}
	
	void csv_loop_raw_data (Order_data data_variable, ArrayList<Order_data> make_list) {//csv 기본 값 만들기
		make_CSV_raw(data_variable.menu);
		
		for (int roundOfOrder = 0; roundOfOrder < make_list.size(); roundOfOrder++) {
			if (make_list.get(roundOfOrder).getDisNum() >= 1) {
				make_CSV_raw(raw_csv_total_order_discount(data_variable, make_list, roundOfOrder));// 할인 정보 추출
			}
			if (make_list.get(roundOfOrder).getNum() >= 1) {
				make_CSV_raw(raw_csv_total_order_nondiscount(data_variable, make_list, roundOfOrder));// 비 할인 정보 추출				
			}
		}
	}		
}
