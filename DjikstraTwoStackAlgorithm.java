import java.util.Scanner;
//by: Isabella Rolfe
public class DjikstraTwoStackAlgorithm {

    public Double alg() {
        Stack<Double> numbers = new Stack<Double>();
        Stack<String> symbols = new Stack<String>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter equation");
        String equation = sc.nextLine();

        Scanner fromString = new Scanner(equation);
        while (fromString.hasNext()) {
            String token = fromString.next();
            if (token.equals("(")) {
                // do nothing
            }
            // else if an operator, push onto the operator stack
            else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("sqrt")) {
                symbols.Push(token);
            } else if (token.equals(")")) {
                String sym = symbols.Pop().item;
                //pop off 2
                double newestValue = numbers.Pop().item;
                if (sym.equals("+")) {
                    //pops off 3 + 2
                    newestValue = numbers.Pop().item + newestValue;
                } else if (sym.equals("-")) {
                    newestValue = numbers.Pop().item - newestValue;
                } else if (sym.equals("*")) {
                    newestValue = numbers.Pop().item * newestValue;
                } else if (sym.equals("/")) {
                    newestValue = numbers.Pop().item / newestValue;
                } else if (sym.equals("sqrt")) {
                    newestValue = Math.sqrt(newestValue);
                }
                //pushes back on numbers stack
                numbers.Push(newestValue);
            } else if (isNumber(token)) {
                //takes string makes a number, assumes it's a number
                numbers.Push(Double.parseDouble(token));
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
        DjikstraTwoStackAlgorithm algorithm = new DjikstraTwoStackAlgorithm();
        System.out.println(algorithm.alg());
    }
}


