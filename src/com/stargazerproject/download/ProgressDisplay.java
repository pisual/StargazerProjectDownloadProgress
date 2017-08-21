package com.stargazerproject.download;

import java.util.concurrent.TimeUnit;

public class ProgressDisplay {
	
	/**
	 * 标准输出显示
	 *[▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇][100%]
	 *[                                                                                   ]
	 *[▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇        ][100%]
	 *[▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆][100%]
	 *50个 ▇
	 *每增加百分比2，增加一个格子
	 *
	 * **/
	
	private Integer point = 0;
	private Integer[] progress = new Integer[50];
	
	public ProgressDisplay() {
		for (Integer p : progress) {
			p = 0;
		}
	}
	
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
	
	private void increaseProgress(int schedule){
		for(int i = point; i<schedule; i++){
			progress[i] = 1;
		}
	}
	
	
	private void displayConvert(){
		StringBuffer progressDispkay = new StringBuffer();
		progressDispkay.append("[");
		
		for (Integer p : progress) {
			if(p == 0){
				progressDispkay.append(" ");
			}
			else{
				progressDispkay.append("▇▇");
			}
		}
		
		progressDispkay.append("][ ");
		progressDispkay.append(point + "% ]");
	}
	
}
