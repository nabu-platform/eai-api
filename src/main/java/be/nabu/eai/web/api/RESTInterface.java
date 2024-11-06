/*
* Copyright (C) 2015 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

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
