package task3;

import itmo.task3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestCoverage {
	
	private Human human;
	private Orator orator;
	private Artur artur;
	private Building building;
	private Crowd crowd;
	 
	@BeforeEach
	void setUp() {
		human = new Human("Человек");
		orator = new Orator("Оратор");
		artur = new Artur();
		building = new Building("Дворец");
		crowd = new Crowd();
	}
	
	@Test
	void shouldCreateHuman() {
		assertEquals("Человек", human.getName());
		assertNull(human.getPosition());
	}
	
	@Test
	void shouldChangeLocation() {
		human.goTo(building);
		assertEquals(building, human.getPosition());
	}
	
	@Test
	void shouldMakeHumanHappy() {
		human.beHappy();
	}
	
	@Test
	void shouldConvertHumanToString() {
		Human human = new Human("Артур");
		assertEquals("Артур в данный момент находится в локации null", human.toString());
		human.goTo(building);
		assertEquals("Артур в данный момент находится в локации Дворец", human.toString());
	}
	
	@Test
	void shouldCreateBuilding() {
		assertEquals("Дворец", building.getName());
	}

	@Test
	void shouldCreateCrowd() {
		Crowd crowd = new Crowd();
		assertTrue(crowd.getHumans().isEmpty());
	}
	
	@Test
	void shouldAddHumansToCrowd() {
		Human person1 = mock(Human.class);
		Human person2 = mock(Human.class);
		
		crowd.addHuman(person1);
		crowd.addHuman(person2);
		
		assertEquals(crowd.getHumans().size(), 2);
	}
	
	@Test
	void shouldMakeCrowdCheer() {
		Human person1 = mock(Human.class);
		Human person2 = mock(Human.class);
		
		crowd.addHuman(person1);
		crowd.addHuman(person2);
		
		crowd.cheer();
		
		verify(person1, times(1)).beHappy();
		verify(person2, times(1)).beHappy();
	}
	
	@Test
	void shouldMakeSpeechSuccessfully() {
		Building buildingMock = mock(Building.class);
		Crowd crowdMock = mock(Crowd.class);
		
		when(buildingMock.getName()).thenReturn("Помост");
		orator.goTo(buildingMock);
		orator.makeSpeech(crowdMock);
		
		verify(crowdMock, times(1)).cheer();
	}
	
	@Test
	void shouldFailMakeSpeech() {
		Building buildingMock = mock(Building.class);
		Crowd crowdMock = mock(Crowd.class);
		
		when(buildingMock.getName()).thenReturn("Дворец");
		orator.goTo(buildingMock);
		
		orator.makeSpeech(crowdMock);
		
		verify(crowdMock, never()).cheer();
	}
	
	@Test
	void shouldGlideThroughTheAir() {
		artur.glideThroughTheAir();
		assertEquals("Величественное окно на втором этаже", artur.getPosition().getName());
	}
}
