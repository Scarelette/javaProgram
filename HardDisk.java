
public class HardDisk {

	Double volume;
	String name;
	Double price;
	public HardDisk() {
		// TODO Auto-generated constructor stub
	}
	public HardDisk(String name,Double volume, Double price) {
		this.name = name;
		this.price = price;
		this.volume = volume;
	}
	public void work() {
		System.out.print(this.name + "work");
	}

}
