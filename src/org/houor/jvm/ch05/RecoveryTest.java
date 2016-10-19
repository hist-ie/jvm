package org.houor.jvm.ch05;

public class RecoveryTest {

	public static void main(String[] args) {
		byte[] b = null;

		for (int j = 0; j < 10; j++) {

			for (int i = 0; i < 10; i++) {
				b = new byte[1024 * 1024];

			}

			System.gc();
		}

	}

	
}
