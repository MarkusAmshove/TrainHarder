package de.justinharder.trainharder.view.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.justinharder.trainharder.setup.Testdaten;

public class BenutzerDtoSollte
{
	private BenutzerDto sut;

	@BeforeEach
	public void setup()
	{
		sut = new BenutzerDto(
			Testdaten.BENUTZER_JUSTIN_ID.getId().toString(),
			"Justin",
			"Harder",
			LocalDate.of(1998, 12, 6),
			"CLASS_5",
			"MAENNLICH",
			"FORTGESCHRITTEN",
			"GUT",
			"GUT",
			"MITTELMAESSIG",
			"NEIN",
			"GUT",
			Testdaten.AUTHENTIFIZIERUNG_DTO_JUSTIN);
	}

	@Test
	@DisplayName("einen AllArgsConstructor und Getter besitzen")
	public void test01()
	{
		assertAll(
			() -> assertThat(sut.getPrimaerschluessel()).isEqualTo(Testdaten.BENUTZER_JUSTIN_ID.getId().toString()),
			() -> assertThat(sut.getVorname()).isEqualTo("Justin"),
			() -> assertThat(sut.getNachname()).isEqualTo("Harder"),
			() -> assertThat(sut.getGeburtsdatum()).isEqualTo(LocalDate.of(1998, 12, 6)),
			() -> assertThat(sut.getKraftlevel()).isEqualTo("CLASS_5"),
			() -> assertThat(sut.getGeschlecht()).isEqualTo("MAENNLICH"),
			() -> assertThat(sut.getErfahrung()).isEqualTo("FORTGESCHRITTEN"),
			() -> assertThat(sut.getErnaehrung()).isEqualTo("GUT"),
			() -> assertThat(sut.getSchlafqualitaet()).isEqualTo("GUT"),
			() -> assertThat(sut.getStress()).isEqualTo("MITTELMAESSIG"),
			() -> assertThat(sut.getDoping()).isEqualTo("NEIN"),
			() -> assertThat(sut.getRegenerationsfaehigkeit()).isEqualTo("GUT"),
			() -> assertThat(sut.getAuthentifizierung()).isEqualTo(Testdaten.AUTHENTIFIZIERUNG_DTO_JUSTIN));
	}

	@Test
	@DisplayName("einen NoArgsConstructor und Setter besitzen")
	public void test02()
	{
		sut = new BenutzerDto()
			.setVorname("Justin")
			.setNachname("Harder")
			.setGeburtsdatum(LocalDate.of(1998, 12, 6))
			.setKraftlevel("CLASS_5")
			.setGeschlecht("MAENNLICH")
			.setErfahrung("FORTGESCHRITTEN")
			.setErnaehrung("GUT")
			.setSchlafqualitaet("GUT")
			.setStress("MITTELMAESSIG")
			.setDoping("NEIN")
			.setRegenerationsfaehigkeit("GUT");

		assertAll(
			() -> assertThat(sut.getVorname()).isEqualTo("Justin"),
			() -> assertThat(sut.getNachname()).isEqualTo("Harder"),
			() -> assertThat(sut.getGeburtsdatum()).isEqualTo(LocalDate.of(1998, 12, 6)),
			() -> assertThat(sut.getKraftlevel()).isEqualTo("CLASS_5"),
			() -> assertThat(sut.getGeschlecht()).isEqualTo("MAENNLICH"),
			() -> assertThat(sut.getErfahrung()).isEqualTo("FORTGESCHRITTEN"),
			() -> assertThat(sut.getErnaehrung()).isEqualTo("GUT"),
			() -> assertThat(sut.getSchlafqualitaet()).isEqualTo("GUT"),
			() -> assertThat(sut.getStress()).isEqualTo("MITTELMAESSIG"),
			() -> assertThat(sut.getDoping()).isEqualTo("NEIN"),
			() -> assertThat(sut.getRegenerationsfaehigkeit()).isEqualTo("GUT"));
	}

	@Test
	@DisplayName("sich vergleichen")
	@SuppressWarnings("unlikely-arg-type")
	public void test05()
	{
		final var anderesBenutzerDto = new BenutzerDto(
			Testdaten.BENUTZER_JUSTIN_ID.getId().toString(),
			"Nicole",
			"Harder",
			LocalDate.of(1998, 12, 6),
			"CLASS_5",
			"WEIBLICH",
			"FORTGESCHRITTEN",
			"GUT",
			"GUT",
			"MITTELMAESSIG",
			"NEIN",
			"GUT",
			Testdaten.AUTHENTIFIZIERUNG_DTO_JUSTIN);

		assertAll(
			() -> assertThat(sut.equals(sut)).isEqualTo(true),
			() -> assertThat(sut.equals(null)).isEqualTo(false),
			() -> assertThat(sut.equals(Testdaten.AUTHENTIFIZIERUNG_JUSTIN)).isEqualTo(false),
			() -> assertThat(sut.equals(anderesBenutzerDto)).isEqualTo(false),
			() -> assertThat(sut.hashCode()).isNotEqualTo(anderesBenutzerDto.hashCode()));
	}

	@Test
	@DisplayName("eine toString()-Methode haben")
	public void test06()
	{
		final var erwartet = "BenutzerDto(primaerschluessel=" + Testdaten.BENUTZER_JUSTIN_ID.getId().toString()
			+ ", vorname=Justin, nachname=Harder, geburtsdatum=1998-12-06, kraftlevel=CLASS_5, geschlecht=MAENNLICH, erfahrung=FORTGESCHRITTEN, ernaehrung=GUT, schlafqualitaet=GUT, stress=MITTELMAESSIG, doping=NEIN, regenerationsfaehigkeit=GUT, authentifizierung=AuthentifizierungDto(primaerschluessel="
			+ Testdaten.AUTHENTIFIZIERUNG_JUSTIN_ID.getId().toString()
			+ ", mail=mail@justinharder.de, benutzername=harder, passwort=JustinHarder#98))";

		assertThat(sut.toString()).isEqualTo(erwartet);
	}
}