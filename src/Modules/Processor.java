package Modules;
import Core.ISA;
import Core.Instruction;

public class Processor {
    public int[] regs = new int[32];

    public void execute(String line, Instruction instruction) {
        String[] arr = line.split(" ");

        if(instruction.getOptype() == ISA.OPTYPE.ADD) {
            if(instruction.getFormat() == ISA.FORMAT.R_TYPE) {
                regs[0] = fromReg(arr[1]) + fromReg(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.I_TYPE) {
                regs[0] = fromReg(arr[1]) + fromHex(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.A_TYPE) {
                regs[0] = fromReg(arr[2]) + fromHex(arr[1]);
            } else if(instruction.getFormat() == ISA.FORMAT.B_TYPE) {
                regs[0] = fromHex(arr[1]) + fromHex(arr[2]);
            } else {
                System.out.println("Given incorrect instruction detected");
                return;
            }
        } else if(instruction.getOptype() == ISA.OPTYPE.SUB) {
            if(instruction.getFormat() == ISA.FORMAT.R_TYPE) {
                regs[0] = fromReg(arr[1]) - fromReg(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.I_TYPE) {
                regs[0] = fromReg(arr[1]) - fromHex(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.A_TYPE) {
                regs[0] = fromReg(arr[2]) - fromHex(arr[1]);
            } else if(instruction.getFormat() == ISA.FORMAT.B_TYPE) {
                regs[0] = fromHex(arr[1]) - fromHex(arr[2]);
            } else {
                System.out.println("Given incorrect instruction detected");
                return;
            }
        } else if(instruction.getOptype() == ISA.OPTYPE.MUL) {
            if(instruction.getFormat() == ISA.FORMAT.R_TYPE) {
                regs[0] = fromReg(arr[1]) * fromReg(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.I_TYPE) {
                regs[0] = fromReg(arr[1]) * fromHex(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.A_TYPE) {
                regs[0] = fromReg(arr[2]) * fromHex(arr[1]);
            } else if(instruction.getFormat() == ISA.FORMAT.B_TYPE) {
                regs[0] = fromHex(arr[1]) * fromHex(arr[2]);
            } else {
                System.out.println("Given incorrect instruction detected");
                return;
            }
        } else if(instruction.getOptype() == ISA.OPTYPE.DIV) {
            if(instruction.getFormat() == ISA.FORMAT.R_TYPE) {
                regs[0] = fromReg(arr[1]) / fromReg(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.I_TYPE) {
                regs[0] = fromReg(arr[1]) / fromHex(arr[2]);
            } else if(instruction.getFormat() == ISA.FORMAT.A_TYPE) {
                regs[0] = fromReg(arr[2]) / fromHex(arr[1]);
            } else if(instruction.getFormat() == ISA.FORMAT.B_TYPE) {
                regs[0] = fromHex(arr[1]) / fromHex(arr[2]);
            } else {
                System.out.println("Given incorrect instruction detected");
                return;
            }
        } else if(instruction.getOptype() == ISA.OPTYPE.MOV) {
            if(instruction.getFormat() == ISA.FORMAT.R_TYPE) {
                regs[fromReg(arr[2])] = regs[fromReg(arr[1])];
            } else if(instruction.getFormat() == ISA.FORMAT.I_TYPE) {
                regs[fromReg(arr[1])] = fromHex(arr[2]);
            } else {
                System.out.println("Given incorrect instruction detected");
                return;
            }
        }
    }

    short fromReg(String s) {
        return Short.parseShort(s.substring((1)));
    }

    short fromHex(String s) {
        return Short.parseShort(s.substring(2), 16);
    }
}
