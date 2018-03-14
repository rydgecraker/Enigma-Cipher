package com.rydgecraker.cvtc.enigmacipher;


public class Reflector {
	
	private char[]	topReflector;
	private char[]	bottomReflector;
	
	
	public Reflector(String reflectorSetting) {
		this.topReflector = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
		this.bottomReflector = reflectorSetting.toCharArray();
	}
	
	
	public char reflect(char c) {
		int position = 0;
		for (int i = 0; i < topReflector.length; i++) {
			if (c == topReflector[i]) {
				position = i;
				break;
			}
		}
		return bottomReflector[position];
	}
	
}
