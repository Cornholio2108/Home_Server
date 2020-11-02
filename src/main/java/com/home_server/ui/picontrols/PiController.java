package com.home_server.ui.picontrols;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.home_server.pi.PiCommands;

@Component
@Scope("view")
public class PiController {
	public void restartPi() {
		new PiCommands().runCommandThread(PiCommands.rebootCMD);
	}

	public void shutdownPi() {
		new PiCommands().runCommandThread(PiCommands.shutdownCMD);
	}
}
