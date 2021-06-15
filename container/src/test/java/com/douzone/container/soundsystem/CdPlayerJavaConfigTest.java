package com.douzone.container.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.config.soundsystem.CDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CdPlayerJavaConfigTest {
	
	@Rule //jnit내에 있는 것은 아니고, 출력이 있는 기능에 대해 console 출력 내용이 잘 출력 되는 지 확인
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDNotNull() {
		assertNotNull(cd);
	}
	
	@Test //JUnit
	public void testCDPlayerNotNull() {
		assertNotNull(cdPlayer); //주입이 잘 되었는 지 확인
	}
	
	@Test
	public void testPlay() {
		cdPlayer.play();
		assertEquals("playing 붕붕 by 김하온",systemOutRule.getLog().replace("\r\n","").replace("\n", "")); 
		// systemoutln 으로 한 경우 줄바꿈을 없애고 확인
	}
	
}
