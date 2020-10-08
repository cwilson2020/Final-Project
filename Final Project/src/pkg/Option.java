package pkg;

public class Option {
	String Name;
	private int PackagePrice;
	private int AlaCartePrice;
	private String Description;


	public Option(String Name, int AlaCartePrice, int PackagePrice, String Description) {
		super();
		this.PackagePrice = PackagePrice;
		this.AlaCartePrice = AlaCartePrice;
		this.Name = Name;
		this.Description = Description;
	}
	public Option() {}
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}
	public int getPackagePrice() {
		return PackagePrice;
	}
	public void setPackagePrice(int packagePrice) {
		PackagePrice = packagePrice;
	}
	public int getAlaCartePrice() {
		return AlaCartePrice;
	}
	public void setAlaCartePrice(int alaCartePrice) {
		AlaCartePrice = alaCartePrice;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}

