package com.aido.common.httpclient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

import com.aido.common.httpclient.loader.PropertyLoader;
import com.aido.common.httpclient.model.HttpClientProperties;

/**
 * ClassName: HttpClientManager  
 * (HttpClient管理类)
 * @author DOUBLE  
 * @version
 */
public class HttpClientManager {
	// 属性文件
	private static HttpClientProperties httpClientProperties = null ;
	public static final PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager() ;
	
	static {
		httpClientProperties = (HttpClientProperties) PropertyLoader.loadProperty(HttpClientProperties.class) ;
		
		// 连接池配置
		if(httpClientProperties.getMaxTotal() != 0) {
			httpClientConnectionManager.setMaxTotal(httpClientProperties.getMaxTotal());
		}
		
		if(httpClientProperties.getDefaultMaxPerRoute() != 0) {
			httpClientConnectionManager.setDefaultMaxPerRoute(httpClientProperties.getDefaultMaxPerRoute());
		}
		
		if(httpClientProperties.getValidateAfterInactivity() != 0) {
			httpClientConnectionManager.setValidateAfterInactivity(httpClientProperties.getValidateAfterInactivity());
		}
	}
	
	private HttpClientManager() {
		
	}
	
	/**
	 *  getHttpClientBuilder:(HttpClientBuilder). 
	 *  @return_type:HttpClientBuilder
	 *  @author DOUBLE 
	 *  @return
	 */
	private static final HttpClientBuilder getHttpClientBuilder(int retryTime) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create() ;
		httpClientBuilder.setConnectionManager(httpClientConnectionManager) ;
		// 是否开启断线重连开关
		if(httpClientProperties.isRetryConnection() && retryTime > 0) {
			httpClientBuilder.setRetryHandler(retryHttpRequestRetryHandler(retryTime)) ;
		}
		return httpClientBuilder ;
	}
	
	/**
	 * 创建CloseableHttpClient
	 *  createCloseableHttpClient:(这里用一句话描述这个方法的作用). 
	 *  @return_type:CloseableHttpClient
	 *  @author DOUBLE 
	 *  @return
	 */
	public static final CloseableHttpClient createCloseableHttpClient(int retryTime) {
		return getHttpClientBuilder(retryTime).build() ;
	}
	
	private static final Builder getBuilder() {
		RequestConfig.Builder builder = RequestConfig.custom() ;
		if(httpClientProperties.getConnectTimeout() != 0) {
			builder.setConnectTimeout(httpClientProperties.getConnectTimeout()) ;
		}
		
		if(httpClientProperties.getConnectionRequestTimeout() != 0) {
			builder.setConnectionRequestTimeout(httpClientProperties.getConnectionRequestTimeout()) ;
		}
		
		if(httpClientProperties.getSocketTimeout() != 0) {
			builder.setSocketTimeout(httpClientProperties.getSocketTimeout()) ;
		}
		return builder ;
	}
	
	/**
	 *  getRequestConfig:(RequestConfig). 
	 *  @return_type:RequestConfig
	 *  @author DOUBLE 
	 *  @return
	 */
	public static final RequestConfig getRequestConfig() {
		RequestConfig requestConfig = getBuilder().build() ;
		return requestConfig ;
	}
	
	private static HttpRequestRetryHandler retryHttpRequestRetryHandler(final int retryTime) {
		return new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= retryTime) {// 如果已经重试了5次，就放弃                     
					return false;  
				}  
                
				if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试                    
                    return true;  
                }  
                
				if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常                   
                    return false;  
                }                 
	               
				if (exception instanceof InterruptedIOException) {// 超时                   
                    return false;  
                }  
	               
				if (exception instanceof UnknownHostException) {// 目标服务器不可达                   
                    return false;  
                }  
				
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝                   
                    return false;  
                }  
                
                if (exception instanceof SSLException) {// ssl握手异常                    
                    return false;  
                }  
                
                HttpClientContext clientContext = HttpClientContext.adapt(context);  
                HttpRequest request = clientContext.getRequest();  
                // 如果请求是幂等的，就再次尝试  
                if (!(request instanceof HttpEntityEnclosingRequest)) {                   
                    return true;  
                }  
                
				return false;
			}
		};
	}
}
