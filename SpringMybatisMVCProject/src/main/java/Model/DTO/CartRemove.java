package Model.DTO;

import java.util.Map;

public class CartRemove {
	Map<String, Object> goodsSeqs;
	String userId;
	public Map<String, Object> getGoodsSeqs() {
		return goodsSeqs;
	}
	public void setGoodsSeqs(Map<String, Object> goodsSeqs) {
		this.goodsSeqs = goodsSeqs;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
