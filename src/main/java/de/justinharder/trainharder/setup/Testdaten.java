package de.justinharder.trainharder.setup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import de.justinharder.trainharder.model.domain.Authentifizierung;
import de.justinharder.trainharder.model.domain.Belastungsfaktor;
import de.justinharder.trainharder.model.domain.Benutzer;
import de.justinharder.trainharder.model.domain.Koerpermessung;
import de.justinharder.trainharder.model.domain.Kraftwert;
import de.justinharder.trainharder.model.domain.Uebung;
import de.justinharder.trainharder.model.domain.embeddables.Benutzerangabe;
import de.justinharder.trainharder.model.domain.embeddables.Koerpermasse;
import de.justinharder.trainharder.model.domain.embeddables.Name;
import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import de.justinharder.trainharder.model.domain.enums.Doping;
import de.justinharder.trainharder.model.domain.enums.Erfahrung;
import de.justinharder.trainharder.model.domain.enums.Ernaehrung;
import de.justinharder.trainharder.model.domain.enums.Geschlecht;
import de.justinharder.trainharder.model.domain.enums.Kraftlevel;
import de.justinharder.trainharder.model.domain.enums.Regenerationsfaehigkeit;
import de.justinharder.trainharder.model.domain.enums.Schlafqualitaet;
import de.justinharder.trainharder.model.domain.enums.Stress;
import de.justinharder.trainharder.model.domain.enums.Uebungsart;
import de.justinharder.trainharder.model.domain.enums.Uebungskategorie;
import de.justinharder.trainharder.model.domain.enums.Wiederholungen;
import de.justinharder.trainharder.view.dto.AuthentifizierungDto;
import de.justinharder.trainharder.view.dto.BelastungsfaktorDto;
import de.justinharder.trainharder.view.dto.BenutzerDto;
import de.justinharder.trainharder.view.dto.KoerpermessungDto;
import de.justinharder.trainharder.view.dto.KraftwertDto;
import de.justinharder.trainharder.view.dto.UebungDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Testdaten
{
	private static final String DATUMSFORMAT = "dd.MM.yyyy";

	public static final Primaerschluessel AUTHENTIFIZIERUNG_JUSTIN_ID = new Primaerschluessel();
	public static final Primaerschluessel AUTHENTIFIZIERUNG_EDUARD_ID = new Primaerschluessel();

	public static final Authentifizierung AUTHENTIFIZIERUNG_JUSTIN = new Authentifizierung();
	public static final Authentifizierung AUTHENTIFIZIERUNG_EDUARD = new Authentifizierung();

	public static final AuthentifizierungDto AUTHENTIFIZIERUNG_DTO_JUSTIN = new AuthentifizierungDto();
	public static final AuthentifizierungDto AUTHENTIFIZIERUNG_DTO_EDUARD = new AuthentifizierungDto();

	public static final Koerpermasse KOERPERMASSE_JUSTIN = new Koerpermasse();
	public static final Koerpermasse KOERPERMASSE_EDUARD = new Koerpermasse();

	public static final Primaerschluessel KOERPERMESSUNG_JUSTIN_ID = new Primaerschluessel();
	public static final Primaerschluessel KOERPERMESSUNG_EDUARD_ID = new Primaerschluessel();

	public static final Koerpermessung KOERPERMESSUNG_JUSTIN = new Koerpermessung();
	public static final Koerpermessung KOERPERMESSUNG_EDUARD = new Koerpermessung();

	public static final KoerpermessungDto KOERPERMESSUNG_DTO_JUSTIN = new KoerpermessungDto();
	public static final KoerpermessungDto KOERPERMESSUNG_DTO_EDUARD = new KoerpermessungDto();

	public static final Benutzerangabe BENUTZERANGABE_JUSTIN = new Benutzerangabe();
	public static final Benutzerangabe BENUTZERANGABE_EDUARD = new Benutzerangabe();

	public static final Primaerschluessel BENUTZER_JUSTIN_ID = new Primaerschluessel();
	public static final Primaerschluessel BENUTZER_EDUARD_ID = new Primaerschluessel();

	public static final Benutzer BENUTZER_JUSTIN = new Benutzer();
	public static final Benutzer BENUTZER_EDUARD = new Benutzer();

	public static final BenutzerDto BENUTZER_DTO_JUSTIN = new BenutzerDto();
	public static final BenutzerDto BENUTZER_DTO_EDUARD = new BenutzerDto();

	public static final Primaerschluessel BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN_ID = new Primaerschluessel();
	public static final Primaerschluessel BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE_ID = new Primaerschluessel();
	public static final Primaerschluessel BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN_ID = new Primaerschluessel();

	public static final Belastungsfaktor BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN = new Belastungsfaktor();
	public static final Belastungsfaktor BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE = new Belastungsfaktor();
	public static final Belastungsfaktor BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN = new Belastungsfaktor();

	public static final BelastungsfaktorDto BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN = new BelastungsfaktorDto();
	public static final BelastungsfaktorDto BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE = new BelastungsfaktorDto();
	public static final BelastungsfaktorDto BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN = new BelastungsfaktorDto();

	public static final Primaerschluessel UEBUNG_WETTKAMPFBANKDRUECKEN_ID = new Primaerschluessel();
	public static final Primaerschluessel UEBUNG_LOWBAR_KNIEBEUGE_ID = new Primaerschluessel();
	public static final Primaerschluessel UEBUNG_KONVENTIONELLES_KREUZHEBEN_ID = new Primaerschluessel();

	public static final Uebung UEBUNG_WETTKAMPFBANKDRUECKEN = new Uebung();
	public static final Uebung UEBUNG_LOWBAR_KNIEBEUGE = new Uebung();
	public static final Uebung UEBUNG_KONVENTIONELLES_KREUZHEBEN = new Uebung();

	public static final UebungDto UEBUNG_DTO_WETTKAMPFBANKDRUECKEN = new UebungDto();
	public static final UebungDto UEBUNG_DTO_LOWBAR_KNIEBEUGE = new UebungDto();
	public static final UebungDto UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN = new UebungDto();

	public static final Primaerschluessel KRAFTWERT_WETTKAMPFBANKDRUECKEN_ID = new Primaerschluessel();
	public static final Primaerschluessel KRAFTWERT_LOWBAR_KNIEBEUGE_ID = new Primaerschluessel();
	public static final Primaerschluessel KRAFTWERT_KONVENTIONELLES_KREUZHEBEN_ID = new Primaerschluessel();

	public static final Kraftwert KRAFTWERT_WETTKAMPFBANKDRUECKEN = new Kraftwert();
	public static final Kraftwert KRAFTWERT_LOWBAR_KNIEBEUGE = new Kraftwert();
	public static final Kraftwert KRAFTWERT_KONVENTIONELLES_KREUZHEBEN = new Kraftwert();

	public static final KraftwertDto KRAFTWERT_DTO_WETTKAMPFBANKDRUECKEN = new KraftwertDto();
	public static final KraftwertDto KRAFTWERT_DTO_LOWBAR_KNIEBEUGE = new KraftwertDto();
	public static final KraftwertDto KRAFTWERT_DTO_KONVENTIONELLES_KREUZHEBEN = new KraftwertDto();

	static
	{
		AUTHENTIFIZIERUNG_JUSTIN.setPrimaerschluessel(AUTHENTIFIZIERUNG_JUSTIN_ID);
		AUTHENTIFIZIERUNG_JUSTIN.setMail("mail@justinharder.de");
		AUTHENTIFIZIERUNG_JUSTIN.setBenutzername("harder");
		AUTHENTIFIZIERUNG_JUSTIN.setPasswort("JustinHarder#98");
		AUTHENTIFIZIERUNG_JUSTIN.setAktiv(false);
		AUTHENTIFIZIERUNG_JUSTIN.setResetUuid(UUID.randomUUID());
		AUTHENTIFIZIERUNG_JUSTIN.setBenutzer(BENUTZER_JUSTIN);

		AUTHENTIFIZIERUNG_EDUARD.setPrimaerschluessel(AUTHENTIFIZIERUNG_EDUARD_ID);
		AUTHENTIFIZIERUNG_EDUARD.setMail("mail@eduard.de");
		AUTHENTIFIZIERUNG_EDUARD.setBenutzername("eduard");
		AUTHENTIFIZIERUNG_EDUARD.setPasswort("EduardEduardEduard_98");
		AUTHENTIFIZIERUNG_EDUARD.setAktiv(true);
		AUTHENTIFIZIERUNG_EDUARD.setBenutzer(BENUTZER_EDUARD);

		AUTHENTIFIZIERUNG_DTO_JUSTIN
			.setPrimaerschluessel(AUTHENTIFIZIERUNG_JUSTIN.getPrimaerschluessel().getId().toString());
		AUTHENTIFIZIERUNG_DTO_JUSTIN.setMail(AUTHENTIFIZIERUNG_JUSTIN.getMail());
		AUTHENTIFIZIERUNG_DTO_JUSTIN.setBenutzername(AUTHENTIFIZIERUNG_JUSTIN.getBenutzername());
		AUTHENTIFIZIERUNG_DTO_JUSTIN.setPasswort(AUTHENTIFIZIERUNG_JUSTIN.getPasswort());

		AUTHENTIFIZIERUNG_DTO_EDUARD
			.setPrimaerschluessel(AUTHENTIFIZIERUNG_EDUARD.getPrimaerschluessel().getId().toString());
		AUTHENTIFIZIERUNG_DTO_EDUARD.setMail(AUTHENTIFIZIERUNG_EDUARD.getMail());
		AUTHENTIFIZIERUNG_DTO_EDUARD.setBenutzername(AUTHENTIFIZIERUNG_EDUARD.getBenutzername());
		AUTHENTIFIZIERUNG_DTO_EDUARD.setPasswort(AUTHENTIFIZIERUNG_EDUARD.getPasswort());

		KOERPERMASSE_JUSTIN.setKoerpergroesse(178);
		KOERPERMASSE_JUSTIN.setKoerpergewicht(90);
		KOERPERMASSE_JUSTIN.setKoerperfettAnteil(25);

		KOERPERMESSUNG_JUSTIN.setPrimaerschluessel(KOERPERMESSUNG_JUSTIN_ID);
		KOERPERMESSUNG_JUSTIN.setDatum(LocalDate.of(2020, 7, 29));
		KOERPERMESSUNG_JUSTIN.setKoerpermasse(KOERPERMASSE_JUSTIN);
		KOERPERMESSUNG_JUSTIN.setKalorieneinnahme(2500);
		KOERPERMESSUNG_JUSTIN.setKalorienverbrauch(2900);
		KOERPERMESSUNG_JUSTIN.setBenutzer(BENUTZER_JUSTIN);

		KOERPERMESSUNG_DTO_JUSTIN.setPrimaerschluessel(KOERPERMESSUNG_JUSTIN.getPrimaerschluessel().getId().toString());
		KOERPERMESSUNG_DTO_JUSTIN
			.setDatum(KOERPERMESSUNG_JUSTIN.getDatum().format(DateTimeFormatter.ofPattern(DATUMSFORMAT)));
		KOERPERMESSUNG_DTO_JUSTIN.setKoerpergroesse(KOERPERMESSUNG_JUSTIN.getKoerpermasse().getKoerpergroesse());
		KOERPERMESSUNG_DTO_JUSTIN.setKoerpergewicht(KOERPERMESSUNG_JUSTIN.getKoerpermasse().getKoerpergewicht());
		KOERPERMESSUNG_DTO_JUSTIN.setKoerperfettAnteil(KOERPERMESSUNG_JUSTIN.getKoerpermasse().getKoerperfettAnteil());
		KOERPERMESSUNG_DTO_JUSTIN.setKalorieneinnahme(KOERPERMESSUNG_JUSTIN.getKalorieneinnahme());
		KOERPERMESSUNG_DTO_JUSTIN.setKalorienverbrauch(KOERPERMESSUNG_JUSTIN.getKalorienverbrauch());

		KOERPERMASSE_EDUARD.setKoerpergroesse(182);
		KOERPERMASSE_EDUARD.setKoerpergewicht(64);
		KOERPERMASSE_EDUARD.setKoerperfettAnteil(9);

		KOERPERMESSUNG_EDUARD.setPrimaerschluessel(KOERPERMESSUNG_EDUARD_ID);
		KOERPERMESSUNG_EDUARD.setDatum(LocalDate.of(2020, 7, 29));
		KOERPERMESSUNG_EDUARD.setKoerpermasse(KOERPERMASSE_EDUARD);
		KOERPERMESSUNG_EDUARD.setKalorieneinnahme(2500);
		KOERPERMESSUNG_EDUARD.setKalorienverbrauch(2900);
		KOERPERMESSUNG_EDUARD.setBenutzer(BENUTZER_EDUARD);

		KOERPERMESSUNG_DTO_EDUARD.setPrimaerschluessel(KOERPERMESSUNG_EDUARD.getPrimaerschluessel().getId().toString());
		KOERPERMESSUNG_DTO_EDUARD
			.setDatum(KOERPERMESSUNG_EDUARD.getDatum().format(DateTimeFormatter.ofPattern(DATUMSFORMAT)));
		KOERPERMESSUNG_DTO_EDUARD.setKoerpergroesse(KOERPERMESSUNG_EDUARD.getKoerpermasse().getKoerpergroesse());
		KOERPERMESSUNG_DTO_EDUARD.setKoerpergewicht(KOERPERMESSUNG_EDUARD.getKoerpermasse().getKoerpergewicht());
		KOERPERMESSUNG_DTO_EDUARD.setKoerperfettAnteil(KOERPERMESSUNG_EDUARD.getKoerpermasse().getKoerperfettAnteil());
		KOERPERMESSUNG_DTO_EDUARD.setKalorieneinnahme(KOERPERMESSUNG_EDUARD.getKalorieneinnahme());
		KOERPERMESSUNG_DTO_EDUARD.setKalorienverbrauch(KOERPERMESSUNG_EDUARD.getKalorienverbrauch());

		BENUTZERANGABE_JUSTIN.setKraftlevel(Kraftlevel.CLASS_5);
		BENUTZERANGABE_JUSTIN.setGeschlecht(Geschlecht.MAENNLICH);
		BENUTZERANGABE_JUSTIN.setErfahrung(Erfahrung.BEGINNER);
		BENUTZERANGABE_JUSTIN.setErnaehrung(Ernaehrung.GUT);
		BENUTZERANGABE_JUSTIN.setSchlafqualitaet(Schlafqualitaet.GUT);
		BENUTZERANGABE_JUSTIN.setStress(Stress.MITTELMAESSIG);
		BENUTZERANGABE_JUSTIN.setDoping(Doping.NEIN);
		BENUTZERANGABE_JUSTIN.setRegenerationsfaehigkeit(Regenerationsfaehigkeit.GUT);

		BENUTZER_JUSTIN.setPrimaerschluessel(BENUTZER_JUSTIN_ID);
		BENUTZER_JUSTIN.setName(new Name("Justin", "Harder"));
		BENUTZER_JUSTIN.setGeburtsdatum(LocalDate.of(1998, 12, 6));
		BENUTZER_JUSTIN.setBenutzerangabe(BENUTZERANGABE_JUSTIN);
		BENUTZER_JUSTIN.setAuthentifizierung(AUTHENTIFIZIERUNG_JUSTIN);
		BENUTZER_JUSTIN.fuegeKoerpermessungHinzu(KOERPERMESSUNG_JUSTIN);

		BENUTZER_DTO_JUSTIN.setPrimaerschluessel(BENUTZER_JUSTIN.getPrimaerschluessel().getId().toString());
		BENUTZER_DTO_JUSTIN.setVorname(BENUTZER_JUSTIN.getName().getVorname());
		BENUTZER_DTO_JUSTIN.setNachname(BENUTZER_JUSTIN.getName().getNachname());
		BENUTZER_DTO_JUSTIN.setGeburtsdatum(BENUTZER_JUSTIN.getGeburtsdatum());
		BENUTZER_DTO_JUSTIN.setKraftlevel(BENUTZER_JUSTIN.getBenutzerangabe().getKraftlevel().name());
		BENUTZER_DTO_JUSTIN.setGeschlecht(BENUTZER_JUSTIN.getBenutzerangabe().getGeschlecht().name());
		BENUTZER_DTO_JUSTIN.setErfahrung(BENUTZER_JUSTIN.getBenutzerangabe().getErfahrung().name());
		BENUTZER_DTO_JUSTIN.setErnaehrung(BENUTZER_JUSTIN.getBenutzerangabe().getErnaehrung().name());
		BENUTZER_DTO_JUSTIN.setSchlafqualitaet(BENUTZER_JUSTIN.getBenutzerangabe().getSchlafqualitaet().name());
		BENUTZER_DTO_JUSTIN.setStress(BENUTZER_JUSTIN.getBenutzerangabe().getStress().name());
		BENUTZER_DTO_JUSTIN.setDoping(BENUTZER_JUSTIN.getBenutzerangabe().getDoping().name());
		BENUTZER_DTO_JUSTIN
			.setRegenerationsfaehigkeit(BENUTZER_JUSTIN.getBenutzerangabe().getRegenerationsfaehigkeit().name());
		BENUTZER_DTO_JUSTIN.setAuthentifizierung(AUTHENTIFIZIERUNG_DTO_JUSTIN);
		BENUTZER_DTO_JUSTIN.fuegeKoerpermessungHinzu(KOERPERMESSUNG_DTO_JUSTIN);

		BENUTZERANGABE_EDUARD.setKraftlevel(Kraftlevel.CLASS_4);
		BENUTZERANGABE_EDUARD.setGeschlecht(Geschlecht.MAENNLICH);
		BENUTZERANGABE_EDUARD.setErfahrung(Erfahrung.FORTGESCHRITTEN);
		BENUTZERANGABE_EDUARD.setErnaehrung(Ernaehrung.SCHLECHT);
		BENUTZERANGABE_EDUARD.setSchlafqualitaet(Schlafqualitaet.SCHLECHT);
		BENUTZERANGABE_EDUARD.setStress(Stress.NIEDRIG);
		BENUTZERANGABE_EDUARD.setDoping(Doping.JA);
		BENUTZERANGABE_EDUARD.setRegenerationsfaehigkeit(Regenerationsfaehigkeit.PERFEKT);

		BENUTZER_EDUARD.setPrimaerschluessel(BENUTZER_EDUARD_ID);
		BENUTZER_EDUARD.setName(new Name("Eduard", "Stremel"));
		BENUTZER_EDUARD.setGeburtsdatum(LocalDate.of(1998, 11, 9));
		BENUTZER_EDUARD.setBenutzerangabe(BENUTZERANGABE_EDUARD);
		BENUTZER_EDUARD.setAuthentifizierung(AUTHENTIFIZIERUNG_EDUARD);
		BENUTZER_EDUARD.fuegeKoerpermessungHinzu(KOERPERMESSUNG_EDUARD);

		BENUTZER_DTO_EDUARD.setPrimaerschluessel(BENUTZER_EDUARD.getPrimaerschluessel().getId().toString());
		BENUTZER_DTO_EDUARD.setVorname(BENUTZER_EDUARD.getName().getVorname());
		BENUTZER_DTO_EDUARD.setNachname(BENUTZER_EDUARD.getName().getNachname());
		BENUTZER_DTO_EDUARD.setGeburtsdatum(BENUTZER_EDUARD.getGeburtsdatum());
		BENUTZER_DTO_EDUARD.setKraftlevel(BENUTZER_EDUARD.getBenutzerangabe().getKraftlevel().name());
		BENUTZER_DTO_EDUARD.setGeschlecht(BENUTZER_EDUARD.getBenutzerangabe().getGeschlecht().name());
		BENUTZER_DTO_EDUARD.setErfahrung(BENUTZER_EDUARD.getBenutzerangabe().getErfahrung().name());
		BENUTZER_DTO_EDUARD.setErnaehrung(BENUTZER_EDUARD.getBenutzerangabe().getErnaehrung().name());
		BENUTZER_DTO_EDUARD.setSchlafqualitaet(BENUTZER_EDUARD.getBenutzerangabe().getSchlafqualitaet().name());
		BENUTZER_DTO_EDUARD.setStress(BENUTZER_EDUARD.getBenutzerangabe().getStress().name());
		BENUTZER_DTO_EDUARD.setDoping(BENUTZER_EDUARD.getBenutzerangabe().getDoping().name());
		BENUTZER_DTO_EDUARD
			.setRegenerationsfaehigkeit(BENUTZER_EDUARD.getBenutzerangabe().getRegenerationsfaehigkeit().name());
		BENUTZER_DTO_EDUARD.setAuthentifizierung(AUTHENTIFIZIERUNG_DTO_EDUARD);
		BENUTZER_DTO_EDUARD.fuegeKoerpermessungHinzu(KOERPERMESSUNG_DTO_EDUARD);

		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setPrimaerschluessel(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN_ID);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setBack(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setBenchpress(1.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setBiceps(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setChest(1.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setCore(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setDeadlift(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setGlutes(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setHamstrings(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setQuads(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setShoulder(0.1);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setSquat(0.0);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setTriceps(0.7);
		BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.setUebung(UEBUNG_WETTKAMPFBANKDRUECKEN);

		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN
			.setPrimaerschluessel(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getPrimaerschluessel().getId().toString());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setBack(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getBack());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN
			.setBenchpress(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getBenchpress());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setBiceps(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getBiceps());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setChest(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getChest());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setCore(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getCore());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setDeadlift(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getDeadlift());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setGlutes(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getGlutes());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN
			.setHamstrings(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getHamstrings());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setQuads(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getQuads());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setShoulder(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getShoulder());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setSquat(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getSquat());
		BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN.setTriceps(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN.getTriceps());

		UEBUNG_WETTKAMPFBANKDRUECKEN.setPrimaerschluessel(UEBUNG_WETTKAMPFBANKDRUECKEN_ID);
		UEBUNG_WETTKAMPFBANKDRUECKEN.setName("Wettkampfbankdrücken (pausiert)");
		UEBUNG_WETTKAMPFBANKDRUECKEN.setUebungsart(Uebungsart.GRUNDUEBUNG);
		UEBUNG_WETTKAMPFBANKDRUECKEN.setUebungskategorie(Uebungskategorie.WETTKAMPF_BANKDRUECKEN);
		UEBUNG_WETTKAMPFBANKDRUECKEN.setBelastungsfaktor(BELASTUNGSFAKTOR_WETTKAMPFBANKDRUECKEN);

		UEBUNG_DTO_WETTKAMPFBANKDRUECKEN
			.setPrimaerschluessel(UEBUNG_WETTKAMPFBANKDRUECKEN.getPrimaerschluessel().getId().toString());
		UEBUNG_DTO_WETTKAMPFBANKDRUECKEN.setName(UEBUNG_WETTKAMPFBANKDRUECKEN.getName());
		UEBUNG_DTO_WETTKAMPFBANKDRUECKEN.setUebungsart(UEBUNG_WETTKAMPFBANKDRUECKEN.getUebungsart().name());
		UEBUNG_DTO_WETTKAMPFBANKDRUECKEN.setUebungskategorie(UEBUNG_WETTKAMPFBANKDRUECKEN.getUebungskategorie().name());
		UEBUNG_DTO_WETTKAMPFBANKDRUECKEN.setBelastungsfaktor(BELASTUNGSFAKTOR_DTO_WETTKAMPFBANKDRUECKEN);

		KRAFTWERT_WETTKAMPFBANKDRUECKEN.setPrimaerschluessel(KRAFTWERT_WETTKAMPFBANKDRUECKEN_ID);
		KRAFTWERT_WETTKAMPFBANKDRUECKEN.setUebung(UEBUNG_WETTKAMPFBANKDRUECKEN);
		KRAFTWERT_WETTKAMPFBANKDRUECKEN.setMaximum(100);
		KRAFTWERT_WETTKAMPFBANKDRUECKEN.setKoerpergewicht(BENUTZER_JUSTIN.getKoerpergewicht());
		KRAFTWERT_WETTKAMPFBANKDRUECKEN.setDatum(LocalDate.now());
		KRAFTWERT_WETTKAMPFBANKDRUECKEN.setWiederholungen(Wiederholungen.ONE_REP_MAX);
		KRAFTWERT_WETTKAMPFBANKDRUECKEN.setBenutzer(BENUTZER_JUSTIN);

		KRAFTWERT_DTO_WETTKAMPFBANKDRUECKEN
			.setPrimaerschluessel(KRAFTWERT_WETTKAMPFBANKDRUECKEN.getPrimaerschluessel().getId().toString());
		KRAFTWERT_DTO_WETTKAMPFBANKDRUECKEN.setMaximum(KRAFTWERT_WETTKAMPFBANKDRUECKEN.getMaximum());
		KRAFTWERT_DTO_WETTKAMPFBANKDRUECKEN.setKoerpergewicht(KRAFTWERT_WETTKAMPFBANKDRUECKEN.getKoerpergewicht());
		KRAFTWERT_DTO_WETTKAMPFBANKDRUECKEN
			.setDatum(KRAFTWERT_WETTKAMPFBANKDRUECKEN.getDatum().format(DateTimeFormatter.ofPattern(DATUMSFORMAT)));
		KRAFTWERT_DTO_WETTKAMPFBANKDRUECKEN
			.setWiederholungen(KRAFTWERT_WETTKAMPFBANKDRUECKEN.getWiederholungen().name());

		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setPrimaerschluessel(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE_ID);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setBack(0.2);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setBenchpress(0.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setBiceps(0.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setChest(0.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setCore(0.3);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setDeadlift(0.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setGlutes(1.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setHamstrings(0.5);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setQuads(1.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setShoulder(0.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setSquat(1.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setTriceps(0.0);
		BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.setUebung(UEBUNG_LOWBAR_KNIEBEUGE);

		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE
			.setPrimaerschluessel(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getPrimaerschluessel().getId().toString());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setBack(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getBack());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setBenchpress(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getBenchpress());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setBiceps(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getBiceps());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setChest(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getChest());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setCore(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getCore());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setDeadlift(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getDeadlift());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setGlutes(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getGlutes());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setHamstrings(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getHamstrings());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setQuads(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getQuads());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setShoulder(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getShoulder());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setSquat(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getSquat());
		BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE.setTriceps(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE.getTriceps());

		UEBUNG_LOWBAR_KNIEBEUGE.setPrimaerschluessel(UEBUNG_LOWBAR_KNIEBEUGE_ID);
		UEBUNG_LOWBAR_KNIEBEUGE.setName("Lowbar-Kniebeuge");
		UEBUNG_LOWBAR_KNIEBEUGE.setUebungsart(Uebungsart.GRUNDUEBUNG);
		UEBUNG_LOWBAR_KNIEBEUGE.setUebungskategorie(Uebungskategorie.WETTKAMPF_KNIEBEUGE);
		UEBUNG_LOWBAR_KNIEBEUGE.setBelastungsfaktor(BELASTUNGSFAKTOR_LOWBAR_KNIEBEUGE);

		UEBUNG_DTO_LOWBAR_KNIEBEUGE
			.setPrimaerschluessel(UEBUNG_LOWBAR_KNIEBEUGE.getPrimaerschluessel().getId().toString());
		UEBUNG_DTO_LOWBAR_KNIEBEUGE.setName(UEBUNG_LOWBAR_KNIEBEUGE.getName());
		UEBUNG_DTO_LOWBAR_KNIEBEUGE.setUebungsart(UEBUNG_LOWBAR_KNIEBEUGE.getUebungsart().name());
		UEBUNG_DTO_LOWBAR_KNIEBEUGE.setUebungskategorie(UEBUNG_LOWBAR_KNIEBEUGE.getUebungskategorie().name());
		UEBUNG_DTO_LOWBAR_KNIEBEUGE.setBelastungsfaktor(BELASTUNGSFAKTOR_DTO_LOWBAR_KNIEBEUGE);

		KRAFTWERT_LOWBAR_KNIEBEUGE.setPrimaerschluessel(KRAFTWERT_LOWBAR_KNIEBEUGE_ID);
		KRAFTWERT_LOWBAR_KNIEBEUGE.setUebung(UEBUNG_LOWBAR_KNIEBEUGE);
		KRAFTWERT_LOWBAR_KNIEBEUGE.setMaximum(150);
		KRAFTWERT_LOWBAR_KNIEBEUGE.setKoerpergewicht(BENUTZER_JUSTIN.getKoerpergewicht());
		KRAFTWERT_LOWBAR_KNIEBEUGE.setDatum(LocalDate.now());
		KRAFTWERT_LOWBAR_KNIEBEUGE.setWiederholungen(Wiederholungen.ONE_REP_MAX);
		KRAFTWERT_LOWBAR_KNIEBEUGE.setBenutzer(BENUTZER_JUSTIN);

		KRAFTWERT_DTO_LOWBAR_KNIEBEUGE
			.setPrimaerschluessel(KRAFTWERT_LOWBAR_KNIEBEUGE.getPrimaerschluessel().getId().toString());
		KRAFTWERT_DTO_LOWBAR_KNIEBEUGE.setMaximum(KRAFTWERT_LOWBAR_KNIEBEUGE.getMaximum());
		KRAFTWERT_DTO_LOWBAR_KNIEBEUGE.setKoerpergewicht(KRAFTWERT_LOWBAR_KNIEBEUGE.getKoerpergewicht());
		KRAFTWERT_DTO_LOWBAR_KNIEBEUGE
			.setDatum(KRAFTWERT_LOWBAR_KNIEBEUGE.getDatum().format(DateTimeFormatter.ofPattern(DATUMSFORMAT)));
		KRAFTWERT_DTO_LOWBAR_KNIEBEUGE.setWiederholungen(KRAFTWERT_LOWBAR_KNIEBEUGE.getWiederholungen().name());

		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN
			.setPrimaerschluessel(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN_ID);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setBack(0.5);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setBenchpress(0.0);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setBiceps(0.0);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setChest(0.0);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setCore(0.3);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setDeadlift(1.0);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setGlutes(0.5);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setHamstrings(0.5);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setQuads(0.3);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setShoulder(0.0);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setSquat(0.0);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setTriceps(0.0);
		BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.setUebung(UEBUNG_KONVENTIONELLES_KREUZHEBEN);

		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setPrimaerschluessel(
				BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getPrimaerschluessel().getId().toString());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setBack(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getBack());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setBenchpress(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getBenchpress());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setBiceps(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getBiceps());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setChest(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getChest());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setCore(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getCore());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setDeadlift(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getDeadlift());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setGlutes(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getGlutes());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setHamstrings(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getHamstrings());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setQuads(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getQuads());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setShoulder(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getShoulder());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setSquat(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getSquat());
		BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN
			.setTriceps(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN.getTriceps());

		UEBUNG_KONVENTIONELLES_KREUZHEBEN.setPrimaerschluessel(UEBUNG_KONVENTIONELLES_KREUZHEBEN_ID);
		UEBUNG_KONVENTIONELLES_KREUZHEBEN.setName("Konventionelles Kreuzheben");
		UEBUNG_KONVENTIONELLES_KREUZHEBEN.setUebungsart(Uebungsart.GRUNDUEBUNG);
		UEBUNG_KONVENTIONELLES_KREUZHEBEN.setUebungskategorie(Uebungskategorie.WETTKAMPF_KREUZHEBEN);
		UEBUNG_KONVENTIONELLES_KREUZHEBEN.setBelastungsfaktor(BELASTUNGSFAKTOR_KONVENTIONELLES_KREUZHEBEN);

		UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN
			.setPrimaerschluessel(UEBUNG_KONVENTIONELLES_KREUZHEBEN.getPrimaerschluessel().getId().toString());
		UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN.setName(UEBUNG_KONVENTIONELLES_KREUZHEBEN.getName());
		UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN.setUebungsart(UEBUNG_KONVENTIONELLES_KREUZHEBEN.getUebungsart().name());
		UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN
			.setUebungskategorie(UEBUNG_KONVENTIONELLES_KREUZHEBEN.getUebungskategorie().name());
		UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN
			.setBelastungsfaktor(BELASTUNGSFAKTOR_DTO_KONVENTIONELLES_KREUZHEBEN);

		KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.setPrimaerschluessel(KRAFTWERT_KONVENTIONELLES_KREUZHEBEN_ID);
		KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.setUebung(UEBUNG_KONVENTIONELLES_KREUZHEBEN);
		KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.setMaximum(200);
		KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.setKoerpergewicht(BENUTZER_JUSTIN.getKoerpergewicht());
		KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.setDatum(LocalDate.now());
		KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.setWiederholungen(Wiederholungen.ONE_REP_MAX);
		KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.setBenutzer(BENUTZER_JUSTIN);

		KRAFTWERT_DTO_KONVENTIONELLES_KREUZHEBEN
			.setPrimaerschluessel(KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.getPrimaerschluessel().getId().toString());
		KRAFTWERT_DTO_KONVENTIONELLES_KREUZHEBEN.setMaximum(KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.getMaximum());
		KRAFTWERT_DTO_KONVENTIONELLES_KREUZHEBEN
			.setKoerpergewicht(KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.getKoerpergewicht());
		KRAFTWERT_DTO_KONVENTIONELLES_KREUZHEBEN.setDatum(
			KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.getDatum().format(DateTimeFormatter.ofPattern(DATUMSFORMAT)));
		KRAFTWERT_DTO_KONVENTIONELLES_KREUZHEBEN
			.setWiederholungen(KRAFTWERT_KONVENTIONELLES_KREUZHEBEN.getWiederholungen().name());
	}
}
