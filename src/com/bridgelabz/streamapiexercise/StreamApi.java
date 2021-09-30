package com.bridgelabz.streamapiexercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {
	public static void main(String[] args) {
		List<Integer> myNumberList = new ArrayList<Integer>();
		Function<Integer,Double> toDoubleFunction = Integer::doubleValue;

		//Use Case 1
		myNumberList.stream().forEach(n->{
			System.out.println("Method1:Stream foreach value:"+n);
		});
		//use case 2
		Predicate<Integer> isEvenFunction = n-> n>0 && n%2==0;
		List<Double> streamList = myNumberList.stream()
				.filter(isEvenFunction)
				.map(toDoubleFunction)
				.collect(Collectors.toList());
		System.out.println("Printing Double List: "+streamList);

	}
}
