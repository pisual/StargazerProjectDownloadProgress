package com.stargazerproject.download.impl;

import java.util.concurrent.TimeUnit;

import com.stargazerproject.download.ProgressCalculate;
import com.stargazerproject.download.ProgressDisplay;

public class ProgressDisplayImpl implements ProgressDisplay{
	
	private Integer point = 0;
	private Integer[] progress = new Integer[100];
	
	public ProgressDisplayImpl() {
//		for (Integer p : progress) {
//			System.out.println("a");
//			p = 0;
//		}
		
		for(int i=0;i<100;i++){
			progress[i] = 0;
		}
		
	}
	
	@Override
	public void standardProgressDisplay(ProgressCalculate progressCalculate){
		while(true){
			int schedule = progressCalculate.ProgressPercentage();
			if((schedule - point) > 0){
				increaseProgress(schedule);
				point = schedule;
			}
			
			if(schedule == 100){
				break;
			}
			
			displayConvert();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void increaseProgress(int schedule){
		for(int i = point; i<schedule; i++){
			progress[i] = 1;
		}
	}
	
	
	public StringBuffer displayConvert(){
		StringBuffer progressDispkay = new StringBuffer();
		progressDispkay.append("[");
		
		for (Integer p : progress) {
			if(p == 0){
				progressDispkay.append("-");
			}
			else{
				progressDispkay.append("█");
			}
		}
		
		progressDispkay.append("][ ");
		progressDispkay.append(point + "% ]");
		return progressDispkay;
	}
	
	public static void main(String[] args) {
		
		ProgressDisplayImpl p = new ProgressDisplayImpl();
		
		for(int i=1;i<101;i++){
				int schedule = i;
				if((schedule - p.point) > 0){
					if((schedule - p.point) >= 1)
					{
						p.increaseProgress(schedule);
						p.point = schedule;
					}
				}
				
				System.out.println(p.displayConvert());
				
				if(schedule == 100){
					break;
				}
				
				try {
					TimeUnit.MICROSECONDS.sleep(100000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	
}
