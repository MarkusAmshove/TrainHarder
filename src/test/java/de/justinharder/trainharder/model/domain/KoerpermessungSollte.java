package de.justinharder.trainharder.model.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import de.justinharder.trainharder.setup.Testdaten;

public class KoerpermessungSollte
{
	private Koerpermessung sut;

	@BeforeEach
	public void setup()
	{
		sut = Testdaten.KOERPERMESSUNG_JUSTIN;
	}

	@Test
	@DisplayName("einen NoArgsConstructor haben")
	public void test01()
	{
		org.hamcrest.MatcherAssert.assertThat(Koerpermessung.class, allOf(hasValidBeanConstructor()));
	}

	@Test
	@DisplayName("einen RequiredArgsConstructor haben")
	public void test02()
	{
		final var id = new Primaerschluessel();
		final var koerpermessung = new Koerpermessung(
			id,
			LocalDate.now(),
			178,
			90,
			25,
			2500,
			2900,
			Testdaten.BENUTZER_JUSTIN);

		assertAll(
			() -> assertThat(koerpermessung.getPrimaerschluessel()).isEqualTo(id),
			() -> assertThat(koerpermessung.getDatum()).isEqualTo(LocalDate.now()),
			() -> assertThat(koerpermessung.getKoerpergroesse()).isEqualTo(178),
			() -> assertThat(koerpermessung.getKoerpergewicht()).isEqualTo(90),
			() -> assertThat(koerpermessung.getKoerperfettAnteil()).isEqualTo(25),
			() -> assertThat(koerpermessung.getEingenommeneKalorien()).isEqualTo(2500),
			() -> assertThat(koerpermessung.getVerbrannteKalorien()).isEqualTo(2900),
			() -> assertThat(koerpermessung.getFettfreiesKoerpergewicht()).isEqualTo(67.5),
			() -> assertThat(koerpermessung.getBodyMassIndex()).isEqualTo(28.41),
			() -> assertThat(koerpermessung.getFatFreeMassIndex()).isEqualTo(21.43),
			() -> assertThat(koerpermessung.getBenutzer()).isEqualTo(Testdaten.BENUTZER_JUSTIN));
	}

	@Test
	@DisplayName("Getter besitzen")
	public void test03()
	{
		assertAll(
			() -> assertThat(sut.getPrimaerschluessel()).isEqualTo(Testdaten.KOERPERMESSUNG_JUSTIN_ID),
			() -> assertThat(sut.getDatum()).isEqualTo(LocalDate.now()),
			() -> assertThat(sut.getKoerpergroesse()).isEqualTo(178),
			() -> assertThat(sut.getKoerpergewicht()).isEqualTo(90),
			() -> assertThat(sut.getKoerperfettAnteil()).isEqualTo(25),
			() -> assertThat(sut.getEingenommeneKalorien()).isEqualTo(2500),
			() -> assertThat(sut.getVerbrannteKalorien()).isEqualTo(2900),
			() -> assertThat(sut.getFettfreiesKoerpergewicht()).isEqualTo(67.5),
			() -> assertThat(sut.getBodyMassIndex()).isEqualTo(28.41),
			() -> assertThat(sut.getFatFreeMassIndex()).isEqualTo(21.43),
			() -> assertThat(sut.getBenutzer()).isEqualTo(Testdaten.BENUTZER_JUSTIN));
	}

	@Test
	@DisplayName("Setter besitzen")
	public void test04()
	{
		final var id = new Primaerschluessel();
		final var koerpermessung = new Koerpermessung();
		koerpermessung.setPrimaerschluessel(id);
		koerpermessung.setDatum(LocalDate.now());
		koerpermessung.setKoerpergroesse(178);
		koerpermessung.setKoerpergewicht(90);
		koerpermessung.setKoerperfettAnteil(25);
		koerpermessung.setEingenommeneKalorien(2500);
		koerpermessung.setVerbrannteKalorien(2900);
		koerpermessung.setBenutzer(Testdaten.BENUTZER_JUSTIN);

		assertAll(
			() -> assertThat(koerpermessung.getPrimaerschluessel()).isEqualTo(id),
			() -> assertThat(koerpermessung.getDatum()).isEqualTo(LocalDate.now()),
			() -> assertThat(koerpermessung.getKoerpergroesse()).isEqualTo(178),
			() -> assertThat(koerpermessung.getKoerpergewicht()).isEqualTo(90),
			() -> assertThat(koerpermessung.getKoerperfettAnteil()).isEqualTo(25),
			() -> assertThat(koerpermessung.getEingenommeneKalorien()).isEqualTo(2500),
			() -> assertThat(koerpermessung.getVerbrannteKalorien()).isEqualTo(2900),
			() -> assertThat(koerpermessung.getFettfreiesKoerpergewicht()).isEqualTo(67.5),
			() -> assertThat(koerpermessung.getBodyMassIndex()).isEqualTo(28.41),
			() -> assertThat(koerpermessung.getFatFreeMassIndex()).isEqualTo(21.43),
			() -> assertThat(koerpermessung.getBenutzer()).isEqualTo(Testdaten.BENUTZER_JUSTIN));
	}

	@Test
	@DisplayName("sich vergleichen")
	@SuppressWarnings("unlikely-arg-type")
	public void test05()
	{
		final var andereKoerpermessung = new Koerpermessung();
		andereKoerpermessung.setPrimaerschluessel(new Primaerschluessel());

		final var koerpermessungMitGleicherId = new Koerpermessung();
		koerpermessungMitGleicherId.setPrimaerschluessel(sut.getPrimaerschluessel());

		assertAll(
			() -> assertThat(sut.equals(sut)).isEqualTo(true),
			() -> assertThat(sut.equals(null)).isEqualTo(false),
			() -> assertThat(sut.equals(Testdaten.AUTHENTIFIZIERUNG_JUSTIN)).isEqualTo(false),
			() -> assertThat(sut.equals(andereKoerpermessung)).isEqualTo(false),
			() -> assertThat(sut.equals(koerpermessungMitGleicherId)).isEqualTo(true),
			() -> assertThat(sut.hashCode()).isNotEqualTo(andereKoerpermessung));
	}

	@Test
	@DisplayName("eine toString()-Methode haben")
	public void test06()
	{
		final var erwartet = "Koerpermessung{ID=" + sut.getPrimaerschluessel().getId().toString() + "}";

		assertThat(sut.toString()).isEqualTo(erwartet);
	}
}
