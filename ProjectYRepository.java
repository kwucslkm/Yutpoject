package ProjectY.Yutpoject;
import java.util.HashMap;
import java.util.Map;
public class ProjectYRepository {
	//
	Map<Integer, ProjectYDTO> Ybmap = new HashMap<>();
	int poCntA = 0;
	int poCntB = 0;
	public int PositionCnt(int nowcnt, String ch) {
		if (ch.equals("A")) {
			return poCntA += nowcnt;
		} else {
			return poCntB += nowcnt;
		}
	}
	public void YboardColum() {
	}
	public void YboardRows(String player) {
		String boardO = "  o";
		String boardA = "  A";
		String boardB = "  B";
		String boardAB = " A B";
		System.out.println("\n\n");
		System.out.println("                         * Death Road *");
		System.out.println(" -----------------------------------------------------------------");
		System.out.print(" ");
		boolean catchM = true; // 잡히는 상황 시 메시지 출력
		if (poCntA == 0 && poCntB == 0) {
			for (int i = 0; i <= 40; i = i + 2) {
				if ((i == (poCntA * 2)) && (i == (poCntB * 2))) {
					System.out.print(boardAB);
				} else {
					System.out.print(boardO);
				}
			}
		} else {
			for (int i = 0; i <= 20; i = i + 1) {
				if ((i == (poCntA )) && (i == (poCntB ))) {
//					if (player.equals("A")) {
//						poCntB = 0;
//					} else {
//						poCntA = 0;
//					}
//					catchM = false;
					System.out.print(boardAB);
				} else if (poCntB < poCntA && i == poCntB) {
					System.out.print(boardB);
				} else if (poCntB < poCntA && i == poCntA) {
					System.out.print(boardA);
				} else if (poCntB > poCntA && i == poCntA) {
					System.out.print(boardA);
				} else if (poCntB > poCntA && i == poCntB) {
				} else {
					System.out.print(boardO);
				}
			}
		}
		if (!catchM) {
			System.out.println("앗 잡았습니다.");
		}
		System.out.println("\n -----------------------------------------------------------------");
		System.out.println();
	}
}
