package pkg;

public class helperFunctions {

	public helperFunctions() {


	}
	public static OptionArray buildFactoryOptions() {
		OptionArray array = new OptionArray(4);		
		array.add(new Option("Cloth Seats",0, 0, "Basic Seat Option"));
		array.add(new Option("AM/FM CD PLayer",0, 0, "Basic Entertainment Option"));
		array.add(new Option("Premium Wheel Covers 15 inch wheels",0, 0, "Basic wheel Option"));		
		array.add(new Option("Cruise Control",0, 0, "Standard Cruise Control"));		
		return array;		
	}

	public static OptionArray buildCommonOptions() {
		OptionArray array = new OptionArray(5);
		array.add(new Option("Leather Bucket Seats w/ lumbar support",100, 50, "Upgraded Seat Option"));
		array.add(new Option("AM/FM CD Player w/ mp3 ",75, 25, "Upgraded Entertainment Option"));
		array.add(new Option("Alloy Rims Wheel Covers 16 inch wheels",150, 100, "Upgraded wheel Option"));		
		array.add(new Option("Security System",175, 150, "Security System"));	
		array.add(new Option("Adaptive Cruise Control",200, 150, "Standard Cruise Control"));
		return array;		
	}

	public static OptionArray buildExtremeOptions() {
		OptionArray array = new OptionArray(7);
		array.add(new Option("Heated & Cooled Leather Seats",250, 150, "Upgraded Seat Option"));
		array.add(new Option("Infotainment MP3/CD PlLayer w/10 Speakers",200, 175, "Upgraded Entertainment Option"));
		array.add(new Option("Alloy Rims Wheel Covers 20 inch wheels", 300, 250, "Upgraded wheel Option"));		
		array.add(new Option("Upgaded Security System w/ heartbeat sensor",250, 75, "Security System"));	
		array.add(new Option("Adaptive Cruise Control",200, 150, "Standard Cruise Control"));
		array.add(new Option("Moon Roof",500, 350, "Panoramic Moon roof"));
		array.add(new Option("Premium Paint",800, 1250, "Extreme Paint w/ Decals"));
		return array;		
	}

}
