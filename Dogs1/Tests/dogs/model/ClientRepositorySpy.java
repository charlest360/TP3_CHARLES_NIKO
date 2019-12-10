package dogs.model;

import java.util.Map;

public class ClientRepositorySpy implements IClientRepository {
	
	public boolean hasAddClientBeenCalled = false;
	
	@Override
	public void addClient(IClient client) {
		this.hasAddClientBeenCalled =true;
	}

	@Override
	public Map<Integer, IClient> getClientList() {
		// TODO Auto-generated method stub
		return null;
	}


}