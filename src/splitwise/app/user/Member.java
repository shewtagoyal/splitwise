package splitwise.app.user;

public class Member {
	
	private int memberId;
	private String phoneNo;
	private String emailId;
	private String name;


	public Member(int memberId, String phoneNo, String emailId, String name) {
		super();
		this.memberId = memberId;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.name = name;
	}


	public int getId() {
		return memberId;
	}


	public String getName() {
		return name;
	}
	
	

	
	

}
