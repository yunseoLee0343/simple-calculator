package Core;

public class ISA {
    private static final ISA instance = new ISA();
    private ISA() {}

    public enum OPTYPE {
        ADD, SUB, MUL, DIV, MOV
    }

    public enum FORMAT {
        R_TYPE, I_TYPE, A_TYPE, B_TYPE;
    }
}
