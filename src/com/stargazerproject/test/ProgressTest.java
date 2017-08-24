package com.stargazerproject.test;


import com.google.common.base.Optional;
import com.stargazerproject.download.impl.ProgressCalculateImpl;
import com.stargazerproject.download.impl.ProgressDisplayImpl;

public class ProgressTest {
	
	public static void main(String[] args) {
		
		ProgressCalculateImpl progressCalculateImpl = new ProgressCalculateImpl(Optional.of(1000F));
		ProgressDisplayImpl progressDisplayImpl = new ProgressDisplayImpl(progressCalculateImpl);
		
		for(int i=0; i<100; i++){
			progressCalculateImpl.increase(Optional.of(10F));
			System.out.println(progressDisplayImpl.standardDisplayConvert());
		}
		
	}
	
}
