package com.rydgecraker.cvtc.enigmacipher;


public class Main {
	
	private String messageToDecode = "AYYTC IMLGF UUEFW LAOGU TZOXE CRMIM JFMPY QRJDW DKBLO JPCFV UDDSF RPJFA RZOCU BXXMY TAJLC IOMQY ADZUS GYIOC MPFKM HRTFX N";
	
	
	public Main() {
		
		Rotor r1 = new Rotor(10, "EKMFLGDQVZNTOWYHXUSPAIBRCJ ");
		Rotor r2 = new Rotor(1, "AJDKSIRUXBLHWTMCQGZNPYFVOE ");
		Rotor r3 = new Rotor(1, "BDFHJLCPRTXVZNYEIWGAKMUSQO ");
		Reflector ref = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD ");
		
		EnigmaMachine em = new EnigmaMachine(r1, r2, r3, ref);
		
		String decodedMessage = em.decode(messageToDecode);
		System.out.println(decodedMessage);
		
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
	
}
