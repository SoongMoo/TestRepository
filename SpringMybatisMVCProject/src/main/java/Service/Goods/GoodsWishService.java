package Service.Goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.AuthInfo;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsWishService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsWishAdd(Long goodsSeq,Model model,HttpSession session) {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		Integer i = goodsRepository.goodsWishAdd(goodsSeq,userId);
		model.addAttribute("num",i);		
	}
}
