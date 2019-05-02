package com.wuku.stater.datasource.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jdbc")
public class DataSourceProperties {
	    private String driver;
	    private String url;
	    private String username;
	    private String password;
	    private String maxPoolSize;
	    private String idleTimeout;
	    private String connectionTimeout;
		public String getDriver() {
			return driver;
		}
		public void setDriver(String driver) {
			this.driver = driver;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMaxPoolSize() {
			return maxPoolSize;
		}
		public void setMaxPoolSize(String maxPoolSize) {
			this.maxPoolSize = maxPoolSize;
		}
		public String getIdleTimeout() {
			return idleTimeout;
		}
		public void setIdleTimeout(String idleTimeout) {
			this.idleTimeout = idleTimeout;
		}
		public String getConnectionTimeout() {
			return connectionTimeout;
		}
		public void setConnectionTimeout(String connectionTimeout) {
			this.connectionTimeout = connectionTimeout;
		}
	    
}
