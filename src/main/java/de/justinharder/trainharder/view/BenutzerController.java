package de.justinharder.trainharder.view;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.binding.BindingResult;
import javax.security.enterprise.SecurityContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import de.justinharder.trainharder.model.domain.exceptions.AuthentifizierungNichtGefundenException;
import de.justinharder.trainharder.model.domain.exceptions.BenutzerNichtGefundenException;
import de.justinharder.trainharder.model.services.AuthentifizierungService;
import de.justinharder.trainharder.model.services.BenutzerService;
import lombok.AccessLevel;
import lombok.Setter;

@Controller
@Path("/benutzer")
public class BenutzerController
{
	@Context
	@Setter(AccessLevel.NONE)
	private HttpServletRequest request;
	@Context
	@Setter(AccessLevel.NONE)
	private HttpServletResponse response;
	@Inject
	private Models models;
	@Inject
	private BindingResult bindingResult;
	@Inject
	private SecurityContext securityContext;

	@Inject
	private AuthentifizierungService authentifizierungService;
	@Inject
	private BenutzerService benutzerService;

	@GET
	public String index()
	{
		return "/benutzer/index.xhtml";
	}

	@GET
	@Path("/{benutzername}")
	public String benutzerdaten(@PathParam("benutzername") final String benutzername)
	{
		initialisiereAuthentifizierung();

		return "/benutzer/benutzer.xhtml";
	}

	private void initialisiereAuthentifizierung()
	{
		try
		{
			if (securityContext.getCallerPrincipal() != null)
			{
				final var authentifizierungDto =
					authentifizierungService.ermittleZuBenutzername(securityContext.getCallerPrincipal().getName());
				models.put("authentifizierung", authentifizierungDto);
				models.put("benutzer",
					benutzerService.ermittleZuAuthentifizierung(authentifizierungDto.getPrimaerschluessel()));
			}
		}
		catch (final AuthentifizierungNichtGefundenException | BenutzerNichtGefundenException e)
		{
			models.put("fehler", e.getMessage());
		}
	}
}
