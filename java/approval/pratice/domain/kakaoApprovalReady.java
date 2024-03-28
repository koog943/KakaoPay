package approval.pratice.domain;

import approval.pratice.domain.Item.Item;
import approval.pratice.domain.request.kakaoRequstBodyPayload;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;


public class kakaoApprovalReady {

    public void requestPay() {
        kakaoRequstBodyPayload reqData = new kakaoRequstBodyPayload();
        Item item = new Item();
        int quantity = 3;
        setReqData(reqData, item, quantity);

        JSONObject reqJson = new JSONObject(reqData);
        System.out.println(reqJson);
    }

    private static void setReqData(kakaoRequstBodyPayload reqData, Item item, int quantity) {
        reqData.setPartner_order_id(item.getId().toString());
        reqData.setParther_user_id("test_user_id");
        reqData.setItem_name(item.getName());
        reqData.setQuantity(quantity);
        reqData.setTotal_amount(quantity * item.getPrice());
        reqData.setTax_free_amount(item.getPrice());
        reqData.setApproval_url("http://localhost:8080/payment/success");
        reqData.setCancel_url("http://localhost:8080/payment/cancel");
        reqData.setFail_url("http://localhost:8080/payment/fail");
    }


}
