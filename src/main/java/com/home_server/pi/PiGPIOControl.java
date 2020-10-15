package com.home_server.pi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class PiGPIOControl {
	final GpioController gpio = GpioFactory.getInstance();

	public void testOutput() {
		GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, // PIN NUMBER
				"My LED", // PIN FRIENDLY NAME (optional)
				PinState.LOW); // PIN STARTUP STATE (optional)
	}

	public boolean testInput() {
		GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, // PIN NUMBER
				"MyButton", // PIN FRIENDLY NAME (optional)
				PinPullResistance.PULL_DOWN); // PIN RESISTANCE (optional)
		PinState myButtonState = myButton.getState();
		boolean buttonPressed = myButton.isHigh();
		return buttonPressed;
	}
}
