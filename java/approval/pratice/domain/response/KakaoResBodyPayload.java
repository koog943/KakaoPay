package approval.pratice.domain.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class KakaoResBodyPayload {
    private String tid;
    private String next_redirect_app_url;
    private String next_redirect_mobile_url;
    private String next_redirect_pc_url;
    private String android_app_scheme;
    private LocalDateTime created_at;
}
