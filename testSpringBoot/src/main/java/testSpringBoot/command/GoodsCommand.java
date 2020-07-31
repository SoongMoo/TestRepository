package testSpringBoot.command;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCommand {
	@NotEmpty(message = "상품번호를 입력해주세요!")
	String goodsNum;
	@NotEmpty(message = "상품이름을 입력해주세요!")
	String goodsName;
	@NotEmpty(message = "가격을 입력해주세요!")
	Long goodsPrice;
	@NotEmpty(message = "수량을 입력해주세요!")
	Long goodsQty;
	@NotEmpty(message = "내용을 입력해주세요!")
	String goodsContent;
	MultipartFile [] goodsImage;
}
