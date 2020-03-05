
public class MainBoard {
	
	Double speed;
	String name;
	Double price;
	
	public MainBoard() {
		// TODO Auto-generated constructor stub
	}
	public MainBoard(String name, Double price, Double speed) {
		this.name = name;
		this.price = price;
		this.speed = speed;
	}
	public void work() {
		System.out.print(this.name + "work");
	}


}
