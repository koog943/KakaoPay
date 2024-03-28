package approval.pratice.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KakaoReqApprove {

    private final String cid = "TC0ONETIME";
    private String tid;
    private String partner_order_id;
    private String partner_user_id;
    private String pg_token;
    private String payload;

}
