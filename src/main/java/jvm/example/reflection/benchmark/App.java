package jvm.example.reflection.benchmark;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jvm.example.reflection.benchmark.TestClass;

public class App {
    
	public static void RunTests(double ymax, int xmax, boolean print) {
		if (print) {
			System.out.println("Odczyt i zapis pola - bezpośrednio: " + DirectGetSet(ymax, xmax) + " milisekund");
	    	System.out.println("Odczyt i zapis pola - refleksja: " + ReflectionGetSet(ymax, xmax) + " milisekund");
	    	System.out.println("Wywołanie metody - bezpośrednio: " + DirectMethodCall(ymax, xmax) + " milisekund");
	    	System.out.println("Wywołanie metody - refleksja: " + ReflectionMethodCall(ymax, xmax) + " milisekund");
		}
		else {
			DirectGetSet(ymax, xmax);
			ReflectionGetSet(ymax, xmax);
			DirectMethodCall(ymax, xmax);
			ReflectionMethodCall(ymax, xmax);
		}
	}
	
	// Odczyt i zapis pola - bezpośrednio
	public static double DirectGetSet(double ymax, int xmax) {
		long startTime = 0, estimTime = 0;
		double y = 0.0;
		TestClass obj = new TestClass();
    	for (y = 0.0; y < ymax; y++) {
	    	startTime = System.currentTimeMillis();
	        for (int x = 0; x < xmax; x++) {
	        	obj.value = obj.value + 1;
	        }
	        estimTime = estimTime + System.currentTimeMillis() - startTime;
    	}
    	return ((double)estimTime / y);
	}

	// Odczyt i zapis pola - refleksja
	public static double ReflectionGetSet(double ymax, int xmax) {
		long startTime = 0, estimTime = 0;
		double y = 0.0;
		try {
			Class<?> cls = Class.forName("jvm.example.reflection.benchmark.TestClass");
			Object obj = cls.newInstance();
			Field fld = obj.getClass().getDeclaredField("value");
	    	for (y = 0.0; y < ymax; y++) {
		    	startTime = System.currentTimeMillis();
		        for (int x = 0; x < xmax; x++) {
		        	fld.setInt(obj, (fld.getInt(obj) + 1));
		        }
		        estimTime = estimTime + System.currentTimeMillis() - startTime;
	    	}
		}
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (SecurityException e) { e.printStackTrace(); }
		catch (IllegalArgumentException e) { e.printStackTrace(); }
		catch (NoSuchFieldException e) { e.printStackTrace(); }
    	return ((double)estimTime / y);
	}
	
	// Wywołanie metody - bezpośrednio
	public static double DirectMethodCall(double ymax, int xmax) {
		long startTime = 0, estimTime = 0;
		double y = 0.0;
		TestClass obj = new TestClass();
    	for (y = 0.0; y < ymax; y++) {
	    	startTime = System.currentTimeMillis();
	        for (int x = 0; x < xmax; x++) {
	        	obj.setValue(x, 1);
	        }
	        estimTime = estimTime + System.currentTimeMillis() - startTime;
    	};
    	return ((double)estimTime / y);
	}
	
	// Wywołanie metody - refleksja
	public static double ReflectionMethodCall(double ymax, int xmax) {
		long startTime = 0, estimTime = 0;
		double y = 0.0;
		try {
			Class<?> cls = Class.forName("jvm.example.reflection.benchmark.TestClass"); 
			Method method = cls.getDeclaredMethod("setValue", int.class, int.class);
			Object obj = cls.newInstance();
			for (y = 0.0; y < ymax; y++) {
		    	startTime = System.currentTimeMillis();
				for (int x = 0; x < xmax; x++) {
					method.invoke(obj, x, 1);
				}
				estimTime = estimTime + System.currentTimeMillis() - startTime;
			}
		}
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (NoSuchMethodException e) { e.printStackTrace(); }
		catch (SecurityException e) { e.printStackTrace(); }
		catch (IllegalArgumentException e) { e.printStackTrace(); }
		catch (InvocationTargetException e) { e.printStackTrace(); }
		return ((double)estimTime / y);
	}
	
	public static void main( String[] args ) throws InterruptedException {
    	RunTests(100.0, 1000, false); // rozgrzewka
    	RunTests(100.0, 10000000, true); // testy
    }
}
