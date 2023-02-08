package com.bezkoder.spring.jdbc.mysql.model;

public class Rewards {
    private long customerId;
	private String customerName;
	private long lastMonthRewardPoints;
    private long lastSecondMonthRewardPoints;
    private long lastThirdMonthRewardPoints;
    private long totalRewards;

    public long getCustomerId() {
        return customerId;
    }

	public String getCustomerName() {
		return customerName;
	}

    public long getLastMonthRewardPoints() {
		return lastMonthRewardPoints;
	}

	public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
		this.lastMonthRewardPoints = lastMonthRewardPoints;
	}

	public long getLastSecondMonthRewardPoints() {
		return lastSecondMonthRewardPoints;
	}

	public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
		this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
	}

	public long getLastThirdMonthRewardPoints() {
		return lastThirdMonthRewardPoints;
	}

	public void setLastThirdMonthRewardPoints(long lastThirdMonthRewardPoints) {
		this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
	}

	public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

    public long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(long totalRewards) {
        this.totalRewards = totalRewards;
    }
}
