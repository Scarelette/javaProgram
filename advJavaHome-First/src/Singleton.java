
public class Singleton {

	private static Singleton instance = new Singleton();
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	public static Singleton getInstance() {
		return instance;
	}

	public static void showInfo() {
		System.out.println("单例化success!!");
	}

}
