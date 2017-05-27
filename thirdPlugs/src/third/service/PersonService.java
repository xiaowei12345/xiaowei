package third.service;

import intf.FPerson;
import intf.PersonImpl;
import intf.PersonTask;
import java.util.List;

import third.script.GetPersonByNameOrm;
import third.script.PersonOrm;
import com.jiuqi.dna.core.Context;
import com.jiuqi.dna.core.da.ORMAccessor;
import com.jiuqi.dna.core.service.Publish;
import com.jiuqi.dna.core.service.Service;

public class PersonService extends Service {

	private PersonOrm personOrm;
	private GetPersonByNameOrm getPersonByNameOrm;

	protected PersonService(PersonOrm personOrm,GetPersonByNameOrm getPersonByNameOrm) {
		super("会员服务");
		this.personOrm = personOrm;
		this.getPersonByNameOrm = getPersonByNameOrm;
	}

	@Publish
	protected class AllPersonProvider extends ResultListProvider<FPerson> {

		@Override
		protected void provide(Context arg0, List<FPerson> arg1)
				throws Throwable {
			ORMAccessor<PersonImpl> acc = arg0.newORMAccessor(personOrm);
			arg1.addAll(acc.fetch());
		}
	}
	
	/*
	 * 根据姓名查询
	 */
	@Publish
	protected class GetPersonByNameProvider extends OneKeyResultListProvider<FPerson, String>{

		@Override
		protected void provide(Context arg0, String arg1, List<FPerson> arg2)
				throws Throwable {
			ORMAccessor<PersonImpl> acc = arg0.newORMAccessor(getPersonByNameOrm);
			arg2.addAll(acc.fetch(arg1));
		}	
	}

	@Publish
	protected class AddPersonHandler extends TaskMethodHandler<PersonTask, PersonTask.Method>{

		protected AddPersonHandler() {
			super(PersonTask.Method.ADD);
		}

		@Override
		protected void handle(Context arg0, PersonTask arg1) throws Throwable {
			PersonImpl pl = new PersonImpl();
			pl.setRecid(arg1.recid);
			pl.setPhone(arg1.phone);
			pl.setUsername(arg1.username);
			pl.setCity(arg1.city);
			pl.setReason(arg1.reason);
			pl.setRemark(arg1.remark);

			ORMAccessor<PersonImpl> newORMAccessor=arg0.newORMAccessor(personOrm);
			newORMAccessor.insert(pl);
			newORMAccessor.unuse();
		}
	}
	
	@Publish
	protected class ModifyPersonHandler extends TaskMethodHandler<PersonTask, PersonTask.Method>{
		
		protected ModifyPersonHandler() {
			super(PersonTask.Method.MODIFY);
		}
		
		@Override
		protected void handle(Context arg0, PersonTask arg1) throws Throwable {
			PersonImpl pl = new PersonImpl();
			pl.setRecid(arg1.recid);
			pl.setPhone(arg1.phone);
			pl.setUsername(arg1.username);
			pl.setCity(arg1.city);
			pl.setReason(arg1.reason);
			pl.setRemark(arg1.remark);
			
			ORMAccessor<PersonImpl> newORMAccessor=arg0.newORMAccessor(personOrm);
			newORMAccessor.update(pl);
			newORMAccessor.unuse();
		}
	}
	
	@Publish
	protected class DeletePersonHandler extends TaskMethodHandler<PersonTask, PersonTask.Method>{
		
		protected DeletePersonHandler() {
			super(PersonTask.Method.DELETE);
		}
		
		@Override
		protected void handle(Context arg0, PersonTask arg1) throws Throwable {
			PersonImpl pl = new PersonImpl();
			pl.setRecid(arg1.recid);
			
			ORMAccessor<PersonImpl> newORMAccessor=arg0.newORMAccessor(personOrm);
			newORMAccessor.delete(pl);
			newORMAccessor.unuse();
		}
	}
}
