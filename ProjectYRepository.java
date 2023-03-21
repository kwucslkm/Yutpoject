package ProjectY.Yutpoject;
import java.util.HashMap;
import java.util.Map;
public class ProjectYRepository {
	//
	Map<Integer, ProjectYDTO> Ybmap = new HashMap<>();
	ProjectYDTO prDTO = new ProjectYDTO();
	int poCntA = 0;
	int poCntB = 0;
	public int PositionCnt(int nowcnt, String ch) {
		if (ch.equals("A")) {
			return poCntA += nowcnt;
		} else {
			return poCntB += nowcnt;
		}
	}
	public int PositionCntreset(String play) {
		if (play.equals("A")) {
			poCntA = 0;
			return poCntA;
		} else {
			poCntB = 0;
			return poCntB;
		}
	}
	public void YboardColum() {
	}
	public ProjectYDTO YboardRows(String player) {
		String boardO = "  o";
		String boardA = "  A";
		String boardB = "  B";
		String boardAB = " A B";
		System.out.println("\n\n");
		System.out.println("                         * Death Road *");
		System.out.println(" -----------------------------------------------------------------");
		System.out.print(" ");
		int catchM = 0; // 잡히는 상황 시 메시지 출력
		if (poCntA == 0 && poCntB == 0) {
			for (int i = 0; i <= 20; i = i + 1) {
				if (i == poCntA && i == poCntB) {
					System.out.print(boardAB);
				} else {
					System.out.print(boardO);
				}
			}
		} else {
			for (int i = 0; i <= 20; i = i + 1) {
				if (i == poCntA && i == poCntB) {
					if (player.equals("A")) {
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
				} else {
					System.out.print(boardO);
				}
			}
		}
		System.out.println("\n -----------------------------------------------------------------");
		if (catchM == 1) {
			System.out.println("앗 " + player + " 님 잡았습니다. 한번더");
		}
		System.out.println();
		prDTO.setPlayer(player);
		prDTO.setRetryChkno(catchM);
		return prDTO;
	}
}
