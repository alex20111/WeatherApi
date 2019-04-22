package net.weather.action;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
//		America/Toronto","currently":{"time":1555929091
		long dt = 1555929091 * 1000l;
		long dt2 = 1000;
		long dt3 = 1555929091;
		
//		dt = dt3 * dt2;
		
		System.out.println("New date: " + new Date(dt) +  " Curr date:" + new Date().getTime() + " dt: " + dt);
	
	}

}
