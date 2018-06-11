import com.alibaba.fastjson.JSONArray;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.xust.utils.DataUtils;
import com.xust.utils.RedisPoll;
import org.json.JSONException;

import java.io.IOException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by lenovo on 2018/5/9.
 */
public class Main {

    @Test
    public void test() {
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String valuem = sdf.format(d);
        System.out.println(valuem);
        for (int i = 0;i<100;i++) {
            System.out.println((Math.random() * 699.5) + 0.5);
        }
        /*
        String str = RedisPoll.getResource().get("1_1_1_20180329");*/
        //System.out.println(str);

       /* String[] datas = dataUtils.getSearchKeys("20010225", "20010325");
        for (int i = 0; i < datas.length; i++) {
            //if (datas[i] != null) {
                System.out.println(datas[i]);
            //}
        }*/
    }

    @Test
    public void test1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 0, 25, 1, 3, 55);
        System.out.println(calendar.getTimeInMillis());
      /*  Date date = new Date(System.currentTimeMillis());
        System.out.println(date);*/
        //System.out.println(new java.util.Date(date.getTime()));
        Date date = new Date();
        Long time = date.getTime();
        System.out.println(time);
        Date d = new Date(calendar.getTimeInMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        System.out.println(sdf.format(d));
    }

    @Test
    public void main() {
        // 短信应用SDK AppID
        int appid = 1400091265; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "0dd73e5f58c0ec62e2ba6926fd49b8a2";

        // 需要发送短信的手机号码
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(0, "13319193336");

        // 短信模板ID，需要在短信应用中申请
        int templateId = 125276; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

        // 签名
        String smsSign = "煤矿大数据安全"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
        try {
            /*SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers.get(0),
                    "【腾讯云】您的验证码是: 5678", "", "");
            System.out.print(result);*/
            ArrayList<String> params = new ArrayList<>();
            params.add("1234");
            //params.add("1");
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", "13319193336",
                    templateId, new ArrayList<String>(), smsSign, "", "");
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
    }
}
