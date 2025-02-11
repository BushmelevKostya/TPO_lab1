package itmo.task3;

public class Human {
	private String name;
	private Movement movement;
	private Building position;
	
	public Human(String name) {
		this.name = name;
		this.movement = Movement.НИЧЕГО_НЕ_ДЕЛАТЬ;
		this.position = null;
	}
	
	public String getName() { return name; }
	
	public void goTo(Building building) { this.position = building; }
	
	public void makeSpeech(Crowd crowd) {
		this.movement = Movement.ОБРАЩАТЬСЯ_К_НАРОДУ;
		for (Human human : crowd.getHumans()) {
			human.movement = Movement.РАЗРАЗИТЬСЯ_КРИКАМИ;
		}
	}
	
	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	public Movement getMovement() {
		return movement;
	}
	
	public Building getPosition() {
		return position;
	}
	
	public void setPosition(Building position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return name + " в данный момент находится в локации '" + position + "' и выполняет действие '" + movement.toString() + "'";
	}
}
