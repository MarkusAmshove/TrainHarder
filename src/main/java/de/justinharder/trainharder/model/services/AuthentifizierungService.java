package de.justinharder.trainharder.model.services;

import com.google.common.base.Preconditions;
import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import de.justinharder.trainharder.model.domain.exceptions.AuthentifizierungNichtGefundenException;
import de.justinharder.trainharder.model.repository.AuthentifizierungRepository;
import de.justinharder.trainharder.model.services.mapper.AuthentifizierungDtoMapper;
import de.justinharder.trainharder.view.dto.AuthentifizierungDto;

import javax.inject.Inject;

public class AuthentifizierungService
{
	private final AuthentifizierungRepository authentifizierungRepository;
	private final AuthentifizierungDtoMapper authentifizierungDtoMapper;

	@Inject
	public AuthentifizierungService(
		final AuthentifizierungRepository authentifizierungRepository,
		final AuthentifizierungDtoMapper authentifizierungDtoMapper)
	{
		this.authentifizierungRepository = authentifizierungRepository;
		this.authentifizierungDtoMapper = authentifizierungDtoMapper;
	}

	public AuthentifizierungDto ermittleZuId(final String id) throws AuthentifizierungNichtGefundenException
	{
		Preconditions.checkNotNull(id, "Ermittlung der Authentifizierung benötigt eine gültige AuthentifizierungID!");

		return authentifizierungRepository.ermittleZuId(new Primaerschluessel(id))
			.map(authentifizierungDtoMapper::konvertiere)
			.orElseThrow(FehlermeldungService.wirfAuthentifizierungNichtGefundenException("der ID", id));
	}

	public AuthentifizierungDto ermittleZuBenutzer(final String benutzerId)
		throws AuthentifizierungNichtGefundenException
	{
		Preconditions.checkNotNull(benutzerId, "Ermittlung der Authentifizierung benötigt eine gültige BenutzerID!");

		return authentifizierungRepository.ermittleZuBenutzer(new Primaerschluessel(benutzerId))
			.map(authentifizierungDtoMapper::konvertiere)
			.orElseThrow(
				FehlermeldungService.wirfAuthentifizierungNichtGefundenException("der BenutzerID", benutzerId));
	}

	public AuthentifizierungDto ermittleZuBenutzername(final String benutzername)
		throws AuthentifizierungNichtGefundenException
	{
		Preconditions.checkNotNull(benutzername,
			"Ermittlung der Authentifizierung benötigt einen gültigen Benutzernamen!");

		return authentifizierungRepository.ermittleZuBenutzername(benutzername)
			.map(authentifizierungDtoMapper::konvertiere)
			.orElseThrow(FehlermeldungService
				.wirfAuthentifizierungNichtGefundenException("dem Benutzernamen", benutzername));
	}
}
