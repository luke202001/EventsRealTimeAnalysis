package erta.common.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AppServiceConstants {

	public static final String SERVICES_EVENTS_NAME = "EventsServices";
	public static final String SERVICES_CUSTOMER_NAME = "CustomerServices";
	public static final String SERVICES_USER_NAME = "UserServices";
	public static final String UI_WEB_ANGULAR_APP_NAME = "UiWebAngular";
	public static final String UI_BACKEND_APP_NAME = "UiBackend";

	public static final String BEAN_ID_EVENTS_SERVICES_IMPL = "EventsServiceImpl";
	public static final String BEAN_ID_CUSTOMER_SERVICES_IMPL = "CustomerServiceImpl";
	public static final String BEAN_ID_USER_SERVICES_IMPL = "UserServiceImpl";

	public static final List<String> APP_SERVICES_COMMON_SPRING_PROFILES_ACTIVE = new ArrayList<String>();

	static {

		APP_SERVICES_COMMON_SPRING_PROFILES_ACTIVE.add("GlobalConfig");
	}

	public AppServiceConstants() {
	}

	public static String[] buildAppServicesSpringActiveProfiles(String serviceProfile) {

		return buildAppServicesSpringActiveProfiles(null, serviceProfile, null);
	}

	public static String[] buildAppServicesSpringActiveProfiles(String[] prefixProfiles, String serviceProfile,
			String[] SuffixProfiles) {

		List<String> allProfiles = new ArrayList<>(APP_SERVICES_COMMON_SPRING_PROFILES_ACTIVE);

		if (prefixProfiles != null && prefixProfiles.length > 0) {
			Stream.of(prefixProfiles).map(aProfile -> allProfiles.add(aProfile));
		}

		allProfiles.add(serviceProfile);

		if (SuffixProfiles != null && SuffixProfiles.length > 0) {
			Stream.of(SuffixProfiles).map(aProfile -> allProfiles.add(aProfile));
		}

		return allProfiles.toArray(new String[allProfiles.size()]);
	}

}
