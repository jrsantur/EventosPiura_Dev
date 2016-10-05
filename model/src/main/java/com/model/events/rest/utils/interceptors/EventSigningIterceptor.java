package com.model.events.rest.utils.interceptors;

import com.model.events.rest.RestDataSource;
import com.model.events.rest.utils.EventApiUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


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

		HttpUrl.Builder authorizedUrlBuilder = 	oldRequest.url().newBuilder()
			.scheme(oldRequest.url().scheme())
			.host(oldRequest.url().host());

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

