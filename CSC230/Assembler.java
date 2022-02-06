import java.util.Scanner;

public class Assembler {
	private static final boolean TEST_MODE = true;

	public static void main(String[] args) {
		int count = 0;
		String op = "";
		String op2 = "";
		String op3 = "";
		String op4 = "";
		byte opcode = 0;
		byte rs = 0;
		byte rt = 0;
		byte rd = 0;
		byte shamt = 0;
		byte funct = 0;
		short immed;
		int machineLang = 0;
		Scanner in = new Scanner(System.in);

		if (!TEST_MODE) {
			testCases();
		} else {

			System.out.println("Assembler - Malik Teague\n");

			System.out.println("*** Begin entering Asslember: ");
			while (op != ("HALT")) {

				op = in.next().toUpperCase();

				if (op.equals("HALT")) {
					break;
				}
				op2 = in.next().toUpperCase();
				op3 = in.next().toUpperCase();
				op4 = in.next().toUpperCase();

				switch (op) {
				case "ADD":
					opcode = 0;
					rs = regToByte(op3);
					rt = regToByte(op4);
					rd = regToByte(op2);
					shamt = 0;
					funct = 0x20;
					machineLang = makeR(opcode, rs, rt, rd, shamt, funct);
					count++;
					break;

				case "AND":
					opcode = 0;
					rs = regToByte(op3);
					rt = regToByte(op4);
					rd = regToByte(op2);
					shamt = 0;
					funct = 0x24;
					machineLang = makeR(opcode, rs, rt, rd, shamt, funct);
					count++;
					break;

				case "SRL":
					opcode = 0;
					rs = 0;
					rt = regToByte(op3);
					rd = regToByte(op2);
					shamt = Byte.parseByte(op4);
					funct = 0x02;
					machineLang = makeR(opcode, rs, rt, rd, shamt, funct);
					count++;
					break;

				case "SLL":
					opcode = 0;
					rs = 0;
					rt = regToByte(op3);
					rd = regToByte(op2);
					shamt = Byte.parseByte(op4);
					funct = 0x00;
					machineLang = makeR(opcode, rs, rt, rd, shamt, funct);
					count++;
					break;

				case "LW":
					opcode = 0x23;
					rt = regToByte(op2);
					immed = Short.parseShort(op3);
					rs = regToByte(op4);
					machineLang = makeI(opcode, rs, rt, immed);
					count++;
					break;

				case "SW":
					opcode = 0x2b;
					rt = regToByte(op2);
					immed = Short.parseShort(op3);
					rs = regToByte(op4);
					machineLang = makeI(opcode, rs, rt, immed);
					count++;
					break;
				case "ADDI":
					opcode = 0x8;
					rt = regToByte(op2);
					rs = regToByte(op3);
					immed = Short.parseShort(op4);
					machineLang = makeI(opcode, rs, rt, immed);
					count++;
					break;
				case "ANDI":
					opcode = 0xc;
					rt = regToByte(op2);
					rs = regToByte(op3);
					immed = Short.parseShort(op4);
					machineLang = makeI(opcode, rs, rt, immed);
					count++;
					break;

				case "BEQ":
					opcode = 0x4;
					rs = regToByte(op2);
					rt = regToByte(op3);
					immed = Short.parseShort(op4);
					machineLang = makeI(opcode, rs, rt, immed);
					count++;
					break;
				}

				System.out.println(
						"***: " + String.format("%32s", Integer.toBinaryString(machineLang)).replace(" ", "0"));
			}

			System.out.println("\n*** Assembly complete. Program required " + count + " words of memory.");
			in.close();
		}
	}

	private static int makeR(byte opcode, byte rs, byte rt, byte rd, byte shamt, byte funct) {
		int returnValue = 0;

		returnValue = opcode << 26;
		returnValue = returnValue | rs << 21;
		returnValue = returnValue | rt << 16;
		returnValue = returnValue | rd << 11;
		returnValue = returnValue | shamt << 6;
		returnValue = returnValue | funct;

		return returnValue;
	}

	private static int makeI(byte opcode, byte rs, byte rt, short immed) {
		int returnValue = 0;
		int temp = 0;

		returnValue = opcode << 26;
		returnValue = returnValue | rs << 21;
		returnValue = returnValue | rt << 16;
		temp = immed & 0x0000FFFF;
		returnValue = returnValue | temp;

		return returnValue;
	}

