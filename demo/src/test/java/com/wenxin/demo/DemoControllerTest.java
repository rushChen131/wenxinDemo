package com.wenxin.demo;

import com.wenxin.demo.bo.request.ErnieRequest;
import com.wenxin.demo.bo.request.ResultRequest;
import com.wenxin.demo.bo.response.ErnieResponse;
import com.wenxin.demo.enums.MaskType;
import com.wenxin.demo.enums.TaskType;
import com.wenxin.demo.service.RequestService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
class DemoControllerTest {

    @Autowired
    private RequestService requestService;

    @Test
    void testGetToken() {
        System.out.println(requestService.getAccessToken());
    }

    private String getToken() {
        return requestService.getAccessToken();
    }

    private String token;

    @Before
    public String setToken() {
        token = getToken();
        return token;
    }

    @Test
    void testRequest() {
        setToken();
        ErnieRequest request = new ErnieRequest();
        request.setText("以末日求生为话题写个小说");
        request.setMin_dec_len(2);
        request.setSeq_len(512);
        request.setTopp(0.8f);
        request.setPenalty_score(1.2f);
//        request.setStop_token();
        request.setTask_prompt(TaskType.novel);
        request.setTypeId(1);
//        request.setPenalty_text();
//        request.setChoice_text();
        request.setIs_unidirectional(0);
//        request.setMin_dec_penalty_text();
//        request.setLogits_bias();
        request.setMask_type(MaskType.word);

        System.out.println(requestService.requestWenXin(token, request, 6));
    }

    ErnieResponse request(String text) {
        ErnieRequest request = new ErnieRequest();
        request.setText(text);
        request.setMin_dec_len(2);
        request.setSeq_len(512);
        request.setTopp(0.8f);
        request.setPenalty_score(1.2f);
//        request.setStop_token();
        request.setTask_prompt(TaskType.novel);
        request.setTypeId(1);
//        request.setPenalty_text();
//        request.setChoice_text();
        request.setIs_unidirectional(0);
//        request.setMin_dec_penalty_text();
//        request.setLogits_bias();
        request.setMask_type(MaskType.word);
        return requestService.requestWenXin(token, request, 6);
    }


    @Test
    void getResult() {
        setToken();
        ErnieResponse response = request("写个都市异能小说");
        System.out.println(requestService.getResult(token, ResultRequest.builder().taskId(response.getTaskId()).build()));
    }

}