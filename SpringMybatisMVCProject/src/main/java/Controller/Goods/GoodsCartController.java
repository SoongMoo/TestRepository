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
	
	@RequestMapping("/goods/goodsCartRemove")
	public String goodsCartRemove(@RequestParam(value = "delete") Long [] goodsSeqs) {
		goodsCartService.goodsCartRemove(goodsSeqs);
		return "redirect:/goods/goodsCartList";
	}
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
	@RequestMapping(value = "/goods/goodsCartQtyDown")
	public String goodsCartQtyDown(@RequestParam(value = "goodsNum") Long goodsSeq, 
			Model model,HttpSession session) {
		goodsCartService.goodsCartQtyDown(goodsSeq,model,session);
		return "redirect:/goods/goodsCartList";
	}
	@RequestMapping(value = "/goods/goodsCartQtyUp")
	public String goodsCartQtyUp(@RequestParam(value = "goodsNum") 
											Long goodsSeq, Model model,
			HttpSession session) {
		System.out.println("aaaaa");
		goodsCartService.goodsCartAdd(goodsSeq,model,session);
		return "redirect:/goods/goodsCartList";
	}
}









