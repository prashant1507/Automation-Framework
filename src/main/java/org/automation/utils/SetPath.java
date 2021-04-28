package org.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.automation.constants.FrameworkConstants;
import org.automation.enums.ConfigProperties;

public final class SetPath {

	private static String reportFilePath = "";

	private SetPath() {
	}

	public static String getReportPath() {
		if (reportFilePath.isEmpty()) {
			reportFilePath = setReportPath();
		}
		return reportFilePath;
	}

	private static String setReportPath() {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase(FrameworkConstants.getNo())) {
			return FrameworkConstants.getReportDir() + "/ExecutionReport_"
					+ new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date()) + ".html";
		} else {
			return FrameworkConstants.getReportDir() + "/index.html";
		}
	}
}