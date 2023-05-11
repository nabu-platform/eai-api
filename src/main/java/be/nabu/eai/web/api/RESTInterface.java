package be.nabu.eai.web.api;

import be.nabu.libs.services.api.DefinedServiceInterface;
import be.nabu.libs.types.api.ComplexType;

public interface RESTInterface extends DefinedServiceInterface {
	public String getMethod();
	public String getPath();
	public ComplexType getPathParameters();
	public ComplexType getQueryParameters();
	public ComplexType getRequestHeaderParameters();
	public ComplexType getResponseHeaderParameters();
	public boolean isInputAsStream();
	public boolean isOutputAsStream();
	// the content type that should be used
	public String getContentType();
	// the default request and response body (not including errors etc)
	public ComplexType getRequestBody();
	public ComplexType getResponseBody();
}
