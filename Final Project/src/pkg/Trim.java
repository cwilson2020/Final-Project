package pkg;

public interface Trim {

	String getTrim();
	int getPrice();	
}

 class Value_Type implements Trim{

	@Override
	public String getTrim() {	
		return "Value";
	}

	@Override
	public int getPrice() {
		return 25000;
	}
}

class Common_Type implements Trim{

	@Override
	public String getTrim() {	
		return "Common";
	}

	@Override
	public int getPrice() {
		return 30000;
	}
}

class Extreme_Type implements Trim{

	@Override
	public String getTrim() {	
		return "Extreme";
	}

	@Override
	public int getPrice() {
		return 56000;
	}
}

