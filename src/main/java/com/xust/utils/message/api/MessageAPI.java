package com.xust.utils.message.api;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created by lenovo on 2018/5/14.
 *
 * @Author fengfan
 */
public abstract class MessageAPI extends TimerTask {
    /**
     * @param appid      短信应用SDK AppID
     * @param appkey     短信应用SDK AppKey
     * @param phoneNum   需要发送短信的手机号码
     * @param templateId 短信模板ID，需要在短信应用中申请
     * @param smsSign    签名
     *                   Exception交由具体子类捕获
     */
    public void send_Message(int appid, String appkey, String phoneNum, int templateId,
                             String smsSign, ArrayList<String> message) throws Exception {

        SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNum,
                templateId, message, smsSign, "", "");
        System.out.println(result);
    }

    public abstract void sendVerificationCode(int appid, String appkey, String phoneNum, int templateId, String smsSign);

}
