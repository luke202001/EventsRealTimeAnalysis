/**
 * 
 */
package eta.customer.services;

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
@EntityScan(basePackages = "erta.common.entity.customer")
@Import(AppConfigUtil.class)
@ImportResource({ "classpath*:application-CustomerServices-SpringCtx.xml" })
public class CustomerServicesMain {

	public CustomerServicesMain() {
	}

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(CustomerServicesMain.class);
		app.setAdditionalProfiles(
				AppServiceConstants.buildAppServicesSpringActiveProfiles(AppServiceConstants.SERVICES_CUSTOMER_NAME));

		app.run(args);
	}

}
