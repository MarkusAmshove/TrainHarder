package de.justinharder.powerlifting.view;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.justinharder.powerlifting.view.navigation.ExternerWebContext;
import de.justinharder.powerlifting.view.navigation.Fehlermeldung;
import de.justinharder.powerlifting.view.navigation.Navigator;
import lombok.extern.slf4j.Slf4j;

@Named
@RequestScoped
@Slf4j
public class Controller
{
	protected final ExternerWebContext externerWebContext;
	protected final Navigator navigator;

	@Inject
	public Controller(final ExternerWebContext externerWebContext, final Navigator navigator)
	{
		this.externerWebContext = externerWebContext;
		this.navigator = navigator;
	}

	protected String getRequestParameter(final String parameterBezeichnung)
	{
		try
		{
			return externerWebContext.getRequestParameter().get(parameterBezeichnung);
		}
		catch (final Exception e)
		{
			log.error("Fehler beim Ermitteln des Request-Parameters!", e);
			return "";
		}
	}

	protected String ermittlePflichtparameterwert(final String parametername)
	{
		final var parameterwert = externerWebContext.getRequestParameter().get(parametername);
		if (parameterwert == null || parameterwert.isEmpty())
		{
			log.error("Der Pflichtparameterwert für den Parameternamen \"" + parametername
				+ "\" konnte nicht aus der URL ermittelt werden.");
			navigiere(navigator.zurFehlerseite(Fehlermeldung.PARAMETER_NICHT_VORHANDEN));
		}
		return parameterwert;
	}

	private void navigiere(final String url)
	{
		try
		{
			externerWebContext.navigiere(url);
		}
		catch (final IOException e)
		{
			throw new RuntimeException(
				"Es ist ein kritischer Fehler aufgetreten. Die direkte Navigation zur URL \"" + url
					+ "\" ist fehlgeschlagen.",
				e);
		}
	}
}