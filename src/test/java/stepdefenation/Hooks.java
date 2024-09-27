package stepdefenation;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@addplace2")
	void main()
	{
		System.out.println("i am good");
	}
}
