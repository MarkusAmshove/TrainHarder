package de.justinharder.powerlifting.model.domain.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginException extends Exception
{
	private static final long serialVersionUID = -1910353351519611596L;

	public LoginException(final String nachricht)
	{
		super(nachricht);
	}
}
