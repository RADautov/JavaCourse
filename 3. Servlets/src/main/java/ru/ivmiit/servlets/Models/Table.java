package ru.ivmiit.servlets.Models;

import ru.ivmiit.servlets.Box;

class Table implements Box {
	private int countOfLegs;
	private double weight;

	public Table(int countOfLegs, double weight) {
		this.countOfLegs = countOfLegs;
		this.weight = weight;
	}

	public double getWeight() {
		return this.weight;
	}
}