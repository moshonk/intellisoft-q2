package org.openmrs.module.practicalsq2.api;

import java.util.List;
import java.util.stream.Collectors;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;

public class testing {
	
	

	public void getEncounters() {
		
		Patient patient = new Patient();
		
		String currentProvider = "";
		List<Encounter> encounters = Context.getEncounterService().getEncountersByPatient(patient);
		encounters.stream()
				.filter(e->e.getCreator().getUuid().equals(currentProvider))
				.collect(Collectors.toList());
	
	}
}
