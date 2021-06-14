package com.douzone.container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
 * VideoSystemConfig <------------- {JavaConfig1, JavaConfig2}
 * 						import
 * 
 * JavaConfig1 + JavaConfig2 + VideoSystemConfig 
 */

@Configuration
@Import({DVDConfig.class, DVDPlayerConfig.class})
public class VideoSystemConfig {
	
}
