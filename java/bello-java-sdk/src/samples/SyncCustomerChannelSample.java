package samples;

import com.belloai.api.BelloClient;
import com.belloai.api.BelloClientBuilder;
import com.belloai.api.model.BelloCustomerChannelList;
import com.belloai.api.model.SyncBelloCustomerChannelRequest;
import com.belloai.api.model.SyncBelloCustomerChannelResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SyncCustomerChannelSample {
    private static String endpoint = "https://hostname";
    private static String authorization = "{jwtToken}";

    public static void syncCustomerChannel() {
        BelloClient belloClient = new BelloClientBuilder().build(authorization);
        try {
            BelloCustomerChannelList customerChannel = new BelloCustomerChannelList();
            // 创建小集合对象
            HashMap<String, String> channelInfo1 = new HashMap<>();
            HashMap<String, String> channelInfo2 = new HashMap<>();
            channelInfo1.put("channel", "渠道1");
            channelInfo1.put("channel_id", "渠道ID");
            channelInfo2.put("channel", "渠道2");
            channelInfo2.put("channel_id", "渠道ID");

            ArrayList<HashMap<String, String>> channels = new ArrayList<>();
            channels.add(channelInfo1);
            channels.add(channelInfo2);

            // 创建数组元素
            HashMap<String, Object> channelList1 = new HashMap<>();
            channelList1.put("channel_type", "类型A");
            channelList1.put("channel_type_id", "1");
            channelList1.put("channels", channels);

            HashMap<String, Object> channelList2 = new HashMap<>();
            channelList2.put("channel_type", "类型B");
            channelList2.put("channel_type_id", "2");
            channelList2.put("channels", channels);

            ArrayList<HashMap<String, Object>> channelList = new ArrayList<>();
            channelList.add(channelList1);
            channelList.add(channelList2);

            customerChannel.setChannel_list(channelList);
            SyncBelloCustomerChannelRequest syncBelloCustomerChannelRequest = new SyncBelloCustomerChannelRequest(customerChannel, endpoint);

            SyncBelloCustomerChannelResult syncBelloCustomerChannelResult = belloClient.syncCustomerChannel(syncBelloCustomerChannelRequest);
            System.out.println("客户渠道全量同步: " + syncBelloCustomerChannelResult.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        // 1. 客户渠道全量同步
        syncCustomerChannel();
    }
}
