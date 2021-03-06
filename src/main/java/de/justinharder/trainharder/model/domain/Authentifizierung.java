package de.justinharder.trainharder.model.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.justinharder.trainharder.model.UuidMapper;
import de.justinharder.trainharder.model.domain.embeddables.Passwort;
import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import lombok.Getter;

@Getter
@Entity
@Table(name = "Authentifizierung")
public class Authentifizierung extends Entitaet
{
	private static final long serialVersionUID = 1607570632256351984L;

	@EmbeddedId
	@Column(name = "ID")
	private Primaerschluessel primaerschluessel;
	@Column(name = "Mail", unique = true, nullable = false)
	private String mail;
	@Column(name = "Benutzername", unique = true, nullable = false)
	private String benutzername;
	@Embedded
	private Passwort passwort;
	@Column(name = "Aktiv", nullable = false)
	private boolean aktiv;
	@Convert(converter = UuidMapper.class)
	@Column(name = "ResetUuid", columnDefinition = "VARCHAR(36)", nullable = true)
	private UUID resetUuid;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BenutzerID", nullable = true)
	private Benutzer benutzer;

	public Authentifizierung()
	{}

	public Authentifizierung(
		final Primaerschluessel primaerschluessel,
		final String mail,
		final String benutzername,
		final Passwort passwort)
	{
		this.primaerschluessel = primaerschluessel;
		this.mail = mail;
		this.benutzername = benutzername;
		this.passwort = passwort;
		aktiv = false;
	}

	public Authentifizierung setPrimaerschluessel(final Primaerschluessel primaerschluessel)
	{
		this.primaerschluessel = primaerschluessel;
		return this;
	}

	public Authentifizierung setMail(final String mail)
	{
		this.mail = mail;
		return this;
	}

	public Authentifizierung setBenutzername(final String benutzername)
	{
		this.benutzername = benutzername;
		return this;
	}

	public Authentifizierung setPasswort(final Passwort passwort)
	{
		this.passwort = passwort;
		return this;
	}

	public Authentifizierung setAktiv(final boolean aktiv)
	{
		this.aktiv = aktiv;
		return this;
	}

	public Authentifizierung setResetUuid(final UUID resetUuid)
	{
		this.resetUuid = resetUuid;
		return this;
	}

	public Authentifizierung setBenutzer(final Benutzer benutzer)
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
