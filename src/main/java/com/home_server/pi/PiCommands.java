package com.home_server.pi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PiCommands {
	public Thread cmdThread;
	public String[] rebootCMD = { "sudo", "reboot", "now" };
	public String[] shellCMDwithArgs = { "nohup", "/home/pi/picam/run_picam.sh", "start" };

	public void runCommandThread(String[] urlStr) {
		cmdThread = new Thread() {
			public void run() {
				try {
					for (String string : urlStr) {
						System.out.print(string + " ");
					}
					System.out.println();

					// Thread.sleep(500);
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec(urlStr);

					Thread out = new Thread() {
						public void run() {
							try {
								String line = null;
								BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
								while ((line = input.readLine()) != null) {
									System.out.println(line);
								}

							} catch (Exception e) {
								System.out.println("out.error: " + e.toString());
							}
						}
					};
					out.start();
					Thread err = new Thread() {
						public void run() {
							try {
								String line = null;
								BufferedReader input = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
								while ((line = input.readLine()) != null) {
									System.out.println(line);
								}
							} catch (Exception e) {
								System.out.println("err.error: " + e.toString());
							}
						}
					};
					err.start();

					int exitVal = pr.waitFor();

					out.join();
					err.join();
				} catch (Exception v) {
					System.out.println(v);
				}
			}
		};
		cmdThread.start();
	}
}
