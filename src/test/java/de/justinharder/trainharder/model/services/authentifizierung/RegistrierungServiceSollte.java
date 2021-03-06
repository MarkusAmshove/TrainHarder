package de.justinharder.trainharder.model.services.authentifizierung;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.justinharder.trainharder.model.domain.Authentifizierung;
import de.justinharder.trainharder.model.domain.embeddables.Primaerschluessel;
import de.justinharder.trainharder.model.domain.exceptions.AuthentifizierungNichtGefundenException;
import de.justinharder.trainharder.model.domain.exceptions.BenutzernameVergebenException;
import de.justinharder.trainharder.model.domain.exceptions.MailVergebenException;
import de.justinharder.trainharder.model.domain.exceptions.PasswortUnsicherException;
import de.justinharder.trainharder.model.repository.AuthentifizierungRepository;
import de.justinharder.trainharder.model.services.authentifizierung.passwort.PasswortCheck;
import de.justinharder.trainharder.model.services.authentifizierung.passwort.PasswortHasher;
import de.justinharder.trainharder.model.services.mail.MailServer;
import de.justinharder.trainharder.model.services.mapper.AuthentifizierungDtoMapper;
import de.justinharder.trainharder.setup.Testdaten;
import de.justinharder.trainharder.view.dto.AuthentifizierungDto;
import de.justinharder.trainharder.view.dto.Registrierung;

class RegistrierungServiceSollte
{
	private RegistrierungService sut;

	private AuthentifizierungRepository authentifizierungRepository;
	private AuthentifizierungDtoMapper authentifizierungDtoMapper;
	private PasswortHasher passwortHasher;
	private PasswortCheck passwortCheck;
	private MailServer mailServer;

	@BeforeEach
	void setup()
	{
		authentifizierungRepository = mock(AuthentifizierungRepository.class);
		authentifizierungDtoMapper = mock(AuthentifizierungDtoMapper.class);
		passwortHasher = mock(PasswortHasher.class);
		passwortCheck = mock(PasswortCheck.class);
		mailServer = mock(MailServer.class);

		sut = new RegistrierungService(
			authentifizierungRepository,
			authentifizierungDtoMapper,
			passwortHasher,
			passwortCheck,
			mailServer);
	}

	private void angenommenDieMailIstVergeben(final String mail, final Optional<Authentifizierung> authentifizierung)
	{
		when(authentifizierungRepository.ermittleZuMail(mail)).thenReturn(authentifizierung);
	}

	private void angenommenDerBenutzernameIstVergeben(final String benutzername,
		final Optional<Authentifizierung> authentifizierung)
	{
		when(authentifizierungRepository.ermittleZuBenutzername(benutzername)).thenReturn(authentifizierung);
	}

	private void angenommenDasPasswortIstUnsicher(final String passwort, final boolean unsicher)
	{
		when(passwortCheck.isUnsicher(passwort)).thenReturn(unsicher);
	}

	private void angenommenDasAuthentifizierungRepositorySpeichertAuthentifizierung(
		final Authentifizierung authentifizierung)
	{
		when(authentifizierungRepository.speichereAuthentifizierung(any(Authentifizierung.class)))
			.thenReturn(authentifizierung);
	}

	private void angenommenDerAuthentifizierungDtoMapperKonvertiertZuAuthentifizierungDto(
		final Authentifizierung authentifizierung, final AuthentifizierungDto authentifizierungDto)
	{
		when(authentifizierungDtoMapper.konvertiere(authentifizierung)).thenReturn(authentifizierungDto);
	}

	private void angenommenDasAuthentifizierungRepositoryErmitteltAuthentifizierungZuId(
		final String authentifizierungId,
		final Optional<Authentifizierung> authentifizierung)
	{
		when(authentifizierungRepository.ermittleZuId(new Primaerschluessel(authentifizierungId)))
			.thenReturn(authentifizierung);
	}

