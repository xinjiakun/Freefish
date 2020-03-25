package com.buy.fish.service;

public interface InformationService {
    /**
     * 修改名字
     * zsj
     * @param
     * @return
     */
    String changeInfoName(Integer id,String name);

    /**
     * 修改头像
     * zsj
     * @param
     * @return
     */
    String changeHeadImg(Integer id,String userHeadImg);

    /**
     * 修改个人签名
     * zsj
     * @param
     * @return
     */
    String changeInformation(Integer id,String information);

    /**
     * 修改性别
     * zsj
     * @param
     * @return
     */
    Integer changeInfoGender(Integer id,Integer gender);

    /**
     * 修改邮箱
     * zsj
     * @param
     * @return
     */
    Integer changeInfoEmail(Integer id);

    /**
     * 修改密码
     * zsj
     * @param
     * @return
     */
    Integer changeInfoPwd(Integer id,String pwd);
}
