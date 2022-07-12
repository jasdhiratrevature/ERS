package com.jasdhir.ers.model;

public class Reimbursement {
	private int reimbursementId;
	private boolean accepted;
	private double amount;
	private String description;
	private String reimbursementType;
	private String resolveTime;
	private boolean resolved;
	private String submitTime;
	private int authorId;
	private int resolverId;
	public Reimbursement() {
		super();
	}
	public Reimbursement(int reimbursementId, boolean accepted, double amount, String description,
			String reimbursementType, String resolveTime, boolean resolved, String submitTime, int authorId,
			int resolverId) {
		super();
		this.reimbursementId = reimbursementId;
		this.accepted = accepted;
		this.amount = amount;
		this.description = description;
		this.reimbursementType = reimbursementType;
		this.resolveTime = resolveTime;
		this.resolved = resolved;
		this.submitTime = submitTime;
		this.authorId = authorId;
		this.resolverId = resolverId;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	public String getResolveTime() {
		return resolveTime;
	}
	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}
	public boolean isResolved() {
		return resolved;
	}
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", accepted=" + accepted + ", amount=" + amount
				+ ", description=" + description + ", reimbursementType=" + reimbursementType + ", resolveTime="
				+ resolveTime + ", resolved=" + resolved + ", submitTime=" + submitTime + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + "]";
	} 


}
