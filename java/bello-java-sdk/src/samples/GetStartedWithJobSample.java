package samples;

import com.belloai.api.BelloClient;
import com.belloai.api.BelloClientBuilder;
import com.belloai.api.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetStartedWithJobSample {
    private static String endpoint = "https://hostname";
    private static String authorization = "{jwtToken}";

    public static void createJob() {
        BelloClient belloClient = new BelloClientBuilder().build(authorization);
        ClientJob clientJob = new ClientJob();
        BelloJob job = clientJob.transformToBelloJob();
        CreateBelloJobRequest createBelloJobRequest = new CreateBelloJobRequest(job, endpoint);
        try {
            BelloJob newJob = belloClient.createBelloJob(createBelloJobRequest);
            System.out.println("创建岗位成功, id: " + newJob.getId() + " title: " + newJob.getTitle());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getJobList() {
        BelloClient belloClient = new BelloClientBuilder().build(authorization);
        try {
            GetBelloJobsRequest getBelloJobsRequest = new GetBelloJobsRequest(endpoint);
            Map<String, Object> where = new HashMap<>();
            where.put("title__icontains", "python");
            getBelloJobsRequest.setWhere(where);
            BelloJobs belloJobs = belloClient.getBelloJobs(getBelloJobsRequest);
            System.out.println("获取岗位列表成功, meta: " + belloJobs.getMeta());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getJob() {
        BelloClient belloClient = new BelloClientBuilder().build(authorization);
        try {
            GetBelloJobsRequest getBelloJobsRequest = new GetBelloJobsRequest(endpoint);
            BelloJobs belloJobs = belloClient.getBelloJobs(getBelloJobsRequest);
            System.out.println("获取岗位列表成功, meta: " + belloJobs.getMeta());
            String belloJobId = belloJobs.getJobs().get(0).getId();
            GetBelloJobRequest getBelloJobRequest = new GetBelloJobRequest(belloJobId, endpoint);
            BelloJob belloJob = belloClient.getBelloJob(getBelloJobRequest);
            System.out.println("获取岗位成功, id: " + belloJob.getId() + " title: " + belloJob.getTitle());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateJob() {
        BelloClient belloClient = new BelloClientBuilder().build(authorization);
        try {
            GetBelloJobsRequest getBelloJobsRequest = new GetBelloJobsRequest(endpoint);
            BelloJobs belloJobs = belloClient.getBelloJobs(getBelloJobsRequest);
            System.out.println("获取岗位列表成功, meta: " + belloJobs.getMeta());
            BelloJob belloJob = belloJobs.getJobs().get(0);
            belloJob.setTitle(belloJob.getTitle() + "-updated");
            UpdateBelloJobRequest updateBelloJobRequest = new UpdateBelloJobRequest(belloJob, endpoint);
            BelloJob updatedBelloJob = belloClient.updateBelloJob(belloJob.getId(), updateBelloJobRequest);
            System.out.println("岗位更新成功, id: " + updatedBelloJob.getId() + ", title: " + updatedBelloJob.getTitle());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getJobAdUrl() {
        BelloClient belloClient = new BelloClientBuilder().build(authorization);
        BelloUser belloUser = new BelloUser();
        belloUser.setEmail("wilder.chen@example.com");
        belloUser.setThird_party_id("wilder.chen@example.com");
        belloUser.setName("wilder");
        try {
            GetsertAuthInfoRequest getsertAuthInfoRequest = new GetsertAuthInfoRequest(belloUser, endpoint);
            GetBelloJobsRequest getBelloJobsRequest = new GetBelloJobsRequest(endpoint);
            BelloJobs belloJobs = belloClient.getBelloJobs(getBelloJobsRequest);
            System.out.println("获取岗位列表成功, meta: " + belloJobs.getMeta());
            String belloJobId = belloJobs.getJobs().get(0).getId();
            String jobAdUrl = belloClient.getBelloJobAdUrl(belloJobId, getsertAuthInfoRequest);
            System.out.println("成功职位广告管理链接: " + jobAdUrl);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws IOException {
        // 1. 创建岗位
         createJob();
        // 2. 获取岗位列表
         getJobList();
        // 3. 获取岗位
         getJob();
        // 4. 更新岗位
        updateJob();
        // 5. 获取岗位广告管理链接
        getJobAdUrl();
    }
}
