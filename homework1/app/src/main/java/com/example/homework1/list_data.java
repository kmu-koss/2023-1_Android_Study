package com.example.homework1;

public class list_data {
    private int iv_profile;
    private String tv_name;

    public list_data(int iv_profile, String tv_name) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }
}
