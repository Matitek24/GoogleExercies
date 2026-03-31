class Solution{
	public boolean isValid(String s){
		Deque<Character> que = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch == '[' || ch == '(' || ch == '{' ){
                que.push(ch);
            }else{
                if(que.isEmpty()) return false;

                char toCheck = que.pop();

                if(toCheck == '[' && ch != ']') return false;
                 if(toCheck == '{' && ch != '}') return false;
                  if(toCheck == '(' && ch != ')') return false;
            }
        
        }
        return que.isEmpty();
	}
    
}
