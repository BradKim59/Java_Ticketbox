package ticketing;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order_data {
	SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
	Calendar cal = Calendar.getInstance();

	private int ticket;
	private int dayTicket;
	private int qty;
	private int advantage;
	private int numDaDoong;
	private int conTicket;
	private int disAdvantage;
	private int generation;
	private int discountType;
	private int price;
	private int totalPrice;
	private int totalDiscountPrice;
	private int grandPrice;
	private int grandSum;
	private int num;
	private int disNum;
	private int year;
	private int month;
	private int date;
	private int gender;
	private int four_digit_year;
	private int current_year;
	private int current_month;
	private int current_date;
	private int lastday_M;
	private int lastday_D;
	private String personID;
	private int nor_Date;
	private int lun_Date;
	int final_count;
	String orderdate;
	String menu = "주문일자"+ "," +"이용권타입" + "," + "시간타입" + "," + "연령대"+ "," + "수량" + "," + "가격" + "," + "할인타입";
	String menu_for_ticket_type = "구분"+ "," +"주간권" + "," + "야간권";
	Order_data(){
		this.price = 0;
		this.totalPrice = 0;
		this.totalDiscountPrice = 0;
		this.grandPrice = 0;
		this.num = 0;
		this.disNum = 0;
		this.disAdvantage = 1;
		this.current_year = cal.get(Calendar.YEAR);
		this.current_month = cal.get(Calendar.MONTH)+1;
		this.current_date = cal.get(Calendar.DATE);
		this.lastday_M = cal.getActualMaximum(Calendar.MONTH+1);
		this.lastday_D = cal.getActualMaximum(Calendar.DATE);
		this.nor_Date = 0;
		this.lun_Date = 0;
		this.final_count = 0;
		this.conTicket = 0;
		this.qty = 1;
		this.orderdate = df.format(cal.getTime());
; 
	}
	
	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public int getTicket() {
		return ticket;
	}
	
	public String getTicketToString() {
		if (ticket ==1) {
			return "종합이용권";
		} else if(ticket == 2) {
			return "파크이용권";
		} else {
			return "error";
		}
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getDayTicket() {
		return dayTicket;
	}

	public String getDayTicketToString() {
		if (dayTicket ==1) {
			return "1DAY";
		} else if(dayTicket == 2) {
			return "AFTER4";
		} else {
			return "error";
		}
	}
	
	public void setDayTicket(int dayTicket) {
		this.dayTicket = dayTicket;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getAdvantage() {
		return advantage;
	}
	
	public String getAdvantageToString() {
		if (advantage == 2) {
			return "장애인 우대적용";
		} else if (advantage == 3) {
			return "국가유공자 우대적용";
		} else if (advantage == 4) {
			return "휴가장병 우대적용";
		} else if (advantage == 5) {
			return "임산부 우대적용";
		} else if (advantage == 6) {
			return "다둥이 우대적용";
		} else {
			return "error";
		}
	}

	public void setAdvantage(int advantage) {
		this.advantage = advantage;
	}

	public int getNumDaDoong() {
		return numDaDoong;
	}

	public void setNumDaDoong(int numDaDoong) {
		this.numDaDoong = numDaDoong;
	}

	public int getConTicket() {
		return conTicket;
	}

	public void setConTicket(int conTicket) {
		this.conTicket = conTicket;
	}

	public int getDisAdvantage() {
		return disAdvantage;
	}
	
	public String getDisAdvantageToString() {
		if (disAdvantage == 1) {
			return "할인 미적용";
		} else if(disAdvantage == 2) {
			return "장애인할인 외 일반가격";
		} else if(disAdvantage == 3) {
			return "유공자할인 외 일반가격";
		} else if(disAdvantage == 4) {
			return "장병할인 외 일반가격";
		} else if(disAdvantage == 5) {
			return "임산부할인 외 일반가격";
		} else if(disAdvantage == 6) {
			return "다둥이할인 외 일반가격";
		} else {
			return "error";
		}
	}

	public void setDisAdvantage(int disAdvantage) {
		this.disAdvantage = disAdvantage;
	}

	public int getGeneration() {
		return generation;
	}
	
	public String getGenerationToString() {
		if (generation == 1) {
			return "신생아";
		} else if (generation == 2) {
			return "영유아";
		} else if (generation == 3) {
			return "어린이";
		} else if (generation == 4) {
			return "청소년";
		} else if (generation == 5) {
			return "성인";
		} else if (generation == 6) {
			return "만67이상";
		} else {
			return "error";
		}
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalDiscountPrice() {
		return totalDiscountPrice;
	}

	public void setTotalDiscountPrice(int totalDiscountPrice) {
		this.totalDiscountPrice = totalDiscountPrice;
	}

	public int getGrandPrice() {
		return grandPrice;
	}

	public void setGrandPrice(int grandPrice) {
		this.grandPrice = grandPrice;
	}

	public int getGrandSum() {
		return grandSum;
	}

	public void setGrandSum(int grandSum) {
		this.grandSum = grandSum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDisNum() {
		return disNum;
	}

	public void setDisNum(int disNum) {
		this.disNum = disNum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getFour_digit_year() {
		return four_digit_year;
	}

	public void setFour_digit_year(int four_digit_year) {
		this.four_digit_year = four_digit_year;
	}

	public int getCurrent_year() {
		return current_year;
	}

	public void setCurrent_year(int current_year) {
		this.current_year = current_year;
	}

	public int getCurrent_month() {
		return current_month;
	}

	public void setCurrent_month(int current_month) {
		this.current_month = current_month;
	}

	public int getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(int current_date) {
		this.current_date = current_date;
	}

	public int getLastday_M() {
		return lastday_M;
	}

	public void setLastday_M(int lastday_M) {
		this.lastday_M = lastday_M;
	}

	public int getLastday_D() {
		return lastday_D;
	}

	public void setLastday_D(int lastday_D) {
		this.lastday_D = lastday_D;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
		this.year = Integer.parseInt(personID.substring(0, 2));
		this.month = Integer.parseInt(personID.substring(2, 4));
		this.date = Integer.parseInt(personID.substring(4, 6));
		this.gender = Integer.parseInt(personID.substring(6, 7));
	}

	public int getNor_Date() {
		return nor_Date;
	}

	public void setNor_Date(int nor_Date) {
		this.nor_Date = nor_Date;
	}

	public int getLun_Date() {
		return lun_Date;
	}

	public void setLun_Date(int lun_Date) {
		this.lun_Date = lun_Date;
	}

}
