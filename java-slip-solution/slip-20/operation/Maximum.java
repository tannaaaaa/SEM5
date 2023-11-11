package operation;

class Addition { 
    public float ans,n1,n2; 
    public float answer,num1,num2; 
    public Addition(float n1,float n2) { 
        this.n1=n1; 
        this.n2=n2; 
    } 
    public void add() { 
        ans=n1+n2; 
        System.out.println("addition is="+ans); 
    } 
    public void sub() {     
        answer=n1-n2; 
        System.out.println("subtraction is="+answer); 
    } 
 } 
 public class Maximum extends Addition { 
    public Maximum(int n1,int n2) { 
        super(n1,n2); 
    } 
    public void max() { 
        if (n1>n2) 
            System.out.println(n1+" is greater than "+n2); 
        else 
            System.out.println(n2+" is greater than "+n1); 
    } 
 } 