package org.automation.testrecorder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.automation.media.ScreenshotPath;
import org.automation.media.VideoPath;
import org.jcodec.api.awt.AWTSequenceEncoder;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Rational;

/**
 * This class will create video using images taken during the test
 * execution.<br>
 * Class is final to avoid extend. <br>
 * <br>
 * Apr 26, 2021
 * 
 * @author User1
 * @version 1.0
 * 
 */
public final class TestRecording {
	/**
	 * Private constructor to avoid external instantiation <br>
	 * Apr 26, 2021
	 */
	private TestRecording() {
	}

	/**
	 * This method creates a video from collection of images <br>
	 * Apr 26, 2021
	 *
	 */
	public static String getRecording() {
		String videoPath = VideoPath.getVideoPath();
		String screenshotsDir = ScreenshotPath.getCurrentTestExecutionScreenshotsDir();
		/*try {
			AWTSequenceEncoder awtEncoder = AWTSequenceEncoder.createSequenceEncoder(new File(videoPath), 1);
			File[] screenshots = new File(screenshotsDir).listFiles();
			Arrays.sort(screenshots, Comparator.comparingLong(File::lastModified));
			for (File screenshot : screenshots) {
				BufferedImage image = ImageIO.read(screenshot.getAbsoluteFile());
				awtEncoder.encodeImage(image);
			}
			awtEncoder.finish();
			FileUtils.deleteDirectory(new File(screenshotsDir));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		SeekableByteChannel out = null;
	    try {
	        out = NIOUtils.writableFileChannel(videoPath);
	        AWTSequenceEncoder encoder = new AWTSequenceEncoder(out, Rational.R(25, 4));
	        File[] screenshots = new File(screenshotsDir).listFiles();
	        Arrays.sort(screenshots, Comparator.comparingLong(File::lastModified));
	        for (File screenshot : screenshots) {
				BufferedImage image = ImageIO.read(screenshot.getAbsoluteFile());
				System.out.println(image.getWidth() + "   " + image.getHeight());
				encoder.encodeImage(image);
			}
	        encoder.finish();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	        NIOUtils.closeQuietly(out);
	    }

		return videoPath;
	}
}
