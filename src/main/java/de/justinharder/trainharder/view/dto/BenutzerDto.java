package de.justinharder.trainharder.view.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BenutzerDto implements Serializable
{
	private static final long serialVersionUID = 2341943957236551490L;

	private String primaerschluessel;
	private String vorname;
	private String nachname;
	private LocalDate geburtsdatum;
	private String kraftlevel;
	private String geschlecht;
	private String erfahrung;
	private String ernaehrung;
	private String schlafqualitaet;
	private String stress;
	private String doping;
	private String regenerationsfaehigkeit;
	private AuthentifizierungDto authentifizierung;

	public BenutzerDto setVorname(final String vorname)
	{
		this.vorname = vorname;
		return this;
	}

	public BenutzerDto setNachname(final String nachname) 
	{
		this.nachname = nachname;
		return this;
	}

	public BenutzerDto setGeburtsdatum(final LocalDate geburtsdatum)
	{
		this.geburtsdatum = geburtsdatum;
		return this;
	}

	public BenutzerDto setKraftlevel(final String kraftlevel)
	{
		this.kraftlevel = kraftlevel;
		return this;
	}

	public BenutzerDto setGeschlecht(final String geschlecht)
	{
		this.geschlecht = geschlecht;
		return this;
	}

	public BenutzerDto setErfahrung(final String erfahrung)
	{
		this.erfahrung = erfahrung;
		return this;
	}

	public BenutzerDto setErnaehrung(final String ernaehrung)
	{
		this.ernaehrung = ernaehrung;
		return this;
	}

	public BenutzerDto setSchlafqualitaet(final String schlafqualitaet)
	{
		this.schlafqualitaet = schlafqualitaet;
		return this;
	}

	public BenutzerDto setStress(final String stress)
	{
		this.stress = stress;
		return this;
	}

	public BenutzerDto setDoping(final String doping)
	{
		this.doping = doping;
		return this;
	}

	public BenutzerDto setRegenerationsfaehigkeit(final String regenerationsfaehigkeit)
	{
		this.regenerationsfaehigkeit = regenerationsfaehigkeit;
		return this;
	}
}