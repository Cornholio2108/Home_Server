package com.home_server.pi;

public class WebRadioPlayer {
	private String url="http://streams.ffh.de/radioffh/mp3/hqlivestream.m3u";

	public void start() {
		try {
			String[] cmd = { "sh", "-c", "mplayer '" + url + "' >/dev/null 2>&1" };
			//mplayer -playlist playlist.m3u </dev/null >/dev/null 2>&1 &
			Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
