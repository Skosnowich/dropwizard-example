package io.github.skosnowich.dropexa.resources;

import com.codahale.metrics.annotation.Timed;
import io.github.skosnowich.dropexa.TestObjects;
import io.github.skosnowich.dropexa.api.TranslationNamespace;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/translation")
@Produces(MediaType.APPLICATION_JSON)
public class TranslationResource {

	@GET
	@Timed
	public TranslationNamespace getTranslation(@Context HttpServletRequest request) {
		return TestObjects.getTranslation(request.getLocale());
	}

}
