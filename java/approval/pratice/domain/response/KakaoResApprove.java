package approval.pratice.domain.response;

import java.time.LocalDateTime;

public class KakaoResApprove {
    private String aid;
    private String tid;
    private String cid;
    private String sid;
    private String partner_order_id;
    private String partner_user_id;
    private String payment_method_type;
    private Amount amount;
    private String item_name;
    private String item_code;
    private Integer quantity;
    private LocalDateTime create_at;
    private LocalDateTime approved_at;
    private String payload;
}
