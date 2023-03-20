package Yproject;
public class ProjectYRepository {
	
	int poCntA = 0;
	int poCntB = 0;
	
	public int PositionCnt(int nowcnt,String ch) {
		if (ch.equals("A")) {
			return poCntA += nowcnt;
		}else {
			return poCntB += nowcnt;
		}
		
	}

}
