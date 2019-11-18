class ElseCaseMissingTestClass {
	
	ElseCaseMissingTestClass(ElseCaseMissingTestClass test) { }
	
	void method1(){
		if(true){
			// then
		}
		else{
			// something else
		}
	}
	
	
	void method2(){
		if(true){
			// then
		}
		else{
			if(false){ // Noncompliant
				// something else
				}
		}
	}
	
	
	void method3(){
		if(true){ // Noncompliant
			// then
		}
	}
	
	
}