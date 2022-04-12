package samples;

import com.belloai.api.BelloClient;
import com.belloai.api.BelloClientBuilder;
import com.belloai.api.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetStartedWithUserSample {
    private static String endpoint = "https://hostname";
    private static String authorization = "{jwtToken}";

    public static void getsertAuthInfo() {
        BelloClient belloClient = new BelloClientBuilder().build(authorization);
        BelloUser belloUser = new BelloUser();
        belloUser.setEmail("wilder.chen@example.com");
        belloUser.setThird_party_id("wilder.chen@example.com");
        belloUser.setName("wilder");
        GetsertAuthInfoRequest getsertAuthInfoRequest = new GetsertAuthInfoRequest(belloUser, endpoint);
        try {
            BelloUserAuthInfo userAuthInfo = belloClient.getsertAuthInfo(getsertAuthInfoRequest);
            System.out.println("成功获取用户授权信息, user_id: " + userAuthInfo.getUser_id() + " token: " + userAuthInfo.getToken());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 获取用户授权信息
         getsertAuthInfo();
    }
}
