package org.automation.utils;

import java.io.File;
import org.automation.constants.FrameworkConstants;
import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.InputFormatException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.VideoAttributes;

/**
 * This class take the .avi format video and convert to .mp4. <br>
 * Class is final to avoid extend. <br>
 * <br>
 * Apr 8, 2021
 * 
 * @author User1
 * @version 1.0
 * 
 */
public final class AviToMP4Convertor {

	/**
	 * 
	 * Private constructor to avoid external instantiation <br>
	 * Apr 8, 2021
	 */
	private AviToMP4Convertor() {
	}

	/**
	 * This function converts avi to mp4 <br>
	 * Apr 8, 2021
	 * 
	 * @param aviPath path of the .avi video.
	 * @param mp4Path path of the new .mp4 video.
	 *
	 */
	public static void AviToMp4(String aviPath, String mp4Path) {
		File source = new File(aviPath);
		File target = new File(mp4Path);
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(800000));
		audio.setChannels(new Integer(1));
		VideoAttributes video = new VideoAttributes();
		video.setCodec("libx264");
		video.setBitRate(new Integer(3200000));
		video.setFrameRate(new Integer(15));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat(FrameworkConstants.getMp4());
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(video);
		Encoder encoder = new Encoder();
		MultimediaObject multimediaObject = new MultimediaObject(source);
		try {
			encoder.encode(multimediaObject, target, attrs);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}

}
