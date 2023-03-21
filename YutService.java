package ProjectY.Yutpoject;
import java.util.Random;
import java.util.Scanner;
public class YutService {
	Scanner sc = new Scanner(System.in);
	ProjectYRepository yr = new ProjectYRepository();
	Random rd = new Random();// 랜덤 객체 생성
	ProjectYDTO pro = new ProjectYDTO();
	//
	public void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}
	public String randomspace() {// 윷가락의 위치를 변경하여 조금의 재미를 부여
		int randoms = rd.nextInt(10);
		String randomSpace = "";
		for (int i = 0; i < randoms; i++) {
			randomSpace = " " + randomSpace + " ";
		}
		return randomSpace;
	}
	public void Yut1() {
		String randomyut = randomspace();
		System.out.println(randomyut + "        _______________");
		System.out.println(randomyut + "       |___X___X___X___|" + 1);
	}
	public void Yut2() {
		String randomyut = randomspace();
		System.out.println(randomyut + "        _______________");
		System.out.println(randomyut + "       |_______________|" + 0);
	}
	public void Yut3() {
		String randomyut = randomspace();
		System.out.println(randomyut + "        _______________");
		System.out.println(randomyut + "       |_B_____________|" + 2);
	}
	public void firstShowroad() {
		clearScreen();
		yr.YboardRows("시작");
	}
	public ProjectYDTO throwYut(String ch) {
		String nowyutCnt = "";// 4개 윷 투척 조합 점수 기록 변수
		int nowPositionCnt = 0; // 한번던질때 진행 하는 칸수
		int sumPositionCnt = 0;
		String nowMal = "";//
		for (int i = 0; i < 4; i++) {
			if (rd.nextInt(2) == 1) {
				nowyutCnt = nowyutCnt + "1";
				Yut1();
			} else {
				nowPositionCnt++;// 도 개 걸 윷 확인(1.도 2.개 3.걸 4.윷 5.모)
				if (i == 0) {
					nowyutCnt = nowyutCnt + "2";
					Yut3();
				} else {
					nowyutCnt = nowyutCnt + "0";
					Yut2();
				}
			}
		}
		System.out.println();
		if (nowPositionCnt == 0) {
			nowPositionCnt = 5;
		} else if (nowyutCnt.equals("2111")) {
			nowPositionCnt = -1;
		}
		if (nowPositionCnt == 1) {// 도 개 걸 윷 모 찍어주는 로직
			nowMal = " => 이번 결과 도!!" + nowPositionCnt + " 칸 전진 입니다. ";
		} else if (nowPositionCnt == 2) {
			nowMal = " => 이번 결과 개!! " + nowPositionCnt + " 칸 전진 입니다. ";
		} else if (nowPositionCnt == 3) {
			nowMal = " => 이번 결과 걸!! " + nowPositionCnt + " 칸 전진 입니다. ";
		} else if (nowPositionCnt == 4) {
			nowMal = " => 이번 결과 윷!! " + nowPositionCnt + " 칸 전진 입니다. 그리고 한 번 더~~";
		} else if (nowPositionCnt == 5) {
			nowMal = " => 이번 결과 모!! " + nowPositionCnt + " 칸 전진 입니다. 그리고 한 번 더~~";
		} else {
			nowMal = " => 빽~도 입니다. 행운이길~! ";
		}
		System.out.println();
		sumPositionCnt = yr.PositionCnt(nowPositionCnt, ch);// 진행하는 말의 위치값을 저장
		ProjectYDTO cachM = yr.YboardRows(ch);// Road에 " 말 " 위치를 찍어주는 메소드
		if (cachM.getRetryChkno()==1&&cachM.getPlayer().equals("A")) {
			yr.PositionCntreset("B");
		} else {
			yr.PositionCntreset("A");
		}
		System.out.println("\n  " + nowyutCnt + " " + "참가자 " + ch + "님" + nowMal);
		System.out.println("  " + ch + " 님 위치 점수는 -> " + sumPositionCnt + " 입니다.");
		pro.setSumPositionCnt(sumPositionCnt);
		if (nowPositionCnt == 4 || nowPositionCnt == 5 || cachM.getRetryChkno() == 1) {
			pro.setRetryChkno(1);
			return pro;
		}
		pro.setRetryChkno(0);
		return pro;
	}
}