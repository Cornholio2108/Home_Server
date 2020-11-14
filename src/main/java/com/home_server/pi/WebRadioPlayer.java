package com.home_server.pi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebRadioPlayer {
	// "/bin/bash" "-c" "mplayer -noconsolecontrols -really-quiet -playlist
	// 'http://streams.ffh.de/radioffh/mp3/hqlivestream.m3u' </dev/null >/dev/null
	// 2>&1 & disown"

	// amixer set Headphone 50%
	// amixer set Headphone 10%+
	// amixer set Headphone 10%-
	// amixer set Headphone mute
//	amixer set Headphone unmute
//	amixer set Headphone toggle

	public void startStream(String url) {
		String[] cmd = { "/bin/bash", "-c", "mplayer -noconsolecontrols -really-quiet -playlist '" + url
				+ "' </dev/null >/dev/null 2>&1 & disown" };
		new TerminalCommand().runCmdOnThread(cmd);
	}

	public void startFile(String url, boolean repeat) {
		String[] cmd = { "/bin/bash", "-c",
				"mplayer -noconsolecontrols -really-quiet '" + url + "' </dev/null >/dev/null 2>&1 & disown" };
		if (repeat) {
			cmd = new String[] { "/bin/bash", "-c", "mplayer -noconsolecontrols -really-quiet -loop 0 '" + url
					+ "' </dev/null >/dev/null 2>&1 & disown" };
		}
		new TerminalCommand().runCmdOnThread(cmd);
	}

	public void stop() {
		String[] cmd = { "killall", "-9", "mplayer" };
		new TerminalCommand().runCmdOnThread(cmd);
	}

	public void setVolume(int volume) {
		String[] cmd = { "/bin/bash", "-c", "amixer set Headphone " + volume + "%" };
		new TerminalCommand().runCmdOnThread(cmd);
	}

	public void toggleMute() {
		String[] cmd = { "/bin/bash", "-c", "amixer set Headphone toggle" };
		new TerminalCommand().runCmdOnThread(cmd);
	}
}
