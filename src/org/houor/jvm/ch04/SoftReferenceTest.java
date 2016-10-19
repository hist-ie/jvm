package org.houor.jvm.ch04;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {

	public static void main(String[] args) {
		User u = new User();
		u.setId(1);

		SoftReference<User> sr = new SoftReference<User>(u);
		u = null;
		
		System.out.println(sr.get());
		System.gc();
		System.out.println("After GC:");
		System.out.println(sr.get());
		
		byte[] ba = new byte[6 * 1024 * 1024 + 530 * 1024];
		System.gc();
		System.out.println(sr.get());
	}

}

class User {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}

}
