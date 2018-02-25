package gui;

public class Record {
	private int cmpnyId;
	private String cmpnyName;
	private String cmpnyLogoPath;
	private int cmpnyCode;
	private String cmpnyLink;
	private String address;
	private int shareTotal;
	private int shareCost;
	private String cmpnyDescription;
	private String phone;
	public Record(int cmpnyId, String cmpnyName,String cmpnyLogoPath, int cmpnyCode,String cmpnyLink, String address, int shareTotal, int shareCost, String cmpnyDescription, String phone)
	{
		this.cmpnyId=cmpnyId;
		this.cmpnyName=cmpnyName;
		this.cmpnyLogoPath=cmpnyLogoPath;
		this.cmpnyCode=cmpnyCode;
		this.cmpnyLink=cmpnyLink;
		this.address=address;
		this.shareTotal=shareTotal;
		this.shareCost=shareCost;
		this.cmpnyDescription=cmpnyDescription;
		this.phone=phone;
	}

	public String getCmpnyLink() {
		return cmpnyLink;
	}

	public String getCmpnyLogoPath() {
		return cmpnyLogoPath;
	}

	public String getAddress() {
		return address;
	}

	public String getCmpnyDescription() {
		return cmpnyDescription;
	}

	public String getPhone() {
		return phone;
	}

	public int getCmpnyId() {
		return cmpnyId;
	}

	public String getCmpnyName() {
		return cmpnyName;
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
}
