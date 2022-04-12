package samples;

import com.belloai.api.model.BelloJob;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientJob {

    private Map<String, Object> clientJob;

    private void initClientJob() {
        Map<String, Object> category = new HashMap<>();
        category.put("major", "专业技术人员");
        category.put("minor", "后端开发");
        category.put("detail", "python工程师");
        category.put("name", "专业技术人员_后端开发_python工程师");
        List<String> descriptions = new ArrayList<>();
        descriptions.add("职位描述内容");
        List<String> domains = new ArrayList<>();
        domains.add("教育");
        domains.add("儿童早教");
        List<Map<String, String>> location = new ArrayList<>();
        Map<String, String> locationItem = new HashMap<>();
        locationItem.put("province", "广东省");
        locationItem.put("city", "深圳市");
        locationItem.put("text", "深圳湾1号101");
        location.add(locationItem);
        List<String> forwardEmails = new ArrayList<>();
        forwardEmails.add("wilder.chen@belloai.com");
        List<String> labels = new ArrayList<>();
        labels.add("五险一金");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        List<String> spots = new ArrayList<>();
        spots.add("大平台");
        clientJob.put("category", category);
        clientJob.put("regreeRankMax", 0);
        clientJob.put("degreeRankMin", 7);
        clientJob.put("descriptions", descriptions);
        clientJob.put("domains", domains);
        clientJob.put("location", location);
        clientJob.put("salaryMax", 15000);
        clientJob.put("salaryMin", 10000);
        clientJob.put("salaryMonth", 12);
        clientJob.put("title", "产品总监-深圳");
        clientJob.put("type", "全职");
        clientJob.put("headCount", 2);
        clientJob.put("yoeMax", 5);
        clientJob.put("yoeMin", 3);
        clientJob.put("ageMax", 30);
        clientJob.put("ageMin", 20);
        clientJob.put("attribute", "normal");
        clientJob.put("contact", "张三");
        clientJob.put("contactPhone", "13800138000");
        clientJob.put("department", "产品部");
        clientJob.put("forwardEmails", forwardEmails);
        clientJob.put("labels", labels);
        clientJob.put("receivedEmail", "wilder.chen@belloai.com");
        clientJob.put("skills", skills);
        clientJob.put("spots", spots);
        clientJob.put("id", "客户系统的岗位ID");
    }

    public ClientJob() {
        clientJob = new HashMap<>();
        // 模拟初始化 clientJob
        initClientJob();
    }

    private void transformClientCategory(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        Map<String, Object> category = new HashMap<>();
        // TODO: 通过字典表映射转换 clientJob 的 major/minor/detail, 倍罗的职能分类详见:
        // http://api-doc.belloai.com/markdown/module_publish__category.md
        String major = "专业技术人员";
        String minor = "后端开发";
        String detail = "python工程师";
        category.put("major", major);
        category.put("minor", minor);
        category.put("detail", detail);
        category.put("name", major + "_" + minor + "_" + detail);
        belloJob.put("category", category);
    }

    private void transformClientDegree(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        belloJob.put("degree_rank_max", 0);
        belloJob.put("degree_rank_min", 0);
        if (clientJob.containsKey("degreeRankMin")) {
            // TODO: 映射最低学历要求到 degree_rank_min, 0: 不限, 5: 专科, 6: 专升本, 7: 本科, 8: 硕士, 9: 博士
            belloJob.put("degree_rank_min", clientJob.get("degreeRankMin"));
        }

    }

    private void transformClientDescriptions(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        List<String> descriptions = new ArrayList<>();
        if (clientJob.containsKey("descriptions")) {
            // TODO: 映射职位描述成 List<String>, 强制映射客户的描述为 String
            // descriptions.add((List<String>)clientJob.get("descriptions")[0]);
            descriptions = (List<String>)clientJob.get("descriptions");
        }
        belloJob.put("descriptions", descriptions);
    }

    private void transformClientDomains(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        List<String> domains = new ArrayList<>();
        if (clientJob.containsKey("domains")) {
            // TODO: 通过字典表映射转换 clientJob 的行业领域, 倍罗的行业领域详见:
            // http://api-doc.belloai.com/markdown/domains.md
            domains.add("教育");
            domains.add("儿童早教");
        }
        belloJob.put("domains", domains);
    }

    private void transformClientLocation(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        List<Map<String, String>> location = new ArrayList<>();
        // TODO: 转换地点信息, 建议参考:
        // https://lbs.amap.com/demo/jsapi-v2/example/map-lifecycle/map-show
        Map<String, String> locationItem = new HashMap<>();
        locationItem.put("province", "广东省");
        locationItem.put("city", "深圳市");
        locationItem.put("text", "深圳湾1号101");
        location.add(locationItem);
        belloJob.put("location", location);
    }

    private void transformClientSalary(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        belloJob.put("salary_max", 0);
        belloJob.put("salary_min", 0);
        belloJob.put("salary_month", 12);
        // TODO: 转换薪资以及薪酬月份, 单位为"元"
        if (clientJob.containsKey("salaryMax")) {
            belloJob.put("salary_max", clientJob.get("salaryMax"));
        }
        if (clientJob.containsKey("salaryMin")) {
            belloJob.put("salary_min", clientJob.get("salaryMin"));
        }
        if (clientJob.containsKey("salaryMonth")) {
            belloJob.put("salary_month", clientJob.get("salaryMonth"));
        }
    }

    private void transformClientTitle(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换职称
        if (clientJob.containsKey("title")) {
            belloJob.put("title", clientJob.get("title"));
        }
    }

    private void transformClientType(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换工作性质, 可选为: 全职, 兼职, 校招, 实习
        if (clientJob.containsKey("type")) {
            belloJob.put("type", clientJob.get("type"));
        }
    }

    private void transformClientHeadCount(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换招聘人数
        if (clientJob.containsKey("headCount")) {
            belloJob.put("wanted_num", clientJob.get("headCount"));
        }
    }

    private void transformClientYearOfWorkExperience(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        belloJob.put("yoe_max", 0);
        belloJob.put("yoe_min", 0);
        // TODO: 转换工作年限
        if (clientJob.containsKey("yoeMax")) {
            belloJob.put("yoe_max", clientJob.get("yoeMax"));
        }
        if (clientJob.containsKey("yoeMin")) {
            belloJob.put("yoe_min", clientJob.get("yoeMin"));
        }
    }

    private void transformClientAge(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        belloJob.put("age_max", 0);
        belloJob.put("age_min", 0);
        // TODO: 转换年龄
        if (clientJob.containsKey("ageMax")) {
            belloJob.put("age_max", clientJob.get("ageMax"));
        }
        if (clientJob.containsKey("ageMin")) {
            belloJob.put("age_min", clientJob.get("ageMin"));
        }
    }

    private void transformClientAttribute(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        belloJob.put("attribute", "normal");
        // TODO: 转换岗位属性 (常规职位为normal，敏感/保密职位为sensitive)
        if (clientJob.containsKey("attribute")) {
            belloJob.put("attribute", clientJob.get("attribute"));
        }
    }

    private void transformClientBelongCompany(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换所属公司
        if (clientJob.containsKey("belongCompany")) {
            belloJob.put("belong_company", clientJob.get("belongCompany"));
        }
    }

    private void transformClientContact(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换联系人等信息
        if (clientJob.containsKey("contact")) {
            belloJob.put("contact", clientJob.get("contact"));
        }
        if (clientJob.containsKey("contactPhone")) {
            belloJob.put("contact_phone", clientJob.get("contactPhone"));
        }
    }

    private void transformClientDepartment(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换部门信息
        if (clientJob.containsKey("department")) {
            belloJob.put("department", clientJob.get("department"));
        }
    }

    private void transformClientEmail(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换转发邮箱、接收邮箱
        if (clientJob.containsKey("forwardEmails")) {
            belloJob.put("forward_emails", clientJob.get("forwardEmails"));
        }
        if (clientJob.containsKey("receivedEmail")) {
            belloJob.put("received_email", clientJob.get("receivedEmail"));
        }
    }

    private void transformClientLabels(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换岗位标签
        if (clientJob.containsKey("labels")) {
            belloJob.put("labels", clientJob.get("labels"));
        }
    }

    private void transformClientOwner(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换负责人(值为Bello用户ID), 格式为 owner: {"id": "{bello_user_id}"}
        if (clientJob.containsKey("owner")) {
            belloJob.put("owner", clientJob.get("owner"));
        }
    }

    private void transformClientSkills(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换技能要求
        if (clientJob.containsKey("skills")) {
            belloJob.put("skills", clientJob.get("skills"));
        }
    }

    private void transformClientSpots(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换亮点
        if (clientJob.containsKey("spots")) {
            belloJob.put("spots", clientJob.get("spots"));
        }
    }

    private void transformClientThirdPartyId(Map<String, Object> clientJob, Map<String, Object> belloJob) {
        // TODO: 转换第三方系统ID
        if (clientJob.containsKey("id")) {
            belloJob.put("third_party_id", clientJob.get("id"));
        }
    }

    public BelloJob transformToBelloJob() {
        HashMap<String, Object> belloJob = new HashMap<>();
        // 把客户系统中的职位信息转换为Bello职位信息
        transformClientCategory(clientJob, belloJob);
        transformClientDegree(clientJob, belloJob);
        transformClientDescriptions(clientJob, belloJob);
        transformClientDomains(clientJob, belloJob);
        transformClientLocation(clientJob, belloJob);
        transformClientSalary(clientJob, belloJob);
        transformClientTitle(clientJob, belloJob);
        transformClientType(clientJob, belloJob);
        transformClientHeadCount(clientJob, belloJob);
        transformClientYearOfWorkExperience(clientJob, belloJob);
        transformClientAge(clientJob, belloJob);
        transformClientAttribute(clientJob, belloJob);
        transformClientBelongCompany(clientJob, belloJob);
        transformClientContact(clientJob, belloJob);
        transformClientDepartment(clientJob, belloJob);
        transformClientEmail(clientJob, belloJob);
        transformClientLabels(clientJob, belloJob);
        transformClientOwner(clientJob, belloJob);
        transformClientSkills(clientJob, belloJob);
        transformClientSpots(clientJob, belloJob);
        transformClientThirdPartyId(clientJob, belloJob);

        // 转换成 BelloJob 对象
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(belloJob, BelloJob.class);
    }
}
