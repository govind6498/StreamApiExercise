package com.bridgelabz.streamapiexercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
	public static void main(String[] args) {
		List<Integer> myNumberList = new ArrayList<Integer>();
		//Use Case 1
		myNumberList.stream().forEach(n->{
			System.out.println("Method1:Stream foreach value:"+n);
		});

	}
}
