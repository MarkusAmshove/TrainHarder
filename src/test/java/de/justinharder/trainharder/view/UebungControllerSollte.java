package de.justinharder.trainharder.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.justinharder.trainharder.model.domain.exceptions.UebungNichtGefundenException;
import de.justinharder.trainharder.model.services.UebungService;
import de.justinharder.trainharder.setup.Testdaten;
import de.justinharder.trainharder.view.dto.UebungDto;

public class UebungControllerSollte
{
	private UebungController sut;
	private UebungService uebungService;

	@BeforeEach
	public void setup()
	{
		uebungService = mock(UebungService.class);
		sut = new UebungController(uebungService);
	}

	private void angenommenDerUebungServiceGibtAlleUebungDtosZurueck(final List<UebungDto> erwartet)
	{
		when(uebungService.ermittleAlle()).thenReturn(erwartet);
	}

	private void angenommenDerUebungServiceGibtAlleUebungDtosZuUebungsartZurueck(
		final List<UebungDto> erwartet) throws UebungNichtGefundenException
	{
		when(uebungService.ermittleZuUebungsart(anyString())).thenReturn(erwartet);
	}

	private void angenommenDerUebungServiceGibtAlleUebungDtosZuUebungskategorieZurueck(
		final List<UebungDto> erwartet) throws UebungNichtGefundenException
	{
		when(uebungService.ermittleZuUebungskategorie(anyString())).thenReturn(erwartet);
	}

	private void angenommenDerUebungServiceGibtEineUebungMithilfeDerIdZurueck(final UebungDto erwartet)
		throws UebungNichtGefundenException
	{
		when(uebungService.ermittleZuId(anyString())).thenReturn(erwartet);
	}

	@Test
	@DisplayName("eine Liste aller UebungEinträge zurückgeben")
	public void test01()
	{
		final var erwartet = List.of(
			Testdaten.UEBUNG_DTO_WETTKAMPFBANKDRUECKEN,
			Testdaten.UEBUNG_DTO_LOWBAR_KNIEBEUGE,
			Testdaten.UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN);
		angenommenDerUebungServiceGibtAlleUebungDtosZurueck(erwartet);

		final var ergebnis = sut.getUebungen();

		assertThat(ergebnis).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("eine Liste aller UebungEinträge einer Uebungsart zurückgeben")
	public void test02() throws UebungNichtGefundenException
	{
		final var erwartet = List.of(
			Testdaten.UEBUNG_DTO_WETTKAMPFBANKDRUECKEN,
			Testdaten.UEBUNG_DTO_LOWBAR_KNIEBEUGE,
			Testdaten.UEBUNG_DTO_KONVENTIONELLES_KREUZHEBEN);
		angenommenDerUebungServiceGibtAlleUebungDtosZuUebungsartZurueck(erwartet);

		final var ergebnis = sut.getUebungenZuUebungsart("GRUNDUEBUNG");

		assertThat(ergebnis).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("eine Liste aller UebungEinträge einer Uebungskategorie zurückgeben")
	public void test03() throws UebungNichtGefundenException
	{
		final var erwartet = List.of(Testdaten.UEBUNG_DTO_WETTKAMPFBANKDRUECKEN);
		angenommenDerUebungServiceGibtAlleUebungDtosZuUebungskategorieZurueck(erwartet);

		final var ergebnis = sut.getUebungenZuUebungskategorie("WETTKAMPF_BANKDRUECKEN");

		assertThat(ergebnis).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("eine Uebung mit der übergebenen ID ermitteln")
	public void test04() throws UebungNichtGefundenException
	{
		final var erwartet = Testdaten.UEBUNG_DTO_LOWBAR_KNIEBEUGE;
		angenommenDerUebungServiceGibtEineUebungMithilfeDerIdZurueck(erwartet);

		final var ergebnis = sut.getUebungZuId(erwartet.getPrimaerschluessel());

		assertThat(ergebnis).isEqualTo(erwartet);
	}
}