	@Test
	@DisplayName("NullPointerException werfen, wenn die Registrierung null ist")
	void test01()
	{
		final var erwartet = "Zum Beitreten wird eine gültige Registrierung benötigt!";

		final var exception = assertThrows(NullPointerException.class, () -> sut.registriere(null));

		assertThat(exception.getMessage()).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("MailVergebenException werfen, wenn die Mail vergeben ist")
	void test02()
	{
		final var registrierung = new Registrierung("mail@justinharder.de", "harder", "Justinharder#98");
		final var erwartet = "Die Mail \"" + registrierung.getMail() + "\" ist bereits vergeben!";
		angenommenDieMailIstVergeben(registrierung.getMail(), Optional.of(Testdaten.AUTHENTIFIZIERUNG_JUSTIN));

		final var exception = assertThrows(MailVergebenException.class, () -> sut.registriere(registrierung));

		assertThat(exception.getMessage()).isEqualTo(erwartet);
		verify(authentifizierungRepository).ermittleZuMail(registrierung.getMail());
	}

	@Test
	@DisplayName("BenutzernameVergebenException werfen, wenn der Benutzername vergeben ist")
	void test03()
	{
		final var registrierung = new Registrierung("mail@justinharder.de", "harder", "Justinharder#98");
		final var erwartet = "Der Benutzername \"" + registrierung.getBenutzername() + "\" ist bereits vergeben!";
		angenommenDieMailIstVergeben(registrierung.getMail(), Optional.empty());
		angenommenDerBenutzernameIstVergeben(registrierung.getBenutzername(),
			Optional.of(Testdaten.AUTHENTIFIZIERUNG_JUSTIN));

		final var exception = assertThrows(BenutzernameVergebenException.class, () -> sut.registriere(registrierung));

		assertThat(exception.getMessage()).isEqualTo(erwartet);
		verify(authentifizierungRepository).ermittleZuMail(registrierung.getMail());
		verify(authentifizierungRepository).ermittleZuBenutzername(registrierung.getBenutzername());
	}

	@Test
	@DisplayName("PasswortUnsicherException werfen, wenn das Passwort unsicher ist")
	void test04()
	{
		final var erwartet = "Das Passwort ist unsicher!";
		final var registrierung = new Registrierung("mail@justinharder.de", "harder", "Justinharder#98");
		angenommenDieMailIstVergeben(registrierung.getMail(), Optional.empty());
		angenommenDerBenutzernameIstVergeben(registrierung.getBenutzername(), Optional.empty());
		angenommenDasPasswortIstUnsicher(registrierung.getPasswort(), true);

		final var exception = assertThrows(PasswortUnsicherException.class, () -> sut.registriere(registrierung));

		assertThat(exception.getMessage()).isEqualTo(erwartet);
		verify(authentifizierungRepository).ermittleZuMail(registrierung.getMail());
		verify(authentifizierungRepository).ermittleZuBenutzername(registrierung.getBenutzername());
		verify(passwortCheck).isUnsicher(registrierung.getPasswort());
	}

	@Test
	@DisplayName("einen Benutzer registrieren")
	void test05() throws MailVergebenException, BenutzernameVergebenException, PasswortUnsicherException,
		InvalidKeySpecException, NoSuchAlgorithmException
	{
		final var erwartet = Testdaten.AUTHENTIFIZIERUNG_DTO_JUSTIN;
		final var registrierung = new Registrierung("mail@justinharder.de", "harder", "Justinharder#98");
		final var authentifizierung = Testdaten.AUTHENTIFIZIERUNG_JUSTIN;
		angenommenDieMailIstVergeben(registrierung.getMail(), Optional.empty());
		angenommenDerBenutzernameIstVergeben(registrierung.getBenutzername(), Optional.empty());
		angenommenDasPasswortIstUnsicher(registrierung.getPasswort(), false);
		angenommenDasAuthentifizierungRepositorySpeichertAuthentifizierung(authentifizierung);
		angenommenDerAuthentifizierungDtoMapperKonvertiertZuAuthentifizierungDto(authentifizierung, erwartet);

		final var ergebnis = sut.registriere(registrierung);

		assertThat(ergebnis).isEqualTo(erwartet);
		verify(authentifizierungRepository).ermittleZuMail(registrierung.getMail());
		verify(authentifizierungRepository).ermittleZuBenutzername(registrierung.getBenutzername());
		verify(passwortCheck).isUnsicher(registrierung.getPasswort());
		//		verify(mailServer).sendeMail(new Mail(
		//			new MailAdresse("mail@justinharder.de", "TrainHarder-Team"),
		//			"Willkommen bei TrainHarder!",
		//			"Hallo " + authentifizierung.getBenutzername() + ",\n"
		//				+ "wir heißen dich herzlich Willkommen bei TrainHarder!\n"
		//				+ "Über folgenden Link kannst du deine E-Mail-Adresse bestätigen: \n"
		//				+ "\thttps://www.trainharder.de/join/" + authentifizierung.getPrimaerschluessel().getId().toString()
		//				+ "\n\n"
		//				+ "Mit den besten Grüßen!\n"
		//				+ "das TrainHarder-Team")
		//					.fuegeEmpfaengerHinzu(new MailAdresse(authentifizierung.getMail())),
		//			StandardCharsets.UTF_8);
		verify(authentifizierungDtoMapper).konvertiere(authentifizierung);
	}

	@Test
	@DisplayName("NullPointerException werfen, wenn die AuthentifizierungID null ist")
	void test06()
	{
		final var erwartet = "Zum Aktivieren wird eine gültige ID benötigt!";

		final var exception = assertThrows(NullPointerException.class, () -> sut.aktiviere(null));

		assertThat(exception.getMessage()).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("AuthentifizierungNichtGefundenException werfen, wenn die AuthentifizierungID nicht existiert")
	void test07()
	{
		final var authentifizierungId = new Primaerschluessel().getId().toString();
		final var erwartet = "Die Authentifizierung mit der ID \"" + authentifizierungId + "\" existiert nicht!";

		final var exception = assertThrows(AuthentifizierungNichtGefundenException.class,
			() -> sut.aktiviere(authentifizierungId));

		assertThat(exception.getMessage()).isEqualTo(erwartet);
	}

	@Test
	@DisplayName("eine Authentifizierung aktivieren")
	void test08() throws AuthentifizierungNichtGefundenException
	{
		final var authentifizierung = Testdaten.AUTHENTIFIZIERUNG_JUSTIN;
		final var authentifizierungId = authentifizierung.getPrimaerschluessel().getId().toString();
		angenommenDasAuthentifizierungRepositoryErmitteltAuthentifizierungZuId(authentifizierungId,
			Optional.of(authentifizierung));
		angenommenDasAuthentifizierungRepositorySpeichertAuthentifizierung(authentifizierung);

		sut.aktiviere(authentifizierungId);

		verify(authentifizierungRepository).ermittleZuId(authentifizierung.getPrimaerschluessel());
		verify(authentifizierungRepository).speichereAuthentifizierung(authentifizierung);
	}
}
