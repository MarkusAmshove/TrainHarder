package de.justinharder.powerlifting.view;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.justinharder.powerlifting.model.domain.dto.AuthentifizierungEintrag;
import de.justinharder.powerlifting.model.domain.exceptions.AuthentifizierungNichtGefundenException;
import de.justinharder.powerlifting.model.domain.exceptions.BenutzernameVergebenException;
import de.justinharder.powerlifting.model.domain.exceptions.MailBereitsRegistriertException;
import de.justinharder.powerlifting.model.domain.exceptions.PasswortNichtSicherException;
import de.justinharder.powerlifting.model.services.AuthentifizierungService;
import de.justinharder.powerlifting.view.navigation.ExternerWebContext;
import de.justinharder.powerlifting.view.navigation.Fehlermeldung;
import de.justinharder.powerlifting.view.navigation.Navigator;
import lombok.Getter;

@Getter
@Named
@SessionScoped
public class AuthentifizierungController extends Controller
{
	private static final long serialVersionUID = -3304162878990370933L;

	private final AuthentifizierungService authentifizierungService;
	private final AuthentifizierungEintrag authentifizierungEintrag = new AuthentifizierungEintrag();

	@Inject
	public AuthentifizierungController(
		final ExternerWebContext externerWebContext,
		final Navigator navigator,
		final AuthentifizierungService authentifizierungService)
	{
		super(externerWebContext, navigator);
		this.authentifizierungService = authentifizierungService;
	}

	public List<AuthentifizierungEintrag> getAuthentifizierung()
	{
		return authentifizierungService.ermittleAlle();
	}

	public AuthentifizierungEintrag getAuthentifizierungZuId() throws AuthentifizierungNichtGefundenException
	{
		return authentifizierungService.ermittleZuId(getRequestParameter("authentifizierungId"));
	}

	public AuthentifizierungEintrag getAuthentifierungZuBenutzer() throws AuthentifizierungNichtGefundenException
	{
		return authentifizierungService.ermittleZuBenutzer(getRequestParameter("benutzerId"));
	}

	public void erstelleAuthentifizierung()
	{
		authentifizierungService.erstelleAuthentifizierung(authentifizierungEintrag);
	}

	public String registriere()
	{
		try
		{
			authentifizierungService.registriereBenutzer(authentifizierungEintrag);
			return navigator
				.zurRegistrierungErfolgreichMailBestaetigung(String.valueOf(authentifizierungEintrag.getId()));
		}
		catch (MailBereitsRegistriertException | BenutzernameVergebenException | PasswortNichtSicherException e)
		{
			return navigator.zurRegistrierungSeiteFehlerhaft(Fehlermeldung.REGISTRIERUNG_FEHLGESCHLAGEN);
		}
	}
}
