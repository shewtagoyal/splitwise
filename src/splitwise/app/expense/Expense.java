package splitwise.app.expense;

import java.util.List;

import splitwise.app.group.Group;
import splitwise.app.user.Member;

public class Expense {
	
	private String description;
	private double amount;
	private Member paidBy;
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
	
}
