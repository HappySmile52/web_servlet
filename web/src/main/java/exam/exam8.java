package exam;

import java.util.ArrayList;
import java.util.Arrays;

public class exam8 extends ex8_box {
	// 메소드 안에서 호출하는 것이 아니라 필드에 호출해야 한다.
	@Override
	public void even() { 	// 짝수
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));

		int w = 0;
		while(w < number.size()) {
			if(number.get(w) % 2 == 1) {	// 홀수 값 조건은 배열에서 삭제
				number.remove(w);	// remove시 배열의 index 즉 노드 번호가 변경됨
				w = 0;	// 0 사용은 배열의 값이 삭제되면 노드 변화로 처음부터 다시 검토하도록 함
			}
			else {
				w++;	// 해당 조건(홀수)이 아니면 +1 증가시켜서 배열을 검토하는 형태
			}
		}
		System.out.println("짝수 : " + number);
	}
	
	@Override
	public void odd() { 	// 홀수
		ArrayList<Integer> number2 = new ArrayList<Integer>(Arrays.asList(this.data));
		
		int w = 0;
		while(w < number2.size()) {
			if(number2.get(w) % 2 == 0) {	// 짝수 값 조건은 배열에서 삭제
				number2.remove(w);
				w = 0;
			}
			else {
				w++;
			}
		}
		System.out.println("홀수 : " + number2);
	}
	
	public static void main(String[] args) {
		new exam8().even();
		new exam8().odd();
	}
}

// 추상 클래스
abstract class ex8_box{
	Integer data[] = {3, 5, 2, 1, 6, 7, 8, 9, 10, 4};

	abstract public void even();	// 추상클래스는 바로 인자값을 넣을 수 없다.
	abstract public void odd();
}