package Controller.Goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsWishService;

@Controller
public class GoodsWishController {
	@Autowired
	GoodsWishService goodsWishService;
	@RequestMapping("/goods/goodsWishAdd")
	public String goodsWishAdd(@RequestParam(value = "num") Long goodsSeq,
			Model model,HttpSession session) {
		goodsWishService.goodsWishAdd(goodsSeq, model, session);
		return "GoodsView/success";
	}
}
