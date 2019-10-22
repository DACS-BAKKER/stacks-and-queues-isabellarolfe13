import java.util.Scanner;
//by: Isabella Rolfe
public class DTSA2 {

    public Double alg() {
        Stack<Double> numbers = new Stack<Double>();
        Stack<String> symbols = new Stack<String>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter equation");
        String equation = sc.nextLine();
        Scanner fromString = new Scanner(equation);
        String prevToken = "";
        while (fromString.hasNext()) {
            String token = fromString.next();
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("sqrt")) {
                symbols.Push(token);
                prevToken = token;
            } else if (isNumber(token)) {
                if (prevToken.equals("")) {
                    numbers.Push(Double.parseDouble(token));
                    prevToken = token;
                } else if (prevToken.equals("*") || prevToken.equals("/")) {
                    String sym = symbols.Pop().item;
                    double newestValue = numbers.Pop().item;
                    if (sym.equals("*")) {
                        newestValue = newestValue * Double.parseDouble(token);
                    } else if (sym.equals("/")) {
                        newestValue = newestValue / Double.parseDouble(token);
                    }
                    numbers.Push(newestValue);
                    prevToken=Double.toString(newestValue);
                } else if (prevToken.equals("sqrt")) {
                    String sym = symbols.Pop().item;
                    double newestValue=Math.sqrt(Double.parseDouble(token));
                    numbers.Push(newestValue);
                    prevToken=Double.toString(newestValue);
                } else if (prevToken.equals("+") || prevToken.equals("-")) {
                    String sym = symbols.Pop().item;
                    double newestValue = numbers.Pop().item;
                    if (sym.equals("+")) {
                        newestValue = newestValue + Double.parseDouble(token);
                    } else if (sym.equals("-")) {
                        newestValue = newestValue - Double.parseDouble(token);
                    }
                    numbers.Push(newestValue);
                    prevToken=Double.toString(newestValue);
                }
            }
        }
        Double result=numbers.Pop().item;
        return result;
    }

    public static boolean isNumber (String token){
        try{
            Double.parseDouble(token);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        DTSA2 algorithm = new DTSA2();
        System.out.println(algorithm.alg());
    }
}


