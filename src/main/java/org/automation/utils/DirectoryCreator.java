package org.automation.utils;

import java.io.File;
import org.automation.constants.FrameworkConstants;
import org.automation.media.ScreenshotPath;

/**
 * This class is to create the folders required by the framework <br>
 * Class is final to avoid extend. <br>
 * <br>
 * Apr 26, 2021
 * 
 * @author User1
 * @version 1.0
 * 
 */
public final class DirectoryCreator {
	/**
	 * Private constructor to avoid external instantiation <br>
	 * Apr 26, 2021
	 */
	private DirectoryCreator() {
	}

	/**
	 * This method will create the directories required by framework <br>
	 * Apr 26, 2021
	 * 
	 * @param
	 *
	 */
	public static void createRequiredDirs() {
		String[] dirsToCreate = { FrameworkConstants.getVideoDir(), ScreenshotPath.getCurrentTestExecutionScreenshotsDir()};
		for (int i = 0; i < dirsToCreate.length; i++) {
			File dir = new File(dirsToCreate[i]);
			if (!dir.exists()) {
				dir.mkdirs();
			}
		}
	}
}
