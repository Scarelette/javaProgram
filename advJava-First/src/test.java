
public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPU cpu = new CPU("11",11.1, 34);
		MainBoard mb = new MainBoard("aaa", 11.6, 22.3);
		HardDisk hd = new HardDisk("hd333", 11.4, 8.8);
		Memory memory = new Memory("qqq", 11.3, 56.6);
		
		Computer computer = new Computer("Lisa", 1000.0, cpu, memory, hd, mb);
		System.out.print(computer.getDescription());

	}

}
