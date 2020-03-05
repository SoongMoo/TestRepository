package Controller.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Goods.GoodsCommand;
import Service.Goods.GoodsWriterService;

@Controller
public class GoodsWriterController {
	@Autowired
	GoodsWriterService goodsWriterService;
	@RequestMapping("/goods/goodsWriter")
	public String goodsWriteForm() {
		return "GoodsView/goodsForm";
	}
	@RequestMapping(value = "/goods/goodsPro",method = RequestMethod.POST)
	public String goodsWritePro(GoodsCommand goodsCommand, HttpSession session,
			HttpServletRequest request) {
		goodsWriterService.goodsWrite(goodsCommand,session,request);
		return "redirect:/goods/goodsList";
	}
	
	
}
