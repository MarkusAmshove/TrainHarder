package de.justinharder.trainharder.model.services;

import com.google.common.base.Preconditions;
import de.justinharder.trainharder.model.domain.Belastungsfaktor;
import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import de.justinharder.trainharder.model.domain.exceptions.BelastungsfaktorNichtGefundenException;
import de.justinharder.trainharder.model.repository.BelastungsfaktorRepository;
import de.justinharder.trainharder.model.services.mapper.BelastungsfaktorDtoMapper;
import de.justinharder.trainharder.view.dto.BelastungsfaktorDto;

import javax.inject.Inject;

public class BelastungsfaktorService
{
	private final BelastungsfaktorRepository belastungsfaktorRepository;
	private final BelastungsfaktorDtoMapper belastungsfaktorDtoMapper;

	@Inject
	public BelastungsfaktorService(
		final BelastungsfaktorRepository belastungsfaktorRepository,
		final BelastungsfaktorDtoMapper belastungsfaktorDtoMapper)
	{
		this.belastungsfaktorRepository = belastungsfaktorRepository;
		this.belastungsfaktorDtoMapper = belastungsfaktorDtoMapper;
	}

	public BelastungsfaktorDto ermittleZuId(final String id) throws BelastungsfaktorNichtGefundenException
	{
		Preconditions.checkNotNull(id, "Ermittlung des Belastungsfaktors benötigt eine gültige BelastungsfaktorID!");

		return belastungsfaktorRepository.ermittleZuId(new Primaerschluessel(id))
			.map(belastungsfaktorDtoMapper::konvertiere)
			.orElseThrow(FehlermeldungService.wirfBelastungsfaktorNichtGefundenException("der ID", id));
	}

	public BelastungsfaktorDto speichereBelastungsfaktor(final BelastungsfaktorDto belastungsfaktorDto)
	{
		Preconditions.checkNotNull(belastungsfaktorDto,
			"Zum Speichern wird ein gueltiges BelastungsfaktorDto benötigt!");

		return belastungsfaktorDtoMapper.konvertiere(belastungsfaktorRepository
			.speichereBelastungsfaktor(new Belastungsfaktor(
				new Primaerschluessel(),
				belastungsfaktorDto.getSquat(),
				belastungsfaktorDto.getBenchpress(),
				belastungsfaktorDto.getDeadlift(),
				belastungsfaktorDto.getTriceps(),
				belastungsfaktorDto.getChest(),
				belastungsfaktorDto.getCore(),
				belastungsfaktorDto.getBack(),
				belastungsfaktorDto.getBiceps(),
				belastungsfaktorDto.getGlutes(),
				belastungsfaktorDto.getQuads(),
				belastungsfaktorDto.getHamstrings(),
				belastungsfaktorDto.getShoulder())));
	}
}
