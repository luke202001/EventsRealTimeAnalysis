package erta.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

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

	public boolean containsProperty(String key) {
		return this.environment.containsProperty(key);
	}

	public String getServicesWFActivitiesCSV(String processorContext, String processorName) {

		String wfActivitiesCSVPropBaseKey = processorContext + ".workflows.tasks";

		String wfActivitiesCSVPropKey = wfActivitiesCSVPropBaseKey + "." + processorName;
		if (!this.environment.containsProperty(wfActivitiesCSVPropKey)) {
			wfActivitiesCSVPropKey = wfActivitiesCSVPropBaseKey;
		}

		return this.environment.getProperty(wfActivitiesCSVPropKey);
	}

	public String getUi2ServicesDelegateRestUrl(String processorContext, String processName) {

		String ui2ServicesRestUrlPropKey = processorContext + "." + processName + ".ui2services.delegate.resturl";

		if (this.environment.containsProperty(ui2ServicesRestUrlPropKey)) {
			return this.environment.getProperty(ui2ServicesRestUrlPropKey);
		}

		ui2ServicesRestUrlPropKey = processorContext + ".*.ui2services.delegate.resturl";
		if (this.environment.containsProperty(ui2ServicesRestUrlPropKey)) {
			return this.environment.getProperty(ui2ServicesRestUrlPropKey) + "/" + processName;
		}

		return null;
	}

	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}

}
