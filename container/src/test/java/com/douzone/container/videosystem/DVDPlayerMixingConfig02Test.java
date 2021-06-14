package com.douzone.container.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.config.videosystem.mixing.VideoSystemConfig;

//VideoSystemConfig test

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {VideoSystemConfig.class})
public class DVDPlayerMixingConfig02Test {

	@Autowired
	private DVDPlayer player;
	
	@Test
	public void testPlayer() {
		assertNotNull(player);
	}
}
