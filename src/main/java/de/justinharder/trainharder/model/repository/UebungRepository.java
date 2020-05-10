package de.justinharder.trainharder.model.repository;

import java.util.List;

import de.justinharder.trainharder.model.domain.Uebung;
import de.justinharder.trainharder.model.domain.enums.Uebungsart;
import de.justinharder.trainharder.model.domain.enums.Uebungskategorie;
import de.justinharder.trainharder.model.domain.exceptions.UebungNichtGefundenException;

public interface UebungRepository
{
	List<Uebung> ermittleAlle();

	List<Uebung> ermittleZuUebungsart(final Uebungsart uebungsart) throws UebungNichtGefundenException;

	List<Uebung> ermittleZuUebungskategorie(final Uebungskategorie uebungskategorie)
		throws UebungNichtGefundenException;

	Uebung ermittleZuId(final int id);

	void erstelleUebung(final Uebung uebung);
}
