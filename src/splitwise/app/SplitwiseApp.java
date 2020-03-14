package splitwise.app;

import java.util.ArrayList;
import java.util.List;

import splitwise.app.expense.EqualExpense;
import splitwise.app.expense.EqualAmongFewExpense;
import splitwise.app.expense.Expense;
import splitwise.app.group.Group;
import splitwise.app.user.Member;

public class SplitwiseApp {
	public static void main(String args[]) {
		Member m1=new Member(1,"1234","Ram@gmail.com","Ram");
		Member m2=new Member(2,"1235","Shyam@gmail.com","Shyam");
		Member m3=new Member(3,"1256","Tina@gmail.com","Tina");
		Member m4=new Member(4,"1345","Rina@gmail.com","Rina");
		
		Group g1=new Group(1,"Friends");
		g1.addMember(m1);
		g1.addMember(m2);
		g1.addMember(m3);
		g1.addMember(m4);
		
		Expense e1=new EqualExpense("Movie",400,m1);
		Expense e2=new EqualExpense("Food",400,m2);
		List<Member> spentOnMembers=new ArrayList<>();
		spentOnMembers.add(m2);
		spentOnMembers.add(m4);
		Expense e3=new EqualAmongFewExpense("Fun",300,m3,spentOnMembers);
		Expense e4=new EqualExpense("Fun",400,m4);
		
		List<Expense> expenses=new ArrayList<>();
		expenses.add(e1);
		expenses.add(e2);
		expenses.add(e3);
		expenses.add(e4);
		
		ExpenseManagerFactory factory=new ExpenseManagerFactory();
		
		
		String output=factory.displayTotalBalance(g1,expenses);
		System.out.print(output);
}
}
