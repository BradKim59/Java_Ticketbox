package ticketing;

import java.util.ArrayList;

public class Print_result {

	void print_total_order(Order_data data_variable, ArrayList<Order_data> make_list){
		System.out.printf("\n티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.printf("========================= 롯데월드 ========================\n");
		System.out.printf("이용권타입\t  시간타입\t  연령대\t    수량\t     가격\t\t   할인타입\n");
		System.out.printf("--------------------------------------------------------\n");
		for (int roundOfOrder = 0; roundOfOrder<make_list.size(); roundOfOrder++){//할인 티켓 출력 
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
			switch (make_list.get(roundOfOrder).getGeneration()) {
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
			if  (make_list.get(roundOfOrder).getDisNum() >= 1 && make_list.get(roundOfOrder).getNum() >= 1) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).getDisNum(), make_list.get(roundOfOrder).getTotalDiscountPrice());
				switch (make_list.get(roundOfOrder).getAdvantage()) {
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
				System.out.printf("\t\t\t X%4d %7d원\t ", make_list.get(roundOfOrder).getNum(), make_list.get(roundOfOrder).getTotalPrice());
				switch (make_list.get(roundOfOrder).getAdvantage()) {
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
			} else if  (make_list.get(roundOfOrder).getDisNum() >= 1 && make_list.get(roundOfOrder).getNum() == 0) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).getDisNum(), make_list.get(roundOfOrder).getTotalDiscountPrice());
				switch (make_list.get(roundOfOrder).getAdvantage()) {
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
			} else if  (make_list.get(roundOfOrder).getDisNum() == 0 && make_list.get(roundOfOrder).getNum() >= 1) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).getNum(), make_list.get(roundOfOrder).getTotalPrice());
				switch (make_list.get(roundOfOrder).getDisAdvantage()) {
					case 1 :
						System.out.printf("%-15s\n", "할인 미적용");
						break;
				}
			}
			data_variable.setGrandSum(data_variable.getGrandSum() + make_list.get(roundOfOrder).getGrandPrice());
		}
		System.out.printf("--------------------------------------------------------\n");
		System.out.printf("\t\t\t 총 누계%8d원\n", data_variable.getGrandSum());
		System.out.printf("========================================================\n");
	}

	

}
