package com.rydgecraker.cvtc.enigmacipher;


public class EnigmaMachine {
	
	private Rotor		firstRotor, secondRotor, thirdRotor;
	private Reflector	reflector;
	
	
	public EnigmaMachine(Rotor firstRotor, Rotor secondRotor, Rotor thirdRotor, Reflector reflector) {
		this.firstRotor = firstRotor;
		this.secondRotor = secondRotor;
		this.thirdRotor = thirdRotor;
		this.reflector = reflector;
	}
	
	
	public String decode(String encodedMessage) {
		char[] code = encodedMessage.toUpperCase().toCharArray();
		char[] decode = new char[code.length];
		
		char tempChar;
		for (int i = 0; i < code.length; i++) {
			tempChar = code[i];
			tempChar = firstRotor.encodeCharacter(tempChar, true);
			tempChar = secondRotor.encodeCharacter(tempChar, true);
			tempChar = thirdRotor.encodeCharacter(tempChar, true);
			
			tempChar = reflector.reflect(tempChar);
			
			tempChar = thirdRotor.encodeCharacter(tempChar, false);
			tempChar = secondRotor.encodeCharacter(tempChar, false);
			tempChar = firstRotor.encodeCharacter(tempChar, false);
			
			decode[i] = tempChar;
			rotate();
			
		}
		
		return new String(decode);
	}
	
	
	private void rotate() {
		boolean keepRotating = false;
		keepRotating = firstRotor.rotate();
		if (keepRotating) {
			keepRotating = secondRotor.rotate();
			if (keepRotating) {
				thirdRotor.rotate();
			}
		}
	}
	
}
