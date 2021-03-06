package de.justinharder.trainharder.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.justinharder.trainharder.model.domain.embeddables.Koerpermasse;
import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import lombok.Getter;

@Getter
@Entity
@Table(name = "Koerpermessung")
public class Koerpermessung extends Entitaet
{
	private static final long serialVersionUID = -6355583837778945437L;

	@EmbeddedId
	@Column(name = "ID")
	private Primaerschluessel primaerschluessel;
	@Column(name = "Datum")
	private LocalDate datum;
	@Embedded
	private Koerpermasse koerpermasse;
	@Column(name = "Kalorieneinnahme")
	private int kalorieneinnahme;
	@Column(name = "Kalorienverbrauch")
	private int kalorienverbrauch;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BenutzerID", nullable = false)
	private Benutzer benutzer;

	public Koerpermessung()
	{}

	public Koerpermessung(
		final Primaerschluessel primaerschluessel,
		final LocalDate datum,
		final Koerpermasse koerpermasse,
		final int kalorieneinnahme,
		final int kalorienverbrauch,
		final Benutzer benutzer)
	{
		this.primaerschluessel = primaerschluessel;
		this.datum = datum;
		this.koerpermasse = koerpermasse;
		this.kalorieneinnahme = kalorieneinnahme;
		this.kalorienverbrauch = kalorienverbrauch;
		this.benutzer = benutzer;

		benutzer.fuegeKoerpermessungHinzu(this);
	}

	public Koerpermessung setPrimaerschluessel(final Primaerschluessel primaerschluessel)
	{
		this.primaerschluessel = primaerschluessel;
		return this;
	}

	public Koerpermessung setDatum(final LocalDate datum)
	{
		this.datum = datum;
		return this;
	}

	public Koerpermessung setKoerpermasse(final Koerpermasse koerpermasse)
	{
		this.koerpermasse = koerpermasse;
		return this;
	}

	public Koerpermessung setKalorieneinnahme(final int kalorieneinnahme)
	{
		this.kalorieneinnahme = kalorieneinnahme;
		return this;
	}

	public Koerpermessung setKalorienverbrauch(final int kalorienverbrauch)
	{
		this.kalorienverbrauch = kalorienverbrauch;
		return this;
	}

	public Koerpermessung setBenutzer(final Benutzer benutzer)
	{
		this.benutzer = benutzer;
		return this;
	}

	@Override
	public boolean equals(final Object obj)
	{
		return super.equals(obj);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
