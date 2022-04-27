import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import Token;
import TokenType;

public class RPN{
    public static void main(String args[]){
        File file = new File("Calc1.stk"); // para mudar o arquivo alterar o endereço
        //System.out.println(new Token(TokenType.PLUS, "+"));
        try {
            Scanner scan = new Scanner(file);
            Stack pilha = new Stack();
            ArrayList<Token> tokens = new ArrayList<Token>();
            while(scan.hasNextLine()){
                String line = String.valueOf(scan.nextLine()); 
                if (line.equals("+")){
                    tokens.add(new Token(TokenType.PLUS,"+"));
                }else if(line.equals("-")){
                    tokens.add(new Token(TokenType.MINUS,"-"));
                }else if(line.equals("*")){
                    tokens.add(new Token(TokenType.STAR,"*"));
                }else if(line.equals("/")){
                    tokens.add(new Token(TokenType.SLASH,"/"));
                }else{
                    try{
                        Float.parseFloat(line);
                        tokens.add(new Token(TokenType.NUM, line));
                    }catch(Exception e){
                        System.out.println("Error: Unexpected character: " + line);
                        System.exit(1);
                    }
                }
                System.out.println(tokens.get(tokens.size()-1));
            }
            
            scan.close();
            while(!tokens.isEmpty()){
                Token token = tokens.remove(0);
                if (token.type == TokenType.NUM){
                    float i = Float.parseFloat(token.lexeme);
                    pilha.push(i);
                } else {
                    float int1 = ((Float)pilha.pop()).floatValue();
                    float int2 = ((Float)pilha.pop()).floatValue();
                    if (token.type == TokenType.PLUS){
                        float result = int2+int1;
                        pilha.push(result);
                    }else if(token.type == TokenType.MINUS){
                        float result = int2-int1;
                        pilha.push(result);
                    }else if(token.type == TokenType.STAR){
                        float result = int2*int1;
                        pilha.push(result);
                    }else if(token.type == TokenType.SLASH){
                        float result = int2/int1;
                        pilha.push(result);
                    }
                }
            }
            float result = ((Float)pilha.pop()).floatValue();
            System.out.printf("%f",result);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        };
    }
}