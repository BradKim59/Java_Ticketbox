import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TicketingProject {
	Scanner sc = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	Calendar cal2 = new GregorianCalendar();
	OrderData orderItem;
	
	int current_year = cal.get(Calendar.YEAR);
	int current_month = cal.get(Calendar.MONTH +1);
	int current_date = cal.get(Calendar.DATE);

	int lastday_M = cal.getActualMaximum(Calendar.MONTH+1);
	int lastday_D = cal.getActualMaximum(Calendar.DATE);
	
	// int ticket, dayTicket, qty = 1, advantage 
	// long personID;
	// => OrderData Class 통합
	
//	int orderArr[][] = new int[10][10];
	ArrayList<OrderData> orderList = new ArrayList<OrderData>();
	
	//계산 시 변수 선언 
	int four_digit_year, nor_Date = 0, lun_Date = 0, gender, disAdvantage, discountType;
	static int conTicket = 0;
	//배열 선언 
	int monthNor [] = {31,28,31,30,31,30,31,31,30,31,30,31};//평달 월말일 
	int monthLun [] = {31,29,31,30,31,30,31,31,30,31,30,31};//윤달 월말일 
	
	
	int check_ticket_type() {
		orderItem.price = 0;
		orderItem.totalPrice = 0; //할인미적용 가격 
		orderItem.totalDiscountPrice = 0;//할인 적용 가격 
		orderItem.grandPrice = 0; //총 가격 
		orderItem.num = 0; //할인미적용 티켓 수
		orderItem.disNum = 0;//할인적용 티켓 수
		disAdvantage = 1;//할인우대 미 적용시
		System.out.printf("권종을 선택 하세요.\n1. 종합이용권\n2. 파크이용권\n->");
		do {
			orderItem.ticketType = sc.nextInt();
			switch (orderItem.ticketType) {
				case 1: case 2:
					System.out.printf("\n");
					break;
				default :
					System.out.printf("\n");
					System.out.printf("항목 1이나 2를 눌러주세요.\n1. 종합이용권\n2. 파크이용권\n->");
			}		
		} while (orderItem.ticketType!=1 && orderItem.ticketType!=2); 
		return orderItem.ticketType;
	}
	
	int check_day_type() {
		System.out.printf("이용시간을 선택 하세요.\n1. 1일권 \n2. AFTER4(16시 이후) \n->");
		do{
			orderItem.ticketTimeType = sc.nextInt();
			switch (orderItem.ticketTimeType) {
				case 1: case 2:
					System.out.printf("\n");
					break;
				default :
					System.out.printf("\n");
					System.out.printf("항목 1이나 2를 눌러주세요.\n1. 1일권 \n2. AFTER4(16시 이후) \n->");
					break;
			}
		}while (orderItem.ticketTimeType!=1 && orderItem.ticketTimeType!=2);
		return orderItem.ticketTimeType;
	}

	void check_person_ID() {
		do{
			System.out.printf("주민번호를 입력하세요\n->");
			orderItem.IDNumber = sc.next();
			System.out.printf("\n");
			//만나이 및 성별 확인
			
			orderItem.year = Integer.parseInt(orderItem.IDNumber.substring(0, 2));
			orderItem.month = Integer.parseInt(orderItem.IDNumber.substring(2, 4));
			orderItem.date = Integer.parseInt(orderItem.IDNumber.substring(4, 6));
//			year = (int)(personID/StaticValue.YEAR_DIGIT);
//			month = (int)(personID/StaticValue.MONTH_DIGIT%100);
//			date = (int)(personID/StaticValue.DAY_DIGIT%100);

			if (orderItem.year < current_year%100) {
				four_digit_year = orderItem.year+2000;
			} else {
				four_digit_year = orderItem.year+1900;
			}
			
			gender = Integer.parseInt(orderItem.IDNumber.substring(7, 8));
//			gender = (int)(personID/StaticValue.GENDER_DIGIT%10);
			
			//주민번호 오류 캐치
//			if (personID < 1000000000 || personID > 10000000000000L) {
//				System.out.printf("주민등록번호는 13자리 입니다.\n");
//			} 
//			if (year > current_year%100 && year < current_year%100+18 ) {
//				System.out.printf("출생년도 확인 해 주세요.\n");
//			}
//			if (month < 1 || month > lastday_M) {
//				System.out.printf("출생월 다시 확인 해 주세요.\n");
//			}
//			if (four_digit_year % 4 == 0 && four_digit_year % 100 != 0 || four_digit_year%400 == 0) {
//				lun_Date = date;
//				if (lun_Date < 1 || lun_Date > monthLun[month-1]) {
//					System.out.printf("출생일 다시 확인 해 주세요.\n");
//				}
//			} else {
//				nor_Date = date;
//				if (nor_Date < 1 || nor_Date > monthNor[month-1]) {
//					System.out.printf("출생일 다시 확인 해 주세요.\n");
//				}				
//			}
//			if (gender  < 1 || gender > 4) {
//				System.out.printf("성별코드 다시 확인 해 주세요.\n");
//			}
//		} while ((month < 1 || month > 12) || (lun_Date < 1 || lun_Date > monthLun[month-1]) 
//				&& (nor_Date < 1 || nor_Date > monthNor[month-1]) || (gender  <1 || gender > 4) 
//				|| (personID < 1000000000 || personID > 10000000000000L) || (year > current_year%100 && year < current_year%100+18));
		} while(orderItem.month < 1 || orderItem.month > 12);
	}
	
	int check_ticket_QTY() {
		System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n->");
		do{
			orderItem.orderCount = sc.nextInt();
			System.out.printf("\n");
			if (orderItem.orderCount > StaticValue.MAX_COUNT || orderItem.orderCount < StaticValue.MIN_COUNT) {
				System.out.printf("다시 주문해 주세요 (1개이상, 최대 10개)\n->");
			}
		} while(orderItem.orderCount > StaticValue.MAX_COUNT || orderItem.orderCount < StaticValue.MIN_COUNT);
		return orderItem.orderCount;
	}

	int check_benefit() {
		System.out.printf("우대사항을 선택하세요\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n->");
		do {
			orderItem.advantageType = sc.nextInt();
			switch (orderItem.advantageType) {
			case 1: case 2: case 3: case 4: case 5: case 6:
				System.out.printf("\n");
				break;
			default :
				System.out.printf("\n아래 항목에 해당하는 번호를 다시 눌러주세요.\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n->");
				break;
			} 		
		} while(orderItem.advantageType!=1 && orderItem.advantageType!=2 && 
				orderItem.advantageType!=3 && orderItem.advantageType!=4 && 
				orderItem.advantageType!=5 && orderItem.advantageType!=6);
		return orderItem.advantageType;
	}
	
	int calculate_manAge (int four_digit_year, int month, int date){
		int manAge;
		manAge = current_year - four_digit_year;
		if ((month > current_month)||(month == current_month && date > current_date)) {
			manAge = manAge - 1;
		}
		//구매자 대상 저장 
		if (manAge < StaticValue.MIN_CHILD && manAge >= StaticValue.MIN_BABY) {
			orderItem.generation = 2;//영유아
		} else if (manAge >= StaticValue.MIN_CHILD && manAge < StaticValue.MIN_TEEN){
			orderItem.generation = 3;//어린이
		} else if (manAge >= StaticValue.MIN_TEEN && manAge <= StaticValue.MAX_TEEN) {
			orderItem.generation = 4;//청소년
		} else if (manAge < StaticValue.MIN_BABY){
			orderItem.generation = 1;//신생아
		} else if (manAge >  StaticValue.MAX_ADULT) {
			orderItem.generation = 6;//만65이상
		} else {
			orderItem.generation = 5;//성인
		}
		return orderItem.generation;
	}
	
	int calculate_ticket_price (int ticket, int dayTicket, int generation){
		if (ticket == 1){
			switch(dayTicket) {
			case 1:
				if (generation == 2) {
					orderItem.price = StaticValue.BABY_ALL_DAY_PRICE;
				} else if (generation == 3 || generation == 6){
					orderItem.price = StaticValue.CHILD_ALL_DAY_PRICE;
				} else if (generation == 4) {
					orderItem.price = StaticValue.TEEN_ALL_DAY_PRICE;
				} else if (generation == 1){
					orderItem.price = StaticValue.INFANT_PRICE;
				} else {
					orderItem.price = StaticValue.ADULT_ALL_DAY_PRICE;
				}
				break;
			case 2:
				if (generation == 2) {
					orderItem.price = StaticValue.BABY_ALL_AFTER4_PRICE;
				} else if (generation == 3 || generation == 6){
					orderItem.price = StaticValue.CHILD_ALL_AFTER4_PRICE;
				} else if (generation == 4) {
					orderItem.price = StaticValue.TEEN_ALL_AFTER4_PRICE;
				} else if (generation == 1){
					orderItem.price = StaticValue.INFANT_PRICE;
				} else {
					orderItem.price = StaticValue.ADULT_ALL_AFTER4_PRICE;
				} 
				break;
			}
		} else if (ticket == 2){
			switch(dayTicket) {
			case 1:
				if (generation == 2) {
					orderItem.price = StaticValue.BABY_PARK_DAY_PRICE;
				} else if (generation == 3 || generation == 6){
					orderItem.price = StaticValue.CHILD_PARK_DAY_PRICE;
				} else if (generation == 4) {
					orderItem.price = StaticValue.TEEN_PARK_DAY_PRICE;
				} else if (generation == 1){
					orderItem.price = StaticValue.INFANT_PRICE;
				} else {
					orderItem.price = StaticValue.ADULT_PARK_DAY_PRICE;
				}
				break;
			case 2:
				if (generation == 2) {
					orderItem.price = StaticValue.BABY_PARK_AFTER4_PRICE;
				} else if (generation == 3 || generation == 6){
					orderItem.price = StaticValue.CHILD_PARK_AFTER4_PRICE;
				} else if (generation == 4) {
					orderItem.price = StaticValue.TEEN_PARK_AFTER4_PRICE;
				} else if (generation == 1){
					orderItem.price = StaticValue.INFANT_PRICE;
				} else {
					orderItem.price = StaticValue.ADULT_PARK_AFTER4_PRICE;
				}
				break;
			}
		} return orderItem.price;
	}

	int adjust_advantage(int advantage, int price, int qty){
		switch(advantage) {
			case 1://일반 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						orderItem.totalPrice += price;
						orderItem.num++;
				}
				System.out.printf("일반 할인 미적용 선택하셨습니다.\n");
			break;
			case 2 ://장애인 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
					 if (ticketCount > 2){
						orderItem.totalPrice += price;
						orderItem.num++;
					} else {
						disAdvantage = 2;
						orderItem.totalDiscountPrice += price * StaticValue.DISABLE_DISCOUNT_RATE;
						orderItem.disNum++;
					} 
				}
				System.out.printf("(장애인증 공식증빙 지참)본인 및 동반 1인까지 할인 적용됩니다.\n");							
			break;
			case 3 ://국가유공자 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
					 if (ticketCount > 2){
						 orderItem.totalPrice += price;
						 orderItem.num++;
					} else {
						disAdvantage = 3;
						orderItem.totalDiscountPrice += price * StaticValue.MERIT_DISCOUNT_RATE;
						orderItem.disNum++;
					}
				}
				System.out.printf("(유공자증 공식증빙 지참)본인 및 동반 1인까지 할인 적용됩니다.\n");							
			break;
			case 4://휴가장병
				if (orderItem.generation >=5){
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						if (ticketCount > 2){
							orderItem.totalPrice += price;
							orderItem.num++; 
						} else {
							disAdvantage = 4;
							orderItem.totalDiscountPrice += price * StaticValue.MILITARY_DISCOUNT_RATE;
							orderItem.disNum++;
						}
					}
					System.out.printf("휴가장병 및 동반 1인까지 할인 적용됩니다.\n");
				} else {
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						orderItem.totalPrice += price;
						orderItem.num++; 
					}
					System.out.printf("죄송합니다, 휴가장병 우대는 본인(성인기준) 이어야 합니다.\n");
				}
			break;
			case 5://임산부 
				if (gender == StaticValue.FEMALE_OLD || gender == StaticValue.FEMALE_NEW){
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						if (ticketCount > 1){
							orderItem.totalPrice += price;
							orderItem.num++; 
						} else {
							disAdvantage = 5;
							orderItem.totalDiscountPrice += price * StaticValue.PREGNANT_DISCOUNT_RATE;
							orderItem.disNum++;
						}
					}
					System.out.printf("(공식증빙지참) 임산부 본인 할인 적용되었습니다.\n");
				} else {
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						orderItem.totalPrice += price;
						orderItem.num++; 
					}
					System.out.printf("죄송합니다, 임산부 우대는 본인(여성) 이어야 합니다.\n");
				}
			break;
			case 6://다둥이 
				System.out.printf("할인가족 인원 선택 해 주세요.\n");
				orderItem.numDaDoong = sc.nextInt(); 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
					if (ticketCount > orderItem.numDaDoong){
						orderItem.totalPrice += price;
						orderItem.num++; 
					} else {
						disAdvantage = 6;
						orderItem.totalDiscountPrice += price * StaticValue.MULTICHILD_DISCOUNT_RATE;
						orderItem.disNum++;
					}
				}
				System.out.printf("(공식증빙지참) 인원수 (%d명) 할인 적용됩니다.\n", orderItem.numDaDoong);
			break;
		}
		orderItem.grandPrice = orderItem.totalPrice + orderItem.totalDiscountPrice;
		return orderItem.grandPrice;
	}
	
	void input_data_in_Arr(int ticket, int dayTicket, int advantage, int disAdvantage, int generation, int num, int disNum, int totalPrice, int totalDiscountPrice, int grandPrice) {
//		orderArr[indexOfArray][StaticValue.TICKET_TYPE] = ticket; 
//		orderArr[indexOfArray][StaticValue.DAY_TYPE] = dayTicket; 
//		orderArr[indexOfArray][StaticValue.DISCOUNT_TYPE] = advantage; 
//		orderArr[indexOfArray][StaticValue.NON_DISCOUNT_TYPE] = disAdvantage;
//		orderArr[indexOfArray][StaticValue.PERSON_TYPE] = generation;
//		orderArr[indexOfArray][StaticValue.NOMAL_TICKET_QTY] = num; 
//		orderArr[indexOfArray][StaticValue.DISC_TICKET_QTY] = disNum; 
//		orderArr[indexOfArray][StaticValue.NORMAL_PRICE_SUM] = totalPrice;
//		orderArr[indexOfArray][StaticValue.DISC_PRICE_SUM] = totalDiscountPrice;
//		orderArr[indexOfArray][StaticValue.SUM_PRICE] = grandPrice;
		orderList.add(orderItem);
	}
	
	void print_grand_price(int grandPrice){
		System.out.printf("총 가격은 %d원 입니다.", grandPrice);
		System.out.printf(" 감사합니다.\n");
		System.out.printf("\n");
	}
	
	void input_information(){
		orderItem = new OrderData();
		check_ticket_type();
		check_day_type();
		check_person_ID();
		check_ticket_QTY();
		check_benefit();
	} 
	
	void caculate_data(){
		calculate_manAge (four_digit_year, orderItem.month, orderItem.date);
		calculate_ticket_price (orderItem.ticketType, orderItem.ticketTimeType, orderItem.generation);
		adjust_advantage(orderItem.advantageType, orderItem.price, orderItem.orderCount);	
		input_data_in_Arr(orderItem.ticketType, orderItem.ticketTimeType, orderItem.advantageType, disAdvantage, orderItem.generation, orderItem.num, orderItem.disNum, orderItem.totalPrice, orderItem.totalDiscountPrice, orderItem.grandPrice);
		print_grand_price(orderItem.grandPrice);
	}
	
	int check_order_proceeding(){
		System.out.printf("계속 발권하시겠습니까? \n1. 계속 발권\n2. 종료\n->");
		do {
			conTicket = sc.nextInt();
			switch(conTicket){
			case 1: case 2:
				System.out.printf("\n");
				break;
			default : 
				System.out.printf("항목에 해당하는 넘버를 다시 눌러주세요. \n1. 계속 발권\n2. 종료\n->");
				break;
			} 
		} while (conTicket != 1 && conTicket != 2);
//		if (conTicket == 1) {
//			indexOfArray++;
//		}
		return conTicket;
	}
	
	void print_total_order(){
		System.out.printf("\n티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.printf("========================= 롯데월드 ========================\n");
		System.out.printf("이용권타입\t  시간타입\t  연령대\t    수량\t     가격\t\t   할인타입\n");
		System.out.printf("--------------------------------------------------------\n");
		for (int index = 0; index < orderList.size(); index++){//할인 티켓 출력 
			switch (orderList.get(index).ticketType) {
				case 1 :
					System.out.printf("%s\t","종합이용권");
					break;
				case 2 :
					System.out.printf("%s\t","파크이용권"); 
					break;
			} 
			switch (orderList.get(index).ticketTimeType) {
				case 1 :
					System.out.printf("%7s", "1DAY");
					break;
				case 2 :
					System.out.printf("%7s","AFTER4"); 
					break;
			}
//			switch (orderArr[roundOfOrder][StaticValue.PERSON_TYPE]) {
//				case 1 :
//					System.out.printf("%6s", "신생아");
//					break;
//				case 2 :
//					System.out.printf("%6s","영유아"); 
//					break;
//				case 3 :
//					System.out.printf("%6s","어린이"); 
//					break;
//				case 4 :
//					System.out.printf("%6s", "청소년");
//					break;
//				case 5 :
//					System.out.printf("%6s","성인"); 
//					break;
//				case 6 :
//					System.out.printf("%6s","만67이상"); 
//					break;
//			}
			//할인권, 일반권 존재 시 
//			if  (orderArr[roundOfOrder][StaticValue.DISC_TICKET_QTY] >= 1 && orderArr[roundOfOrder][StaticValue.NOMAL_TICKET_QTY] >= 1) {
//				System.out.printf("\t X%4d %7d원\t ", orderArr[roundOfOrder][StaticValue.DISC_TICKET_QTY], orderArr[roundOfOrder][StaticValue.DISC_PRICE_SUM]);
//				switch (orderArr[roundOfOrder][StaticValue.DISCOUNT_TYPE]) {
//					case 2 :	
//						System.out.printf("%-15s\n","장애인 우대적용"); 
//						break;
//					case 3 :
//						System.out.printf("%-15s\n","국가유공자 우대적용 ");
//						break;
//					case 4 :
//						System.out.printf("%-15s\n", "휴가장병 우대적용");
//						break;
//					case 5 :
//						System.out.printf("%-15s\n","임산부 우대적용 "); 
//						break;
//					case 6 :
//						System.out.printf("%-15s\n","다둥이 우대적용 "); 
//						break;
//				}
//				System.out.printf("\t\t\t X%4d %7d원\t ", orderArr[roundOfOrder][StaticValue.NOMAL_TICKET_QTY], orderArr[roundOfOrder][StaticValue.NORMAL_PRICE_SUM]);
//				switch (orderArr[roundOfOrder][StaticValue.NON_DISCOUNT_TYPE]) {
//					case 2 :	
//						System.out.printf("%-15s\n","장애인할인 외 일반가격"); 
//						break;
//					case 3 :
//						System.out.printf("%-15s\n","유공자할인 외 일반가격");
//						break;
//					case 4 :
//						System.out.printf("%-15s\n", "장병할인 외 일반가격");
//						break;
//					case 5 :
//						System.out.printf("%-15s\n","임산부할인 외 일반가격"); 
//						break;
//					case 6 :
//						System.out.printf("%-15s\n","다둥이할인 외 일반가격"); 
//						break;
//				}
//			//할인권만 존재 시 
//			} else if  (orderArr[roundOfOrder][StaticValue.DISC_TICKET_QTY] >= 1 && orderArr[roundOfOrder][StaticValue.NOMAL_TICKET_QTY] == 0) {
//				System.out.printf("\t X%4d %7d원\t ", orderArr[roundOfOrder][StaticValue.DISC_TICKET_QTY], orderArr[roundOfOrder][StaticValue.DISC_PRICE_SUM]);
//				switch (orderArr[roundOfOrder][StaticValue.DISCOUNT_TYPE]) {
//					case 2 :	
//						System.out.printf("%-15s\n","장애인 우대적용 "); 
//						break;
//					case 3 :
//						System.out.printf("%-15s\n","국가유공자 우대적용 ");
//						break;
//					case 4 :
//						System.out.printf("%-15s\n", "휴가장병 우대적용 ");
//						break;
//					case 5 :
//						System.out.printf("%-15s\n","임산부 우대적용 "); 
//						break;
//					case 6 :
//						System.out.printf("%-15s\n","다둥이 우대적용 "); 
//						break;
//				}
//			//일반권만 존재 시 
//			} else if  (orderArr[roundOfOrder][StaticValue.DISC_TICKET_QTY] == 0 && orderArr[roundOfOrder][StaticValue.NOMAL_TICKET_QTY] >= 1) {
//				System.out.printf("\t X%4d %7d원\t ", orderArr[roundOfOrder][StaticValue.NOMAL_TICKET_QTY], orderArr[roundOfOrder][StaticValue.NORMAL_PRICE_SUM]);
//				switch (orderArr[roundOfOrder][StaticValue.NON_DISCOUNT_TYPE]) {
//					case 1 :
//						System.out.printf("%-15s\n", "할인 미적용");
//						break;
//				}
//			}
//			grandSum += orderArr[roundOfOrder][StaticValue.SUM_PRICE];
		}
		System.out.printf("--------------------------------------------------------\n");
//		System.out.printf("\t\t\t 총 누계%8d원\n", grandSum);
		System.out.printf("========================================================\n");
	}
	public static void main(String[] args) {
		TicketingProject tb = new TicketingProject();
		do{
			//입력 부분 
			tb.input_information();
			//계산 부분
			tb.caculate_data();
			//반복or 종료 확인한다.
			tb.check_order_proceeding();
		} while(conTicket == 1);
		//출력 부분  
		tb.print_total_order();
		//프로그램 종료 시 매출내역을 파일로 저장한다. 
	}
}















