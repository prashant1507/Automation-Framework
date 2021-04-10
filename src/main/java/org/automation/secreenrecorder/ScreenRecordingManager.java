package org.automation.secreenrecorder;

import org.monte.screenrecorder.ScreenRecorder;

public final class ScreenRecordingManager {
	private ScreenRecordingManager() {
	}
	
	private static ThreadLocal<ScreenRecorder> sr = new ThreadLocal<ScreenRecorder>();

	public static ScreenRecorder getRecorder() {
		return sr.get();
	}

	public static void setRecorder (ScreenRecorder screenRecorder) {
		sr.set(screenRecorder);
	}

	public static void unload() {
		sr.remove();
	}

}
