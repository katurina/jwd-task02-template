package main;

class Baap {
	int x = 1;

	public void method() {
		System.out.println("1");
	}
}

class Baaap extends Baap {
	int x = 2;

	public void method() {
		System.out.println("2");
	}

}

public class Main extends Baap {
	public static void main(String[] args) {
		Baap a = new Baaap();
		((Baaap) a).method();
	}
}
