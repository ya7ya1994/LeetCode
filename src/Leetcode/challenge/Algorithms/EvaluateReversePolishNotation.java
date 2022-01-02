class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack();
        List<String> operators = new ArrayList();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        
        for(String token : tokens) {
            //when token is an operand
            if (!operators.contains(token)) {
                numbers.push(Integer.parseInt(token));
                continue;
            } 
            
            //when token is an operator
            //we pop two operands from the Stack numbers
            //we calculate the operation then push the value in numbers
            int operand1 = numbers.pop();
            int operand2 = numbers.pop();
            int result = 0;
            
            switch (token) {
                case "+" :
                    result = operand2 + operand1;
                    break;
                case "-" :
                    result = operand2 - operand1;
                    break;
                case "/" :
                    result = operand2 / operand1;
                    break;
                case "*" :
                    result = operand2 * operand1;
                    break;
                default :
                    break;
            }
            numbers.push(result);               
        }
        //the only value left in the stack is the final result
        return numbers.pop();
        
    }
}
