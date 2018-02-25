package gui;

public class CompanyDetails {
	private String cmpnyName;
	private String cmpnyLogoPath;
	private int cmpnyCode;
	private String cmpnyLink;
	private String address;
	private int shareTotal;
	private int shareCost;
	private String date;
	private String cmpnyDescription;
	private String phone;
	
	public CompanyDetails(String cmpnyName,String cmpnyLogoPath,int cmpnyCode,String cmpnyLink,String address,int shareTotal,
			int shareCost,String date,String cmpnyDescription,String phone)
	{
		this.cmpnyName=cmpnyName;
		this.cmpnyLogoPath=cmpnyLogoPath;
		this.cmpnyCode=cmpnyCode;
		this.cmpnyLink=cmpnyLink;
		this.address=address;
		this.shareTotal=shareTotal;
		this.shareCost=shareCost;
		this.date=date;
		this.cmpnyDescription=cmpnyDescription;
		this.phone=phone;
	}

	public String getCmpnyLink() {
		return cmpnyLink;
	}

	public String getCmpnyLogoPath() {
		return cmpnyLogoPath;
	}

	public int getCmpnyCode() {
		return cmpnyCode;
	}

	public String getDate() {
		return date;
	}

	public String getCmpnyName() {
		return cmpnyName;
	}

	public String getAddress() {
		return address;
	}

	public int getShareTotal() {
		return shareTotal;
	}

	public int getShareCost() {
		return shareCost;
	}

	public String getCmpnyDescription() {
		return cmpnyDescription;
	}

	public String getPhone() {
		return phone;
	}
}
