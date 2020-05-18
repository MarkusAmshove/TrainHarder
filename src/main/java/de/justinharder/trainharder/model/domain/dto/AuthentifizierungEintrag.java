package de.justinharder.trainharder.model.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthentifizierungEintrag implements Serializable
{
	private static final long serialVersionUID = -2585152739995047225L;

	private String id;
	private String mail;
	private String benutzername;
	private String passwort;
}
