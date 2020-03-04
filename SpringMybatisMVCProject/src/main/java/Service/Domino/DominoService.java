package Service.Domino;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DTO.ADTO;
import Model.DTO.BDTO;
import Model.DTO.CDTO;
import Repository.Domino.DominoRepository;

public class DominoService {
	@Autowired
	private DominoRepository dominoRepository;
	public void execute(Model model) {
		List<ADTO> list = dominoRepository.selectA();
		model.addAttribute("aa",list);
	}
	public void execute1(Model model, Integer a1) {
		List<BDTO> list = dominoRepository.selectB(a1);
		model.addAttribute("bb", list);
	}
	public void execute2(Model model, Integer a1, Integer b1) {
		BDTO dto = new BDTO();
		dto.setA1(a1);
		dto.setB1(b1);
		List<CDTO> list = dominoRepository.selectC(dto);
		model.addAttribute("cc", list);
	}
}



