package com.douzone.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	@Autowired
	private CompactDisc cd; //DI
	
	public void play() {
		cd.play();
	}
}
