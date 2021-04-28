import java.util.Iterator;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Randoms implements Iterable<Integer> {
	private int min;
	private int max;
	private int randInt;
	protected Random random;

	public Randoms(int min, int max) {
		this.min = min;
		this.max = max;
		random = new Random();
	}

	private void renew() {
		randInt = (random.nextInt((max - min) + 1)) + min;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){
			@Override
			public boolean hasNext() {
				if (randInt == max) {
					return false;
				}
				return true;
			}

			@Override
			public Integer next() {
				renew();
				if (min >= max) {
					throw new IllegalArgumentException("max must be greater than min");
				} else {
					if (iterator().hasNext()){
						System.out.println("Случайное число: " + randInt);
						return randInt;
					} else {
						System.out.println("Выпало число " + max + ", давайте на этом закончим");
						return randInt;
					}
				}
			}
		};
	}
}