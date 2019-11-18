class TooManyArgumentsTestClass{
	
	TooManyArgumentsTestClass(TooManyArgumentsTestClass test){ }
	
	void method0(int a, int b, int c, int d, int e, String f){ } // Noncompliant
	
	int method1(int a, int b, int c, int d, String f, double g, short h) { return 0;}
	
	void method2(int a, int b, int c, int d){ }
	
	void method3(Object a, Object b, Object c, Object d, Object e){ } // Noncompliant
	
	void method4(){ }
	
	}	