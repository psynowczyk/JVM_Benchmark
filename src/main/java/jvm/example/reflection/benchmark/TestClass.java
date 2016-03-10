package jvm.example.reflection.benchmark;

public class TestClass {
	public int value = 0;

	public int getValue() {
		return value;
	}
	
	public void setValue(int a) {
		this.value = a;
	}
	
	public void setValue(int a, int b) {
		this.value = a + b;
	}
}
