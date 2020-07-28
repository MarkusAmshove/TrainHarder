package de.justinharder.trainharder.model.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
	@Column(name = "Koerpergroesse")
	private int koerpergroesse;
	@Column(name = "Koerpergewicht")
	private double koerpergewicht;
	@Column(name = "KoerperfettAnteil")
	private double koerperfettAnteil;
	@Column(name = "EingenommeneKalorien")
	private int eingenommeneKalorien;
	@Column(name = "VerbrannteKalorien")
	private int verbrannteKalorien;
	@Column(name = "FettfreiesKoerpergewicht")
	@Setter(value = AccessLevel.NONE)
	private double fettfreiesKoerpergewicht;
	@Column(name = "BodyMassIndex")
	@Setter(value = AccessLevel.NONE)
	private double bodyMassIndex;
	@Column(name = "FatFreeMassIndex")
	@Setter(value = AccessLevel.NONE)
	private double fatFreeMassIndex;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "BenutzerID", nullable = false)
	private Benutzer benutzer;

	public Koerpermessung(
		final Primaerschluessel primaerschluessel,
		final LocalDate datum,
		final int koerpergroesse,
		final double koerpergewicht,
		final double koerperfettAnteil,
		final int eingenommeneKalorien,
		final int verbrannteKalorien,
		final Benutzer benutzer)
	{
		this.primaerschluessel = primaerschluessel;
		this.datum = datum;
		this.koerpergroesse = koerpergroesse;
		this.koerpergewicht = koerpergewicht;
		this.koerperfettAnteil = koerperfettAnteil;
		this.eingenommeneKalorien = eingenommeneKalorien;
		this.verbrannteKalorien = verbrannteKalorien;
		this.fettfreiesKoerpergewicht = berechneFettfreiesKoerpergewicht(koerpergewicht, koerperfettAnteil);
		this.bodyMassIndex = berechneBmi(koerpergroesse, koerpergewicht);
		this.fatFreeMassIndex = berechneFfmi(koerpergewicht, koerperfettAnteil, koerpergroesse);
		this.benutzer = benutzer;

		benutzer.fuegeKoerpermessungHinzu(this);
	}

	private double berechneFettfreiesKoerpergewicht(final double koerpergewicht, final double koerperfettAnteil)
	{
		var fettfreiesKoerpergewicht = koerpergewicht - koerpergewicht * (koerperfettAnteil / 100);
		return Math.round(fettfreiesKoerpergewicht * 100) / 100.0;
	}

	private double berechneBmi(final int koerpergroesse, final double koerpergewicht)
	{
		final var bmi = koerpergewicht / Math.pow(koerpergroesse / 100.0, 2);
		return Math.round(bmi * 100) / 100.0;
	}

	private double berechneFfmi(final double koerpergewicht, final double koerperfettAnteil, final int koerpergroesse)
	{
		final var magermasse = koerpergewicht * (1 - koerperfettAnteil / 100.0);
		final var ffmi = magermasse / Math.pow(koerpergroesse / 100.0, 2) + 6.1 * (1.8 - koerpergroesse / 100.0);
		return Math.round(ffmi * 100) / 100.0;
	}

	public void setKoerpergroesse(final int koerpergroesse)
	{
		this.koerpergroesse = koerpergroesse;
		this.bodyMassIndex = berechneBmi(koerpergroesse, koerpergewicht);
		this.fettfreiesKoerpergewicht = berechneFettfreiesKoerpergewicht(koerpergewicht, koerperfettAnteil);
		this.fatFreeMassIndex = berechneFfmi(koerpergewicht, koerperfettAnteil, koerpergroesse);
	}

	public void setKoerpergewicht(final double koerpergewicht)
	{
		this.koerpergewicht = koerpergewicht;
		this.fettfreiesKoerpergewicht = berechneFettfreiesKoerpergewicht(koerpergewicht, koerperfettAnteil);
		this.bodyMassIndex = berechneBmi(koerpergroesse, koerpergewicht);
		this.fatFreeMassIndex = berechneFfmi(koerpergewicht, koerperfettAnteil, koerpergroesse);
	}

	public void setKoerperfettAnteil(final double koerperfettAnteil)
	{
		this.koerperfettAnteil = koerperfettAnteil;
		this.fettfreiesKoerpergewicht = berechneFettfreiesKoerpergewicht(koerpergewicht, koerperfettAnteil);
		this.bodyMassIndex = berechneBmi(koerpergroesse, koerpergewicht);
		this.fatFreeMassIndex = berechneFfmi(koerpergewicht, koerperfettAnteil, koerpergroesse);
	}
}
