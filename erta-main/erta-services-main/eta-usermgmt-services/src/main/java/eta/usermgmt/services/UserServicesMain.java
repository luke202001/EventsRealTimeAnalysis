package eta.usermgmt.services;

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
@EntityScan(basePackages = "erta.common.entity.user")
@Import(AppConfigUtil.class)
@ImportResource({ "classpath*:application-UserServices-SpringCtx.xml" })
public class UserServicesMain {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(UserServicesMain.class);
		app.setAdditionalProfiles(
				AppServiceConstants.buildAppServicesSpringActiveProfiles(AppServiceConstants.SERVICES_USER_NAME));

		app.run(args);
	}

}
