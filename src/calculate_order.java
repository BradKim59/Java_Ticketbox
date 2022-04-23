package ticketing;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculate_order {
	Input_order inputted_data = new Input_order();
//	order_data data_variable = new order_data();

	int calculate_manAge (Order_data data_variable){
		int manAge;
		manAge = data_variable.getCurrent_year() - data_variable.getFour_digit_year();
		if ((data_variable.getMonth() > data_variable.getCurrent_month())
			||(data_variable.getMonth() == data_variable.getCurrent_month() 
			&& data_variable.getDate() > data_variable.getCurrent_date())) {
			manAge = manAge - 1;
		}
		//구매자 대상 저장 
		if (manAge < Static_data.MIN_CHILD && manAge >= Static_data.MIN_BABY) {
			data_variable.setGeneration(2);//영유아
		} else if (manAge >= Static_data.MIN_CHILD && manAge < Static_data.MIN_TEEN){
			data_variable.setGeneration(3);//어린이
		} else if (manAge >= Static_data.MIN_TEEN && manAge <= Static_data.MAX_TEEN) {
			data_variable.setGeneration(4);//청소년
		} else if (manAge < Static_data.MIN_BABY){
			data_variable.setGeneration(1);//신생아
		} else if (manAge >  Static_data.MAX_ADULT) {
			data_variable.setGeneration(6);//만65이상
		} else {
			data_variable.setGeneration(5);//성인
		}
		return data_variable.getGeneration();
	}
	
	int calculate_ticket_price (Order_data data_variable){
		if (data_variable.getTicket() == 1){
			switch(data_variable.getDayTicket()) {
			case 1:
				if (data_variable.getGeneration() == 2) {
					data_variable.setPrice(Static_data.BABY_ALL_DAY_PRICE);
				} else if (data_variable.getGeneration() == 3 || data_variable.getGeneration() == 6){
					data_variable.setPrice(Static_data.CHILD_ALL_DAY_PRICE);
				} else if (data_variable.getGeneration() == 4) {
					data_variable.setPrice(Static_data.TEEN_ALL_DAY_PRICE);
				} else if (data_variable.getGeneration() == 1){
					data_variable.setPrice(Static_data.INFANT_PRICE);
				} else {
					data_variable.setPrice(Static_data.ADULT_ALL_DAY_PRICE);
				}
				break;
			case 2:
				if (data_variable.getGeneration() == 2) {
					data_variable.setPrice(Static_data.BABY_ALL_AFTER4_PRICE);
				} else if (data_variable.getGeneration() == 3 || data_variable.getGeneration() == 6){
					data_variable.setPrice(Static_data.CHILD_ALL_AFTER4_PRICE);
				} else if (data_variable.getGeneration() == 4) {
					data_variable.setPrice(Static_data.TEEN_ALL_AFTER4_PRICE);
				} else if (data_variable.getGeneration() == 1){
					data_variable.setPrice(Static_data.INFANT_PRICE);
				} else {
					data_variable.setPrice(Static_data.ADULT_ALL_AFTER4_PRICE);
				} 
				break;
			}
		} else if (data_variable.getTicket() == 2){
			switch(data_variable.getDayTicket()) {
			case 1:
				if (data_variable.getGeneration() == 2) {
					data_variable.setPrice(Static_data.BABY_PARK_DAY_PRICE);
				} else if (data_variable.getGeneration() == 3 || data_variable.getGeneration() == 6){
					data_variable.setPrice(Static_data.CHILD_PARK_DAY_PRICE);
				} else if (data_variable.getGeneration() == 4) {
					data_variable.setPrice(Static_data.TEEN_PARK_DAY_PRICE);
				} else if (data_variable.getGeneration() == 1){
					data_variable.setPrice(Static_data.INFANT_PRICE);
				} else {
					data_variable.setPrice(Static_data.ADULT_PARK_DAY_PRICE);
				}
				break;
			case 2:
				if (data_variable.getGeneration() == 2) {
					data_variable.setPrice(Static_data.BABY_PARK_AFTER4_PRICE);
				} else if (data_variable.getGeneration() == 3 || data_variable.getGeneration() == 6){
					data_variable.setPrice(Static_data.CHILD_PARK_AFTER4_PRICE);
				} else if (data_variable.getGeneration() == 4) {
					data_variable.setPrice(Static_data.TEEN_PARK_AFTER4_PRICE);
				} else if (data_variable.getGeneration() == 1){
					data_variable.setPrice(Static_data.INFANT_PRICE);
				} else {
					data_variable.setPrice(Static_data.ADULT_PARK_AFTER4_PRICE);
				}
				break;
			}
		} return data_variable.getPrice();
	}

	int adjust_advantage(Order_data data_variable){
		switch(data_variable.getAdvantage()) {
			case 1://일반 
				data_variable.setDisAdvantage(1);
				for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
					data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
					data_variable.setNum(data_variable.getNum() + 1);
				}
				System.out.printf("일반 할인 미적용 선택하셨습니다.\n");
			break;
			case 2 ://장애인 
				for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
					 if (ticketCount > 2){
						 data_variable.setDisAdvantage(2);
						 data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
						 data_variable.setNum(data_variable.getNum() + 1);
					} else {
						data_variable.setTotalDiscountPrice((int) (data_variable.getTotalDiscountPrice() + data_variable.getPrice() * Static_data.DISABLE_DISCOUNT_RATE));
						data_variable.setDisNum(data_variable.getDisNum() + 1);
					} 
				}
				System.out.printf("(장애인증 공식증빙 지참)본인 및 동반 1인까지 할인 적용됩니다.\n");							
			break;
			case 3 ://국가유공자 
				for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
					 if (ticketCount > 2){
						 data_variable.setDisAdvantage(3);
						 data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
						 data_variable.setNum(data_variable.getNum() + 1);
					} else {
						data_variable.setTotalDiscountPrice((int) (data_variable.getTotalDiscountPrice() + data_variable.getPrice() * Static_data.MERIT_DISCOUNT_RATE));
						data_variable.setDisNum(data_variable.getDisNum() + 1);
					}
				}
				System.out.printf("(유공자증 공식증빙 지참)본인 및 동반 1인까지 할인 적용됩니다.\n");							
			break;
			case 4://휴가장병
				if (data_variable.getGeneration() >=5){
					for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
						if (ticketCount > 2){
							data_variable.setDisAdvantage(4);
							data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
							data_variable.setNum(data_variable.getNum() + 1); 
						} else {
							data_variable.setTotalDiscountPrice((int) (data_variable.getTotalDiscountPrice() + data_variable.getPrice() * Static_data.MILITARY_DISCOUNT_RATE));
							data_variable.setDisNum(data_variable.getDisNum() + 1);
						}
					}
					System.out.printf("휴가장병 및 동반 1인까지 할인 적용됩니다.\n");
				} else {
					for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
						data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
						data_variable.setNum(data_variable.getNum() + 1); 
					}
					System.out.printf("죄송합니다, 휴가장병 우대는 본인(성인기준) 이어야 합니다.\n");
				}
			break;
			case 5://임산부 
				if (data_variable.getGender() == Static_data.FEMALE_OLD || data_variable.getGender() == Static_data.FEMALE_NEW){
					for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
						if (ticketCount > 1){
							data_variable.setDisAdvantage(5);
							data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
							data_variable.setNum(data_variable.getNum() + 1); 
						} else {
							data_variable.setTotalDiscountPrice((int) (data_variable.getTotalDiscountPrice() + data_variable.getPrice() * Static_data.PREGNANT_DISCOUNT_RATE));
							data_variable.setDisNum(data_variable.getDisNum() + 1);
						}
					}
					System.out.printf("(공식증빙지참) 임산부 본인 할인 적용되었습니다.\n");
				} else {
					for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
						data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
						data_variable.setNum(data_variable.getNum() + 1); 
					}
					System.out.printf("죄송합니다, 임산부 우대는 본인(여성) 이어야 합니다.\n");
				}
			break;
			case 6://다둥이
				Scanner sc = new Scanner(System.in);
				int numDaDoong;
				System.out.printf("할인가족 인원 선택 해 주세요.\n");
				numDaDoong = sc.nextInt(); 
				for (int ticketCount = 1; ticketCount <= data_variable.getQty(); ticketCount++){
					if (ticketCount > numDaDoong){
						data_variable.setDisAdvantage(6);
						data_variable.setTotalPrice(data_variable.getTotalPrice() + data_variable.getPrice());
						data_variable.setNum(data_variable.getNum() + 1); 
					} else {
						data_variable.setTotalDiscountPrice((int) (data_variable.getTotalDiscountPrice() + data_variable.getPrice() * Static_data.MULTICHILD_DISCOUNT_RATE));
						data_variable.setDisNum(data_variable.getDisNum() + 1);
					}
				}
				System.out.printf("(공식증빙지참) 인원수 (%d명) 할인 적용됩니다.\n", numDaDoong);
			break;
		}
		data_variable.setGrandPrice(data_variable.getTotalPrice() + data_variable.getTotalDiscountPrice());
		return data_variable.getGrandPrice();
	}
	
//	void input_data_in_Arr(int ticket, int dayTicket, int advantage, int disAdvantage, int generation, int num, int disNum, int totalPrice, int totalDiscountPrice, int grandPrice) {
	void input_data_in_Arr(Order_data data_variable, ArrayList<Order_data> make_list) {
		make_list.add(data_variable);
	}
	
	void print_grand_price(Order_data data_variable){
		System.out.printf("총 가격은 %d원 입니다.", data_variable.getGrandPrice());
		System.out.printf(" 감사합니다.\n");
		System.out.printf("\n");
	}

	
}
