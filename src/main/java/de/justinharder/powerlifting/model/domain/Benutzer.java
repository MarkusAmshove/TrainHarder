package de.justinharder.powerlifting.model.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import de.justinharder.powerlifting.model.domain.enums.Doping;
import de.justinharder.powerlifting.model.domain.enums.Erfahrung;
import de.justinharder.powerlifting.model.domain.enums.Ernaehrung;
import de.justinharder.powerlifting.model.domain.enums.Geschlecht;
import de.justinharder.powerlifting.model.domain.enums.Regenerationsfaehigkeit;
import de.justinharder.powerlifting.model.domain.enums.Schlafqualitaet;
import de.justinharder.powerlifting.model.domain.enums.Stress;
import lombok.Data;

@Data
@Entity
public class Benutzer
{
	@Id
	private String id;
	private String vorname;
	private String nachname;
	private double koerpergewicht;
	private int koerpergroesse;
	private int alter;
	@Enumerated(EnumType.STRING)
	private Geschlecht geschlecht;
	@Enumerated(EnumType.STRING)
	private Erfahrung erfahrung;
	@Enumerated(EnumType.STRING)
	private Ernaehrung ernaehrung;
	@Enumerated(EnumType.STRING)
	private Schlafqualitaet schlafqualitaet;
	@Enumerated(EnumType.STRING)
	private Stress stress;
	@Enumerated(EnumType.STRING)
	private Doping doping;
	@Enumerated(EnumType.STRING)
	private Regenerationsfaehigkeit regenerationsfaehigkeit;
}
