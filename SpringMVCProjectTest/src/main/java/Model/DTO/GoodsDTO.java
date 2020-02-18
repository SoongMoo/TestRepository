package Model.DTO;

import java.sql.Timestamp;

public class GoodsDTO {
	Integer goodsSeq ;
	String goodsNum ;
	String userId ;
	String goodsName ;
	Integer goodsPrice;
	Integer goodsQty ;
	String goodsContent;
	String goodsImage;
	Timestamp goodsRegister;
	Integer goodsVisit;
	public GoodsDTO() {}
	public GoodsDTO(Integer goodsSeq, String goodsNum, String userId, String goodsName, Integer goodsPrice,
			Integer goodsQty, String goodsContent, String goodsImage, Integer goodsVisit) {
		this.goodsSeq = goodsSeq;
		this.goodsNum = goodsNum;
		this.userId = userId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsQty = goodsQty;
		this.goodsContent = goodsContent;
		this.goodsImage = goodsImage;
		this.goodsVisit = goodsVisit;
	}
	public Integer getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Integer goodsSeq) {
		this.goodsSeq = goodsSeq;
	}
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
	public Integer getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsQty() {
		return goodsQty;
	}
	public void setGoodsQty(Integer goodsQty) {
		this.goodsQty = goodsQty;
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
	public Timestamp getGoodsRegister() {
		return goodsRegister;
	}
	public void setGoodsRegister(Timestamp goodsRegister) {
		this.goodsRegister = goodsRegister;
	}
	public Integer getGoodsVisit() {
		return goodsVisit;
	}
	public void setGoodsVisit(Integer goodsVisit) {
		this.goodsVisit = goodsVisit;
	}
}
