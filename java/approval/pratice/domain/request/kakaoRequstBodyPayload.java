package approval.pratice.domain.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter @Getter
public class kakaoRequstBodyPayload {
    private final String cid = "TC0ONETIME";
    private String cid_secret;
    private String partner_order_id;
    private String parther_user_id;
    private String item_name;
    private String item_code;
    private Integer quantity;
    private Integer total_amount;
    private Integer tax_free_amount;
    private Integer vat_amount;
    private Integer green_deposit;
    private String approval_url;
    private String cancel_url;
    private String fail_url;
    private String payment_method_type;
    private Integer install_month;
    private String use_share_installment;
}
