package erta.ui.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import erta.common.config.AppConfigUtil;
import erta.common.constants.AppServiceConstants;

@SpringBootApplication
@EnableConfigurationProperties
@Import(AppConfigUtil.class)
public class UiBackendMain {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(UiBackendMain.class);
		app.setAdditionalProfiles(
				AppServiceConstants.buildAppServicesSpringActiveProfiles(AppServiceConstants.UI_BACKEND_APP_NAME));

		app.run(args);

	}

}
