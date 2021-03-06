package de.justinharder.trainharder.model.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.justinharder.trainharder.model.domain.enums.Uebungskategorie;

class UebungskategorieSollte
{

	@Test
	@DisplayName("IllegalArgumentException werfen, wenn die Uebungskategorie-Option nicht existiert")
	void test01()
	{
		final var exception =
			assertThrows(IllegalArgumentException.class,
				() -> Uebungskategorie.fromUebungskategorieOption("UNGUELTIG"));

		assertThat(exception.getMessage()).isEqualTo("Die Uebungskategorie-Option \"UNGUELTIG\" existiert nicht!");
	}

	@Test
	@DisplayName("die Uebungskategorie aus der Uebungskategorie-Option zurückgeben")
	void test02()
	{
		final var erwartet = Uebungskategorie.UEBERKOPFDRUECKEN;

		final var ergebnis = Uebungskategorie.fromUebungskategorieOption("UEBERKOPFDRUECKEN");

		assertThat(ergebnis).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("IllegalArgumentException werfen, wenn der Name nicht existiert")
	void test03()
	{
		final var exception =
			assertThrows(IllegalArgumentException.class, () -> Uebungskategorie.fromName("UNGUELTIG"));

		assertThat(exception.getMessage()).isEqualTo("Der Name \"UNGUELTIG\" existiert nicht!");
	}

	@Test
	@DisplayName("die Uebungskategorie aus dem Namen zurückgeben")
	void test04()
	{
		final var erwartet = Uebungskategorie.ASSISTENZ_CORE;

		final var ergebnis = Uebungskategorie.fromName("ASSISTENZ_CORE");

		assertThat(ergebnis).isEqualTo(erwartet);
	}
}
