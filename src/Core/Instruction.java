package Core;

public class Instruction {
    ISA.OPTYPE optype;
    ISA.FORMAT format;

    public Instruction(ISA.OPTYPE optype, ISA.FORMAT format) {
        this.optype = optype;
        this.format = format;
    }

    public ISA.OPTYPE getOptype() {
        return optype;
    }

    public ISA.FORMAT getFormat() {
        return format;
    }
}
