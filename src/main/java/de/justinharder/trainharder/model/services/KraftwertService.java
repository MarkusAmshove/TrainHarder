package de.justinharder.trainharder.model.services;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import de.justinharder.trainharder.model.domain.Kraftwert;
import de.justinharder.trainharder.model.domain.Primaerschluessel;
import de.justinharder.trainharder.model.domain.dto.KraftwertEintrag;
import de.justinharder.trainharder.model.domain.enums.Wiederholungen;
import de.justinharder.trainharder.model.domain.exceptions.BenutzerNichtGefundenException;
import de.justinharder.trainharder.model.domain.exceptions.KraftwertNichtGefundenException;
import de.justinharder.trainharder.model.domain.exceptions.UebungNichtGefundenException;
import de.justinharder.trainharder.model.repository.BenutzerRepository;
import de.justinharder.trainharder.model.repository.KraftwertRepository;
import de.justinharder.trainharder.model.repository.UebungRepository;

public class KraftwertService implements Serializable
{
	private static final String DATUMSFORMAT = "dd.MM.yyyy";

	private static final long serialVersionUID = -5443953675613638545L;

	private final KraftwertRepository kraftwertRepository;
	private final BenutzerRepository benutzerRepository;
	private final UebungRepository uebungRepository;

	@Inject
	public KraftwertService(
		final KraftwertRepository kraftwertRepository,
		final BenutzerRepository benutzerRepository,
		final UebungRepository uebungRepository)
	{
		this.kraftwertRepository = kraftwertRepository;
		this.benutzerRepository = benutzerRepository;
		this.uebungRepository = uebungRepository;
	}

	public List<KraftwertEintrag> ermittleAlle()
	{
		return Konvertierer.konvertiereAlleZuKraftwertEintrag(kraftwertRepository.ermittleAlle());
	}

	public List<KraftwertEintrag> ermittleAlleZuBenutzer(final String benutzerId)
	{
		return Konvertierer.konvertiereAlleZuKraftwertEintrag(
			kraftwertRepository.ermittleAlleZuBenutzer(new Primaerschluessel(benutzerId)));
	}

	public KraftwertEintrag ermittleZuId(final String id) throws KraftwertNichtGefundenException
	{
		Preconditions.checkNotNull(id, "Ermittlung des Kraftwerts benötigt eine gültige KraftwertID!");

		return Konvertierer.konvertiereZuKraftwertEintrag(kraftwertRepository
			.ermittleZuId(new Primaerschluessel(id))
			.orElseThrow(() -> new KraftwertNichtGefundenException(
				"Der Kraftwert mit der ID \"" + id + "\" existiert nicht!")));
	}

	public KraftwertEintrag speichereKraftwert(
		final KraftwertEintrag kraftwertEintrag,
		final String uebungId,
		final String benutzerId) throws UebungNichtGefundenException, BenutzerNichtGefundenException
	{
		final var uebung = uebungRepository
			.ermittleZuId(new Primaerschluessel(uebungId))
			.orElseThrow(
				() -> new UebungNichtGefundenException("Die Uebung mit der ID \"" + uebungId + "\" existiert nicht!"));
		final var benutzer = benutzerRepository
			.ermittleZuId(new Primaerschluessel(benutzerId))
			.orElseThrow(() -> new BenutzerNichtGefundenException(
				"Der Benutzer mit der ID \"" + benutzerId + "\" existiert nicht!"));

		return Konvertierer.konvertiereZuKraftwertEintrag(kraftwertRepository.speichereKraftwert(new Kraftwert(
			new Primaerschluessel(),
			kraftwertEintrag.getMaximum(),
			kraftwertEintrag.getKoerpergewicht(),
			LocalDate.parse(kraftwertEintrag.getDatum(), DateTimeFormatter.ofPattern(DATUMSFORMAT)),
			Wiederholungen.fromName(kraftwertEintrag.getWiederholungen()),
			uebung,
			benutzer)));
	}
}
