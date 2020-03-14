package splitwise.app.expense;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import splitwise.app.group.Group;
import splitwise.app.user.Member;

public class EqualAmongFewExpense extends Expense {
	
	private List<Member> spentOnMembers=new ArrayList<>();

	public EqualAmongFewExpense(String description, double amount, Member paidBy,List<Member> spentOnMembers) {
		super(description, amount, paidBy, SplitType.EQUAL_AMONG_FEW);
		this.spentOnMembers=spentOnMembers;
	}

	@Override
	public Map<Member, BigDecimal> calculateAmountSpentOnEachMemberAfterSplit(Group group) {
		Map<Member, BigDecimal> map=new HashMap<>();
        int noOfMembers=spentOnMembers.size()+1;
        BigDecimal amountSpentOnEachMember=BigDecimal.valueOf(amount/noOfMembers);
		for(Member member:spentOnMembers) {
			map.putIfAbsent(member, amountSpentOnEachMember);
		}
		map.putIfAbsent(paidBy, amountSpentOnEachMember);
		return map;
	}

}
