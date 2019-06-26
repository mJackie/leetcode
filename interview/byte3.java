package interview;
import java.util.Scanner;
import java.util.Stack;

public class byte3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack();
        int i = 0;
        char[] str_arr = s.toCharArray();
        StringBuilder res = new StringBuilder();

        while(i<s.length()){
            if(str_arr[i]=='#'){
                StringBuilder temp = new StringBuilder();
                StringBuilder num = new StringBuilder();
                while(st.peek()!='%'){
                    temp.insert(0, st.pop());
                }
                st.pop();   // pop出 [
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num.insert(0, st.pop());
                }
                StringBuilder temp2 = new StringBuilder();
                for (int j = 0; j < Integer.valueOf(num.toString()) ; j++) {
                    temp2.append(temp.toString());
                }
                //入栈
                for (int j = 0; j < temp2.toString().length() ; j++) {
                    st.push(temp2.toString().toCharArray()[j]);
                }
            }else{
                st.push(str_arr[i]);
            }
            i++;
        }
        // 别忘了末尾的
        StringBuilder sb1 = new StringBuilder();
        while(!st.isEmpty()){
            sb1.insert(0, st.pop());
        }
        res.append(sb1);
        System.out.println(res.toString());
    }
}
