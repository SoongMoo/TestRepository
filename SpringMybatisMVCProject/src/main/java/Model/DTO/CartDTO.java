package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartDTO implements Serializable{
	Long goodsSeq;
	String userId   ;
	String goodsName;
	Long goodsPrice;
	String goodsImage ;
	Long qty;
	public Long getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Long goodsSeq) {
		this.goodsSeq = goodsSeq;
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
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
}
