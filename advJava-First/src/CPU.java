
public class CPU {

	String name;
	Double price;
	int coreNum = 0;
	public CPU() {
		// TODO Auto-generated constructor stub
	}
	public CPU(String name, Double price, int coreNum) {
		this.name = name;
		this.price = price;
		this.coreNum = coreNum;
	}
	public void work() {
		System.out.print(this.name + "work");
	}

}
