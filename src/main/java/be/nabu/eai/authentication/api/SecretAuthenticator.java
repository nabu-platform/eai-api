package be.nabu.eai.authentication.api;

import javax.jws.WebParam;
import javax.validation.constraints.NotNull;

import be.nabu.libs.authentication.api.Device;
import be.nabu.libs.authentication.api.Token;
import be.nabu.libs.authentication.api.principals.SharedSecretPrincipal;

public interface SecretAuthenticator {
	public Token authenticate(@NotNull @WebParam(name = "realm") String realm, @NotNull @WebParam(name = "credentials") SharedSecretPrincipal credential, @NotNull @WebParam(name = "device") Device device);
}
