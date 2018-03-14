package com.rydgecraker.cvtc.enigmacipher;


public class Rotor {
	
	private char[]	topRotor;
	private char[]	bottomRotor;
	private int		currentPosition;
	
	
	/**
	 * 
	 * @param startingPosition
	 *            1 - 27 (Alphabet + space)
	 * @param rotorSetting
	 *            (The order of the 27 scrambled characters)
	 */
	public Rotor(int startingPosition, String rotorSetting) {
		this.topRotor = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
		this.bottomRotor = rotorSetting.toCharArray();
		this.currentPosition = startingPosition - 1;
	}
	
	
	public char encodeCharacter(char c, boolean forward) {
		if (forward) {
			return encode(c, topRotor, bottomRotor, forward);
		} else {
			return encode(c, bottomRotor, topRotor, forward);
		}
	}
	
	
	private char encode(char c, char[] rotor1, char[] rotor2, boolean forward) {
		int position = 0;
		for (int i = 0; i < rotor1.length; i++) {
			if (c == rotor1[i]) {
				position = i;
				break;
			}
		}
		if (forward) {
			position += currentPosition;
			if (position > 26) {
				position -= 27;
			}
		} else {
			position -= currentPosition;
			if (position < 0) {
				position += 27;
			}
		}
		
		return rotor2[position];
	}
	
	
	public boolean rotate() {
		currentPosition++;
		if (currentPosition > 26) {
			currentPosition = 0;
			return true;
		}
		return false;
	}
	
	
	public int getCurrentPosition() {
		return currentPosition;
	}
	
	
	
}
