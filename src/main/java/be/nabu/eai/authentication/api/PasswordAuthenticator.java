package be.nabu.eai.authentication.api;

import javax.jws.WebParam;

import be.nabu.libs.authentication.api.TokenWithSecret;
import be.nabu.libs.authentication.api.principals.BasicPrincipal;

public interface PasswordAuthenticator {
	public TokenWithSecret authenticate(@WebParam(name = "realm") String realm, @WebParam(name = "credentials") BasicPrincipal credential);
}
