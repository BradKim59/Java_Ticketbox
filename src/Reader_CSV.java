package ticketing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader_CSV {

	void csv_reader_raw() {
		ArrayList <String> raw = new ArrayList<String>();
		ArrayList <String> raw2 = new ArrayList<String>();
			try {
				BufferedReader br = null;
				String line;
				String path = "C:\\project\\ticket_list_raw.csv";
				try {
					System.out.printf("=================================================== report.csv ==================================================\n");
					br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ms949"));
					while ((line = br.readLine()) != null) {
						raw.add(line); // 쉼표로 구분
					}
					for (int index = 0; index < raw.size(); index++) {
						String comma = raw.get(index).replaceAll(",", "   \t    ");
						raw2.add(comma);
					}
					for (int index2 = 0; index2 < raw2.size(); index2++) {
						System.out.print(raw2.get(index2));
						System.out.println(" ");
						if (index2 == 0) {
							System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");
						}
					}
					System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} finally {
		}
	}
	
	void csv_ticket_type_reader( ) {
		ArrayList <String> raw = new ArrayList<String>();
		ArrayList <String> raw_generation_1day = new ArrayList<String>();
		ArrayList <String> raw_generation_after4 = new ArrayList<String>();
		int oneDayTicket = 0;
		int after4Ticket = 0;
		int oneDayPrice = 0;
		int after4Price = 0;
		try {
			BufferedReader br = null;
			String line;
			String path = "C:\\project\\ticket_list_raw.csv";
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ms949"));
				while ((line = br.readLine()) != null) {
					raw.add(line); // 쉼표로 구분
				}
				for (int index = 0; index < raw.size(); index++) {
					String[] arr = raw.get(index).split(",");
					
					if (arr[2].equals("1")) {
						oneDayTicket += Integer.parseInt(arr[4]);
						oneDayPrice += Integer.parseInt(arr[5]);
						raw_generation_1day.add(arr[3]);
					}
					if (arr[2].equals("2")) {
						after4Ticket += Integer.parseInt(arr[4]);
						after4Price += Integer.parseInt(arr[5]);
						raw_generation_after4.add(arr[3]);
					}

				}
				System.out.printf("================================ 권종 별 판매 현황 =================================\n");
				System.out.printf("1DAY 총 %d매\n", oneDayTicket);
				int infant_ticket = 0;
				int baby_ticket = 0;
				int child_ticket = 0;
				int teen_ticket = 0;
				int adult_ticket = 0;
				int old_ticket = 0;			
				for (int index = 1; index<raw_generation_1day.size(); index++) {
					if (raw_generation_1day.get(index).equals("1")) {
						infant_ticket = infant_ticket + Integer.parseInt(raw_generation_1day.get(index));
					} else if(raw_generation_1day.get(index).equals("2")) {
						baby_ticket = baby_ticket + Integer.parseInt(raw_generation_1day.get(index));
					} else if(raw_generation_1day.get(index).equals("3")) {
						child_ticket = child_ticket + Integer.parseInt(raw_generation_1day.get(index));
					} else if(raw_generation_1day.get(index).equals("4")) {
						teen_ticket = teen_ticket + Integer.parseInt(raw_generation_1day.get(index));
					} else if(raw_generation_1day.get(index).equals("5")) {
						adult_ticket = adult_ticket + Integer.parseInt(raw_generation_1day.get(index));
					} else if(raw_generation_1day.get(index).equals("6")) {
						old_ticket = old_ticket + Integer.parseInt(raw_generation_1day.get(index));
					} 
				}
				System.out.printf("신생아 %d매, 영유아 %d매, 어린이 %d매, 청소년 %d매,성인 %d매, 만65이상 %d매\n"
						, infant_ticket, baby_ticket, child_ticket, teen_ticket, adult_ticket, old_ticket);
				System.out.printf("1DAY 매출 : %d원\n\n", oneDayPrice);
				System.out.printf("AFTER4 총 %d매\n", after4Ticket);
				infant_ticket = 0;
				baby_ticket = 0;
				child_ticket = 0;
				teen_ticket = 0;
				adult_ticket = 0;
				old_ticket = 0;			
				for (int index = 1; index<raw_generation_after4.size(); index++) {
					if (raw_generation_after4.get(index).equals("1")) {
						infant_ticket = infant_ticket + Integer.parseInt(raw_generation_after4.get(index));
					} else if(raw_generation_after4.get(index).equals("2")) {
						baby_ticket = baby_ticket + Integer.parseInt(raw_generation_after4.get(index));
					} else if(raw_generation_after4.get(index).equals("3")) {
						child_ticket = child_ticket + Integer.parseInt(raw_generation_after4.get(index));
					} else if(raw_generation_after4.get(index).equals("4")) {
						teen_ticket = teen_ticket + Integer.parseInt(raw_generation_after4.get(index));
					} else if(raw_generation_after4.get(index).equals("5")) {
						adult_ticket = adult_ticket + Integer.parseInt(raw_generation_after4.get(index));
					} else if(raw_generation_after4.get(index).equals("6")) {
						old_ticket = old_ticket + Integer.parseInt(raw_generation_after4.get(index));
					} 
				}
				System.out.printf("신생아 %d매, 영유아 %d매, 어린이 %d매, 청소년 %d매,성인 %d매, 만65이상 %d매\n"
						, infant_ticket, baby_ticket, child_ticket, teen_ticket, adult_ticket, old_ticket);
				System.out.printf("AFTER4 매출 : %d원\n", after4Price);
				System.out.printf("---------------------------------------------------------------\n");
				System.out.println(raw_generation_1day);
				System.out.println(raw_generation_after4);


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} finally {
			
		}
	}
}