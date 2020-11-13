package com.home_server.pi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TerminalCommand {
	public void runCmd(String[] cmd) {
		try {
			String cmdString = "";
			for (String string : cmd) {
				cmdString = cmdString.concat(string);
			}
			System.out.println("Executing cmd: " + cmdString);
			String s;
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = br.readLine()) != null)
				System.out.println("line: " + s);
			p.waitFor();
			System.out.println("exit: " + p.exitValue());
			p.destroy();

			System.out.println("Cmd executed successfully: " + cmdString);
		} catch (Exception e) {
			System.out.println("Cmd execution error: " + e.getCause() + "\n" + e.toString());
		}
	}

	public void runCmdOnThread(String[] urlStr) {
		new Thread() {
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
		}.start();
	}
}
