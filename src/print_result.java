package ticketing;

import java.util.ArrayList;

public class Print_result {

	void print_total_order(Order_data data_variable, ArrayList<Order_data> make_list){
		System.out.printf("\n티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.printf("========================= 롯데월드 ========================\n");
		System.out.printf("이용권타입\t  시간타입\t  연령대\t    수량\t     가격\t\t   할인타입\n");
		System.out.printf("--------------------------------------------------------\n");
		for (int roundOfOrder = 0; roundOfOrder<make_list.size(); roundOfOrder++){//할인 티켓 출력
			System.out.printf("%s\t",make_list.get(roundOfOrder).getTicketToString());
			System.out.printf("%7s",make_list.get(roundOfOrder).getDayTicketToString());
			System.out.printf("%6s", make_list.get(roundOfOrder).getGenerationToString());

			//할인권, 일반권 존재 시 
			if  (make_list.get(roundOfOrder).getDisNum() >= 1 && make_list.get(roundOfOrder).getNum() >= 1) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).getDisNum(), make_list.get(roundOfOrder).getTotalDiscountPrice());
				System.out.printf("%-15s\n",make_list.get(roundOfOrder).getAdvantageToString());
				System.out.printf("\t\t\t X%4d %7d원\t ", make_list.get(roundOfOrder).getNum(), make_list.get(roundOfOrder).getTotalPrice());
				System.out.println(make_list.get(roundOfOrder).getDisAdvantageToString());

			//할인권만 존재 시 
			} else if  (make_list.get(roundOfOrder).getDisNum() >= 1 && make_list.get(roundOfOrder).getNum() == 0) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).getDisNum(), make_list.get(roundOfOrder).getTotalDiscountPrice());
				System.out.printf("%-15s\n",make_list.get(roundOfOrder).getAdvantageToString());

			//일반권만 존재 시 
			} else if  (make_list.get(roundOfOrder).getDisNum() == 0 && make_list.get(roundOfOrder).getNum() >= 1) {
				System.out.printf("\t X%4d %7d원\t ", make_list.get(roundOfOrder).getNum(), make_list.get(roundOfOrder).getTotalPrice());
				System.out.println(make_list.get(roundOfOrder).getDisAdvantageToString());

			}
			data_variable.setGrandSum(data_variable.getGrandSum() + make_list.get(roundOfOrder).getGrandPrice());
		}
		System.out.printf("--------------------------------------------------------\n");
		System.out.printf("\t\t\t 총 누계%8d원\n", data_variable.getGrandSum());
		System.out.printf("========================================================\n");
	}

	

}
