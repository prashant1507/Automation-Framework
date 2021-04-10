package org.automation.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.automation.constants.FrameworkConstants;
import org.automation.enums.ConfigProperties;

public final class ReportPath {

	private static String reportFilePath = "";
	private static ThreadLocal<String> videoPath = new ThreadLocal<String>();
	private static ThreadLocal<String> videoName = new ThreadLocal<String>();
	private static ThreadLocal<String> videoFullPath = new ThreadLocal<String>();

	private ReportPath() {
	}

	public static String getReportPath() {
		if (reportFilePath.isEmpty()) {
			reportFilePath = setReportPath();
		}
		return reportFilePath;
	}

	public static String getVideoPath() {
		if (videoPath.get() == null) {
			videoPath.set(setVideoPath());
			if (!new File(videoPath.get()).exists()) {
				new File(videoPath.get()).mkdirs();
			}
		}
		return videoPath.get();
	}

	public static String getVideoName() {
		if (videoName.get() == null) {
			videoName.set(setVideoName());
		}
		return videoName.get();
	}

	public static String getVideoFullPath() {
		if (videoFullPath.get() == null) {
			videoFullPath.set(getVideoPath() + "/" + getVideoName());
		}
		return videoFullPath.get();
	}

	private static String setReportPath() {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase(FrameworkConstants.getNo())) {
			return FrameworkConstants.getReportFolder() + "/ExecutionReport_"
					+ new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date()) + ".html";
		} else if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase(FrameworkConstants.getYes())) {
			return FrameworkConstants.getReportFolder() + "/index.html";
		}
		return "";
	}

	private static String setVideoPath() {
		return FrameworkConstants.getVideoFolder();
	}

	public static String setVideoName() {
		return "ExecutionVideo_" + new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date())
				+ ".avi";
	}
}