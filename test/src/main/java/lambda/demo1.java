package lambda;

import java.util.Collection;
import java.util.Collections;

import javax.swing.event.ListSelectionEvent;

import com.google.common.collect.Lists;

public class demo1 {
	public static void main(String[] args) {
		Collections.sort(Lists.newArrayList("jack","rose"),(o1,o2)->o1.compareTo(o2));
	}

}
