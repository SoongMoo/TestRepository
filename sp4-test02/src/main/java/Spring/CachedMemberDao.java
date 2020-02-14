package Spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CachedMemberDao {
	private static long nextId = 0;
	private static Map<String, MemberDTO> map =
			new HashMap<String, MemberDTO>(); 
	public void insert(MemberDTO dto) {
		dto.setId(++nextId);
		map.put(dto.getEmail(), dto);
		System.out.println(map.get(dto.getEmail()).getEmail());
	}
	public void update(MemberDTO dto) {
		map.put(dto.getEmail(), dto);
	}
	public Collection<MemberDTO> selectAll(){
		return map.values();
	}
	public MemberDTO selectByEmail(String email) {
		return map.get(email);
	}
}
