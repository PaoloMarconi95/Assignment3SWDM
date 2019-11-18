class AlwaysFinallyBlockTestClass {
	
	AlwaysFinallyBlockTestClass(AlwaysFinallyBlockTestClass test) { }
	
	void method0(){
		try{ // Noncompliant
		}
		catch(Exception e){
		}
	}
	
	void method1(){
		try{
		}
		catch(Exception e){
		}
		finally{
		}
	}
	
}