package erta.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfigUtil implements EnvironmentAware {

	@Autowired
	public ApplicationContext appCtx;

	private Environment environment;

	public AppConfigUtil() {
	}

//	@ConfigurationProperties
//	@Bean(autowireCandidate = true, name = "springEnvironmentREf")
//	@Autowired
//	public Properties getProperties(@Autowired ApplicationContext appCtx) {
//
//		final SortedMap<String, String> sortedMap = new TreeMap<>();
//
//		Environment env = appCtx.getEnvironment();
//
//		return new Properties();
//	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getProperty(String key) {
		return this.environment.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return this.environment.getProperty(key, defaultValue);
	}

	public <T> Object getProperty(String key, Class<T> targetType) {
		return this.environment.getProperty(key, targetType);
	}

}
