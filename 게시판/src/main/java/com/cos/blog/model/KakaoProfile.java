package com.cos.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class KakaoProfile {
	public Long id;
	public String connected_at;
	public Properties properties;
	public Kakao_account kakao_account;

	@Data
	@JsonIgnoreProperties(ignoreUnknown=true)
	public class Properties {
		public String nickname;
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown=true)
	public class Kakao_account {
		public Boolean profile_nickname_needs_agreement;
		public Profile profile;
		public Boolean has_email;
		public Boolean email_needs_agreement;
		public Boolean is_email_valid;
		public Boolean is_email_verified;
		public String email;

		@Data
		@JsonIgnoreProperties(ignoreUnknown=true)
		public class Profile {
			public String nickname;
		}
	}
}
