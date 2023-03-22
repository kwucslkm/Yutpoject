package ProjectYnew;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
//
public class YutService {
	Scanner sc = new Scanner(System.in);
	ProjectYRepository prepository = new ProjectYRepository();
	Random rd = new Random();// 랜덤 객체 생성
	int poCntA = 0; // A누적 점수
	int poCntB = 0; // B누적 점수
	public void clearScreen(int line) {
		for (int i = 0; i < line; i++)
			System.out.println("");
	}
	public void firstShowroad() {
		clearScreen(80);
//		YboardRows("시작");
	}
	public int PositionSumCnt(int nowPositionCnt, String player) {// 누적 점수 저장 메소드
		if (player.equals("A")) {
			poCntA += nowPositionCnt;
			return poCntA;
		} else {
			poCntB += nowPositionCnt;
			return poCntB;
		}
	}
	public ProjectYDTO throwYut(String player) {
		ProjectYDTO proYDTO = new ProjectYDTO();
		String nowyutCnt = "";// 4개 윷 투척 조합 점수 기록 코드 변수
		int nowPositionCnt = 0; // 한번던질때 진행 하는 칸수
		int sumPositionCnt = 0; // 누적점수
		int retryChk = 0; // 다시 윷 던지기 변수
		String nowMal = "";//
		System.out.println(" _______________________________YUT GAME !!_______________________________\n");
		clearScreen(1);
		for (int i = 0; i < 4; i++) {
			if (rd.nextInt(2) == 1) {
				nowyutCnt = nowyutCnt + "1";// 윷가락 코드를 따기위한
				prepository.Yut1();// 랜덤윷 호출
			} else {
				nowPositionCnt++;// 윗면이 안나오면 합산- 도 개 걸 윷 확인(1.도 2.개 3.걸 4.윷 5.모)
				if (i == 0) {
					nowyutCnt = nowyutCnt + "2";
					prepository.Yut3();
				} else {
					nowyutCnt = nowyutCnt + "0";
					prepository.Yut2();
				}
			}
		}
		System.out.println();
		if (nowPositionCnt == 0) {// '모'가 나올경우 5점으로 바꿔줌
			nowPositionCnt = 5; // '모'가 나올경우 5점으로 바꿔줌
		} else if (nowyutCnt.equals("2111")) {// 빽도가 나올경우
			nowPositionCnt = -1; // 빽도가 나올경우 -1점으로 바꿔 줌
		}
		if (nowPositionCnt == 4 || nowPositionCnt == 5) {// 윷이나 모가 나오면 재실행 변수를 1로 바꿈
			retryChk = 1;
		}
		nowMal = prepository.nowyutresult(nowPositionCnt);// 화면에 현재 윷 던지 결과를 출력
		System.out.println();// 여기서 플레이어와 현재 카운트와 다시실행 값을 넘겨줘야
		//
		proYDTO.setPlayer(player); // DTO 에 플레이어 저장
		proYDTO.setNowyutCnt(nowPositionCnt);// DTO 에 현재 윷카운트값 저장
		if (retryChk == 1) // DTO 에 재실행 변수를 저장
			proYDTO.setRetryChkno(retryChk);
		else {
			proYDTO.setRetryChkno(retryChk);
		}
		// 나중에 데스로드에서 잡힐 경우 DTO 에 누적값을 0으로 만드는 로직 추가 에정
		sumPositionCnt = PositionSumCnt(nowPositionCnt, player);
		proYDTO.setSumPositionCnt(sumPositionCnt);// DTO 에 누적카운트값 저장
		prepository.save(proYDTO);// 맵리스트에 윷 한 번 던졌을때의 값들을 저장
//
		System.out.println("\n  " + nowyutCnt + " " + "참가자 " + player + "님" + nowMal);// 현재윷 던진 결과값을 출력
		System.out.println("  " + player + " 님 위치 점수는 -> " + sumPositionCnt + " 입니다.");
//
		YboardRows(proYDTO);
		System.out.println(proYDTO);
		return proYDTO;
	}
	public ProjectYDTO YboardRows(ProjectYDTO proYDTO) {
		String boardO = " o ";
		String boardA = "\u001B[32m 'A' \u001B[0m";
		String boardB = "\u001B[33m 'B' \u001B[0m";
		String boardAB = " 'A B'";
		Map<Integer, ProjectYDTO> prDTO = prepository.remap();
		System.out.println("\n");
		System.out.println("                             * Death Road *");
		prepository.deathroad1();// 데스로드 호출
		System.out.print(" ");
		int catchM = 0; // 잡히는 상황 시 메시지 출력
		int goalNum = 20;
//		
		for (int i = 0; i <= goalNum; i = i + 1) {
			if (i == poCntA && i == poCntB) { // 따라잡은 상황
				if (proYDTO.getPlayer().equals("A")) {
					poCntB = 0;
				} else {
					poCntA = 0;
				}
				catchM = 1;
				System.out.print(boardAB);
			} else if (poCntB < poCntA && i == poCntB) {
				System.out.print(boardB);
			} else if (poCntB < poCntA && i == poCntA) {
				System.out.print(boardA);
			} else if (poCntB > poCntA && i == poCntA) {
				System.out.print(boardA);
			} else if (poCntB > poCntA && i == poCntB) {
				System.out.print(boardB);
			} else if(i==20) {
				if(poCntA>=goalNum) {
					System.out.print(boardA);
					System.out.println();
				}else if(poCntB>=goalNum) {
					System.out.print(boardB);
					System.out.println();
				}else {
					System.out.print("  GOAL!\n");
				}
				
			} else {
				System.out.print(boardO);
			}
				
		}
//		System.out.print("  GOAL!\n");
		prepository.deathroad1();// 데스로드 호출
		if (catchM == 1) {
			System.out.println("   앗 " + proYDTO.getPlayer() + " 님 잡았습니다. 한번더");
			proYDTO.setRetryChkno(1);
		}
		System.out.println();
		return proYDTO;
	}
}