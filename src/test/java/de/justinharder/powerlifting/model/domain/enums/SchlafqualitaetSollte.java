package de.justinharder.powerlifting.model.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SchlafqualitaetSollte
{
	@Test
	@DisplayName("IllegalArgumentException werfen, wenn die Schlafqualitaet-Option nicht existiert")
	public void test01()
	{
		final var exception =
			assertThrows(IllegalArgumentException.class, () -> Schlafqualitaet.fromSchlafqualitaetOption("UNGUELTIG"));

		assertThat(exception.getMessage()).isEqualTo("Die Schlafqualitaet-Option \"UNGUELTIG\" existiert nicht!");
	}

	@Test
	@DisplayName("die Schlafqualitaet aus der Schlafqualitaet-Option zurückgeben")
	public void test02()
	{
		final var erwartet = Schlafqualitaet.DURCHSCHNITT;

		final var ergebnis = Schlafqualitaet.fromSchlafqualitaetOption("DURCHSCHNITT");

		assertThat(ergebnis).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("IllegalArgumentException werfen, wenn der Name nicht existiert")
	public void test03()
	{
		final var exception = assertThrows(IllegalArgumentException.class, () -> Schlafqualitaet.fromName("UNGUELTIG"));

		assertThat(exception.getMessage()).isEqualTo("Der Name \"UNGUELTIG\" existiert nicht!");
	}

	@Test
	@DisplayName("die Schlafqualitaet aus dem Namen zurückgeben")
	public void test04()
	{
		final var erwartet = Schlafqualitaet.GUT;

		final var ergebnis = Schlafqualitaet.fromName("GUT");

		assertThat(ergebnis).isEqualTo(erwartet);
	}
}
