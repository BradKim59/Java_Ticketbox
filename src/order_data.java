package Ticket;

import java.util.Calendar;

public class order_data {
	Calendar cal = Calendar.getInstance();

	private int ticket;
	private int dayTicket;
	private int qty = 1;
	private int advantage;
	private int numDaDoong;
	private int conTicket = 0;
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
	private int current_year = cal.get(Calendar.YEAR);
	private int current_month = cal.get(Calendar.MONTH +1);
	private int current_date = cal.get(Calendar.DATE);
	private int lastday_M = cal.getActualMaximum(Calendar.MONTH+1);
	private int lastday_D = cal.getActualMaximum(Calendar.DATE);
	private String personID;
	private int nor_Date = 0;
	private int lun_Date = 0;
	
	order_data(int price, int totalPrice, int totalDiscountPrice, int grandPrice, int num, int disNum, int disAdvantage){
		this.price = price;
		this.totalPrice = totalPrice;
		this.totalDiscountPrice = totalDiscountPrice;
		this.grandPrice = grandPrice;
		this.num = num;
		this.disNum = disNum;
		this.disAdvantage = disAdvantage;
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

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getDayTicket() {
		return dayTicket;
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

	public void setDisAdvantage(int disAdvantage) {
		this.disAdvantage = disAdvantage;
	}

	public int getGeneration() {
		return generation;
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
