
public class Getname extends Thread{
	public void run(){
		System.out.println("running....");
		
	}
	public static void main(String ar[])
	{
		Getname t1=new Getname();
		Getname t2=new Getname();
		System.out.println("name of t1="+t1.getName());
		System.out.println("name of t2="+t2.getName());

		System.out.println("id of t1="+t1.getId());
		System.out.println("id of t2="+t1.getId());
		t1.start();
		t2.start();
		
		t1.setName("Arjun");
		System.out.println("After changing name of t1:"+t1.getName());  

		t2.setName("komal");
		System.out.println("After changing name of t2:"+t2.getName());  

	}

}
