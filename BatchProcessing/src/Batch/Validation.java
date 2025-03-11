package Batch;

public class Validation {
	
	private String result;
	@SuppressWarnings("finally")
	public String validate(String name,String phone,int sal) {
		
	try {
		int namelen=name.length();
		int phonelen=phone.length();
		
		if(namelen<3 || namelen>30) {
			result="Enter valid name";
			throw new InvalidEmployeeInputexception("Enter valid name");
		}
		else if(phonelen!=13){
			result="Enter valid phone";
			throw new InvalidEmployeeInputexception("Eneter valid phone");
		}
		else if(sal<100 || sal>2000) {
			result="Enter valid salary";
			throw new InvalidEmployeeInputexception("Eneter valid salary");
		}
		else {
			
			result="valid";
			
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	finally {
		return result;
	}
			
	}

}
