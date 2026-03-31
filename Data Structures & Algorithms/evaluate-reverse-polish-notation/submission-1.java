class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")){
                int b = stack.poll();
                int a = stack.poll();

                if(s.equals("+")) stack.push(a+b);
                if(s.equals("*")) stack.push(a*b);
                if(s.equals("/")) stack.push(a/b);
                if(s.equals("-")) stack.push(a-b);
            }else{
                  stack.push(Integer.parseInt(s));
            }
        }
        return stack.poll();
    }
}
