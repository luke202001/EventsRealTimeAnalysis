package erta.common.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AppServiceConstants {

	public static final String EVENTS_APP_SERVICES_NAME = "EventsApp";

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
