package de.justinharder.trainharder.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import de.justinharder.trainharder.model.domain.Belastungsfaktor;
import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import de.justinharder.trainharder.model.repository.BelastungsfaktorRepository;

public class BelastungsfaktorJpaRepository extends JpaRepository<Belastungsfaktor> implements BelastungsfaktorRepository
{
	@Override
	public Optional<Belastungsfaktor> ermittleZuId(final Primaerschluessel id)
	{
		return super.ermittleZuId(Belastungsfaktor.class, id);
	}

	@Override
	@Transactional
	public Belastungsfaktor speichereBelastungsfaktor(final Belastungsfaktor belastungsfaktor)
	{
		return super.speichereEntitaet(Belastungsfaktor.class, belastungsfaktor);
	}
}
