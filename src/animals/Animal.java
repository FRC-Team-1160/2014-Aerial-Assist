package animals;


public abstract class Animal {
	private int age;
	private String color;
	
	public Animal(int age, String color){
		this.setAge(age);
		this.setColor(color);
	}
	
	public void speak(){
		System.out.println("rawr");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
