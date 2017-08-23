package com.stargazerproject.download;

import com.google.common.base.Optional;


public interface ProgressCalculate {
	public Optional<Integer> progress();
	public void increase(Optional<Float> increaseDownloadFileLenght);
	
}
