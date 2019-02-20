package cn.lsu.chicken.file.enums;

public enum OSSTypeEnum {
    SYSTEM(0, "系统资料"),
    HEAD(1, "用户头像"),
    RESOURCES(2, "会议资料"),
    FACE(3, "人脸图片");

    private Integer code;
    private String msg;

    OSSTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByCode(Integer code) {
        for (OSSTypeEnum ossTypeEnum : OSSTypeEnum.values()) {
            if (ossTypeEnum.getCode().equals(code)) {
                return ossTypeEnum.name() + "/";
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
