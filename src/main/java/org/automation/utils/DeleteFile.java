package org.automation.utils;

import java.io.File;
import java.util.Objects;
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
public final class DeleteFile {

	/**
	 * 
	 * Private constructor to avoid external instantiation <br>
	 * Apr 7, 2021
	 */
	private DeleteFile() {
	}

	/**
	 * This method deletes all the X days older reports and videos. <br>
	 * Apr 7, 2021
	 *
	 */
	public static void deleteOldReports() {
		File targetDirForReport = new File(FrameworkConstants.getReportFolder());
		File targetDirForVideos = new File(FrameworkConstants.getVideoFolder());
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
	 * This function deletes the file based on the pattern. <br>
	 * Apr 8, 2021
	 * 
	 * @param contains       keyword in the path
	 * @param endsWithString end string of the path
	 *
	 */
	public static void deleteFilesUsingPattern(String contains, String endsWithString) {
		File dir = new File(ReportPath.getVideoPath());
		File[] files = dir.listFiles();
		if (Objects.nonNull(files)) {
			for (File f : files) {
				if (f.toString().contains(contains) && f.toString().endsWith(endsWithString)) {
					f.delete();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}
	}
}