package Yproject;
//import java.util.Random;
import java.util.Scanner;
public class ProjectYMain {
	public static void main(String[] args) {
		YutService service = new YutService();
		Scanner sc = new Scanner(System.in);
		//
		boolean play = false;
		int gamecnt = 0;
		System.out.println("먼저 하실분을 정하세요");
		while (true) {
			
			System.out.println();
			System.out.println("   ------- GAME START!-------");
			System.out.println("   현재 윷을 던진 횟수는 "+gamecnt+"입니다.\n");
			if (gamecnt == 10) {
				System.out.println("무승부");
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
				gamecnt++;
				if (service.throwYut("A") == 1) {
					continue;
				}
				play = true;
				continue;
			} else if (menu == 2 && play == true) {
				service.clearScreen();
				gamecnt++;
				if (service.throwYut("B") == 1) {
					continue;
				}
				play = false;
				continue;
			} else {
				System.out.println("다시입력");
			}
		}
		System.out.println(" 게임 테스트 종료");sc.close();
	}
}