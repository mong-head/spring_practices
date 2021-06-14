package com.douzone.container.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.config.videosystem.DVDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DVDPlayerConfig.class)
public class DVDPlayerJavaConfigTest {

	@Rule //junit내에 있는 것은 아니고, 출력이 있는 기능에 대해 console 출력 내용이 잘 출력 되는 지 확인
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DigitalVideoDisc dvd; //interface 
	
	@Autowired
	// 같은 타입 빈이 2개 이상 존재하는 경우 1 : bean 생성 method 이름
	//@Qualifier("dvdPlayer03")
	// 같은 타입 빈이 2개 이상 존재하는 경우 2 : @Bean 의 name 속성
	@Qualifier("player04")
	private DVDPlayer player;
	
	@Test
	public void testDVDNotNull() {
		assertNotNull(dvd);
	}
	
	@Test
	public void testPlayerNotNull() {
		assertNotNull(player);
	}
	
	@Test
	public void testPlay() {
		player.play();
		assertEquals("playing Movie MARVEL's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n",""));
	}
}
