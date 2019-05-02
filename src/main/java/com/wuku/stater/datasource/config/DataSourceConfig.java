package com.wuku.stater.datasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wuku.stater.datasource.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 * @author SunMy
 *
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfig {
	
	@Autowired
	DataSourceProperties dataSourceProperties;
   
    @Bean
    public HikariDataSource getDataSource() {
    	String driver=dataSourceProperties.getDriver();
    	String url=dataSourceProperties.getUrl();
    	String username=dataSourceProperties.getUsername();
    	String password=dataSourceProperties.getPassword();
 	    String maxPoolSize=dataSourceProperties.getMaxPoolSize();
 	    String idleTimeout=dataSourceProperties.getIdleTimeout();
 	    String connectionTimeout=dataSourceProperties.getConnectionTimeout();
    	
		// connection pool config
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		if (username != null && username.length() > 0) {
			config.setUsername(username);
		}
		if (password != null && password.length() > 0) {
			config.setPassword(password);
		}
		if (driver != null && driver.length() > 0) {
			config.setDriverClassName(driver);
		}
		if (maxPoolSize != null && maxPoolSize.length() > 0) {
			config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
		}
		// IdleTimeout
		if (idleTimeout != null && idleTimeout.length() > 0) {
			config.setIdleTimeout(Integer.parseInt(idleTimeout));
		}
		// ConnectionTimeout
		if (connectionTimeout != null && connectionTimeout.length() > 0) {
			config.setConnectionTimeout(Integer.parseInt(connectionTimeout));
		}
		
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		return new HikariDataSource(config);
	}
}