	private static byte regToByte(String r) {
		byte returnValue = 0;

		switch (r) {

		case "$ZERO":
			returnValue = 0;
			break;
		case "$AT":
			returnValue = 1;
			break;
		case "$V0":
			returnValue = 2;
			break;
		case "$V1":
			returnValue = 3;
			break;
		case "$A0":
			returnValue = 4;
			break;
		case "$A1":
			returnValue = 5;
			break;
		case "$A2":
			returnValue = 6;
			break;
		case "$A3":
			returnValue = 7;
			break;
		case "$T0":
			returnValue = 8;
			break;
		case "$T1":
			returnValue = 9;
			break;
		case "$T2":
			returnValue = 10;
			break;
		case "$T3":
			returnValue = 11;
			break;
		case "$T4":
			returnValue = 12;
			break;
		case "$T5":
			returnValue = 13;
			break;
		case "$T6":
			returnValue = 14;
			break;
		case "$T7":
			returnValue = 15;
			break;
		case "$S0":
			returnValue = 16;
			break;
		case "$S1":
			returnValue = 17;
			break;
		case "$S2":
			returnValue = 18;
			break;
		case "$S3":
			returnValue = 19;
			break;
		case "$S4":
			returnValue = 20;
			break;
		case "$S5":
			returnValue = 21;
			break;
		case "$S6":
			returnValue = 22;
			break;
		case "$S7":
			returnValue = 23;
			break;
		case "$T8":
			returnValue = 24;
			break;
		case "$T9":
			returnValue = 25;
			break;
		}

		return returnValue;
	}

	/*************************************************************
	 *
	 * Test Code below Do NOT modify
	 * 
	 ************************************************************/

	private static void testCases() {
		if (test_regToByte())
			System.out.println("RegToByte working well\n");
		else
			System.out.println("RegToByte failed\n");

		if (test_makeR())
			System.out.println("makeR working well\n");
		else
			System.out.println("makeR failed\n");

		if (test_makeI())
			System.out.println("makeI working well\n");
		else
			System.out.println("makeI failed\n");
	}

	private static boolean test_regToByte() {
		boolean passedTest = true;
		String[] regs = { "$ZERO", "$AT", "$V0", "$V1", "$A0", "$A1", "$A2", "$A3", "$T0", "$T1", "$T2", "$T3", "$T4",
				"$T5", "$T6", "$T7", "$S0", "$S1", "$S2", "$S3", "$S4", "$S5", "$S6", "$S7", "$T8", "$T9" };

		for (int i = 0; i < regs.length; i++) {
			passedTest &= testReg(regs[i], i);
		}

		return passedTest;
	};

	private static boolean testReg(String regName, int expValue) {
		if (regToByte(regName) != expValue)
			System.out.printf("Fail: regToByte(\"%s\") = %d, should be %d\n", regName, regToByte(regName), expValue);
		return regToByte(regName) == expValue;
	}

	private static boolean test_makeR() {
		boolean passedTest = true;

		int i = makeR((byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1);
		if (i != 0b00000100001000010000100001000001) {
			System.out.println("Test: makeR(1,1,1,1,1,1) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		i = makeR((byte) 63, (byte) 0, (byte) 31, (byte) 0, (byte) 31, (byte) 0);
		if (i != 0b11111100000111110000011111000000) {
			System.out.println("Test: makeR(63,0,31,0,31,0) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		return passedTest;
	};

	private static boolean test_makeI() {
		boolean passedTest = true;

		int i = makeI((byte) 1, (byte) 1, (byte) 1, (short) 1);
		if (i != 0b00000100001000010000000000000001) {
			System.out.println("Test: makeI(1,1,1,1) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		i = makeI((byte) 63, (byte) 0, (byte) 31, (short) 0);
		if (i != 0b11111100000111110000000000000000) {
			System.out.println("Test: makeI(63,0,31,0) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		i = makeI((byte) 63, (byte) 0, (byte) 31, (short) -1);
		if (i != 0b11111100000111111111111111111111) {
			System.out.println("Test: makeI(63,0,31,-1) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		return passedTest;
	};

}
