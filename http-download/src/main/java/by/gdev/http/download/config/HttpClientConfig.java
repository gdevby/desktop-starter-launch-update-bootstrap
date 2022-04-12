package by.gdev.http.download.config;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
/**
 * This class allows you to set the maximum number of total open connections, the maximum number of concurrent connections per route and connection Keep-Alive strategy.
 * @author Robert Makrytski
 *
 */
public class HttpClientConfig {

	public static CloseableHttpClient getInstanceHttpClient() {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setDefaultMaxPerRoute(5);
		cm.setMaxTotal(20);
		CloseableHttpClient builder = HttpClients.custom()
				.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE).setConnectionManager(cm)
				.evictIdleConnections(10, TimeUnit.SECONDS).build();
		return builder;
	}
}