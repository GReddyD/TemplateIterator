public class Main {
	public static void main(String[] args) {
		for (int r : new Randoms(90, 100)) {
			if (r == 100) {
				break;
			}
		}
	}
}
