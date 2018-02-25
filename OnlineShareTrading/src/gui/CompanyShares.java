package gui;

public class CompanyShares {
	private int cmpnyCode;
	private int shareTotal;
	private int shareCost;
	private String date;
	
	public CompanyShares(int cmpnyCode,int shareTotal,int shareCost,String date)
	{
		this.cmpnyCode=cmpnyCode;
		this.shareTotal=shareTotal;
		this.shareCost=shareCost;
		this.date=date;
	}

	public int getCmpnyCode() {
		return cmpnyCode;
	}

	public int getShareTotal() {
		return shareTotal;
	}

	public int getShareCost() {
		return shareCost;
	}

	public String getDate() {
		return date;
	}
}
