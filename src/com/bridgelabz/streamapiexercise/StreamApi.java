package com.bridgelabz.streamapiexercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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

		//Listing the first Even
		Integer first = myNumberList.stream()
				.filter(isEvenFunction)
				.peek(n->System.out.println("Peek Even Number:"+n))
				.findFirst()
				.orElse(null);
		System.out.println("First Even :"+first);

		//Listing the find max number
		Integer max = myNumberList.stream()
				.filter(isEvenFunction)
				.max(Comparator.comparing(Integer::intValue))
				.orElse(null);
		System.out.println("Max Value: "+max);

		//Listing the find min number
		Integer min = myNumberList.stream()
				.filter(isEvenFunction)
				.min(Comparator.comparing(Integer::intValue))
				.orElse(null);
		System.out.println("Min Value: "+min);

		//		OR
		Integer min1 = myNumberList.stream()
				.filter(isEvenFunction)
				.min((n1,n2)->n1-n2)
				.orElse(null);
		System.out.println("Min Value: "+min1);

		//find Sum  and Average of Number
		Optional<Integer> sum = myNumberList.stream().reduce(Integer::sum);
		long count = myNumberList.stream().count();
		System.out.println("Sum : "+sum);
		System.out.println("Count:"+count);
		
//		checking all even ,single even and none are divisible by 6;
		boolean allEven = myNumberList.stream().allMatch(isEvenFunction);
		boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
		boolean noneMultiOfSix = myNumberList.stream().noneMatch(i->i>0 && i%6==0);
		
		System.out.println("AllEven:"+allEven+" OneEven:"+oneEven+" noneMultiOfSix: "+noneMultiOfSix);
	}
}
