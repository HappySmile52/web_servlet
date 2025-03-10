package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class exam4 {
	public static void main(String[] args) {
		exam4_box eb = new exam4_box();
		eb.exam4();
	}
}

class exam4_box{
	Scanner sc = null;
	
	ArrayList<Integer> al = null;	// 배열 저장
	int num;	// 입력한 숫자
	
	public void exam4() {
		this.al = new ArrayList<Integer>();
		this.sc = new Scanner(System.in);
		
		System.out.println("10개의 숫자를 입력하세요 (1 ~ 500) : ");
		
		int w = 0;
		while(w < 10) {
			this.num = this.sc.nextInt();
			
			if(this.num >= 1 && this.num <= 500) {
				this.al.add(this.num);
				w++;
			}
			else {
				System.out.println("숫자는 1 ~ 500까지만 입력 가능합니다. 다시 입력해주세요");
			}
		}
		
		Collections.sort(this.al, Collections.reverseOrder());	// 내림차순
		System.out.println(this.al);
		
		this.sc.close();
	}
}