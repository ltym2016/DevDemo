package com.samluys.devdemo;

/**
 * @author luys
 * @describe 邀请通话的信息，转换成json 通过IM传输
 * @date 2019-05-22
 * @email samluys@foxmail.com
 */
public class CallInfoEntity {

    /**
     * 房间号
     */
    private int roomId;

    /**
     * 类型区分  视频/语音
     */
    private String callType;

    /**
     * 类型区分  挂断/拒绝/未接听/礼物
     */
    private String type;

    /**
     * 文字内容
     */
    private String content;

    /**
     * 通话价格
     */
    private String price;

    /**
     * 通话时长
     */
    private String time;

    /**
     * 主播收入
     */
    private String income;

    private String giftUrl;// 图片URL
    private String giftText;// 获赠糖果X2，价值1000钻，积分+1w，亲密度+1.2w

    public String getGiftUrl() {
        return giftUrl;
    }

    public void setGiftUrl(String giftUrl) {
        this.giftUrl = giftUrl;
    }

    public String getGiftText() {
        return giftText;
    }

    public void setGiftText(String giftText) {
        this.giftText = giftText;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
