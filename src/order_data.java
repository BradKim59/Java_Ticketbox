public class order_data {
	private int ticket;
	private int dayTicket;
	public int qty = 1;
	public int advantage;
	public int numDaDoong;
	//계산 시 변수 선언 
	public int disAdvantage;
	public int generation;
	public int discountType;
	public int price;
	public int totalPrice;
	public int totalDiscountPrice;
	public int grandPrice;
	public int grandSum;
	public int num;
	public int disNum;
	private int gender;
	public int year;
	public int month;
	public int date;
	public int four_digit_year;
	
	
	
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public int getDayTicket() {
		return dayTicket;
	}
	public void setDayTicket(int dayTicket) {
		this.dayTicket = dayTicket;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		if(gender < 1 || gender > 2) {
			return;
		}
		this.gender = gender;
	}
}













