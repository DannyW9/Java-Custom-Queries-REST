package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskysByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canFindDistilleriesByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindWhiskysFromASpecificDistilleryByAge() {
		List<Whisky> found = whiskyRepository.findWhiskysOfACertainAgeFromASpecificDistillery(1L, 12);
		assertEquals(1, found.size());
	}

	@Test
	public void canFindWhiskiesByRegion() {
		List<Whisky> found = whiskyRepository.findWhiskiesByRegion("Highland");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindDistilleriesWithWhiskiesOfCertainAge() {
		List<Distillery> found = distilleryRepository.findDistilleriesWithXYearOldWhiskies(12);
		assertEquals(2, found.size());
	}
}
