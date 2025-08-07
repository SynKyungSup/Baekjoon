//중위 표기식을 후위 표기식으로 바꾸기
import java.util.Scanner;
import java.util.Stack;
public class B1918 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for( char c: expression.toCharArray()){
            if(c=='+'||c=='-'){
                if(stack.isEmpty() || stack.peek()=='('){ // 스택이 비어있거나, (가 맨 뒤 일 경우 c를 그냥 push;
                    stack.push(c);
                } else{
                    while(!stack.isEmpty()&&stack.peek() !='('){
                        result.append(stack.pop());
                    }
                    stack.push(c);
                }    
            } else if(c=='*' || c=='/'){    
                if(stack.isEmpty() || stack.peek()=='('){
                    stack.push(c);
                }
                else{
                    while((!stack.isEmpty()&&stack.peek()!='(')&&(stack.peek()=='*'||stack.peek()=='/')){
                        result.append(stack.pop());
                    }
                    stack.push(c);
                }

            } else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek() !='('){
                    result.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // '(' 제거
                }
            }
            else { // c는 연산자가 아닌 일반 문자
                result.append(c);
            }
            
        }
        while(!stack.isEmpty()){
                result.append(stack.pop());
            }
        System.out.println(result.toString());
    }
    
}
