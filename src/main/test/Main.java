import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by lenovo on 2018/5/9.
 */
public class Main {
    public static void main(String[] args) {
        // 短信应用SDK AppID
        int appid = 1400091265; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "0dd73e5f58c0ec62e2ba6926fd49b8a2";

        // 需要发送短信的手机号码
        String[] phoneNumbers = {"13319193336"};

        // 短信模板ID，需要在短信应用中申请
        int templateId = 7839; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

        // 签名
        String smsSign = "腾讯云"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
                    "【腾讯云】您的验证码是: 5678", "", "");
            System.out.print(result);
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
