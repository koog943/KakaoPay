package approval.pratice.service;

import approval.pratice.domain.Item.Item;
import approval.pratice.domain.request.KakaoReqApprove;
import approval.pratice.domain.request.kakaoRequstBodyPayload;
import approval.pratice.domain.response.KakaoResApprove;
import approval.pratice.domain.response.KakaoResBodyPayload;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional
public class PayService {

    private KakaoResBodyPayload kakaoResBodyPayload;

    public KakaoResBodyPayload kakaoPayReady() {
        kakaoRequstBodyPayload reqPayData = new kakaoRequstBodyPayload();
        Item item = new Item();
        int quantity = 3;
        setReqPayData(reqPayData, item, quantity);

        JSONObject reqPayJson = new JSONObject(reqPayData);

        // 파라미터, 헤더
        HttpEntity<JSONObject> reqEntity = new HttpEntity<>(reqPayJson, this.getHeaders());

        //외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";


        this.kakaoResBodyPayload = restTemplate.postForObject(
                url,
                reqEntity,
                KakaoResBodyPayload.class
        );

        return kakaoResBodyPayload;
    }

    public KakaoResApprove approveResponse(String pgToken) {
        KakaoReqApprove reqApproveData = new KakaoReqApprove();
        setReqApproveJson(reqApproveData, pgToken);
        JSONObject reqApproveJson = new JSONObject(reqApproveData);

        HttpEntity<JSONObject> reqEntity = new HttpEntity<>(reqApproveJson, this.getHeaders());

        //외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";

        KakaoResApprove kakaoResApprove = new KakaoResApprove();


        kakaoResApprove = restTemplate.postForObject(
                url,
                reqEntity,
                KakaoResApprove.class
        );

        return kakaoResApprove;
    }

    private void setReqApproveJson(KakaoReqApprove reqApproveData, String pgToken) {
        reqApproveData.setTid(this.kakaoResBodyPayload.getTid());
        reqApproveData.setPartner_order_id("test_order_id");
        reqApproveData.setPartner_user_id("test_user_id");
        reqApproveData.setPg_token(pgToken);
    }

    private void setReqPayData(kakaoRequstBodyPayload reqPayData, Item item, int quantity) {
        reqPayData.setPartner_order_id("test_order_id");
        reqPayData.setParther_user_id("test_user_id");
        reqPayData.setItem_name(item.getName());
        reqPayData.setQuantity(quantity);
        reqPayData.setTotal_amount(quantity * item.getPrice());
        reqPayData.setTax_free_amount(item.getPrice());
        reqPayData.setApproval_url("http://localhost:8080/payment/success");
        reqPayData.setCancel_url("http://localhost:8080/payment/cancel");
        reqPayData.setFail_url("http://localhost:8080/payment/fail");
    }

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.set("Authorization", "SECRET_KEY "); //시크릿키 필요
        httpHeaders.set("Content-type", "application/json;charset=UTF-8");

        return httpHeaders;
    }
}
