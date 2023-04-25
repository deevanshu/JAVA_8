package com.javatechie.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		/*
		 * Consumer<Integer> consumer = t -> System.out.println("Printing  : " + t);
		 * 
		 * void accept(T t)
		 * consumer.accept(10);
		 */

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		list1.stream().forEach(t -> System.out.println("print  : " + t));
		
		 String num = "1223.230";
	        int d = 0, g = 0, c = 0, fnl = 0;
	        int exp = (num.indexOf(".") - 1);
	        while (num.charAt(d) != '.') {
	            g = num.charAt(d) - 48;
	            int k = 1;
	            for (int f = 0; f < exp; f++) {
	                k = (k * 10) * g;
	            }
	            fnl += k;
	            d++;
	            exp--;
	            System.out.println(fnl);                
	        }   

	}
}
