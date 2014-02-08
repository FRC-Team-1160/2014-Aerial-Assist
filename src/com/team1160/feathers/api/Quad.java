package com.team1160.feathers.api;

/*
 * simple class used to
 * out source the quad math
 */

public class Quad {
	
	protected double a,b,c;
	
	public Quad(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double result(double in){
		return a*in*in + b*in + c;
	}
	
}
