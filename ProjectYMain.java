package Yproject.Yutpoject;
//import java.util.Random;
import java.util.Scanner;
//
public class ProjectYMain {
	public static void main(String[] args) {
		YutService service = new YutService();
		Scanner sc = new Scanner(System.in);
		//
		boolean play = false;
		int gamecntA = 0;
		int gamecntB = 0;
		//
		service.firstShowroad();//화면을 지웁니다.
		System.out.println("                20칸 GOAL에 먼저 도달 하시는 플레이어가 승립합니다. ");
		System.out.println("                먼저 시작하실 분을 정하시고 참가자 A께서는 '1'을 눌러 시작하세요");
		System.out.println(" ------------------------ YUT GAME Start!!!!-----------------------\n");
		while (true) {
			System.out.println();
			System.out.println("   현재 A의 위치는 " + gamecntA + "입니다.");
			System.out.println("   현재 B의 위치는 " + gamecntB + "입니다.\n");
			if (gamecntA >= 20) {
				System.out.println("  축하합니다. 참가자 A 승리!!");
				break;
			} else if (gamecntB >= 20) {
				System.out.println("  축하합니다. 참가자 B 승리!!");
				break;
			}
			if (play) {
				System.out.println("  참가자 B press '2' enter> ");
			} else {
				System.out.println("  참가자 A press '1' enter> ");
			}
			int menu = sc.nextInt();
			if (menu == 1 && play == false) {
				service.clearScreen();
				ProjectYDTO resultThrow = service.throwYut("A");
				gamecntA = resultThrow.getSumPositionCnt();
				if (resultThrow.getRetryChkno() == 1) {// 윷이나 모가 나올경우 다시
					continue;
				}
				play = true;// turn 전환
				continue;
			} else if (menu == 2 && play == true) {
				service.clearScreen();
				ProjectYDTO resultThrow = service.throwYut("B");
				gamecntB = resultThrow.getSumPositionCnt();
				if (resultThrow.getRetryChkno() == 1) {
					continue;
				}
				play = false;// turn 전환
				continue;
			} else {
				System.out.println("다시입력");
			}
		}
		System.out.println("\n  게임 테스트 종료");
		sc.close();
	}
}