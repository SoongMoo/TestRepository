package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class GoodsDTO implements Serializable{
	Long goodsSeq ;
	String goodsNum ;
	String userId ;
	String goodsName ;
	Long goodsPrice;
	Long goodsQty ;
	String goodsContent;
	String goodsImage;
	Timestamp goodsRegister;
	Long goodsVisit;
	public GoodsDTO() {}
	public GoodsDTO(Long goodsSeq, String goodsNum, String userId, String goodsName, Long goodsPrice,
			Long goodsQty, String goodsContent, String goodsImage, Long goodsVisit) {
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
	public Long getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Long goodsSeq) {
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
	public Long getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Long getGoodsQty() {
		return goodsQty;
	}
	public void setGoodsQty(Long goodsQty) {
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
	public Long getGoodsVisit() {
		return goodsVisit;
	}
	public void setGoodsVisit(Long goodsVisit) {
		this.goodsVisit = goodsVisit;
	}
}
