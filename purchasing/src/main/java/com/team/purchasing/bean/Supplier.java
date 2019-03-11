package com.team.purchasing.bean;

import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 下午12:54
 * 供应商表
 */
@Data
public class Supplier {

    private Integer id;

    //供应商名称
    private String name;

    //供应商编号
    private String code;

    //分类
    private Integer category;

    //销售区域分类
    private Integer salesAreaType;

    //销售省份
    private Integer salesProvince;

    //生产或者经营范围
    private Integer businessScope;

    //地址
    private String managementAddress;

    //营业执照有效期
    private String businessLicenseExpireDate;

    //法人代表
    private String legalPerson;

    //销售人员名称
    private String salesName;

    //电话、传真
    private String telorFax;

    //药品经营许可证(路径或者图片url)
    private String drugbusinesslicense;

    //药品生产许可证（路径或者图片url）
    private String drugProductionLicense;

    //医疗器械经营许可证(路径或者图片url)
    private String medicalInstrumentBusinessLicense;

    //医疗器械生产许可证(路径或者图片url)
    private String medicalInstrumentProductionLicense;

    //卫生许可证(路径或者图片url)
    private String hygieneLience;

    //营业执照(路径或者图片url)
    private String businessLicense;

    //GSP认证证书
    private String GSPCertification;

    //GMP认证证书
    private String GMPCertification;

    //质量保证协议
    private String qualityAssuranceAgreement;

    //供应商质量体系调查表
    private String supplierQualityQuestionnaire;

    //销售方法人委托书
    private String sellerLegalPersonEntrust;

    //销售方法人委托销售人员身份证复印件
    private String sellerLegalPersonIDCardPic;

    //审批状态
    private Integer auditStatus;

    //可用标志（0不可用，1可用）
    private Integer isEnabled;

    //删除标志（0未删除，1删除）
    private Integer isvalid;

    //创建时间
    private String createTime;

    //创建人id
    private Integer createUserId;

    //最近更新时间
    private String updateTime;

    //最近更新人
    private Integer updateUserId;

}
