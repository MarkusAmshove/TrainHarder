package de.justinharder.powerlifting.model.repository;

import java.util.List;

import de.justinharder.powerlifting.model.domain.Belastungsfaktor;

public interface BelastungsfaktorRepository
{
	List<Belastungsfaktor> ermittleAlle();

	Belastungsfaktor ermittleZuId(final int id);

	void erstelleBelastungsfaktor(final Belastungsfaktor belastungsfaktor);
}
