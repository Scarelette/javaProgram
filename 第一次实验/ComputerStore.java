
public class ComputerStore {

	Computer computer1;
	Computer computer2;
	Computer computer3;
	
	public ComputerStore() {
		// TODO Auto-generated constructor stub
	}
	public ComputerStore(Computer cmp1,Computer cmp2, Computer cmp3) {
		this.computer1 = cmp1;
		this.computer2 = cmp2;
		this.computer3 = cmp3;
	}
	public void showComputerInfo() {
		System.out.print(computer1.getName() + "描述：" + computer1.getDescription() + "价格：" + computer1.getPrice() + "工作状态：" + computer1.work());
		System.out.print(computer2.getName() + "描述：" + computer2.getDescription() + "价格：" + computer2.getPrice() + "工作状态：" + computer2.work());
		System.out.print(computer3.getName() + "描述：" + computer3.getDescription() + "价格：" + computer3.getPrice() + "工作状态：" + computer3.work());
	}

}
