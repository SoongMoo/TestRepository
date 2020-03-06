package Controller.Goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsCartService;

@Controller
public class GoodsCartController {
	@Autowired
	GoodsCartService goodsCartService;
	@RequestMapping("/goods/goodsCartAdd")
	public String goodsCartAdd(
			@RequestParam(value = "num") Long goodsSeq, Model model,
			HttpSession session) {
		goodsCartService.goodsCartAdd(goodsSeq,model,session);
		return "GoodsView/success";
	}
	@RequestMapping(value = "/goods/goodsCartList")
	public String goodsCartList(Model model, HttpSession session) {
		goodsCartService.goodsCartList(session, model);
		return "GoodsView/goodsCartList";
	}
}









