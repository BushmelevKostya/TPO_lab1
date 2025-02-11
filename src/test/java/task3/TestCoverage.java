package task3;

import itmo.task3.Building;
import itmo.task3.Crowd;
import itmo.task3.Human;
import itmo.task3.Movement;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TestCoverage {
	
	@Test
	void shouldCreateHumanWithDefaultState() {
		Human arthur = new Human("Артур");
		assertEquals("Артур", arthur.getName());
		assertEquals(Movement.НИЧЕГО_НЕ_ДЕЛАТЬ, arthur.getMovement());
		assertNull(arthur.getPosition());
	}
	
	@Test
	void shouldChangeLocationWhenGoTo() {
		Human arthur = new Human("Артур");
		Building palace = new Building("Дворец");
		
		arthur.goTo(palace);
		assertThat(arthur.toString()).contains("Дворец");
	}
	
	@Test
	void shouldChangeMovement() {
		Human arthur = new Human("Артур");
		arthur.setMovement(Movement.СКОЛЬЗИТЬ_ПО_ВОЗДУХУ);
		assertEquals(Movement.СКОЛЬЗИТЬ_ПО_ВОЗДУХУ, arthur.getMovement());
	}
	
	@Test
	void shouldMakeSpeechAndAffectCrowd() {
		Human speaker = new Human("Оратор");
		Crowd crowd = new Crowd();
		
		Human listener1 = new Human("Слушатель 1");
		Human listener2 = new Human("Слушатель 2");
		crowd.addHuman(listener1);
		crowd.addHuman(listener2);
		
		speaker.makeSpeech(crowd);
		
		assertEquals(Movement.ОБРАЩАТЬСЯ_К_НАРОДУ, speaker.getMovement());
		assertEquals(Movement.РАЗРАЗИТЬСЯ_КРИКАМИ, listener1.getMovement());
		assertEquals(Movement.РАЗРАЗИТЬСЯ_КРИКАМИ, listener2.getMovement());
	}
	
	@Test
	void shouldConvertToStringCorrectly() {
		Human arthur = new Human("Артур");
		assertThat(arthur.toString()).contains("Артур", "НИЧЕГО_НЕ_ДЕЛАТЬ");
		
		Building palace = new Building("Дворец");
		assertThat(palace.toString()).isEqualTo("Здесь возведено: Дворец");
	}
	
	
	@Test
	void shouldCreateBuildingWithName() {
		Building palace = new Building("Дворец");
		assertEquals("Дворец", palace.getName());
	}
	
	@Test
	void shouldAllowChangingName() {
		Building palace = new Building("Дворец");
		palace.setName("Замок");
		assertEquals("Замок", palace.getName());
	}
	
	@Test
	void shouldInitializeWithEmptyHumanList() {
		Building palace = new Building("Дворец");
		assertNull(palace.getHumans());
	}
	
	
	@Test
	void shouldCreateEmptyCrowd() {
		Crowd crowd = new Crowd();
		assertTrue(crowd.getHumans().isEmpty());
	}
	
	@Test
	void shouldAddHumansToCrowd() {
		Crowd crowd = new Crowd();
		Human person1 = new Human("Человек 1");
		Human person2 = new Human("Человек 2");
		
		crowd.addHuman(person1);
		crowd.addHuman(person2);
		
		assertThat(crowd.getHumans()).containsExactly(person1, person2);
	}
	
	
	@Test
	void shouldContainCorrectEnumValues() {
		assertEquals(Movement.НИЧЕГО_НЕ_ДЕЛАТЬ, Movement.valueOf("НИЧЕГО_НЕ_ДЕЛАТЬ"));
		assertEquals(Movement.СКОЛЬЗИТЬ_ПО_ВОЗДУХУ, Movement.valueOf("СКОЛЬЗИТЬ_ПО_ВОЗДУХУ"));
		assertEquals(Movement.ОБРАЩАТЬСЯ_К_НАРОДУ, Movement.valueOf("ОБРАЩАТЬСЯ_К_НАРОДУ"));
		assertEquals(Movement.РАЗРАЗИТЬСЯ_КРИКАМИ, Movement.valueOf("РАЗРАЗИТЬСЯ_КРИКАМИ"));
	}
}
