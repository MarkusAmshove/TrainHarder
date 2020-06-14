package de.justinharder.trainharder.model.services;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import de.justinharder.trainharder.model.domain.Authentifizierung;
import de.justinharder.trainharder.model.domain.Belastungsfaktor;
import de.justinharder.trainharder.model.domain.Benutzer;
import de.justinharder.trainharder.model.domain.Kraftwert;
import de.justinharder.trainharder.model.domain.Primaerschluessel;
import de.justinharder.trainharder.model.domain.Uebung;
import de.justinharder.trainharder.view.dto.AuthentifizierungDto;
import de.justinharder.trainharder.view.dto.BelastungsfaktorDto;
import de.justinharder.trainharder.view.dto.BenutzerDto;
import de.justinharder.trainharder.view.dto.KraftwertDto;
import de.justinharder.trainharder.view.dto.UebungDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Konvertierer
{
	private static final String DATUMSFORMAT = "dd.MM.yyyy";

	public static List<AuthentifizierungDto> konvertiereAlleZuAuthentifizierungEintrag(
		final List<Authentifizierung> authentifizierungen)
	{
		return authentifizierungen
			.stream()
			.map(Konvertierer::konvertiereZuAuthentifizierungEintrag)
			.collect(Collectors.toList());
	}

	public static AuthentifizierungDto konvertiereZuAuthentifizierungEintrag(
		final Authentifizierung authentifizierung)
	{
		return new AuthentifizierungDto(
			authentifizierung.getPrimaerschluessel().getId().toString(),
			authentifizierung.getMail(),
			authentifizierung.getBenutzername(),
			authentifizierung.getPasswort());
	}

	public static List<BenutzerDto> konvertiereAlleZuBenutzerEintrag(final List<Benutzer> alleBenutzer)
	{
		return alleBenutzer.stream()
			.map(Konvertierer::konvertiereZuBenutzerEintrag)
			.collect(Collectors.toList());
	}

	public static BenutzerDto konvertiereZuBenutzerEintrag(final Benutzer benutzer)
	{
		return new BenutzerDto(
			benutzer.getPrimaerschluessel().getId().toString(),
			benutzer.getVorname(),
			benutzer.getNachname(),
			benutzer.getLebensalter(),
			benutzer.getKraftlevel().name(),
			benutzer.getGeschlecht().name(),
			benutzer.getErfahrung().name(),
			benutzer.getErnaehrung().name(),
			benutzer.getSchlafqualitaet().name(),
			benutzer.getStress().name(),
			benutzer.getDoping().name(),
			benutzer.getRegenerationsfaehigkeit().name(),
			konvertiereZuAuthentifizierungEintrag(benutzer.getAuthentifizierung()));
	}

	public static List<UebungDto> konvertiereAlleZuUebungEintrag(final List<Uebung> uebungen)
	{
		return uebungen
			.stream()
			.map(Konvertierer::konvertiereZuUebungEintrag)
			.collect(Collectors.toList());
	}

	public static UebungDto konvertiereZuUebungEintrag(final Uebung uebung)
	{
		return new UebungDto(
			uebung.getPrimaerschluessel().getId().toString(),
			uebung.getName(),
			uebung.getUebungsart().name(),
			uebung.getUebungskategorie().name(),
			konvertiereZuBelastungsfaktorEintrag(uebung.getBelastungsfaktor()));
	}

	public static List<BelastungsfaktorDto> konvertiereAlleZuBelastungsfaktorEintrag(
		final List<Belastungsfaktor> belastungsfaktoren)
	{
		return belastungsfaktoren
			.stream()
			.map(Konvertierer::konvertiereZuBelastungsfaktorEintrag)
			.collect(Collectors.toList());
	}

	public static BelastungsfaktorDto konvertiereZuBelastungsfaktorEintrag(final Belastungsfaktor belastungsfaktor)
	{
		return new BelastungsfaktorDto(
			belastungsfaktor.getPrimaerschluessel().getId().toString(),
			belastungsfaktor.getSquat(),
			belastungsfaktor.getBenchpress(),
			belastungsfaktor.getDeadlift(),
			belastungsfaktor.getTriceps(),
			belastungsfaktor.getChest(),
			belastungsfaktor.getCore(),
			belastungsfaktor.getBack(),
			belastungsfaktor.getBiceps(),
			belastungsfaktor.getGlutes(),
			belastungsfaktor.getQuads(),
			belastungsfaktor.getHamstrings(),
			belastungsfaktor.getShoulder());
	}

	public static List<KraftwertDto> konvertiereAlleZuKraftwertEintrag(final List<Kraftwert> kraftwerte)
	{
		return kraftwerte
			.stream()
			.map(Konvertierer::konvertiereZuKraftwertEintrag)
			.collect(Collectors.toList());
	}

	public static KraftwertDto konvertiereZuKraftwertEintrag(final Kraftwert kraftwert)
	{
		return new KraftwertDto(
			kraftwert.getPrimaerschluessel().getId().toString(),
			kraftwert.getMaximum(),
			kraftwert.getKoerpergewicht(),
			kraftwert.getDatum().format(DateTimeFormatter.ofPattern(DATUMSFORMAT)),
			kraftwert.getWiederholungen().name());
	}

	public static Belastungsfaktor konvertiereZuBelastungsfaktor(final BelastungsfaktorDto belastungsfaktorEintrag)
	{
		return new Belastungsfaktor(
			new Primaerschluessel(belastungsfaktorEintrag.getId()),
			belastungsfaktorEintrag.getSquat(),
			belastungsfaktorEintrag.getBenchpress(),
			belastungsfaktorEintrag.getDeadlift(),
			belastungsfaktorEintrag.getTriceps(),
			belastungsfaktorEintrag.getChest(),
			belastungsfaktorEintrag.getCore(),
			belastungsfaktorEintrag.getBack(),
			belastungsfaktorEintrag.getBiceps(),
			belastungsfaktorEintrag.getGlutes(),
			belastungsfaktorEintrag.getQuads(),
			belastungsfaktorEintrag.getHamstrings(),
			belastungsfaktorEintrag.getShoulder());
	}
}
