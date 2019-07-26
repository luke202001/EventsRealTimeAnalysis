package erta.ui.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import erta.common.constants.AppServiceConstants;

@SpringBootApplication
public class UiBackendMain {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(UiBackendMain.class);
		app.setAdditionalProfiles(
				AppServiceConstants.buildAppServicesSpringActiveProfiles(AppServiceConstants.UI_BACKEND_APP_NAME));

		app.run(args);

	}

}
