import Core.*;
import Modules.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java FileInputExample <file-path>");
            return;
        }

        String filePath = args[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            Processor processor = new Processor();
            while ((line = reader.readLine()) != null) {
                Instruction instruction = Parser.parse(line);
                processor.execute(line, instruction);
                System.out.println("result: " + processor.regs[0]);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

