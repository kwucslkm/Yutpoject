package ProjectYnew;
//import java.util.Random;
import java.util.Scanner;
//
public class ProjectYMain {
	public static void main(String[] args) {
		YutService service = new YutService();
		Scanner sc = new Scanner(System.in);
		//
		boolean play = false;// 참가자 순서를 바꿔 줄 변수
		int gamecntA = 0;// A말의 점수를 저장 할 변수
		int gamecntB = 0;// B말의 점수를 저장 할 변수
		//
		service.firstShowroad();// 처음0인 상태 로드 보드판을 출력합니다.
		System.out.println(" _____________________________YUT GAME !!_____________________________\n");
		service.clearScreen(14);
		System.out.println("              20칸 GOAL에 먼저 도달 하시는 플레이어가 '승리' 합니다. ");
		System.out.println("              먼저 시작하실 분을 정하시고 참가자 A께서는 '1'을 눌러 시작하세요\n");
//		service.YboardRows();
		System.out.println("\u001B[31m" + " ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
				+ "\u001B[0m");
		for (int i = 0; i < 20; i = i + 1) {
			if (i == 0) {
				System.out.print(" 'AB' ");
			}else {
				System.out.print(" o ");
			}
		}
		System.out.println("  Goal");
		System.out.println("\u001B[31m" + " ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
				+ "\u001B[0m");
		System.out.println(" ■■■■■■■■■■■■■■■■■■■■■■■■■ YUT GAME Start!!! ■■■■■■■■■■■■■■■■■■■■■■■■■\n");
		while (true) {// palyer A 와 player B 번갈아 가며 윷을 던집니다.
			System.out.println();// player의 점수를 출력 합니다.
			System.out.println("   현재 A의 위치는 " + gamecntA + "입니다.");
			System.out.println("   현재 B의 위치는 " + gamecntB + "입니다.\n");
			if (gamecntA >= 20) {
				System.out.println("  축하합니다. 참가자 A 승리!!");
				break;
			} else if (gamecntB >= 20) {
				System.out.println("  축하합니다. 참가자 B 승리!!");
				break;
			}
			//
			if (play) { // 게임을 시작 합니다.
				System.out.println("  참가자 B press '2' enter> ");
			} else {
				System.out.println("  참가자 A press '1' enter> ");
			}
			int menu = sc.nextInt();
			service.clearScreen(80);
			if (menu == 1 && play == false) {
				ProjectYDTO resultThrow = service.throwYut("A");// 윷을 던지는 메소드 호출 하여 DTO타입 변수에 리턴값을 담는다.
				gamecntA = resultThrow.getSumPositionCnt();// A의 위치값을 받아 변수에 담는다.
				if (resultThrow.getRetryChkno() == 1) {// 윷이나 모가 나오거나 앞 플레이어를 잡을 경우 다시 한 번 던집니다.
					continue;
				}
				play = true;// turn 전환
				continue;
			} else if (menu == 2 && play == true) {
				ProjectYDTO resultThrow = service.throwYut("B");
				gamecntB = resultThrow.getSumPositionCnt();// B 위치값을 받아 변수에 담는다.
				if (resultThrow.getRetryChkno() == 1) {// 윷이나 모가 나오거나 앞 플레이어를 잡을 경우 다시 한 번 던집니다.
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