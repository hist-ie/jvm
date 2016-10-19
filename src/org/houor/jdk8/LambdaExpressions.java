package org.houor.jdk8;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {
	
	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("1", "2", "3");
		
		stringList.forEach(stringListValue -> System.out.println(stringListValue));
	}

}
