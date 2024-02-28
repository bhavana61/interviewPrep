/* package whatever; // don't place package name! */

import java.util.*;

import src.Ola;
import src.Enums.CabType;
import src.Enums.UserType;

import java.lang.*;
import java.io.*;

class Root
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Ola ola = new Ola(10);
		int p1 = ola.registerRider(UserType.RIDER);
		int p2 = ola.registerRider(UserType.RIDER);

		int c1 = ola.registerCab(CabType.SEDEN, 1, 1, 1);
		int c2 = ola.registerCab(CabType.SEDEN, 1, 2, 2);

		int r1 = ola.bookRide(p1, 2, 1, 5,3);
		int r2 = ola.bookRide(p2, 2, 1, 5,1);
		
		double price1 = ola.completeRide(r1);
		double price2 = ola.completeRide(r2);
		int r3 = ola.bookRide(p2, 2, 1, 5,10);
		double price3 = ola.completeRide(r3);

		System.out.println(price1);
		System.out.println(price2);
		System.out.println(price3);
		
	}
}