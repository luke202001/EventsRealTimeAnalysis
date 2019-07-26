package erta.ui.web.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import erta.common.constants.AppServiceConstants;

@SpringBootApplication
public class UiWebAngularMain {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(UiWebAngularMain.class);
		app.setAdditionalProfiles(
				AppServiceConstants.buildAppServicesSpringActiveProfiles(AppServiceConstants.UI_WEB_ANGULAR_APP_NAME));

		app.run(args);
	}

}
