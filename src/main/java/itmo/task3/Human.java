package itmo.task3;

public class Human {
	protected final String name;

	protected Building position;
	
	public Human(String name) {
		this.name = name;
		this.position = null;
	}
	
	public String getName() { return name; }
	
	public void goTo(Building building) { this.position = building; }
	
	public void beHappy() {
		System.out.println(name + " разразился ликующими криками!");
	}
	
	public Building getPosition() {
		return position;
	}
	
	public void setPosition(Building position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return name + " в данный момент находится в локации " + position;
	}
}
