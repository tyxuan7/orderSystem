package ForderMapperTest;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orderSystem.dao.SorderMapper;
import com.orderSystem.entiry.Sorder;
import com.orderSystem.test.BaseTest;

public class ForderMapperTest extends BaseTest {
	@Autowired
	private SorderMapper sorderMapper;
	
	
	@Test
	public void findByAdmin(){
		
		 List<Sorder> account = sorderMapper.listSorderByfid(201407013);
		
		System.out.println("------------------" + account);
		System.out.println("------------------" + sorderMapper);
	}
}
