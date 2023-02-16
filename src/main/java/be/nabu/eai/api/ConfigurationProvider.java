package be.nabu.eai.api;

import be.nabu.libs.artifacts.api.ContextualArtifact;

public interface ConfigurationProvider extends ContextualArtifact {
	// for the context you are in, provide us with a configuration of this type (if you have any)
	public Object getConfiguration(String typeId);
}
