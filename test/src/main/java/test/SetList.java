package test;

import java.util.LinkedList;

public class SetList<T> extends LinkedList<T>{
	private static final long serialVersionUID = 1434324234L;  
	  
    @Override  
    public boolean add(T object) {  
        if (size() == 0) {  
            return super.add(object);  
        } else {  
            int count = 0;  
            for (T t : this) {  
                if (t.equals(object)) {  
                    count++;  
                    break;  
                }  
            }  
            if (count == 0) {  
                return super.add(object);  
            } else {  
                return false;  
            }  
        }  
    }  

}
