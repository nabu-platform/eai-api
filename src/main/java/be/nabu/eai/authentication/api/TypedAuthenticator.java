package be.nabu.eai.authentication.api;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.validation.constraints.NotNull;

import be.nabu.libs.authentication.api.Device;
import be.nabu.libs.authentication.api.Token;
import be.nabu.libs.authentication.api.principals.TypedPrincipal;

// can authenticate multiple types of credentials
public interface TypedAuthenticator {
	// the type could be for instance "password" or "secret" or "oauth2"
	
	// for oauth2, you should store all the relevant data of the original request in a record in the database, we send the id of that record as state
	// upon return the state becomes the name, the code we get from the redirect becomes the password
	// this can be exchanged in the backend into a token, which can then be wrapped with a secret (if relevant) etc etc
	
	// secret authentication requires the device (for cms at least)
	// sms2fa uses temporary authentication, as would google authenticator and the likes
	// the subtype is to distinguish between variations, for example sms2fa and email2fa might both use "temporary" authentication but have a different subtype, this may or may not be relevant for the implementation
	@WebResult(name = "token")
	public Token authenticate(@NotNull @WebParam(name = "realm") String realm, @NotNull @WebParam(name = "credentials") TypedPrincipal credential, @WebParam(name = "device") Device device);
}
