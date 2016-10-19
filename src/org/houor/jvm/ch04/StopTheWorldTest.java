package org.houor.jvm.ch04;

import java.util.HashMap;

public class StopTheWorldTest {

	public static void main(String[] args) {

		AllocateMemoryThread amt = new AllocateMemoryThread();
		PrintThread pt = new PrintThread();
		amt.start();
		pt.start();

	}

}

class PrintThread extends Thread {

	private static final long startTime = System.currentTimeMillis();

	@Override
	public void run() {

		try {
			while (true) {
				long t = System.currentTimeMillis() - startTime;
				System.out.println(t);
				Thread.sleep(100);

			}
		} catch (Exception e) {
		}

	}

}

class AllocateMemoryThread extends Thread {

	HashMap<Long, byte[]> map = new HashMap<Long, byte[]>();

	@Override
	public void run() {
		while (true) {
			try {
				if (map.size() * 512 / 1024 / 1024 > 550) {
					map.clear();
					System.out.println("Clear Map.");
				}

				byte[] b;
				for (int i = 0; i < 100; i++) {
					b = new byte[10 * 1024];
					map.put(System.currentTimeMillis(), b);
				}

				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
