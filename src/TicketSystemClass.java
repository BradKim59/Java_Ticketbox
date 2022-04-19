import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class TicketSystemClass {
	public order_data data_variable = null;
	public ArrayList<order_data> make_list = new ArrayList<order_data>();
	public Scanner sc = new Scanner(System.in);
	public int conTicket = 0;
	
	void startSystem() {
		do{
			//입력 부분 
			input_information();
			//계산 부분
			caculate_data();
			//반복or 종료 확인한다.
			check_order_proceeding();
		} while(conTicket == 1);
		//출력 부분  
		print_total_order();
	}
	
	
	int check_ticket_type() {
		data_variable.price = 0;
		data_variable.totalPrice = 0; //할인미적용 가격 
		data_variable.totalDiscountPrice = 0;//할인 적용 가격 
		data_variable.grandPrice = 0; //총 가격 
		data_variable.num = 0; //할인미적용 티켓 수
		data_variable.disNum = 0;//할인적용 티켓 수
		data_variable.disAdvantage = 1;//할인우대 미 적용시
		System.out.printf("권종을 선택 하세요.\n1. 종합이용권\n2. 파크이용권\n->");
		do {
			//data_variable.setTicket = sc.nexInt();
			
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
	
	int check_day_type() {
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

	int check_person_ID() {
		Calendar cal = Calendar.getInstance();
		int current_year = cal.get(Calendar.YEAR);
		int lastday_M = cal.getActualMaximum(Calendar.MONTH+1);
		String personID;
		
		int nor_Date = 0;
		int lun_Date = 0;
		do{
			System.out.printf("주민번호를 입력하세요\n->");
			personID = sc.next();
			System.out.printf("\n");
			//만나이 및 성별 확인 
			data_variable.year = Integer.parseInt(personID.substring(0,2));
			data_variable.month = Integer.parseInt(personID.substring(2,4));
			data_variable.date = Integer.parseInt(personID.substring(4,6));
			data_variable.setGender(Integer.parseInt(personID.substring(6,7)));
			if (data_variable.year < current_year%100) {
				data_variable.four_digit_year = data_variable.year+2000;
			} else {
				data_variable.four_digit_year = data_variable.year+1900;
			}
			
			//주민번호 오류 캐치
			if (personID.length() != 13) {
				System.out.printf("주민등록번호는 13자리 입니다.\n");
			} 
			if (data_variable.year > current_year%100 && data_variable.year < current_year%100+18 ) {
				System.out.printf("출생년도 확인 해 주세요.\n");
			}
			if (data_variable.month < 1 || data_variable.month > lastday_M) {
				System.out.printf("출생월 다시 확인 해 주세요.\n");
			}
			if (data_variable.four_digit_year % 4 == 0 && data_variable.four_digit_year % 100 != 0 || data_variable.four_digit_year%400 == 0) {
				lun_Date = data_variable.date;
				if (lun_Date < 1 || lun_Date > static_variable.MONTH_LUN[data_variable.month-1]) {
					System.out.printf("출생일 다시 확인 해 주세요.\n");
				}
			} else {
				nor_Date = data_variable.date;
				if (nor_Date < 1 || nor_Date > static_variable.MONTH_NOR[data_variable.month-1]) {
					System.out.printf("출생일 다시 확인 해 주세요.\n");
				}				
			}
			if (data_variable.getGender()  < 1 && data_variable.getGender() > 4) {
				System.out.printf("성별코드 다시 확인 해 주세요.\n");
			}
		} while ((data_variable.month < 1 || data_variable.month > 12) 
				|| (lun_Date < 1 || lun_Date > static_variable.MONTH_LUN[data_variable.month-1]) 
				&& (nor_Date < 1 || nor_Date > static_variable.MONTH_NOR[data_variable.month-1]) 
				|| (data_variable.getGender()  <1 || data_variable.getGender() > 4) 
				|| (personID.length() != 13) 
				|| (data_variable.year > current_year%100 && data_variable.year < current_year%100+18));
		return data_variable.getGender();
	}
	
	int check_ticket_QTY() {
		System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n->");
		do{
			data_variable.qty = sc.nextInt();
			System.out.printf("\n");
			if (data_variable.qty > static_variable.MAX_COUNT || data_variable.qty < static_variable.MIN_COUNT) {
				System.out.printf("다시 주문해 주세요 (1개이상, 최대 10개)\n->");
			}
		} while(data_variable.qty > static_variable.MAX_COUNT || data_variable.qty < static_variable.MIN_COUNT);
		return data_variable.qty;
	}

	int check_benefit() {
		System.out.printf("우대사항을 선택하세요\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n->");
		do {
			data_variable.advantage = sc.nextInt();
			switch (data_variable.advantage) {
			case 1: case 2: case 3: case 4: case 5: case 6:
				System.out.printf("\n");
				break;
			default :
				System.out.printf("\n아래 항목에 해당하는 번호를 다시 눌러주세요.\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드\n->");
				break;
			} 		
		} while(data_variable.advantage!=1 && data_variable.advantage!=2 && data_variable.advantage!=3 && data_variable.advantage!=4 && data_variable.advantage!=5 && data_variable.advantage!=6);
		return data_variable.advantage;
	}
	
	int calculate_manAge (int four_digit_year, int month, int date){
		int manAge;
		Calendar cal = Calendar.getInstance();
		int current_year = cal.get(Calendar.YEAR);
		int current_month = cal.get(Calendar.MONTH +1);
		int current_date = cal.get(Calendar.DATE);
		
		manAge = current_year - four_digit_year;
		if ((month > current_month)||(month == current_month && date > current_date)) {
			manAge = manAge - 1;
		}
		//구매자 대상 저장 
		if (manAge < static_variable.MIN_CHILD && manAge >= static_variable.MIN_BABY) {
			data_variable.generation = 2;//영유아
		} else if (manAge >= static_variable.MIN_CHILD && manAge < static_variable.MIN_TEEN){
			data_variable.generation = 3;//어린이
		} else if (manAge >= static_variable.MIN_TEEN && manAge <= static_variable.MAX_TEEN) {
			data_variable.generation = 4;//청소년
		} else if (manAge < static_variable.MIN_BABY){
			data_variable.generation = 1;//신생아
		} else if (manAge >  static_variable.MAX_ADULT) {
			data_variable.generation = 6;//만65이상
		} else {
			data_variable.generation = 5;//성인
		}
		return data_variable.generation;
	}
	
	int calculate_ticket_price (int ticket, int dayTicket, int generation){
		if (ticket == 1){
			switch(dayTicket) {
			case 1:
				if (generation == 2) {
					data_variable.price = static_variable.BABY_ALL_DAY_PRICE;
				} else if (generation == 3 || generation == 6){
					data_variable.price = static_variable.CHILD_ALL_DAY_PRICE;
				} else if (generation == 4) {
					data_variable.price = static_variable.TEEN_ALL_DAY_PRICE;
				} else if (generation == 1){
					data_variable.price = static_variable.INFANT_PRICE;
				} else {
					data_variable.price = static_variable.ADULT_ALL_DAY_PRICE;
				}
				break;
			case 2:
				if (generation == 2) {
					data_variable.price = static_variable.BABY_ALL_AFTER4_PRICE;
				} else if (generation == 3 || generation == 6){
					data_variable.price = static_variable.CHILD_ALL_AFTER4_PRICE;
				} else if (generation == 4) {
					data_variable.price = static_variable.TEEN_ALL_AFTER4_PRICE;
				} else if (generation == 1){
					data_variable.price = static_variable.INFANT_PRICE;
				} else {
					data_variable.price = static_variable.ADULT_ALL_AFTER4_PRICE;
				} 
				break;
			}
		} else if (ticket == 2){
			switch(dayTicket) {
			case 1:
				if (generation == 2) {
					data_variable.price = static_variable.BABY_PARK_DAY_PRICE;
				} else if (generation == 3 || generation == 6){
					data_variable.price = static_variable.CHILD_PARK_DAY_PRICE;
				} else if (generation == 4) {
					data_variable.price = static_variable.TEEN_PARK_DAY_PRICE;
				} else if (generation == 1){
					data_variable.price = static_variable.INFANT_PRICE;
				} else {
					data_variable.price = static_variable.ADULT_PARK_DAY_PRICE;
				}
				break;
			case 2:
				if (generation == 2) {
					data_variable.price = static_variable.BABY_PARK_AFTER4_PRICE;
				} else if (generation == 3 || generation == 6){
					data_variable.price = static_variable.CHILD_PARK_AFTER4_PRICE;
				} else if (generation == 4) {
					data_variable.price = static_variable.TEEN_PARK_AFTER4_PRICE;
				} else if (generation == 1){
					data_variable.price = static_variable.INFANT_PRICE;
				} else {
					data_variable.price = static_variable.ADULT_PARK_AFTER4_PRICE;
				}
				break;
			}
		} return data_variable.price;
	}

	int adjust_advantage(int advantage, int price, int qty, int gender){
		switch(advantage) {
			case 1://일반 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
					data_variable.totalPrice += price;
					data_variable.num++;
				}
				System.out.printf("일반 할인 미적용 선택하셨습니다.\n");
			break;
			case 2 ://장애인 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
					 if (ticketCount > 2){
						 data_variable.totalPrice += price;
						 data_variable.num++;
					} else {
						data_variable.disAdvantage = 2;
						data_variable.totalDiscountPrice += price * static_variable.DISABLE_DISCOUNT_RATE;
						data_variable.disNum++;
					} 
				}
				System.out.printf("(장애인증 공식증빙 지참)본인 및 동반 1인까지 할인 적용됩니다.\n");							
			break;
			case 3 ://국가유공자 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
					 if (ticketCount > 2){
						 data_variable.totalPrice += price;
						 data_variable.num++;
					} else {
						data_variable.disAdvantage = 3;
						data_variable.totalDiscountPrice += price * static_variable.MERIT_DISCOUNT_RATE;
						data_variable.disNum++;
					}
				}
				System.out.printf("(유공자증 공식증빙 지참)본인 및 동반 1인까지 할인 적용됩니다.\n");							
			break;
			case 4://휴가장병
				if (data_variable.generation >=5){
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						if (ticketCount > 2){
							data_variable.totalPrice += price;
							data_variable.num++; 
						} else {
							data_variable.disAdvantage = 4;
							data_variable.totalDiscountPrice += price * static_variable.MILITARY_DISCOUNT_RATE;
							data_variable.disNum++;
						}
					}
					System.out.printf("휴가장병 및 동반 1인까지 할인 적용됩니다.\n");
				} else {
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						data_variable.totalPrice += price;
						data_variable.num++; 
					}
					System.out.printf("죄송합니다, 휴가장병 우대는 본인(성인기준) 이어야 합니다.\n");
				}
			break;
			case 5://임산부 
				if (gender == static_variable.FEMALE_OLD || gender == static_variable.FEMALE_NEW){
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						if (ticketCount > 1){
							data_variable.totalPrice += price;
							data_variable.num++; 
						} else {
							data_variable.disAdvantage = 5;
							data_variable.totalDiscountPrice += price * static_variable.PREGNANT_DISCOUNT_RATE;
							data_variable.disNum++;
						}
					}
					System.out.printf("(공식증빙지참) 임산부 본인 할인 적용되었습니다.\n");
				} else {
					for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
						data_variable.totalPrice += price;
						data_variable.num++; 
					}
					System.out.printf("죄송합니다, 임산부 우대는 본인(여성) 이어야 합니다.\n");
				}
			break;
			case 6://다둥이
				int numDaDoong;
				System.out.printf("할인가족 인원 선택 해 주세요.\n");
				numDaDoong = sc.nextInt(); 
				for (int ticketCount = 1; ticketCount <= qty; ticketCount++){
					if (ticketCount > numDaDoong){
						data_variable.totalPrice += price;
						data_variable.num++; 
					} else {
						data_variable.disAdvantage = 6;
						data_variable.totalDiscountPrice += price * static_variable.MULTICHILD_DISCOUNT_RATE;
						data_variable.disNum++;
					}
				}
				System.out.printf("(공식증빙지참) 인원수 (%d명) 할인 적용됩니다.\n", numDaDoong);
			break;
		}
		data_variable.grandPrice = data_variable.totalPrice + data_variable.totalDiscountPrice;
		return data_variable.grandPrice;
	}
	
	void input_data_in_Arr(int ticket, int dayTicket, int advantage, int disAdvantage, int generation, int num, int disNum, int totalPrice, int totalDiscountPrice, int grandPrice) {
//		orderArr[indexOfArray][static_variable.TICKET_TYPE] = ticket;
//		orderArr[indexOfArray][static_variable.DAY_TYPE] = dayTicket;
//		orderArr[indexOfArray][static_variable.DISCOUNT_TYPE] = advantage;
//		orderArr[indexOfArray][static_variable.NON_DISCOUNT_TYPE] = disAdvantage;
//		orderArr[indexOfArray][static_variable.PERSON_TYPE] = generation;
//		orderArr[indexOfArray][static_variable.NOMAL_TICKET_QTY] = num;
//		orderArr[indexOfArray][static_variable.DISC_TICKET_QTY] = disNum;
//		orderArr[indexOfArray][static_variable.NORMAL_PRICE_SUM] = totalPrice;
//		orderArr[indexOfArray][static_variable.DISC_PRICE_SUM] = totalDiscountPrice;
//		orderArr[indexOfArray][static_variable.SUM_PRICE] = grandPrice;
		make_list.add(data_variable);
	}
	
	void print_grand_price(int grandPrice){
		System.out.printf("총 가격은 %d원 입니다.", grandPrice);
		System.out.printf(" 감사합니다.\n");
		System.out.printf("\n");
	}
	
	void input_information(){
		data_variable = new order_data();
		check_ticket_type();
		check_day_type();
		check_person_ID();
		check_ticket_QTY();
		check_benefit();
	} 
	
	void caculate_data(){
		calculate_manAge (data_variable.four_digit_year, data_variable.month, data_variable.date);
		calculate_ticket_price (data_variable.getTicket(), data_variable.getDayTicket(), data_variable.generation);
		adjust_advantage(data_variable.advantage, data_variable.price, data_variable.qty, data_variable.getGender());	
		input_data_in_Arr(data_variable.getTicket(), data_variable.getDayTicket(), data_variable.advantage, data_variable.disAdvantage, data_variable.generation, data_variable.num, data_variable.disNum, data_variable.totalPrice, data_variable.totalDiscountPrice, data_variable.grandPrice);
		print_grand_price(data_variable.grandPrice);
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
		return conTicket;
	}
	
	void print_total_order(){
		System.out.printf("\n티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.printf("========================= 롯데월드 ========================\n");
		System.out.printf("이용권타입\t  시간타입\t  연령대\t    수량\t     가격\t\t   할인타입\n");
		System.out.printf("--------------------------------------------------------\n");
		for (int roundOfOrder = 0; roundOfOrder<make_list.size(); roundOfOrder++){//할인 티켓 출력 
//			System.out.println(make_list.get(roundOfOrder));
			switch (make_list.get(roundOfOrder).getTicket()) {
				case 1 :	
					System.out.printf("%s\t","종합이용권");
					break;
				case 2 :
					System.out.printf("%s\t","파크이용권"); 
					break;
			} 
			switch (make_list.get(roundOfOrder).getDayTicket()) {
				case 1 :
					System.out.printf("%7s", "1DAY");
					break;
				case 2 :
					System.out.printf("%7s","AFTER4"); 
					break;
			}
			switch (make_list.get(roundOfOrder).generation) {
				case 1 :
					System.out.printf("%6s", "신생아");
					break;
				case 2 :
					System.out.printf("%6s","영유아"); 
					break;
				case 3 :
					System.out.printf("%6s","어린이"); 
					break;
				case 4 :
					System.out.printf("%6s", "청소년");
					break;
				case 5 :
					System.out.printf("%6s","성인"); 
					break;
				case 6 :
					System.out.printf("%6s","만67이상"); 
					break;
			}
			//할인권, 일반권 존재 시 
			if  (make_list.get(roundOfOrder).disNum >= 1 && make_list.get(roundOfOrder).num >= 1) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).disNum, make_list.get(roundOfOrder).totalDiscountPrice);
				switch (make_list.get(roundOfOrder).advantage) {
					case 2 :	
						System.out.printf("%-15s\n","장애인 우대적용"); 
						break;
					case 3 :
						System.out.printf("%-15s\n","국가유공자 우대적용 ");
						break;
					case 4 :
						System.out.printf("%-15s\n", "휴가장병 우대적용");
						break;
					case 5 :
						System.out.printf("%-15s\n","임산부 우대적용 "); 
						break;
					case 6 :
						System.out.printf("%-15s\n","다둥이 우대적용 "); 
						break;
				}
				System.out.printf("\t\t\t X%4d %7d원\t ", make_list.get(roundOfOrder).num, make_list.get(roundOfOrder).totalPrice);
				switch (make_list.get(roundOfOrder).disAdvantage) {
					case 2 :	
						System.out.printf("%-15s\n","장애인할인 외 일반가격"); 
						break;
					case 3 :
						System.out.printf("%-15s\n","유공자할인 외 일반가격");
						break;
					case 4 :
						System.out.printf("%-15s\n", "장병할인 외 일반가격");
						break;
					case 5 :
						System.out.printf("%-15s\n","임산부할인 외 일반가격"); 
						break;
					case 6 :
						System.out.printf("%-15s\n","다둥이할인 외 일반가격"); 
						break;
				}
			//할인권만 존재 시 
			} else if  (make_list.get(roundOfOrder).disNum >= 1 && make_list.get(roundOfOrder).num == 0) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).disNum, make_list.get(roundOfOrder).totalDiscountPrice);
				switch (make_list.get(roundOfOrder).advantage) {
					case 2 :	
						System.out.printf("%-15s\n","장애인 우대적용 "); 
						break;
					case 3 :
						System.out.printf("%-15s\n","국가유공자 우대적용 ");
						break;
					case 4 :
						System.out.printf("%-15s\n", "휴가장병 우대적용 ");
						break;
					case 5 :
						System.out.printf("%-15s\n","임산부 우대적용 "); 
						break;
					case 6 :
						System.out.printf("%-15s\n","다둥이 우대적용 "); 
						break;
				}
			//일반권만 존재 시 
			} else if  (make_list.get(roundOfOrder).disNum == 0 && make_list.get(roundOfOrder).num >= 1) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).num, make_list.get(roundOfOrder).totalPrice);
				switch (make_list.get(roundOfOrder).disAdvantage) {
					case 1 :
						System.out.printf("%-15s\n", "할인 미적용");
						break;
				}
			}
			data_variable.grandSum += make_list.get(roundOfOrder).grandPrice;
		}
		System.out.printf("--------------------------------------------------------\n");
		System.out.printf("\t\t\t 총 누계%8d원\n", data_variable.grandSum);
		System.out.printf("========================================================\n");
	}
}
