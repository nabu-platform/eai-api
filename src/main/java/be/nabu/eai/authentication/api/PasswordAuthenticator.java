package be.nabu.eai.authentication.api;

import javax.jws.WebParam;
import javax.validation.constraints.NotNull;

import be.nabu.libs.authentication.api.Device;
import be.nabu.libs.authentication.api.TokenWithSecret;
import be.nabu.libs.authentication.api.principals.BasicPrincipal;

public interface PasswordAuthenticator {
	public TokenWithSecret authenticate(@NotNull @WebParam(name = "realm") String realm, @NotNull @WebParam(name = "credentials") BasicPrincipal credential, @WebParam(name = "device") Device device);
}
