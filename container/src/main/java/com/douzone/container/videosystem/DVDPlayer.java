package com.douzone.container.videosystem;

import org.springframework.beans.factory.annotation.Autowired;

public class DVDPlayer {

	//@Autowired
	private DigitalVideoDisc dvd;
	
	public DVDPlayer() {
	}
	
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}

	public void play() {
		dvd.play();
	}

	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
}
