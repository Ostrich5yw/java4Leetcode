package MediumDifficulty;

import java.util.LinkedList;

public class p150 {
    //    public String calculate(String a, String b, String opt){
//        String res = "";
//        switch(opt){
//            case "+" : res = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
//                break;
//            case "-" : res = String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
//                break;
//            case "*" : res = String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
//                break;
//            case "/" : res = String.valueOf(Integer.parseInt(a) / Integer.parseInt(b));
//                break;
//        }
//        return res;
//    }
//
//    public String[] removeAndJoin(int start, String[] tokens){
//        int i;
//        int end = start + 2;
//        System.out.println(tokens[start] + " " + tokens[start + 1] + " " + tokens[end]);
//        tokens[start] = calculate(tokens[start], tokens[start + 1], tokens[end]);
//        start += 1;
//        for(i = end + 1; i < tokens.length && tokens[i] != "end"; i ++){
//            tokens[start ++] = tokens[i];
//        }
//        while(start != i){
//            tokens[start ++] = "end";
//        }
////        for(int g = 0; g < tokens.length; g ++)
////            System.out.print(tokens[g] + " ");
////        System.out.println();
//        return tokens;
//    }
//
//
//    public int evalRPN(String[] tokens) {
//        while(tokens[1] != "end"){
//            for(int i = 0; tokens[i] != "end"; i ++){
//                if((!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
//                     && (!tokens[i + 1].equals("+") && !tokens[i + 1].equals("-") && !tokens[i + 1].equals("*") && !tokens[i + 1].equals("/"))
//                        && (tokens[i + 2].equals("+") || tokens[i + 2].equals("-") || tokens[i + 2].equals("*") || tokens[i + 2].equals("/"))) {
//                    tokens = removeAndJoin(i, tokens);
//                    continue;
//                }
//            }
//        }
//        return Integer.parseInt(tokens[0]);
//    }
//}

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            int a, b;
            switch (tokens[i]) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}
