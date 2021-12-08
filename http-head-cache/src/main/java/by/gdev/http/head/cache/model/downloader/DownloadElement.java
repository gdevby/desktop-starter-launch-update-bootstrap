/**
 * 
 */
package by.gdev.http.head.cache.model.downloader;

import java.time.LocalTime;
import java.util.List;

import by.gdev.http.head.cache.exeption.ThrowableExeption;
import by.gdev.http.head.cache.handler.PostHandler;
import by.gdev.util.model.download.Metadata;
import by.gdev.util.model.download.Repo;
import lombok.Data;

/**
 * Described all info to download  for one file
 * 
 * @author Robert Makrytski
 *
 */
@Data
public class DownloadElement {
	private List<PostHandler> handlers;
	private Metadata metadata;
	private String pathToDownload;
	/**
	 * Download part of the file
	 */
	private LocalTime start;
	private LocalTime end;
	private Repo repo;
	private volatile double downloadBytes;
	private volatile Throwable error;

}
