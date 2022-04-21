package ticketing;

import java.util.ArrayList;

public class Ticketing_program {
	
	void start_system() {
		Writer_CSV writer_csv = new Writer_CSV();
		Print_result result = new Print_result();
		Reader_CSV reader_csv = new Reader_CSV();
		Order_data data_variable = null;
		ArrayList<Order_data> make_list;
		do {
			make_list = new ArrayList<Order_data>();
			do{
				Input_order in = new Input_order();
				Calculate_order cal = new Calculate_order();
				data_variable = new Order_data();
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
			Input_order in = new Input_order();
			in.check_final_reconfirm(data_variable);
		}while (data_variable.final_count == 1);
		writer_csv.csv_loop(data_variable, make_list);
		writer_csv.csv_loop_raw_data(data_variable, make_list);
		reader_csv.csv_reader_raw();
		reader_csv.csv_ticket_type_reader();

	}


}
