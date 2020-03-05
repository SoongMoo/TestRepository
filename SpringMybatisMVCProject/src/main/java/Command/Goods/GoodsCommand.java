package Command.Goods;

import org.springframework.web.multipart.MultipartFile;

public class GoodsCommand {
	String goodsNum;
	String goodsName;
	Long goodsPrice;
	Long goodsQty;
	String goodsContent;
	MultipartFile [] goodsImage;
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
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
	public MultipartFile[] getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(MultipartFile[] goodsImage) {
		this.goodsImage = goodsImage;
	}
}
