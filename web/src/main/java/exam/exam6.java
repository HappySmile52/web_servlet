package exam;

import java.util.Scanner;

public class exam6 {
	public static void main(String[] args) {
		String user[][] = {
				{"마동석", "01011112222"},
				{"김무열", "01022223333"},
				{"이동휘", "01033334444"},
				{"박지환", "01044445555"},
				{"이주빈", "01055556666"}
		};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("고객명을 입력하세요 : ");
		String name = sc.nextLine().replaceAll(" ", "");
		System.out.println(name);
		
		int w = 0;
		while(w < user.length) {
			if(name.equals(user[w][0])) {
				System.out.println(user[w][0] + "님 연락처는 " + user[w][1] + "입니다.");
			}
			w++;
		}
		sc.close();
	}

}
