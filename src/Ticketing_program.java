package Ticket;

import java.util.ArrayList;

public class Ticketing_program {
	
	void start_system() {
		print_result result = new print_result();
		ArrayList<order_data> make_list = new ArrayList<order_data>();
		order_data data_variable = null;
		do{
			input_order in = new input_order();
			calculate_order cal = new calculate_order();
			data_variable = new order_data(0,0,0,0,0,0,1);
//			data_variable.price = 0;
//			data_variable.totalPrice = 0; //할인미적용 가격 
//			data_variable.totalDiscountPrice = 0;//할인 적용 가격 
//			data_variable.grandPrice = 0; //총 가격 
//			data_variable.num = 0; //할인미적용 티켓 수
//			data_variable.disNum = 0;//할인적용 티켓 수
//			data_variable.disAdvantage = 1;//할인우대 미 적용시
			//입력 부분 
			in.check_ticket_type(data_variable);
			in.check_day_type(data_variable);
			in.check_person_ID(data_variable);
			in.check_ticket_QTY(data_variable);
			in.check_benefit(data_variable);
			//계산 부분
			cal.calculate_manAge(data_variable);
			cal.calculate_ticket_price(data_variable);
			cal.adjust_advantage(data_variable);
			cal.input_data_in_Arr(data_variable, make_list);
			cal.print_grand_price(data_variable);
			//반복or 종료 확인한다.
			in.check_order_proceeding(data_variable);
		} while(data_variable.getConTicket() == 1);
		//출력 부분  
		result.print_total_order(data_variable, make_list);
	}


}
