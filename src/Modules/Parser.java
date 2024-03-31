package Modules;

import Core.ISA;
import Core.Instruction;

public class Parser {
    private static Parser parser;
    private Parser() {}

    public static Parser getInstance() {
        return parser;
    }

    public static Instruction parse(String line) {
        String[] arr = line.split(" ");
        ISA.OPTYPE optype = null;
        ISA.FORMAT format = null;

        switch(arr[0]) {
            case "+" : optype = ISA.OPTYPE.ADD;
            case "-" : optype = ISA.OPTYPE.SUB;
            case "*" : optype = ISA.OPTYPE.MUL;
            case "/" : optype = ISA.OPTYPE.DIV;
            case "M" : optype = ISA.OPTYPE.MOV;
        }

        String operand1 = arr[1];
        String operand2 = arr[2];

        if(operand1.charAt(0) == 'R' && operand2.charAt(0) == 'R') {
            format = ISA.FORMAT.R_TYPE;
        } else if(operand1.charAt(0) == 'R' && operand2.substring(0,1).equals("0x")) {
            format = ISA.FORMAT.I_TYPE;
        } else if(operand1.substring(0,1).equals("0x") && operand2.charAt(0) == 'R') {
            format = ISA.FORMAT.A_TYPE;
        } else if(operand1.substring(0,1).equals("0x") && operand2.substring(0,1).equals("0x")) {
            format = ISA.FORMAT.B_TYPE;
        }

        if(optype==null && format==null) {
            System.out.println("Incorrect instruction.");
            return null;
        }
        return new Instruction(optype, format);
    }
}
