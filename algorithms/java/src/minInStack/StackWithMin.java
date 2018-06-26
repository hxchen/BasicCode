package minInStack;

import java.util.Stack;

/**
 * Created by hxchen on 2018/6/26.
 */
public class StackWithMin<E> {

    private Stack<Integer> m_data = new Stack<>();
    private Stack<Integer> m_min = new Stack<>();

    // 返回栈的最小元素
    public Integer min(){
        return m_min.peek();
    }
    // 取出栈顶元素
    public Integer pop(){
        assert  (m_data.size() > 0 && m_min.size() > 0);
        Integer value = m_data.pop();
        m_min.pop();
        return value;
    }
    // 压入栈
    public Integer push(Integer value){
        m_data.push(value);
        if (m_min.isEmpty()){
            m_min.push(value);
        }else if(value < min()){
            m_min.push(value);
        }else {
            m_min.push(min());
        }
        return value;
    }
}
