package com.dscexpen.conllection;

import com.dscexpen.model.Person;

import java.util.Comparator;


public class sortByAge implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int h=o1.getAge()-o2.getAge();
		return h==0?o1.getName().hashCode()-o2.getName().hashCode():h;
	}

}
