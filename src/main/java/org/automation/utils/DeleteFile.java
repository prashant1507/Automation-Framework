package org.automation.utils;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AgeFileFilter;
import org.apache.commons.lang3.time.DateUtils;
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
	 * This method deletes all the X days older reports. <br>
	 * Apr 7, 2021
	 *
	 */
	public static void deleteOldReports() {
		if (PropertyUtils.get(ConfigProperties.DELETEOLDREPORTS).equals(FrameworkConstants.getYes())) {
			int days = Integer.parseInt(PropertyUtils.get(ConfigProperties.NUMBEROFDAYS));
			Date oldestAllowedFileDate = DateUtils.addDays(new Date(), days);
			// To delete html test reports
			if (new File(FrameworkConstants.getReportFolder()).exists()) {
				File targetDir = new File(FrameworkConstants.getReportFolder());
				Iterator<File> filesToDelete = FileUtils.iterateFiles(targetDir,
						new AgeFileFilter(oldestAllowedFileDate), null);
				while (filesToDelete.hasNext()) {
					FileUtils.deleteQuietly(filesToDelete.next());
				}
			}

			// To delete generated videos
			if (new File(FrameworkConstants.getVideoFolder()).exists()) {
				File targetDirForVideos = new File(FrameworkConstants.getVideoFolder());
				Iterator<File> videosToDelete = FileUtils.iterateFiles(targetDirForVideos,
						new AgeFileFilter(oldestAllowedFileDate), null);
				while (videosToDelete.hasNext()) {
					FileUtils.deleteQuietly(videosToDelete.next());
				}
			}
		}
	}
	
	/**
	 * This function deletes the file based on the pattern.
	 * <br>
	 * Apr 8, 2021
	 * @param contains keyword in the path
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