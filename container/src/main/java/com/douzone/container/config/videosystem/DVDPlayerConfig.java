package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

//explicit config - bean 명시적으로 설정해야함
@Configuration
public class DVDPlayerConfig {

	@Bean
	public Avengers avengers() {
		return new Avengers();
	}

	// DI 1 (injection)
	// parameter : Bean 생성 method 직접 호출
	// 생성자 주입
	// @Bean
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}

	// DI 2 (injection)
	// parameter로 bean 전달하기
	// 생성자 주입
	// @Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}

	// DI 3 (injection)
	// parameter로 bean 전달하기
	// setter 주입
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		DVDPlayer player = new DVDPlayer();
		player.setDvd(dvd);

		return player;
	}

	// 같은 type의 bean이 생성된 경우
	@Bean(name="player04")
	public DVDPlayer dvdPlayer04(DigitalVideoDisc dvd) {
		DVDPlayer player = new DVDPlayer();
		player.setDvd(dvd);

		return player;
	}

}
