package org.automation.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.automation.constants.FrameworkConstants;
import org.automation.enums.ConfigProperties;

/**
 * 
 * RemoveOldReports removes all the reports older than X days. User can set the
 * decision to delete the files in properties file. <br>
 * Class is final to avoid extend. <br>
 * <br>
 * Apr 7, 2021
 * 
 * @author User1
 * @version 1.0
 * 
 */
public final class DeleteFileAndFolders {

	/**
	 * 
	 * Private constructor to avoid external instantiation <br>
	 * Apr 7, 2021
	 */
	private DeleteFileAndFolders() {
	}

	/**
	 * This method deletes all the X days older reports and videos. <br>
	 * Apr 7, 2021
	 *
	 */
	public static void deleteOldReports() {
		File targetDirForReport = new File(FrameworkConstants.getReportDir());
		File targetDirForVideos = new File(FrameworkConstants.getVideoDir());
		if (PropertyUtils.get(ConfigProperties.DELETEOLDREPORTS).equals(FrameworkConstants.getYes())) {
			if (targetDirForReport.exists()) {
				deleteOldFiles(targetDirForReport.listFiles());
			}
			if (targetDirForVideos.exists()) {
				deleteOldFiles(targetDirForVideos.listFiles());
			}
		}
	}
	
	/**
	 * This method deletes all the X days older reports and videos.<br>
	 * Apr 22, 2021
	 * @param filesToDelete Path for files to be deleted
	 *
	 */
	private static void deleteOldFiles(File[] filesToDelete) {
		int daysBack = Integer.parseInt(PropertyUtils.get(ConfigProperties.NUMBEROFDAYS));
		long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000);
		for (File report : filesToDelete) {
			if (report.lastModified() < purgeTime) {
				report.delete();
			}
		}
	}
	
	/**
	 * This function will clean old data from screenshots folder
	 * <br>
	 * Apr 26, 2021
	 *
	 */
	public static void cleanScreenshotsDir() {
		try {
			if (new File(FrameworkConstants.getScreenshotsDir()).exists())
				FileUtils.deleteDirectory(new File(FrameworkConstants.getScreenshotsDir()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}