package com.model.events.rest.utils.interceptors;

import com.model.events.rest.RestDataSource;
import com.model.events.rest.utils.EventApiUtils;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;


public class EventSigningIterceptor implements Interceptor {
	private final String mApiKey;
	private final String mApiSecret;

	public EventSigningIterceptor(String apiKey, String apiSecret) {
		mApiKey = apiKey;
		mApiSecret = apiSecret;
	}

	@Override public Response intercept(Chain chain) throws IOException {
		String marvelHash = EventApiUtils.generateEventHash(mApiKey, mApiSecret);
		Request oldRequest = chain.request();

		HttpUrl.Builder authorizedUrlBuilder = oldRequest.httpUrl().newBuilder()
			.scheme(oldRequest.httpUrl().scheme())
			.host(oldRequest.httpUrl().host());

		authorizedUrlBuilder.addQueryParameter(RestDataSource.PARAM_API_KEY, mApiKey)
			.addQueryParameter(RestDataSource.PARAM_TIMESTAMP, EventApiUtils.getUnixTimeStamp())
			.addQueryParameter(RestDataSource.PARAM_HASH, marvelHash);

		Request newRequest = oldRequest.newBuilder()
			.method(oldRequest.method(), oldRequest.body())
			.url(authorizedUrlBuilder.build())
			.build();

		return chain.proceed(newRequest);
	}
}

