package org.automation.media;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.automation.constants.FrameworkConstants;

/**
 * 
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 27, 2021
 * @author User1
 * @version 1.0
 * 
 */
public final class VideoPath {

	private VideoPath() {
	}
	
	private static ThreadLocal<String> videoFullPath = new ThreadLocal<String>();

	
	public static void setVideoPath() {
		videoFullPath.set(FrameworkConstants.getVideoDir() + "/" + "ExecutionVideo_" + new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date()) + ".mp4");
	}
	
	public static String getVideoPath() {
		return videoFullPath.get();
	}
	
	public static void flushVideoPath() {
		videoFullPath.remove();
	}
}
