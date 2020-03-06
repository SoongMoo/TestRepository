package Service.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DTO.AuthInfo;
import Model.DTO.CartDTO;
import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

public class GoodsCartService {
	@Autowired
	GoodsRepository goodsRepository;
	
	public void goodsCartRemove(Long [] goodsSeqs) {
		List<Long> cs  = new ArrayList<Long>();
		
		for(Long goodsSeq : goodsSeqs) { // 11,2,55
			cs.add(goodsSeq);
		}

		Map<String, Object> condition = new HashMap<String, Object>(); 
		condition.put("seqs", cs);
		
		goodsRepository.goodsCartRemove(condition);
	}
	
	public void goodsCartQtyDown(Long goodsSeq,Model model,HttpSession session) {
		CartDTO cart = new CartDTO();
		cart.setGoodsSeq(goodsSeq);
		cart.setUserId(((AuthInfo)session.getAttribute("authInfo")).getId());
		goodsRepository.goodsCartQtyDown(cart);
	}
	
	public void goodsCartAdd(Long goodsSeq, Model model,
			HttpSession session) {
		GoodsDTO dto = goodsRepository.goodsDetail(goodsSeq);
		CartDTO cart = new CartDTO();
		cart.setGoodsImage(dto.getGoodsImage());
		cart.setGoodsName(dto.getGoodsName());
		cart.setGoodsPrice(dto.getGoodsPrice());
		cart.setGoodsSeq(dto.getGoodsSeq());
		cart.setQty(1L);
		cart.setUserId(((AuthInfo)session.getAttribute("authInfo")).getId());
		Integer i = goodsRepository.goodsCartAdd(cart);
		model.addAttribute("num" , i);
	}
	public void goodsCartList(HttpSession session, Model model) {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		List<CartDTO> list = goodsRepository.cartList(userId);
		model.addAttribute("cartList", list);
	}
}
