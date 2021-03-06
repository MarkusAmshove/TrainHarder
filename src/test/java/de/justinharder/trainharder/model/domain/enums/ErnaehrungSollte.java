package de.justinharder.trainharder.model.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.justinharder.trainharder.model.domain.enums.Ernaehrung;

class ErnaehrungSollte
{
	@Test
	@DisplayName("IllegalArgumentException werfen, wenn die Ernaehrung-Option nicht existiert")
	void test01()
	{
		final var exception =
			assertThrows(IllegalArgumentException.class, () -> Ernaehrung.fromErnaehrungOption("UNGUELTIG"));

		assertThat(exception.getMessage()).isEqualTo("Die Ernaehrung-Option \"UNGUELTIG\" existiert nicht!");
	}

	@Test
	@DisplayName("die Ernaehrung aus der Ernaehrung-Option zurückgeben")
	void test02()
	{
		final var erwartet = Ernaehrung.DURCHSCHNITT;

		final var ergebnis = Ernaehrung.fromErnaehrungOption("DURCHSCHNITT");

		assertThat(ergebnis).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("IllegalArgumentException werfen, wenn der Name nicht existiert")
	void test03()
	{
		final var exception = assertThrows(IllegalArgumentException.class, () -> Ernaehrung.fromName("UNGUELTIG"));

		assertThat(exception.getMessage()).isEqualTo("Der Name \"UNGUELTIG\" existiert nicht!");
	}

	@Test
	@DisplayName("die Ernaehrung aus dem Namen zurückgeben")
	void test04()
	{
		final var erwartet = Ernaehrung.GUT;

		final var ergebnis = Ernaehrung.fromName("GUT");

		assertThat(ergebnis).isEqualTo(erwartet);
	}
}
