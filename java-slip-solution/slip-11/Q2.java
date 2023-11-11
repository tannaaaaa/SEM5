class InvalidUsernameException extends Exception{ 
	public InvalidUsernameException(){ 
		System.out.println("Invalid Username"); 
	} 
} 

class InvalidPasswordException extends Exception{ 
	public InvalidPasswordException(){ 
		System.out.println("Invalid Password"); 
	} 
} 

class Login{ 
	String uname,pwd; 
	public Login(String uname,String pwd) { 
		this.uname=uname; 
		this.pwd=pwd; 
	} 
} 

public class Q2 {
    public static void main(String[] args) { 
		String uname,pwd; 
		uname=args[0]; 
		pwd=args[1]; 
		Login ob=new Login(uname,pwd); 
		try{ 
			if(("austinmakasare").equals(ob.uname)) 
				System.out.println("Valid Username"); 
			else 
				throw new InvalidUsernameException(); 
		}catch(InvalidUsernameException e){ } 
		try{ 
			if(("makasare0031").equals(ob.pwd)) 
				System.out.println("Valid Password"); 
			else 
				throw new InvalidPasswordException(); 
		}catch(InvalidPasswordException e1){ } 
	} 
}