package com.aido.common.httpclient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * ClassName: IdleConnectionEvictor  
 * (定时清无效连接)
 * @author zhangtian  
 * @version
 */
public class IdleConnectionEvictor {

	private ExecutorService executorService = Executors.newSingleThreadExecutor();
	private final HttpClientConnectionManager connMgr;
	private volatile boolean shutdown;

	public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
		this.connMgr = connMgr;
	}
	
	public void executeClearIdleConnection() {
		// 启动当前线程
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					while (!shutdown) {
						synchronized (this) {
							wait(5000);
							// 关闭失效的连接
							connMgr.closeExpiredConnections();
						}
					}
				} catch (InterruptedException ex) {
					// 结束
					ex.printStackTrace();
				}
			}
		});
	}

	public void shutdown() {
		shutdown = true;
		executorService.shutdown();
		synchronized (this) {
			notifyAll();
		}
	}
	
}
