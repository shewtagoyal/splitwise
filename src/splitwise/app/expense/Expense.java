package splitwise.app.expense;

import java.math.BigDecimal;
import java.util.Map;

import splitwise.app.group.Group;
import splitwise.app.user.Member;

public abstract class Expense {
	
	private String description;
	protected double amount;
	protected Member paidBy;
	private SplitType splitType;
	public Expense(String description, double amount, Member paidBy, SplitType splitType) {
		this.description = description;
		this.amount = amount;
		this.paidBy = paidBy;
		this.splitType = splitType;
	}
	
	

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public Member getPaidBy() {
		return paidBy;
	}

	public SplitType getSplitType() {
		return splitType;
	}
	
	public abstract Map<Member,BigDecimal> calculateAmountSpentOnEachMemberAfterSplit(Group group); 
	
	

	
}
