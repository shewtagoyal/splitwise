package splitwise.app.group;
import java.util.List;

import splitwise.app.expense.Expense;
import splitwise.app.expense.SplitType;
import splitwise.app.user.Member;
public class Group {

	private int groupId;
	private String GroupName;
	private List<Member> members;
	private List<Expense> expenses;
	
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
		public void addExpense(Expense expense) {
			this.expenses.add(expense);
		}
		
		 public double calculateBalanceOfEachMember() {
			 List<Member> members=getMembers();
				int noOfMembers=members.size();
				double balance = 0;
			 if(this.splitType==SplitType.EQUAL) {
				balance =amount/noOfMembers;			
			 }
			 if(this.splitType==SplitType.EXACT) {
				 balance=amount;
			 }
			 return balance;
		 }
		 
	}

