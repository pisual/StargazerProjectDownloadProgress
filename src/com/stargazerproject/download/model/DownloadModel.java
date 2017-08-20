package com.stargazerproject.download.model;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class DownloadModel {
	
	private Float fileLenght;
	private Float downloadLenght;
	private int downloadProgress;
	
	
	public DownloadModel(Optional<Float> fileLenghtArg) {
		fileLenght = fileLenghtArg.get();
		downloadLenght = 0F;
		downloadProgress = 0;
	}
	
	public void increase(Optional<Float> increaseDownloadFileLenght){
		Preconditions.checkArgument(increaseDownloadFileLenght.get()>0F, "increaseDownloadFileLenght Must positive");
		downloadLenght = increaseDownloadFileLenght.get() + downloadLenght;
		increaseProgress();
	}
	
	private void increaseProgress(){
		downloadProgress = (int) ((downloadLenght / fileLenght) * 100);
	}
	
	public Optional<Integer> progress(){
		return Optional.of(downloadProgress);
	}
	
	public Optional<String> numberProgress(){
		return Optional.of(downloadLenght + " : " + fileLenght);
	}
	
	public static void main(String[] args) {
		DownloadModel d = new DownloadModel(Optional.of(100F));
		System.out.println(d.progress().get());
		
		for(int i=0;i<100;i++){
			d.increase(Optional.of(1F));
			System.out.println(d.progress().get());
			System.out.println(d.numberProgress().get());
		}
		
	}
	
}
