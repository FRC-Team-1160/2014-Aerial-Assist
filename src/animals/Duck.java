package animals;


public class Duck extends Animal {
	
	public Duck(int age, String color){
		super(age, color);
		super.setColor("yellow");
	}
	
	@Override
	public void speak(){
		System.out.println(super.getColor());
	}
}
