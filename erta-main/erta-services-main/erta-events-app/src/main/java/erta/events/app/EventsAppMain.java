/**
 * 
 */
package erta.events.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import erta.common.config.AppConfigUtil;
import erta.common.constants.AppServiceConstants;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = "erta.common")
@Import(AppConfigUtil.class)
@ImportResource({ "classpath*:application-EventsApp-SpringCtx.xml" })
public class EventsAppMain {

	public EventsAppMain() {
	}

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(EventsAppMain.class);
		app.setAdditionalProfiles(
				AppServiceConstants.buildAppServicesSpringActiveProfiles(AppServiceConstants.SERVICES_EVENTS_NAME));

		app.run(args);

	}

}
