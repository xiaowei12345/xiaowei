package third.service;

import com.jiuqi.dna.ui.wt.rs.IRemoteService;
import com.jiuqi.dna.ui.wt.rs.RemoteChannel;

public class CheckInfoRemoteService implements IRemoteService {

	@Override
	public void handle(RemoteChannel channel) throws Throwable {
		boolean tag = true;
		String username = channel.getRequest().getString("username");
		if(username.equals("xiaowei")){
			tag = false;
		}
		channel.getResponse().put("exists", tag);
	}
}
