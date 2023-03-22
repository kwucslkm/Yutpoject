package ProjectYnew;
//
public class ProjectYDTO {
	//
	private int retryChkno;
	private int nowyutCnt;
	private int sumPositionCnt;
	private String player;
	private static Integer totalyutcnt=0;
	private int playercnt;
	//
	public ProjectYDTO() {
		totalyutcnt++;
		this.playercnt++;
	}
	public int getRetryChkno() {
		return retryChkno;
	}
	public void setRetryChkno(int retryChkno) {
		this.retryChkno = retryChkno;
	}
	public int getSumPositionCnt() {
		return sumPositionCnt;
	}
	public void setSumPositionCnt(int sumPositionCnt) {
		this.sumPositionCnt = sumPositionCnt;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getNowyutCnt() {
		return nowyutCnt;
	}
	public void setNowyutCnt(int nowyutCnt) {
		this.nowyutCnt = nowyutCnt;
	}
	
	public static int getTotalyutcnt() {
		return totalyutcnt;
	}
	public static void setTotalyutcnt(int totalyutcnt) {
		ProjectYDTO.totalyutcnt = totalyutcnt;
	}
	public int getPlayercnt() {
		return playercnt;
	}
	public void setPlayercnt(int playercnt) {
		this.playercnt = playercnt;
	}
	@Override
	public String toString() {
		//
		String s2 = "  ";
		String str = totalyutcnt + s2 + playercnt + s2 + player + s2 + nowyutCnt
				+ s2 + sumPositionCnt + s2+ retryChkno;
		return str;
	}
}
