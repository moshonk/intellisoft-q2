package org.openmrs.module.practicalsq2.api;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.openmrs.Encounter;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class EncounterAroundAdvisor extends StaticMethodMatcherPointcutAdvisor implements Advisor {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6650838938766436615L;

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if (method.getName().equals("getEncounters ")) {
			return true;
		}
		return false;
	}
       
    @Override
	public Advice getAdvice() {
		return new EncounterAroundAdvisor ();
	}

    private class PatientAroundAdvice implements MethodInterceptor {

		@SuppressWarnings("unchecked")
		@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object args[] = invocation.getArguments();
		Object o = null;
			List<Encounter> encounters = (List<Encounter>) args[0];
			String userUuid = Context.getUserContext().getAuthenticatedUser().getUuid();
			List<Encounter> filteredPatientEncounters = encounters.stream()
			        .filter(encounter -> encounter.getCreator().getUuid().equals(userUuid))
             .collect(Collectors.toList());
             
			o = filteredPatientEncounters;
		
	    return o;
	  }
	}
}
