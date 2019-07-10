package src.com.revature.pojo;

import java.util.List;

public class Info {
	private ERS_USERS user;
	private List<ReimInfo> reims;
	
	
	public Info(){}
	public ERS_USERS getUser() {
		return user;
	}
	public void setUser(ERS_USERS user) {
		this.user=user;
	}
	
	
	
	public List<ReimInfo> getReims(){
	return reims;
}
	public void setReims(List<ReimInfo> reims) {

		this.reims = reims;

	}
}

