package com.home_server.rest.user;

public class RestResponse {
	private final long id;
	private final String content;

	public RestResponse(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
