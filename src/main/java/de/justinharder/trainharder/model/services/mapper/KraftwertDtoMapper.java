package de.justinharder.trainharder.model.services.mapper;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import de.justinharder.trainharder.model.domain.Kraftwert;
import de.justinharder.trainharder.view.dto.KraftwertDto;

public class KraftwertDtoMapper
{
	private static final DateTimeFormatter DATUMSFORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	public List<KraftwertDto> konvertiereAlle(final List<Kraftwert> kraftwerte)
	{
		return kraftwerte
			.stream()
			.map(this::konvertiere)
			.collect(Collectors.toList());
	}

	public KraftwertDto konvertiere(final Kraftwert kraftwert)
	{
		return new KraftwertDto(
			kraftwert.getPrimaerschluessel().getId().toString(),
			kraftwert.getMaximum(),
			kraftwert.getKoerpergewicht(),
			kraftwert.getDatum().format(DATUMSFORMAT),
			kraftwert.getWiederholungen().name());
	}
}
