package model.DTO;

import java.sql.Timestamp;

public class GoodsDTO {
	String goodsNum;
	String userId;
	String goodsName;
	String goodsContent;
	String goodsImage;
	Long goodsVisit;
	String ipAddr;
	Timestamp goodsRegister;
	long goodsPrice;
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public long getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public Long getGoodsVisit() {
		return goodsVisit;
	}
	public void setGoodsVisit(Long goodsVisit) {
		this.goodsVisit = goodsVisit;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public void setGoodsRegister(Timestamp goodsRegister) {
		this.goodsRegister = goodsRegister;
	}
	public Timestamp getGoodsRegister() {
		return goodsRegister;
	}
	
}
