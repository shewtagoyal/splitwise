package splitwise.app.group;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import splitwise.app.user.Member;
public class Group {

	private int groupId;
	private String GroupName;
	private List<Member> members=new ArrayList<>();
	private Map<Member,BigDecimal> m=new HashMap<>();
	
	public Group(int id,String name) {
		this.groupId=id;
		this.GroupName=name;
	}
	
	public List<Member> getMembers() {
		return members;
	}
	public void addMember(Member member) {
		this.members.add(member);
	}

		
		
			}
			
				
		


		
			
		 

