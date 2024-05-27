package com.syncinator.kodi.login.oauth.provider;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component(Provider.NAME_PREFIX + OneDriveProvider.NAME)
public class OneDriveProvider extends Provider {
	protected static final String NAME = "onedrive";

	@Override
	public String authorize(final String pin) {
		return getAuthorizeUrl(NAME, pin, Map.of(
				"scope", "offline_access sites.read.all files.read.all user.read",
				"response_mode", "form_post"));
	}

	@Override
	public Map<String,Object> tokens(final String grantType, final String value) {
		return getTokens(NAME, grantType, value);
	}
}
