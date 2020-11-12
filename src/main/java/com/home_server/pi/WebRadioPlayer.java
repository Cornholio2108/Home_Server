package com.home_server.pi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebRadioPlayer {
	private String url = "http://streams.ffh.de/radioffh/mp3/hqlivestream.m3u";

	public void start() {
		try {
			String[] cmd = {
					"mplayer", "-noconsolecontrols -really-quiet -playlist '" + url + "' </dev/null >/dev/null 2>&1 &",
					"disown" };
			// nohup mplayer -noconsolecontrols -really-quiet -playlist
			// http://streams.ffh.de/radioffh/mp3/hqlivestream.m3u </dev/null >/dev/null
			// 2>&1 & disown
			String cmdString = "";
			for (String string : cmd) {
				cmdString = cmdString.concat(string);
			}
			System.out.println("Try start Radio: " + cmdString);
			String s;
			Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();

//			ProcessBuilder pb = new ProcessBuilder(cmd);
//			Process p = pb.start();
//
//			StringBuffer sb = new StringBuffer();
//
//			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//			String line = reader.readLine();
//			sb.append(line);
//			while (line != null) {
//				line = reader.readLine();
//				sb.append(line);
//			}
//			System.out.println(sb.toString());

			System.out.println("Radio started: " + url);
		} catch (Exception e) {
			System.out.println("Radio start error: " + e.getCause() + "\n" + e.toString());
		}
	}
	
	public void startTest(String newCmd) {
		try {
			String[] cmd = { newCmd };
			// mplayer -noconsolecontrols -really-quiet -playlist 'http://streams.ffh.de/radioffh/mp3/hqlivestream.m3u' </dev/null >/dev/null 2>&1 & disown
			String cmdString = "";
			for (String string : cmd) {
				cmdString = cmdString.concat(string);
			}
			System.out.println("Try start Radio: " + cmdString);
			
			String s;
			Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();

			System.out.println("Radio started: " + url);
		} catch (Exception e) {
			System.out.println("Radio start error: " + e.getCause() + "\n" + e.toString());
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
