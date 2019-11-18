class SwitchControlTestClass {
	
	SwitchControlTestClass(SwitchControlTestClass test) { }
	
	void method1a(){
		switch(a){ // Noncompliant
			case b:
			break;
			case c:
			break;
		}
	}
	
	void method1b(){
		switch(a){ // Noncompliant
			case b:
			break;
			default:
			break;
		}
	}
	
	
	void method2(){
		switch(a){
			case b:
			break;
			case c:
			break;
			default:
			return 0;
		}
	}
	
	
	
	void method3(){
		switch(a){
			case b:
			break;
			case c:
			break;
			case d:
			break;
			default:
			return 0;
		}
	}
	
}