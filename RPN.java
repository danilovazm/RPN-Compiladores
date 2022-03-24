import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RPN{
    public static void main(String args[]){
        File file = new File("Calc1.stk"); // para mudar o arquivo alterar o endereço
        try {
            Scanner scan = new Scanner(file);
            Stack pilha = new Stack();
            while(scan.hasNextLine()){
                String line = String.valueOf(scan.nextLine());
                if (!line.equals("+") && !line.equals("-") && !line.equals("*") && !line.equals("/")){
                    float i = Float.parseFloat(line);
                    pilha.push(i);
                } else {
                    float int1 = ((Float)pilha.pop()).floatValue();
                    float int2 = ((Float)pilha.pop()).floatValue();
                    if (line.equals("+")){
                        float result = int2+int1;
                        pilha.push(result);
                    }else if(line.equals("-")){
                        float result = int2-int1;
                        pilha.push(result);
                    }else if(line.equals("*")){
                        float result = int2*int1;
                        pilha.push(result);
                    }else if(line.equals("/")){
                        float result = int2/int1;
                        pilha.push(result);
                    }
                }
            }
            scan.close();
            float result = ((Float)pilha.pop()).floatValue();
            System.out.printf("%f",result);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        };
    }
}