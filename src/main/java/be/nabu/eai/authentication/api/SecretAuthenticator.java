package be.nabu.eai.authentication.api;

import javax.jws.WebParam;

import be.nabu.libs.authentication.api.Token;
import be.nabu.libs.authentication.api.principals.SharedSecretPrincipal;

public interface SecretAuthenticator {
	public Token authenticate(@WebParam(name = "realm") String realm, @WebParam(name = "credentials") SharedSecretPrincipal credential);
}
