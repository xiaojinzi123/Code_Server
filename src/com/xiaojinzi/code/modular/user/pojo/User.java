package com.xiaojinzi.code.modular.user.pojo;


import com.xiaojinzi.code.modular.base.entity.BaseEntity;

/**
 * 用户实体对象,包括app的用户对象,后台登陆的用户对象都是这个
 */
public class User extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 用于即时聊天的token,在登陆的时候返回,不会在数据库中存在该字段
     */
    private String imToken;

    /**
     * 客户端应该持有的token,这个token会代表这个用户<br/>
     * token在登陆成功后交给用户,如果app退出了,应该调用loginOut方法来登出来销毁当前的生成的token<br/>
     * 为了防止恶心的对服务器进行攻击,所以设计了这个,token在登陆成功的时候自动生成<br/>
     * 是一个和时间戳有关的加密32位字符串,攻击者肯定拿不到这个值得,同时也是可以利用这个token防止在多个设备上登陆<br/>
     * 如果用户退出app是被强制杀死的,那么肯定不会调用登出的方法,下次登陆token会使用之前生成的那个token
     */
    private String clientToken;

    /* 用户名,唯一 */
    private String name;

    /**
     * 经验值,通过每日登录而来,每日登录获取的经验值后面再定
     * 也可以通过回答别人的问题获得最佳答案而得到楼主发布问题所花费的经验值
     * 然后相应的就会出现等级,等级这个数据就是由这个经验值计算而来,客户端需要计算,计算方式如下:
     * 1-2 100经验值
     * 2-3 200经验值
     * 3-4 500经验值
     * 4-5 1000经验值
     * 5-6 2000经验值
     * 6-7 5000经验值
     * 7-8 10000经验值
     */
    private int xp;

    /**
     * 用户的简介
     */
    private String description;

    /**
     * 性别<br/>
     * 0:男性<br/>
     * 1:女性
     */
    private String sex;

    /* 密码 */
    private String password;

    /* 电话号码 */
    private String phoneNumber;

    /* 头像地址,有默认地址 */
    private String avatarAddress;

    //===========第三方登录========================

    /**
     * 微信的唯一码
     */
    private String weixinId;

    /**
     * 微博的唯一码
     */
    private String weiboId;

    /**
     * qq的唯一码
     */
    private String qqId;

    /**
     * 用户的类型,暂时用不到,标识用户现在的状态的<br/>
     * 比如正在审核,通过审核等等
     */
    private Integer userType;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    //=======================getter和setter方法=========================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public String getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(String weiboId) {
        this.weiboId = weiboId;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
