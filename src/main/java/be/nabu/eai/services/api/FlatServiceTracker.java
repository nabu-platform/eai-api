package be.nabu.eai.services.api;

import javax.jws.WebParam;

public interface FlatServiceTracker {
	public void track(@WebParam(name="isBefore") boolean isBefore, @WebParam(name="serviceId") String service, @WebParam(name="step") String step, @WebParam(name="exception") Exception exception);
}
