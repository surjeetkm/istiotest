package com.example.config;

public class HelloTest {

	public void m() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Future 2 Test..");
			for(int j=0;j<100;j++) {
				System.out.println("Local changes");
			}
		}
		while(true){
			System.out.println("Infinite Loop");
		}
		
	}
}
