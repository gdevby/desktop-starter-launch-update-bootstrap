/**
 * 
 */
package by.gdev.http.upload.download.downloader;

import java.time.Duration;
import java.util.List;

import com.google.common.eventbus.EventBus;

import lombok.Data;

/**
 * Contains information about current status of the downloading. Will send with
 * {@link EventBus} every second in {@link DownloaderStatusEnum#WORK} status
 * 
 * @author Robert Makrytski
 *
 */

@Data
public class DownloaderStatus {
	/**
	 * Times was passed after start. 
	 */
	private Duration duration;
	/**
	 * Speed in KB
	 */
	private double speed;
	/**
	 * Summary download traffic for every resources
	 */
	private long downloadSize;
	/**
	 * Summary download traffic.
	 */
	private long allDownloadSize;
	private Integer leftFiles;
	private Integer allFiles;
	/**
	 * To get errors after asynchronous upload all files
	 */
	private List<Throwable> throwables;
	private DownloaderStatusEnum downloaderStatusEnum;

}
