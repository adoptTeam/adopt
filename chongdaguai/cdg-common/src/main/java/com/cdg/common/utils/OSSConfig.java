package com.cdg.common.utils;

/**
 * @ClassName: OSSConfig
 * @Description: OSS配置类
 * @author AggerChen
 * @date 2016年11月4日 下午3:58:36
 */
public class OSSConfig {

	//@Value("${endpoint}")
	//private String endpoint; // 连接区域地址
	//@Value("${accessKeyId}")
	//private String accessKeyId; // 连接keyId
	//@Value("${accessKeySecret}")
	//private String accessKeySecret; // 连接秘钥
	//@Value("${bucketName}")
	//private String bucketName; // 需要存储的bucketName
	//@Value("${picLocation}")
	//private String picLocation; // 图片保存路径

	private String endpoint="http://oss-cn-beijing.aliyuncs.com"; // 连接区域地址
	private String accessKeyId="LTAItdpeByyTyhrj"; // 连接keyId
	private String accessKeySecret="zfxIXpWU0M5Ow2VtrDm07QFwSBBgUa"; // 连接秘钥
	private String bucketName="chognxiaoguaidev"; // 需要存储的bucketName
	private String picLocation="dev/"; // 图片保存路径
	public OSSConfig() {
		//System.out.println(this.picLocation+"___________");
		//try {
		//	this.endpoint = SystemConfig.getConfigResource("endpoint");
		//	this.bucketName = SystemConfig.getConfigResource("bucketName");
		//	this.picLocation = SystemConfig.getConfigResource("picLocation");
		//	this.accessKeyId = SystemConfig.getConfigResource("accessKeyId");
		//	this.accessKeySecret = SystemConfig.getConfigResource("accessKeySecret");
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getPicLocation() {
		return picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}
}