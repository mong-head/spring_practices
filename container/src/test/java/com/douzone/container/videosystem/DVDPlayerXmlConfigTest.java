package com.douzone.container.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml"})
public class DVDPlayerXmlConfigTest {
	
	@Rule //junit내에 있는 것은 아니고, 출력이 있는 기능에 대해 console 출력 내용이 잘 출력 되는 지 확인
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	// @Autowired
	// 예외 발생
	// XML bean설정시 id자동 부여 되지 않음
	// @Qualifier 사용 불가
	private DigitalVideoDisc dvd1;
	
	@Autowired
	@Qualifier("ironMan")
	private DigitalVideoDisc dvd2;
	
	@Autowired
	@Qualifier("avangersInfinityWar")
	private DigitalVideoDisc dvd3;
	
	@Autowired
	@Qualifier("avangersEndgame")
	private DigitalVideoDisc dvd4;
	
	@Autowired
	@Qualifier("avangersAgeOfUltron")
	private DigitalVideoDisc dvd5;
	
	@Autowired
	@Qualifier("captainAmerica")
	private DigitalVideoDisc dvd6;
	
	@Autowired
	@Qualifier("avangersDirectorEdition")
	private DigitalVideoDisc dvd7;
	
	@Autowired
	@Qualifier("avangersTriplePack")
	private DVDPack dvdPack;
	
	@Autowired
	@Qualifier("avangersExpansionPack1")
	private DigitalVideoDisc dvd8;
	
	@Autowired
	@Qualifier("avangersExpansionPack2")
	private DigitalVideoDisc dvd9;
	
	@Autowired
	@Qualifier("avangersExpansionPack3")
	private DigitalVideoDisc dvd10;
	
	@Autowired
	@Qualifier("dvdPlayer1")
	private DVDPlayer player1;
	
	@Autowired
	@Qualifier("dvdPlayer2")
	private DVDPlayer player2;
	
	@Autowired
	@Qualifier("dvdPlayer3")
	private DVDPlayer player3;
	
	@Autowired
	@Qualifier("dvdPlayer4")
	private DVDPlayer player4;
	
	@Autowired
	@Qualifier("dvdPlayer5")
	private DVDPlayer player5;
	
	@Ignore // test 건너뛰기
	@Test
	public void testDvd1NotNull() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDvd2NotNull() {
		assertNotNull(dvd2);
	}
	
	@Test
	public void testDvd3NotNull() {
		assertNotNull(dvd3);
	}
	
	@Test
	public void testDvd4NotNull() {
		assertNotNull(dvd4);
	}
	
	@Test
	public void testDvd5NotNull() {
		assertNotNull(dvd5);
	}
	
	@Test
	public void testDvd6NotNull() {
		assertNotNull(dvd6);
	}
	
	@Test
	public void testDvd7NotNull() {
		assertNotNull(dvd7);
	}
	
	@Test
	public void testDvdPackNotNull() {
		assertNotNull(dvdPack);
	}
	
	@Test
	public void testDvd8NotNull() {
		assertNotNull(dvd8);
	}
	
	@Test
	public void testDvd9NotNull() {
		assertNotNull(dvd9);
	}
	
	@Test
	public void testDvd10NotNull() {
		assertNotNull(dvd10);
	}
	
	@Test
	public void testPlay1() {
		player1.play();
		assertEquals("playing Movie MARVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n",""));
	}
	
	@Test
	public void testPlay2() {
		player2.play();
		assertEquals("playing Movie MARVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n",""));
	}
	
	@Test
	public void testPlay3() {
		player3.play();
		assertEquals("playing Movie MARVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n",""));
	}
	
	@Test
	public void testPlay4() {
		player4.play();
		assertEquals("playing Movie MARVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n",""));
	}
	
	@Test
	public void testPlay5() {
		player5.play();
		assertEquals("playing Movie MARVEL's IronMan", systemOutRule.getLog().replace("\r\n", "").replace("\n",""));
	}
}
