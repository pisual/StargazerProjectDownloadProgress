package com.stargazerproject.download.impl;

import com.stargazerproject.download.ProgressCalculate;
import com.stargazerproject.download.ProgressDisplay;

public class ProgressDisplayImpl implements ProgressDisplay{
	
	private int[] progress = new int[100];
	private ProgressCalculate progressCalculate;
	
	public ProgressDisplayImpl(ProgressCalculate progressCalculateArg) {
		progressCalculate = progressCalculateArg;
		initProgress();
	}
	
	private void progressDisplayCalculate(){
		increaseProgress(progressCalculate.progress().get());
	}
	
	private void increaseProgress(int schedule){
		for(int i = 0; i<schedule; i++){
			progress[i] = 1;
		}
	}
	
	private void initProgress(){
		for(int i=0; i<progress.length; i++){
			progress[i] = 0;
		}
	}
	
	
	public StringBuffer standardDisplayConvert(){
		StringBuffer progressDispkay = new StringBuffer();
		int percent = 0;
		progressDisplayCalculate();
		progressDispkay.append("[");
		for (int p : progress) {
			if(p == 0){
				progressDispkay.append(".");
			}
			else{
				progressDispkay.append("█");
				++percent;
			}
		}
		
		progressDispkay.append("][ ");
		progressDispkay.append(percent + "% ]");
		return progressDispkay;
	}	
}
