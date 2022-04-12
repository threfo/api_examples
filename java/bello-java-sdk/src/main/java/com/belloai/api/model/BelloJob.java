package com.belloai.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BelloJob{
    private String id;
    private Map<String, Object> category;
    private Integer degree_rank_max;
    private Integer degree_rank_min;
    private List<String> descriptions;
    private List<String> domains;
    private List<Map<String, String>> location;
    private Integer salary_max;
    private Integer salary_min;
    private Integer salary_month;
    private String title;
    private String type;
    private Integer wanted_num;
    private Integer yoe_max;
    private Integer yoe_min;
    private Integer age_max;
    private Integer age_min;
    private String attribute;
    private String belong_company;
    private String contact;
    private String contact_phone;
    private String department;
    private List<String> forward_emails;
    private List<String> labels;
    private Map<String, Object> owner;
    private String received_email;
    private List<String> skills;
    private List<String> spots;
    private String third_party_id;
    private List<Map<String, Object>> channels_info;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Map<String, Object> getCategory() {
        return category;
    }
    public void setCategory(Map<String, Object> category) {
        this.category = category;
    }
    public Integer getDegree_rank_max() {
        return degree_rank_max;
    }
    public void setDegree_rank_max(Integer degree_rank_max) {
        this.degree_rank_max = degree_rank_max;
    }
    public Integer getDegree_rank_min() {
        return degree_rank_min;
    }
    public void setDegree_rank_min(Integer degree_rank_min) {
        this.degree_rank_min = degree_rank_min;
    }
    public List<String> getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }
    public List<String> getDomains() {
        return domains;
    }
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }
    public List<Map<String, String>> getLocation() {
        return location;
    }
    public void setLocation(List<Map<String, String>> location) {
        this.location = location;
    }
    public Integer getSalary_max() {
        return salary_max;
    }
    public void setSalary_max(Integer salary_max) {
        this.salary_max = salary_max;
    }
    public Integer getSalary_min() {
        return salary_min;
    }
    public void setSalary_min(Integer salary_min) {
        this.salary_min = salary_min;
    }
    public Integer getSalary_month() {
        return salary_month;
    }
    public void setSalary_month(Integer salary_month) {
        this.salary_month = salary_month;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getWanted_num() {
        return wanted_num;
    }
    public void setWanted_num(Integer wanted_num) {
        this.wanted_num = wanted_num;
    }
    public Integer getYoe_max() {
        return yoe_max;
    }
    public void setYoe_max(Integer yoe_max) {
        this.yoe_max = yoe_max;
    }
    public Integer getYoe_min() {
        return yoe_min;
    }
    public void setYoe_min(Integer yoe_min) {
        this.yoe_min = yoe_min;
    }
    public Integer getAge_max() {
        return age_max;
    }
    public void setAge_max(Integer age_max) {
        this.age_max = age_max;
    }
    public Integer getAge_min() {
        return age_min;
    }
    public void setAge_min(Integer age_min) {
        this.age_min = age_min;
    }
    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    public String getBelong_company() {
        return belong_company;
    }
    public void setBelong_company(String belong_company) {
        this.belong_company = belong_company;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContact_phone() {
        return contact_phone;
    }
    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getForward_emails() {
        return forward_emails;
    }
    public void setForward_emails(List<String> forward_emails) {
        this.forward_emails = forward_emails;
    }

    public List<String> getLabels() {
        return labels;
    }
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Map<String, Object> getOwner() {
        return owner;
    }
    public void setOwner(Map<String, Object> owner) {
        this.owner = owner;
    }

    public String getReceived_email() {
        return received_email;
    }
    public void setReceived_email(String received_email) {
        this.received_email = received_email;
    }

    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSpots() {
        return spots;
    }

    public void setSpots(List<String> spots) {
        this.spots = spots;
    }

    public String getThird_party_id() {
        return third_party_id;
    }
    public void setThird_party_id(String third_party_id) {
        this.third_party_id = third_party_id;
    }
    public List<Map<String, Object>> getChannels_info() {
        return channels_info;
    }
    public void setChannels_info(List<Map<String, Object>> channels_info) {
        this.channels_info = channels_info;
    }
}
