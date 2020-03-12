package splitwise.app;

import splitwise.app.expense.Expense;
import splitwise.app.expense.SplitType;
import splitwise.app.group.Group;
import splitwise.app.user.Member;

public class ExpenseManager {

	
	public static void main(String args[]) {
		Member m1=new Member(1,"1234","Ram@gmail.com","Ram");
		Member m2=new Member(2,"1235","Shyam@gmail.com","Shyam");
		Member m3=new Member(3,"1256","Dhyam@gmail.com","Dhyam");
		
		Group g1=new Group(1,"Friends");
		g1.addMember(m1);
		g1.addMember(m2);
		g1.addMember(m3);
		
		Expense e1=new Expense("Movie",500,m1,SplitType.EQUAL);
		Expense e2=new Expense("Food",100,m2,SplitType.EXACT);
		Expense e3=new Expense("Fun",200,m3,SplitType.PERCENT);
		
		g1.addExpense(e1);
		g1.addExpense(e2);
		g1.addExpense(e3);
		
		
		
				
	}
}
