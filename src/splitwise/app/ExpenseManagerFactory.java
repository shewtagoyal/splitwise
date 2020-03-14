package splitwise.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import splitwise.app.expense.Expense;
import splitwise.app.expense.SplitType;
import splitwise.app.group.Group;
import splitwise.app.user.Member;

public class ExpenseManagerFactory {

	private Map<Member,BigDecimal> m=new HashMap<>();
	
	public String displayTotalBalance(Group group,List<Expense> expenses) {
		
		for(Expense expense:expenses) {
		calculateAmountOwedByEachMemberAfterExpense(group,expense);
		}
		String display="";
		for(Map.Entry<Member, BigDecimal> entry:  m.entrySet()) {
			if(entry.getValue().compareTo(BigDecimal.valueOf(0))>0)
			{
				display=display+entry.getKey().getName()+ " gets back "+ entry.getValue().toString() +"\n";
			}
			else {
				BigDecimal amountOwed=entry.getValue().multiply(BigDecimal.valueOf(-1));
				display=display+entry.getKey().getName()+ " owe "+ amountOwed.toString() + "\n";
			}
		}
		return display;
	}
	
	private void calculateAmountOwedByEachMemberAfterExpense(Group group, Expense expense) {
		Map<Member, BigDecimal> amountSpentOnEachMember;
		BigDecimal amountOwed = null;
		amountSpentOnEachMember=expense.calculateAmountSpentOnEachMemberAfterSplit(group);
		for(Member member:group.getMembers()) {	
			if(amountSpentOnEachMember.containsKey(member)) {
			if(member.getId()==expense.getPaidBy().getId()) {
				amountOwed=BigDecimal.valueOf(expense.getAmount()-amountSpentOnEachMember.get(member).doubleValue());
				
			}
			else {
				amountOwed=BigDecimal.valueOf(amountSpentOnEachMember.get(member).doubleValue()*-1);					
			}
			
			
			if(m.containsKey(member)) {
			amountOwed=amountOwed.add(m.get(member));	
			m.replace(member,amountOwed);
			}
			}
			m.putIfAbsent(member, amountOwed);
			
		}
		
		
		
				
	}
}
