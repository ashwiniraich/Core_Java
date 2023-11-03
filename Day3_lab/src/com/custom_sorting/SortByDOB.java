package com.custom_sorting;

import java.util.Comparator;

import com.core.Customer;

public class SortByDOB implements Comparator<Customer>{

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getDob().compareTo(c2.getDob());
	}

}
