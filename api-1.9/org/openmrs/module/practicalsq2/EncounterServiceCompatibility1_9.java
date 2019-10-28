
package org.openmrs.module.practicalsq2;

import org.openmrs.module.htmlformentry.compatibility.EncounterServiceCompatibility;

@Component("htmlformentry.EncounterServiceCompatibility")
@OpenmrsProfile(openmrsPlatformVersion = "1.9.9 - 1.12.*")
public class EncounterServiceCompatibility1_9 implements EncounterServiceCompatibility {
	@Override
	public List<Encounter> getEncounters(Patient who, Location loc, Date fromDate, Date toDate,
			Collection<Form> enteredViaForms,
			Collection<EncounterType> encounterTypes,
			Collection<Provider> providers, Collection<VisitType> visitTypes,
			Collection<Visit> visits, boolean includeVoided) {

		return Context.getEncounterService().getEncounters(who, loc, fromDate, toDate,
				enteredViaForms, encounterTypes, providers, visitTypes, visits,
				includeVoided);
	}
}
