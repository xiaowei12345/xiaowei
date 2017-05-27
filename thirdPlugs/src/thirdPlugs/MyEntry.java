package thirdPlugs;

import com.jiuqi.dna.ui.wt.UIEntry;
import com.jiuqi.dna.ui.wt.widgets.Shell;

public class MyEntry implements UIEntry{

	@Override
	public void createUI(String[] args, Shell shell) {
		shell.showPage("uitestpage");
	}

}
