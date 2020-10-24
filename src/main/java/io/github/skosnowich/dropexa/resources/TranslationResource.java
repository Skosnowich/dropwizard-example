package io.github.skosnowich.dropexa.resources;

import com.codahale.metrics.annotation.Timed;
import io.github.skosnowich.dropexa.TestObjects;
import io.github.skosnowich.dropexa.api.TranslationNamespace;
import lombok.EqualsAndHashCode;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@EqualsAndHashCode
@Path("/translation")
@Produces(MediaType.APPLICATION_JSON)
public class TranslationResource {

	private final TestObjects testObjects;

	public TranslationResource(TestObjects testObjects) {
		this.testObjects = testObjects;
	}

	@GET
	@Timed
	public TranslationNamespace getTranslation(@Context HttpServletRequest request) {
		return testObjects.getTranslation(request.getLocale());
	}

}
