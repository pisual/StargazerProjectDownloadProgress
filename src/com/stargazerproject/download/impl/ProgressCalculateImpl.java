package com.stargazerproject.download.impl;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.stargazerproject.download.ProgressCalculate;

public class ProgressCalculateImpl implements ProgressCalculate{
	
	private Float fileLenght;
	private Float downloadLenght;
	private int downloadProgress;

	public ProgressCalculateImpl(Optional<Float> fileLenghtArg) {
		fileLenght = fileLenghtArg.get();
		downloadLenght = 0F;
		downloadProgress = 0;
	}
	
	@Override
	public void increase(Optional<Float> increaseDownloadFileLenght){
		Preconditions.checkArgument(increaseDownloadFileLenght.get()>0F, "increaseDownloadFileLenght Must positive");
		downloadLenght = increaseDownloadFileLenght.get() + downloadLenght;
		increaseProgress();
	}
	
	private void increaseProgress(){
		downloadProgress = (int) ((downloadLenght / fileLenght) * 100);
	}
	
	@Override
	public Optional<Integer> progress(){
		return Optional.of(downloadProgress);
	}

}
