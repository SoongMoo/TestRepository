package Service.Goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsList(Model model) {
		List<GoodsDTO> list= goodsRepository.goodsList();
		model.addAttribute("goodsList", list);
	}
}




