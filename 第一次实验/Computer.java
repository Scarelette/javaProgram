
public class Computer {
	
	private String name;
	private CPU CPU;
	private Memory memory;
	private HardDisk hardDisk;
	private MainBoard mainBoard;
	private Double price;

	public String getName() {
		return name;
	}

	public CPU getCPU() {
		return CPU;
	}

	public Memory getMemory() {
		return memory;
	}

	public HardDisk getHardDisk() {
		return hardDisk;
	}

	public MainBoard getMainBoard() {
		return mainBoard;
	}

	public Double getPrice() {
		return price;
	}

	public String getDescription() {
		String str = this.name + " CPU: " + this.CPU.name + " Memory: " + this.memory + " MainBoard: " + this.mainBoard + "HardDisk: " + this.hardDisk;
		return str;
	}
	
	public String work() {
		return "电脑在工作！";
	}
	public Computer(String name, Double price, CPU cpu, Memory memory, HardDisk hd, MainBoard mb) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.CPU = cpu;
		this.hardDisk = hd;
		this.memory = memory;
		this.mainBoard = mb;
	}
	

}
