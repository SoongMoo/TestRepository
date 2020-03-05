package Controller.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsDetailService;

@Controller
public class GoodsDetailController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("goods/goodsDetail")
	public String goodsDetail(@RequestParam(value = "num") Long GOODS_SEQ,
			Model model) {
		goodsDetailService.goodsDetail(model, GOODS_SEQ);
		return "GoodsView/goodsDetail";
	}
}
