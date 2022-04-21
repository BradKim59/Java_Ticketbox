package ticketing;

import java.util.Scanner;

public class Input_order {

	int check_ticket_type(Order_data data_variable) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("권종을 선택 하세요.\n1. 종합이용권\n2. 파크이용권\n->");
		do {
			data_variable.setTicket(sc.nextInt());
			switch (data_variable.getTicket()) {
				case 1: case 2:
					System.out.printf("\n");
					break;
				default :
					System.out.printf("\n");
					System.out.printf("항목 1이나 2를 눌러주세요.\n1. 종합이용권\n2. 파크이용권\n->");
			}		
		} while (data_variable.getTicket()!=1 && data_variable.getTicket()!=2); 
		return data_variable.getTicket();
	}

	int check_day_type(Order_data data_variable) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("이용시간을 선택 하세요.\n1. 1일권 \n2. AFTER4(16시 이후) \n->");
		do{
			data_variable.setDayTicket(sc.nextInt());
			switch (data_variable.getDayTicket()) {
				case 1: case 2:
					System.out.printf("\n");
					break;
				default :
					System.out.printf("\n");
					System.out.printf("항목 1이나 2를 눌러주세요.\n1. 1일권 \n2. AFTER4(16시 이후) \n->");
					break;
			}
		}while (data_variable.getDayTicket()!=1 && data_variable.getDayTicket()!=2);
		return data_variable.getDayTicket();
	}

	int check_person_ID(Order_data data_variable) {
		Scanner sc = new Scanner(System.in);
		do{
			System.out.printf("주민번호13자리를 입력하세요\n->");
			data_variable.setPersonID(sc.next());
			System.out.printf("\n");
			//만나이 및 성별 확인 
			data_variable.setYear(Integer.parseInt(data_variable.getPersonID().substring(0,2)));
			data_variable.setMonth(Integer.parseInt(data_variable.getPersonID().substring(2,4)));
			data_variable.setDate(Integer.parseInt(data_variable.getPersonID().substring(4,6)));
			data_variable.setGender(Integer.parseInt(data_variable.getPersonID().substring(6,7)));
			if (data_variable.getYear() < data_variable.getCurrent_year()%100) {
				data_variable.setFour_digit_year(data_variable.getYear()+2000);
			} else {
				data_variable.setFour_digit_year(data_variable.getYear()+1900);
			}
			
			//주민번호 오류 캐치
			if (data_variable.getPersonID().length() != 13) {
				System.out.printf("주민등록번호는 13자리 입니다.\n");
			} 
			if (data_variable.getYear() > data_variable.getCurrent_year()%100 && data_variable.getYear() < data_variable.getCurrent_year()%100+18 ) {
				System.out.printf("출생년도 확인 해 주세요.\n");
			}
			if (data_variable.getMonth() < 1 || data_variable.getMonth() > data_variable.getLastday_M()) {
				System.out.printf("출생월 다시 확인 해 주세요.\n");
			}
			if (data_variable.getFour_digit_year() % 4 == 0 && data_variable.getFour_digit_year() % 100 != 0 || data_variable.getFour_digit_year()%400 == 0) {
				data_variable.setLun_Date(data_variable.getDate());
				if (data_variable.getLun_Date() < 1 || data_variable.getLun_Date() > Static_data.MONTH_LUN[data_variable.getMonth()-1]) {
					System.out.printf("출생일 다시 확인 해 주세요.\n");
				}
			} else {
				data_variable.setNor_Date(data_variable.getDate());
				if (data_variable.getNor_Date() < 1 || data_variable.getNor_Date() > Static_data.MONTH_NOR[data_variable.getMonth()-1]) {
					System.out.printf("출생일 다시 확인 해 주세요.\n");
				}				
			}
			if (data_variable.getGender()  < 1 && data_variable.getGender() > 4) {
				System.out.printf("성별코드 다시 확인 해 주세요.\n");
			}
		} while ((data_variable.getMonth() < 1 || data_variable.getMonth() > 12) 
				|| (data_variable.getLun_Date() < 1 || data_variable.getLun_Date() > Static_data.MONTH_LUN[data_variable.getMonth()-1]) 
				&& (data_variable.getNor_Date() < 1 || data_variable.getNor_Date() > Static_data.MONTH_NOR[data_variable.getMonth()-1]) 
				|| (data_variable.getGender()  <1 || data_variable.getGender() > 4) 
				|| (data_variable.getPersonID().length() != 13) 
				|| (data_variable.getYear() > data_variable.getCurrent_year()%100 && data_variable.getYear() < data_variable.getCurrent_year()%100+18));
		return data_variable.getGender();
	}
	
	int check_ticket_QTY(Order_data data_variable) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n->");
		do{
			data_variable.setQty(sc.nextInt());
			System.out.printf("\n");
			if (data_variable.getQty() > Static_data.MAX_COUNT || data_variable.getQty() < Static_data.MIN_COUNT) {
				System.out.printf("다시 주문해 주세요 (1개이상, 최대 10개)\n->");
			}
		} while(data_variable.getQty() > Static_data.MAX_COUNT || data_variable.getQty() < Static_data.MIN_COUNT);
		return data_variable.getQty();
	}

	int check_benefit(Order_data data_variable) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("우대사항을 선택하세요\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n->");
		do {
			data_variable.setAdvantage(sc.nextInt());
			switch (data_variable.getAdvantage()) {
			case 1: case 2: case 3: case 4: case 5: case 6:
				System.out.printf("\n");
				break;
			default :
				System.out.printf("\n아래 항목에 해당하는 번호를 다시 눌러주세요.\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n->");
				break;
			} 		
		} while(data_variable.getAdvantage()!=1 && data_variable.getAdvantage()!=2 && data_variable.getAdvantage()!=3 && data_variable.getAdvantage()!=4 && data_variable.getAdvantage()!=5 && data_variable.getAdvantage()!=6);
		return data_variable.getAdvantage();
	}
	
	int check_order_proceeding(Order_data data_variable){
		Scanner sc = new Scanner(System.in);
		System.out.printf("계속 발권하시겠습니까? \n1. 계속 발권\n2. 종료\n->");
		do {
			data_variable.setConTicket(sc.nextInt());
			switch(data_variable.getTicket()){
			case 1: case 2:
				System.out.printf("\n");
				break;
			default : 
				System.out.printf("항목에 해당하는 넘버를 다시 눌러주세요. \n1. 계속 발권\n2. 종료\n->");
				break;
			} 
		} while (data_variable.getTicket() != 1 && data_variable.getTicket() != 2);
		return data_variable.getTicket();
	}

	int check_final_reconfirm(Order_data data_variable){
		Scanner sc = new Scanner(System.in);
		System.out.printf("진행 하시겠습니까? \n1. 새로운 주문\n2. 발권확인 및 프로그램 종료\n->");
		do {
			data_variable.final_count = sc.nextInt();
			switch(data_variable.final_count){
			case 1: case 2:
				System.out.printf("\n");
				break;
			default : 
				System.out.printf("항목에 해당하는 넘버를 다시 눌러주세요. \\n1. 새로운 주문\\n2. 발권확인 및 프로그램 종료\n->");
				break;
			} 
		} while (data_variable.final_count != 1 && data_variable.final_count != 2);
		return data_variable.final_count;
	}
}
