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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/com/douzone/container/config/soundsystem/CDPlayerConfig.xml"})
public class CdPlayerXmlConfigTest {
	
	@Rule //jnit내에 있는 것은 아니고, 출력이 있는 기능에 대해 그 기능이 잘 되는 지 확인하기 위함
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private CDPlayer cdPlayer;
	
	@Test //JUnit
	public void testCDPlayerNotNull() {
		assertNotNull(cdPlayer); //주입이 잘 되었는 지 확인
	}
	
	@Test
	public void testPlay() {
		cdPlayer.play();
		assertEquals("playing 붕붕 by 김하온",systemOutRule.getLog().replace("\r\n","")); 
		// systemoutln 으로 한 경우 줄바꿈을 없애고 확인
	}
}
