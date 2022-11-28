package TPE.comparador;

import TPE.Nodo;

import java.util.Comparator;

public class CompInt implements Comparator<Integer> {

	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}
