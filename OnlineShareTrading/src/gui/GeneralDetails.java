package gui;

public class GeneralDetails {
	private String cmpnyName;
	private String cmpnyLogoPath;
	private int cmpnyCode;
	private String cmpnyLink;
	private String address;
	private String cmpnyDescription;
	private String phone;
	
	public GeneralDetails(String cmpnyName,String cmpnyLogoPath, int cmpnyCode,String cmpnyLink, String address, String cmpnyDescription, String phone)
	{
		this.cmpnyName=cmpnyName;
		this.cmpnyLogoPath=cmpnyLogoPath;
		this.cmpnyCode=cmpnyCode;
		this.cmpnyLink=cmpnyLink;
		this.address=address;
		this.cmpnyDescription=cmpnyDescription;
		this.phone=phone;
	}

	public String getCmpnyLogoPath() {
		return cmpnyLogoPath;
	}

	public String getCmpnyLink() {
		return cmpnyLink;
	}

	public String getCmpnyName() {
		return cmpnyName;
	}

	public int getCmpnyCode() {
		return cmpnyCode;
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
}
