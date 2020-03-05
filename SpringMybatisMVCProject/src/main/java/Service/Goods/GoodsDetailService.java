package Service.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsDetailService {
	@Autowired	
	GoodsRepository goodsRepository;
	public void goodsDetail(Model model,Long goodsSeq) {
		GoodsDTO dto = goodsRepository.goodsDetail(goodsSeq);
		model.addAttribute("goods",dto);
	}
}
