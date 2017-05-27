package third.service;

import java.util.ArrayList;
import java.util.List;
import intf.Token;
import intf.TokenImpl;
import intf.TokenRequestKey;
import com.jiuqi.dna.core.resource.ResourceContext;
import com.jiuqi.dna.core.resource.ResourceService;
import com.jiuqi.dna.core.service.Publish;
import com.jiuqi.dna.core.type.GUID;

public final class SignService extends ResourceService<Token, TokenImpl, TokenImpl> {

	protected SignService() {
		super("Ç©µ½·þÎñ");
	}
	
	@Publish
	protected final class ByTokenIdProvider extends OneKeyResourceProvider<String>{

		@Override
		protected String getKey1(TokenImpl keysHolder) {
			return keysHolder.getCreateTime();
		}	
	}
	
	@Publish
	protected final class RequestTokenProvider extends OneKeyResultProvider<Token, TokenRequestKey>{

		@Override
		protected Token provide(
				ResourceContext<Token, TokenImpl, TokenImpl> context,
				TokenRequestKey key) throws Throwable {
			Token token = context.find(Token.class, key.getTime());
			if(token != null){
				token.getSignPerson().add(key.getUser());
				return token;
			}
			List<GUID> list = new ArrayList<GUID>();
			list.add(key.getUser());
			TokenImpl tokenImpl = new TokenImpl(list);
			context.putResource(tokenImpl);
			return tokenImpl;
		}	
	}
}
