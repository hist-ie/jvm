package org.houor.jvm.ch04;

public class CanReliveObject {

	public static CanReliveObject obj;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("CanReliveObject finalize called.");
		obj = this;
	}

	@Override
	public String toString() {
		return "I am CanReliveObject";
	}

	public static void main(String[] args) throws InterruptedException {
		obj = new CanReliveObject();
		obj = null;
		System.gc();
		Thread.sleep(1000);
		if (obj == null) {
			System.out.println("obj is null");
		} else {
			System.out.println("obj can use");
		}

		System.out.println("the second gc....");

		obj = null;
		Thread.sleep(1000);
		if (obj == null) {
			System.out.println("obj is null");
		} else {
			System.out.println("obj can use");
		}

	}

}
