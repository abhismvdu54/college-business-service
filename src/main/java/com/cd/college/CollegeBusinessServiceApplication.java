package com.cd.college;
/**
 * @author Mayank
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableAutoConfiguration
@EnableCaching
@ComponentScan("com.cd")
public class CollegeBusinessServiceApplication {


    public static void main(String[] args) throws Exception {
	SpringApplication.run(CollegeBusinessServiceApplication.class, args);
    }

    @Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
}


