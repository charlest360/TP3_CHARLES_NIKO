package model.mock;

import java.util.Map;

import dogs.model.IClient;
import dogs.model.IClientRepository;

public class ClientRepositoryDummy implements IClientRepository{

	@Override
	public void addClient(IClient client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, IClient> getClientList() {
		// TODO Auto-generated method stub
		return null;
	}

}
