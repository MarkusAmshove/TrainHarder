package de.justinharder.powerlifting.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Authentifizierung extends Entitaet
{
	private static final long serialVersionUID = 1607570632256351984L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Mail", unique = true, nullable = false)
	private String mail;
	@Column(name = "Benutzername", unique = true, nullable = false)
	private String benutzername;
	@Column(name = "Passwort", nullable = false)
	private String passwort;
	@ElementCollection(fetch = FetchType.EAGER)
    private Set<String> gruppen = new HashSet<>();
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Benutzer benutzer;

	public Authentifizierung(
		final String mail,
		final String benutzername,
		final String passwort)
	{
		this.mail = mail;
		this.benutzername = benutzername;
		this.passwort = passwort;
	}
}
