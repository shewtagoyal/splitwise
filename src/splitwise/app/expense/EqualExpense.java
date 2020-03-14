package splitwise.app.expense;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import splitwise.app.group.Group;
import splitwise.app.user.Member;

public class EqualExpense extends Expense{

	public EqualExpense(String description, double amount, Member paidBy) {
		super(description, amount, paidBy, SplitType.EQUAL_AMONG_ALL);
		
	}

	@Override
	public Map<Member, BigDecimal> calculateAmountSpentOnEachMemberAfterSplit(Group group) {
		Map<Member, BigDecimal> map=new HashMap<>();
		int noOfMembers=group.getMembers().size();
		BigDecimal amountSpentOnEachMember=BigDecimal.valueOf(amount/noOfMembers);
		
		for(Member member:group.getMembers()) {
		map.putIfAbsent(member, amountSpentOnEachMember);
		}
		return map;
		
	}
	
	
		
		
		
	}


