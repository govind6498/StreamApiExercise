package com.bridgelabz.streamapiexercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
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
		List<Double> streamList = myNumberList.stream()
				.map(toDoubleFunction)
				.collect(Collectors.toList());
		System.out.println("Printing Double List: "+streamList);

	}
}
